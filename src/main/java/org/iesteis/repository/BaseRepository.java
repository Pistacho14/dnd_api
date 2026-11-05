package org.iesteis.repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.iesteis.database.DatabaseManager;
import org.iesteis.database.DatabaseService;

public abstract class BaseRepository<T> implements CrudRepository<T> {

    protected final DatabaseManager db;

    protected BaseRepository() {
        this.db = new DatabaseService();
    }

    protected BaseRepository(DatabaseManager db) {
        this.db = db;
    }

    protected abstract String tableName();

    protected abstract T toModel(Map<String, Object> entity);

    protected abstract T copy(T source);

    protected List<T> findMany(String sql, Object... parameters) {
        return db.select(sql, parameters).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<T> findAll() {
        return findMany("SELECT * FROM " + tableName());
    }

    @Override
    public T findById(String index) {
        List<Map<String, Object>> result = db.select(
                "SELECT * FROM " + tableName() + " WHERE `index` = ?", index);
        return result.isEmpty() ? null : toModel(result.get(0));
    }

    @Override
    public T update(String index, T item) {
        if (findById(index) == null) {
            return null;
        }
        return updateItem(index, item);
    }

    protected abstract T updateItem(String index, T item);

    @Override
    public T delete(String index) {
        T item = findById(index);
        if (item == null) {
            return null;
        }
        int result = db.delete("DELETE FROM " + tableName() + " WHERE `index` = ?", index);
        return result <= 0 ? null : item;
    }

    public void exportAsCsv(Path directorio) throws IOException {
        exportTableAsCsv(db, tableName(), directorio);
    }

    public static void exportTableAsCsv(
            DatabaseManager database, String tableName, Path directorio) throws IOException {
        String safeTableName = tableName.replace("`", "``");
        String sql = "SELECT * FROM `" + safeTableName + "`";
        List<Map<String, Object>> filas = database.select(sql);
        Path outputFile = directorio.resolve(tableName + ".csv");

        // Crea o reemplaza el archivo usando los canales de escritura de java.nio.
        try (CSVPrinter csv = new CSVPrinter(
                Files.newBufferedWriter(
                        outputFile,
                        StandardCharsets.UTF_8,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING),
                CSVFormat.DEFAULT)) {

            if (!filas.isEmpty()) {
                List<String> columnas = new ArrayList<>(filas.get(0).keySet());
                csv.printRecord(columnas);

                for (Map<String, Object> fila : filas) {
                    List<Object> valores = columnas.stream()
                            .map(fila::get)
                            .collect(Collectors.toList());
                    csv.printRecord(valores);
                }
            }
        }
    }
}

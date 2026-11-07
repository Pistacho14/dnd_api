package org.iesteis.repository.alignments;


import org.iesteis.model.alignments.Alignments;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.repository.BaseRepository;

/**
 * Persiste y reconstruye alineamientos en la tabla {@code alignments}.
 */
public class AlignmentsRepositoryImpl extends BaseRepository<Alignments> implements AlignmentsRepository {

    public AlignmentsRepositoryImpl() { super(); }
    public AlignmentsRepositoryImpl(DatabaseManager db) { super(db); }

    @Override
    protected String tableName() { return "alignments"; }

    @Override
    public Alignments save(Alignments item) {
        int result = db.insert(
                "INSERT INTO alignments (`index`, name, abbreviation, description, url) VALUES (?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getAbbreviation(), item.getDescription(), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Alignments updateItem(String index, Alignments item) {
        int result = db.update(
                "UPDATE alignments SET `index` = ?, name = ?, abbreviation = ?, description = ?, url = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getAbbreviation(), item.getDescription(), item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override
    public java.util.List<Alignments> findByName(String name) {
        return findMany("SELECT * FROM alignments WHERE LOWER(name) LIKE LOWER(?)", "%" + name + "%");
    }

    @Override
    public java.util.List<Alignments> findByIndex(String index) {
        return findMany("SELECT * FROM alignments WHERE `index` = ?", index);
    }

    @Override
    public java.util.List<Alignments> findByUrl(String url) {
        return findMany("SELECT * FROM alignments WHERE url = ?", url);
    }

    @Override
    protected Alignments toModel(Map<String, Object> entity) {
        return new Alignments(
                (String) entity.get("index"),
                (String) entity.get("name"),
                (String) entity.get("abbreviation"),
                (String) entity.get("description"),
                (String) entity.get("url"));
    }

    @Override
    protected Alignments copy(Alignments source) {
        return new Alignments(
                source.getIndex(),
                source.getName(),
                source.getAbbreviation(),
                source.getDescription(),
                source.getUrl());
    }
}

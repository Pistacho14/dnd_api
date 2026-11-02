package org.iesteis.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
}

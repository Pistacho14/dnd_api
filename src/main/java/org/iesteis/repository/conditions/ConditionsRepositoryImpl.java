package org.iesteis.repository.conditions;

import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.conditions.Conditions;
import org.iesteis.repository.BaseRepository;

/**
 * Persiste y reconstruye condiciones en la tabla {@code conditions}.
 */
public class ConditionsRepositoryImpl extends BaseRepository<Conditions> implements ConditionsRepository {

    public ConditionsRepositoryImpl() { super(); }
    public ConditionsRepositoryImpl(DatabaseManager db) { super(db); }

    @Override
    protected String tableName() { return "conditions"; }

    @Override
    public Conditions save(Conditions item) {
        int result = db.insert(
                "INSERT INTO conditions (`index`, name, description, url) VALUES (?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getDescription(), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Conditions updateItem(String index, Conditions item) {
        int result = db.update(
                "UPDATE conditions SET `index` = ?, name = ?, description = ?, url = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getDescription(), item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override
    public List<Conditions> findByName(String name) {
        return findMany("SELECT * FROM conditions WHERE LOWER(name) LIKE LOWER(?)", "%" + name + "%");
    }

    @Override
    public List<Conditions> findByIndex(String index) {
        return findMany("SELECT * FROM conditions WHERE `index` = ?", index);
    }

    @Override
    public List<Conditions> findByUrl(String url) {
        return findMany("SELECT * FROM conditions WHERE url = ?", url);
    }

    @Override
    protected Conditions toModel(Map<String, Object> entity) {
        return new Conditions(
                (String) entity.get("index"),
                (String) entity.get("name"),
                (String) entity.get("description"),
                (String) entity.get("url"));
    }

    @Override
    protected Conditions copy(Conditions source) {
        return new Conditions(
                source.getIndex(),
                source.getName(),
                source.getDescription(),
                source.getUrl());
    }
}

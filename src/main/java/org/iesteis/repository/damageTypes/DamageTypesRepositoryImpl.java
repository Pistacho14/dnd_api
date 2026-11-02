package org.iesteis.repository.damageTypes;

import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.damageTypes.DamageTypes;
import org.iesteis.repository.BaseRepository;

public class DamageTypesRepositoryImpl extends BaseRepository<DamageTypes> implements DamageTypesRepository {

    public DamageTypesRepositoryImpl() { super(); }
    public DamageTypesRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "damage_types"; }

    @Override
    public DamageTypes save(DamageTypes item) {
        int result = db.insert(
                "INSERT INTO damage_types (`index`, name, description, url) VALUES (?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getDescription(), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected DamageTypes updateItem(String index, DamageTypes item) {
        int result = db.update(
                "UPDATE damage_types SET `index` = ?, name = ?, description = ?, url = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getDescription(), item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<DamageTypes> findByName(String value) {
        return findMany("SELECT * FROM damage_types WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<DamageTypes> findByIndex(String value) {
        return findMany("SELECT * FROM damage_types WHERE `index` = ?", value);
    }
    @Override public List<DamageTypes> findByUrl(String value) {
        return findMany("SELECT * FROM damage_types WHERE url = ?", value);
    }

    @Override
    protected DamageTypes toModel(Map<String, Object> entity) {
        return new DamageTypes(
                (String) entity.get("index"),
                (String) entity.get("name"),
                (String) entity.get("description"),
                (String) entity.get("url"));
    }

    @Override protected DamageTypes copy(DamageTypes source) {
        return new DamageTypes(
                source.getIndex(),
                source.getName(),
                source.getDescription(),
                source.getUrl());
    }
}

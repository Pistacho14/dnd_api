package org.iesteis.repository.equipmentCategories;

import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.equipmentCategories.EquipmentCategories;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

/**
 * Persiste y reconstruye categorías de equipo en la tabla {@code equipment_categories}.
 */
public class EquipmentCategoriesRepositoryImpl extends BaseRepository<EquipmentCategories>
        implements EquipmentCategoriesRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public EquipmentCategoriesRepositoryImpl() { super(); }
    public EquipmentCategoriesRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "equipment_categories"; }

    @Override
    public EquipmentCategories save(EquipmentCategories item) {
        int result = db.insert(
                "INSERT INTO equipment_categories (`index`, name, equipment, url) VALUES (?, ?, ?, ?)",
                item.getIndex(), item.getName(), JSON_MAPPER.writeValueAsString(item.getEquipment()), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected EquipmentCategories updateItem(String index, EquipmentCategories item) {
        int result = db.update(
                "UPDATE equipment_categories SET `index` = ?, name = ?, equipment = ?, url = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), JSON_MAPPER.writeValueAsString(item.getEquipment()),
                item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<EquipmentCategories> findByName(String value) {
        return findMany("SELECT * FROM equipment_categories WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<EquipmentCategories> findByIndex(String value) {
        return findMany("SELECT * FROM equipment_categories WHERE `index` = ?", value);
    }
    @Override public List<EquipmentCategories> findByUrl(String value) {
        return findMany("SELECT * FROM equipment_categories WHERE url = ?", value);
    }

    @Override
    protected EquipmentCategories toModel(Map<String, Object> entity) {
        Object equipment = entity.get("equipment");
        EquipmentCategories[] equipmentModels = equipment == null
                ? null
                : JSON_MAPPER.readValue((String) equipment, EquipmentCategories[].class);
        return new EquipmentCategories(
                (String) entity.get("index"),
                (String) entity.get("name"),
                equipmentModels,
                (String) entity.get("url"));
    }

    @Override protected EquipmentCategories copy(EquipmentCategories source) {
        return new EquipmentCategories(
                source.getIndex(),
                source.getName(),
                source.getEquipment(),
                source.getUrl());
    }
}

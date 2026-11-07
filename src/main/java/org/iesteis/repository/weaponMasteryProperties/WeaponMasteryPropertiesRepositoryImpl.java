package org.iesteis.repository.weaponMasteryProperties;

import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.weaponMasteryProperties.WeaponMasteryProperties;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

/**
 * Persiste y reconstruye propiedades de maestría de armas en {@code weapon_mastery_properties}.
 */
public class WeaponMasteryPropertiesRepositoryImpl extends BaseRepository<WeaponMasteryProperties> implements WeaponMasteryPropertiesRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public WeaponMasteryPropertiesRepositoryImpl() { super(); }
    public WeaponMasteryPropertiesRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "weapon_mastery_properties"; }

    @Override
    public WeaponMasteryProperties save(WeaponMasteryProperties item) {
        int result = db.insert(
                "INSERT INTO weapon_mastery_properties (`index`, `name`, `description`, `url`) VALUES (?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getDescription(), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected WeaponMasteryProperties updateItem(String index, WeaponMasteryProperties item) {
        int result = db.update(
                "UPDATE weapon_mastery_properties SET `index` = ?, `name` = ?, `description` = ?, `url` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getDescription(), item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<WeaponMasteryProperties> findByName(String value) {
        return findMany("SELECT * FROM weapon_mastery_properties WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<WeaponMasteryProperties> findByIndex(String value) {
        return findMany("SELECT * FROM weapon_mastery_properties WHERE `index` = ?", value);
    }
    @Override public List<WeaponMasteryProperties> findByUrl(String value) {
        return findMany("SELECT * FROM weapon_mastery_properties WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de weapon_mastery_properties deben recibirse como texto");
        }
        return JSON_MAPPER.readValue((String) value, type);
    }

    private Long number(Object value) {
        return value == null ? null : ((Number) value).longValue();
    }

    private <E extends Enum<E>> E enumValue(Object value, Class<E> type) {
        if (value == null) return null;
        String enumName = ((String) value).toUpperCase(java.util.Locale.ROOT).replaceAll("[^A-Z0-9]+", "_");
        return Enum.valueOf(type, enumName);
    }

    @Override
    protected WeaponMasteryProperties toModel(Map<String, Object> entity) {
        return new WeaponMasteryProperties(
                (String) entity.get("index"),
                (String) entity.get("name"),
                (String) entity.get("description"),
                (String) entity.get("url")
        );
    }

    @Override
    protected WeaponMasteryProperties copy(WeaponMasteryProperties source) {
        return new WeaponMasteryProperties(
                source.getIndex(),
                source.getName(),
                source.getDescription(),
                source.getUrl()
        );
    }
}

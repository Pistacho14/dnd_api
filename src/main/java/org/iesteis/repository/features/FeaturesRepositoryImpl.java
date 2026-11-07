package org.iesteis.repository.features;


import org.iesteis.model.features.ClassClass;
import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.features.Features;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

/**
 * Persiste y reconstruye rasgos de personaje en la tabla {@code features}.
 */
public class FeaturesRepositoryImpl extends BaseRepository<Features> implements FeaturesRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public FeaturesRepositoryImpl() { super(); }
    public FeaturesRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "features"; }

    @Override
    public Features save(Features item) {
        int result = db.insert(
                "INSERT INTO features (`index`, `name`, `description`, `level`, `class`, `subclass`, `url`) VALUES (?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getDescription(), json(item.getLevel()), json(item.getFeatureClass()), json(item.getSubclass()), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Features updateItem(String index, Features item) {
        int result = db.update(
                "UPDATE features SET `index` = ?, `name` = ?, `description` = ?, `level` = ?, `class` = ?, `subclass` = ?, `url` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getDescription(), json(item.getLevel()), json(item.getFeatureClass()), json(item.getSubclass()), item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Features> findByName(String value) {
        return findMany("SELECT * FROM features WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Features> findByIndex(String value) {
        return findMany("SELECT * FROM features WHERE `index` = ?", value);
    }
    @Override public List<Features> findByUrl(String value) {
        return findMany("SELECT * FROM features WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de features deben recibirse como texto");
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
    protected Features toModel(Map<String, Object> entity) {
        return new Features(
                (String) entity.get("index"),
                (String) entity.get("url"),
                (String) entity.get("name"),
                read(entity.get("class"), ClassClass.class),
                read(entity.get("level"), ClassClass.class),
                (String) entity.get("description"),
                read(entity.get("subclass"), ClassClass.class)
        );
    }

    @Override
    protected Features copy(Features source) {
        return new Features(
                source.getIndex(),
                source.getUrl(),
                source.getName(),
                source.getFeatureClass(),
                source.getLevel(),
                source.getDescription(),
                source.getSubclass()
        );
    }
}

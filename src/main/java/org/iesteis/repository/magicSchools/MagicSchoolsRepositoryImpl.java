package org.iesteis.repository.magicSchools;

import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.magicSchools.MagicSchools;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

/**
 * Persiste y reconstruye escuelas de magia en la tabla {@code magic_schools}.
 */
public class MagicSchoolsRepositoryImpl extends BaseRepository<MagicSchools> implements MagicSchoolsRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public MagicSchoolsRepositoryImpl() { super(); }
    public MagicSchoolsRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "magic_schools"; }

    @Override
    public MagicSchools save(MagicSchools item) {
        int result = db.insert(
                "INSERT INTO magic_schools (`index`, `name`, `description`, `url`) VALUES (?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getDescription(), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected MagicSchools updateItem(String index, MagicSchools item) {
        int result = db.update(
                "UPDATE magic_schools SET `index` = ?, `name` = ?, `description` = ?, `url` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getDescription(), item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<MagicSchools> findByName(String value) {
        return findMany("SELECT * FROM magic_schools WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<MagicSchools> findByIndex(String value) {
        return findMany("SELECT * FROM magic_schools WHERE `index` = ?", value);
    }
    @Override public List<MagicSchools> findByUrl(String value) {
        return findMany("SELECT * FROM magic_schools WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de magic_schools deben recibirse como texto");
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
    protected MagicSchools toModel(Map<String, Object> entity) {
        return new MagicSchools(
                (String) entity.get("index"),
                (String) entity.get("name"),
                (String) entity.get("description"),
                (String) entity.get("url")
        );
    }

    @Override
    protected MagicSchools copy(MagicSchools source) {
        return new MagicSchools(
                source.getIndex(),
                source.getName(),
                source.getDescription(),
                source.getUrl()
        );
    }
}

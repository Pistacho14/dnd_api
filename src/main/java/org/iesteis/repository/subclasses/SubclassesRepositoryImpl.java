package org.iesteis.repository.subclasses;



import org.iesteis.model.subclasses.Feature;
import org.iesteis.model.subclasses.ClassClass;
import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.subclasses.Subclasses;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

public class SubclassesRepositoryImpl extends BaseRepository<Subclasses> implements SubclassesRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public SubclassesRepositoryImpl() { super(); }
    public SubclassesRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "subclasses"; }

    @Override
    public Subclasses save(Subclasses item) {
        int result = db.insert(
                "INSERT INTO subclasses (`index`, `url`, `name`, `class`, `summary`, `description`, `features`) VALUES (?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getUrl(), item.getName(), json(item.getSubclassClass()), item.getSummary(), item.getDescription(), json(item.getFeatures()));
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Subclasses updateItem(String index, Subclasses item) {
        int result = db.update(
                "UPDATE subclasses SET `index` = ?, `url` = ?, `name` = ?, `class` = ?, `summary` = ?, `description` = ?, `features` = ? WHERE `index` = ?",
                item.getIndex(), item.getUrl(), item.getName(), json(item.getSubclassClass()), item.getSummary(), item.getDescription(), json(item.getFeatures()), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Subclasses> findByName(String value) {
        return findMany("SELECT * FROM subclasses WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Subclasses> findByIndex(String value) {
        return findMany("SELECT * FROM subclasses WHERE `index` = ?", value);
    }
    @Override public List<Subclasses> findByUrl(String value) {
        return findMany("SELECT * FROM subclasses WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de subclasses deben recibirse como texto");
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
    protected Subclasses toModel(Map<String, Object> entity) {
        return new Subclasses(
                (String) entity.get("index"),
                (String) entity.get("url"),
                (String) entity.get("name"),
                read(entity.get("class"), ClassClass.class),
                (String) entity.get("summary"),
                (String) entity.get("description"),
                read(entity.get("features"), Feature[].class)
        );
    }

    @Override
    protected Subclasses copy(Subclasses source) {
        return new Subclasses(
                source.getIndex(),
                source.getUrl(),
                source.getName(),
                source.getSubclassClass(),
                source.getSummary(),
                source.getDescription(),
                source.getFeatures()
        );
    }
}

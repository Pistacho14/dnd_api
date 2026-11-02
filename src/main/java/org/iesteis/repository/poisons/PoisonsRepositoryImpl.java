package org.iesteis.repository.poisons;

import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.poisons.Poisons;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

public class PoisonsRepositoryImpl extends BaseRepository<Poisons> implements PoisonsRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public PoisonsRepositoryImpl() { super(); }
    public PoisonsRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "poisons"; }

    @Override
    public Poisons save(Poisons item) {
        int result = db.insert(
                "INSERT INTO poisons (`index`, `name`, `cost`, `type`, `description`, `url`) VALUES (?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getCost(), item.getType(), item.getDescription(), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Poisons updateItem(String index, Poisons item) {
        int result = db.update(
                "UPDATE poisons SET `index` = ?, `name` = ?, `cost` = ?, `type` = ?, `description` = ?, `url` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getCost(), item.getType(), item.getDescription(), item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Poisons> findByName(String value) {
        return findMany("SELECT * FROM poisons WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Poisons> findByIndex(String value) {
        return findMany("SELECT * FROM poisons WHERE `index` = ?", value);
    }
    @Override public List<Poisons> findByUrl(String value) {
        return findMany("SELECT * FROM poisons WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de poisons deben recibirse como texto");
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
    protected Poisons toModel(Map<String, Object> entity) {
        return new Poisons(
                (String) entity.get("index"),
                (String) entity.get("name"),
                (String) entity.get("url"),
                ((Number) entity.get("cost")).longValue(),
                (String) entity.get("type"),
                (String) entity.get("description")
        );
    }

    @Override
    protected Poisons copy(Poisons source) {
        return new Poisons(
                source.getIndex(),
                source.getName(),
                source.getUrl(),
                source.getCost(),
                source.getType(),
                source.getDescription()
        );
    }
}

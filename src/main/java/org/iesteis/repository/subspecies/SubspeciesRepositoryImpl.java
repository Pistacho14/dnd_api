package org.iesteis.repository.subspecies;


import org.iesteis.model.subspecies.Species;
import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.subspecies.Subspecies;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

/**
 * Persiste y reconstruye subespecies en la tabla {@code subspecies}.
 */
public class SubspeciesRepositoryImpl extends BaseRepository<Subspecies> implements SubspeciesRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public SubspeciesRepositoryImpl() { super(); }
    public SubspeciesRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "subspecies"; }

    @Override
    public Subspecies save(Subspecies item) {
        int result = db.insert(
                "INSERT INTO subspecies (`index`, `name`, `url`, `species`, `traits`, `damage_type`) VALUES (?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getUrl(), json(item.getSpecies()), json(item.getTraits()), json(item.getDamageType()));
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Subspecies updateItem(String index, Subspecies item) {
        int result = db.update(
                "UPDATE subspecies SET `index` = ?, `name` = ?, `url` = ?, `species` = ?, `traits` = ?, `damage_type` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getUrl(), json(item.getSpecies()), json(item.getTraits()), json(item.getDamageType()), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Subspecies> findByName(String value) {
        return findMany("SELECT * FROM subspecies WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Subspecies> findByIndex(String value) {
        return findMany("SELECT * FROM subspecies WHERE `index` = ?", value);
    }
    @Override public List<Subspecies> findByUrl(String value) {
        return findMany("SELECT * FROM subspecies WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de subspecies deben recibirse como texto");
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
    protected Subspecies toModel(Map<String, Object> entity) {
        return new Subspecies(
                (String) entity.get("index"),
                (String) entity.get("url"),
                (String) entity.get("name"),
                read(entity.get("damage_type"), Species.class),
                read(entity.get("species"), Species.class),
                read(entity.get("traits"), Species[].class)
        );
    }

    @Override
    protected Subspecies copy(Subspecies source) {
        return new Subspecies(
                source.getIndex(),
                source.getUrl(),
                source.getName(),
                source.getDamageType(),
                source.getSpecies(),
                source.getTraits()
        );
    }
}

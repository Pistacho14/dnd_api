package org.iesteis.repository.species;



import org.iesteis.model.species.Trait;
import org.iesteis.model.species.SizeOptions;
import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.species.Species;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

public class SpeciesRepositoryImpl extends BaseRepository<Species> implements SpeciesRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public SpeciesRepositoryImpl() { super(); }
    public SpeciesRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "species"; }

    @Override
    public Species save(Species item) {
        int result = db.insert(
                "INSERT INTO species (`index`, `name`, `url`, `type`, `size`, `size_options`, `speed`, `traits`, `subspecies`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getUrl(), item.getType(), item.getSize(), json(item.getSizeOptions()), item.getSpeed(), json(item.getTraits()), json(item.getSubspecies()));
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Species updateItem(String index, Species item) {
        int result = db.update(
                "UPDATE species SET `index` = ?, `name` = ?, `url` = ?, `type` = ?, `size` = ?, `size_options` = ?, `speed` = ?, `traits` = ?, `subspecies` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getUrl(), item.getType(), item.getSize(), json(item.getSizeOptions()), item.getSpeed(), json(item.getTraits()), json(item.getSubspecies()), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Species> findByName(String value) {
        return findMany("SELECT * FROM species WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Species> findByIndex(String value) {
        return findMany("SELECT * FROM species WHERE `index` = ?", value);
    }
    @Override public List<Species> findByUrl(String value) {
        return findMany("SELECT * FROM species WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de species deben recibirse como texto");
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
    protected Species toModel(Map<String, Object> entity) {
        return new Species(
                (String) entity.get("index"),
                (String) entity.get("url"),
                (String) entity.get("name"),
                (String) entity.get("type"),
                (String) entity.get("size"),
                ((Number) entity.get("speed")).longValue(),
                read(entity.get("subspecies"), Trait[].class),
                read(entity.get("traits"), Trait[].class),
                read(entity.get("size_options"), SizeOptions.class)
        );
    }

    @Override
    protected Species copy(Species source) {
        return new Species(
                source.getIndex(),
                source.getUrl(),
                source.getName(),
                source.getType(),
                source.getSize(),
                source.getSpeed(),
                source.getSubspecies(),
                source.getTraits(),
                source.getSizeOptions()
        );
    }
}

package org.iesteis.repository.proficiencies;


import org.iesteis.model.proficiencies.Reference;
import org.iesteis.model.proficiencies.Type;
import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.proficiencies.Proficiencies;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

/**
 * Persiste y reconstruye competencias en la tabla {@code proficiencies}.
 */
public class ProficienciesRepositoryImpl extends BaseRepository<Proficiencies> implements ProficienciesRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public ProficienciesRepositoryImpl() { super(); }
    public ProficienciesRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "proficiencies"; }

    @Override
    public Proficiencies save(Proficiencies item) {
        int result = db.insert(
                "INSERT INTO proficiencies (`index`, `name`, `type`, `backgrounds`, `classes`, `reference`, `url`) VALUES (?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), (item.getType() == null ? null : item.getType().toValue()), json(item.getBackgrounds()), json(item.getClasses()), json(item.getReference()), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Proficiencies updateItem(String index, Proficiencies item) {
        int result = db.update(
                "UPDATE proficiencies SET `index` = ?, `name` = ?, `type` = ?, `backgrounds` = ?, `classes` = ?, `reference` = ?, `url` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), (item.getType() == null ? null : item.getType().toValue()), json(item.getBackgrounds()), json(item.getClasses()), json(item.getReference()), item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Proficiencies> findByName(String value) {
        return findMany("SELECT * FROM proficiencies WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Proficiencies> findByIndex(String value) {
        return findMany("SELECT * FROM proficiencies WHERE `index` = ?", value);
    }
    @Override public List<Proficiencies> findByUrl(String value) {
        return findMany("SELECT * FROM proficiencies WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de proficiencies deben recibirse como texto");
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
    protected Proficiencies toModel(Map<String, Object> entity) {
        return new Proficiencies(
                (String) entity.get("index"),
                enumValue(entity.get("type"), Type.class),
                (String) entity.get("name"),
                read(entity.get("classes"), Reference[].class),
                read(entity.get("backgrounds"), Reference[].class),
                (String) entity.get("url"),
                read(entity.get("reference"), Reference.class)
        );
    }

    @Override
    protected Proficiencies copy(Proficiencies source) {
        return new Proficiencies(
                source.getIndex(),
                source.getType(),
                source.getName(),
                source.getClasses(),
                source.getBackgrounds(),
                source.getUrl(),
                source.getReference()
        );
    }
}

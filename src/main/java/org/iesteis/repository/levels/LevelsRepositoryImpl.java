package org.iesteis.repository.levels;


import org.iesteis.model.levels.ClassClass;
import org.iesteis.model.levels.ClassSpecific;
import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.levels.Levels;
import org.iesteis.repository.BaseRepository;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class LevelsRepositoryImpl extends BaseRepository<Levels> implements LevelsRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public LevelsRepositoryImpl() { super(); }
    public LevelsRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "levels"; }

    @Override
    public Levels save(Levels item) {
        int result = db.insert(
                "INSERT INTO levels (`index`, `name`, `level`, `prof_bonus`, `features`, `class`, `subclass`, `class_specific`, `spellcasting`, `url`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getLevel(), item.getProfBonus(), json(item.getFeatures()), json(item.getLevelClass()), json(item.getSubclass()), json(item.getClassSpecific()), json(item.getSpellcasting()), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Levels updateItem(String index, Levels item) {
        int result = db.update(
                "UPDATE levels SET `index` = ?, `name` = ?, `level` = ?, `prof_bonus` = ?, `features` = ?, `class` = ?, `subclass` = ?, `class_specific` = ?, `spellcasting` = ?, `url` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getLevel(), item.getProfBonus(), json(item.getFeatures()), json(item.getLevelClass()), json(item.getSubclass()), json(item.getClassSpecific()), json(item.getSpellcasting()), item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Levels> findByName(String value) {
        return findMany("SELECT * FROM levels WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Levels> findByIndex(String value) {
        return findMany("SELECT * FROM levels WHERE `index` = ?", value);
    }
    @Override public List<Levels> findByUrl(String value) {
        return findMany("SELECT * FROM levels WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de levels deben recibirse como texto");
        }
        return JSON_MAPPER.readValue((String) value, type);
    }

    private <V> V read(Object value, TypeReference<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de levels deben recibirse como texto");
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
    protected Levels toModel(Map<String, Object> entity) {
        return new Levels(
                (String) entity.get("index"),
                (String) entity.get("name"),
                ((Number) entity.get("level")).longValue(),
                number(entity.get("prof_bonus")),
                read(entity.get("features"), ClassClass[].class),
                read(entity.get("class"), ClassClass.class),
                read(entity.get("class_specific"), ClassSpecific.class),
                (String) entity.get("url"),
                read(entity.get("subclass"), ClassClass.class),
                read(entity.get("spellcasting"), new TypeReference<Map<String, Long>>() {})
        );
    }

    @Override
    protected Levels copy(Levels source) {
        return new Levels(
                source.getIndex(),
                source.getName(),
                source.getLevel(),
                source.getProfBonus(),
                source.getFeatures(),
                source.getLevelClass(),
                source.getClassSpecific(),
                source.getUrl(),
                source.getSubclass(),
                source.getSpellcasting()
        );
    }
}

package org.iesteis.repository.feats;

import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.feats.Feats;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

public class FeatsRepositoryImpl extends BaseRepository<Feats> implements FeatsRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public FeatsRepositoryImpl() { super(); }
    public FeatsRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "feats"; }

    @Override
    public Feats save(Feats item) {
        int result = db.insert(
                "INSERT INTO feats (`index`, name, description, type, repeatable, prerequisites, prerequisite_options, url) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getDescription(), item.getType(), item.getRepeatable(),
                JSON_MAPPER.writeValueAsString(item.getPrerequisites()),
                JSON_MAPPER.writeValueAsString(item.getPrerequisiteOptions()), item.getUrl());
        if (result <= 0) {
            return null;
        }

        return toModel(item);
    }

    @Override
    protected Feats updateItem(String index, Feats item) {
        int result = db.update(
                "UPDATE feats SET `index` = ?, name = ?, description = ?, type = ?, repeatable = ?, "
                        + "prerequisites = ?, prerequisite_options = ?, url = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getDescription(), item.getType(), item.getRepeatable(),
                JSON_MAPPER.writeValueAsString(item.getPrerequisites()),
                JSON_MAPPER.writeValueAsString(item.getPrerequisiteOptions()), item.getUrl(), index);
        if (result <= 0) {
            return null;
        }

        return toModel(item);
    }

    @Override public List<Feats> findByName(String value) {
        return findMany("SELECT * FROM feats WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Feats> findByIndex(String value) {
        return findMany("SELECT * FROM feats WHERE `index` = ?", value);
    }
    @Override public List<Feats> findByUrl(String value) {
        return findMany("SELECT * FROM feats WHERE url = ?", value);
    }

    @Override
    protected Feats toModel(Map<String, Object> entity) {
        return new Feats(
                (String) entity.get("index"),
                (String) entity.get("name"),
                (String) entity.get("description"),
                (String) entity.get("type"),
                (String) entity.get("repeatable"),
                readJson(entity.get("prerequisites")),
                readJson(entity.get("prerequisite_options")),
                (String) entity.get("url"));
    }

    private Object readJson(Object value) {
        if (value == null) {
            return null;
        }
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de feats deben recibirse como texto");
        }
        return JSON_MAPPER.readValue((String) value, Object.class);
    }

    private Feats toModel(Feats source) {
        return new Feats(
                source.getIndex(),
                source.getName(),
                source.getDescription(),
                source.getType(),
                source.getRepeatable(),
                source.getPrerequisites(),
                source.getPrerequisiteOptions(),
                source.getUrl());
    }

    @Override
    protected Feats copy(Feats source) {
        return toModel(source);
    }
}

package org.iesteis.repository.languages;

import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.languages.Languages;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

public class LanguagesRepositoryImpl extends BaseRepository<Languages> implements LanguagesRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public LanguagesRepositoryImpl() { super(); }
    public LanguagesRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "languages"; }

    @Override
    public Languages save(Languages item) {
        int result = db.insert(
                "INSERT INTO languages (`index`, `name`, `is_rare`, `note`, `url`) VALUES (?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getIsRare(), item.getNote(), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Languages updateItem(String index, Languages item) {
        int result = db.update(
                "UPDATE languages SET `index` = ?, `name` = ?, `is_rare` = ?, `note` = ?, `url` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getIsRare(), item.getNote(), item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Languages> findByName(String value) {
        return findMany("SELECT * FROM languages WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Languages> findByIndex(String value) {
        return findMany("SELECT * FROM languages WHERE `index` = ?", value);
    }
    @Override public List<Languages> findByUrl(String value) {
        return findMany("SELECT * FROM languages WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de languages deben recibirse como texto");
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
    protected Languages toModel(Map<String, Object> entity) {
        return new Languages(
                (String) entity.get("index"),
                (String) entity.get("name"),
                (Boolean) entity.get("is_rare"),
                (String) entity.get("note"),
                (String) entity.get("url")
        );
    }

    @Override
    protected Languages copy(Languages source) {
        return new Languages(
                source.getIndex(),
                source.getName(),
                source.getIsRare(),
                source.getNote(),
                source.getUrl()
        );
    }
}

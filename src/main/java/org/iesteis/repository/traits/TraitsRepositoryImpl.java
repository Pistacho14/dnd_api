package org.iesteis.repository.traits;



import org.iesteis.model.traits.Species;
import org.iesteis.model.traits.Spell;
import org.iesteis.model.traits.ProficiencyChoices;
import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.traits.Traits;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

public class TraitsRepositoryImpl extends BaseRepository<Traits> implements TraitsRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public TraitsRepositoryImpl() { super(); }
    public TraitsRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "traits"; }

    @Override
    public Traits save(Traits item) {
        int result = db.insert(
                "INSERT INTO traits (`index`, `name`, `url`, `description`, `species`, `spells`, `subspecies`, `proficiency_choices`, `speed`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getUrl(), item.getDescription(), json(item.getSpecies()), json(item.getSpells()), json(item.getSubspecies()), json(item.getProficiencyChoices()), item.getSpeed());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Traits updateItem(String index, Traits item) {
        int result = db.update(
                "UPDATE traits SET `index` = ?, `name` = ?, `url` = ?, `description` = ?, `species` = ?, `spells` = ?, `subspecies` = ?, `proficiency_choices` = ?, `speed` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getUrl(), item.getDescription(), json(item.getSpecies()), json(item.getSpells()), json(item.getSubspecies()), json(item.getProficiencyChoices()), item.getSpeed(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Traits> findByName(String value) {
        return findMany("SELECT * FROM traits WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Traits> findByIndex(String value) {
        return findMany("SELECT * FROM traits WHERE `index` = ?", value);
    }
    @Override public List<Traits> findByUrl(String value) {
        return findMany("SELECT * FROM traits WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de traits deben recibirse como texto");
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
    protected Traits toModel(Map<String, Object> entity) {
        return new Traits(
                (String) entity.get("index"),
                (String) entity.get("url"),
                (String) entity.get("name"),
                (String) entity.get("description"),
                read(entity.get("species"), Species[].class),
                read(entity.get("subspecies"), Species[].class),
                read(entity.get("spells"), Spell[].class),
                read(entity.get("proficiency_choices"), ProficiencyChoices.class),
                number(entity.get("speed"))
        );
    }

    @Override
    protected Traits copy(Traits source) {
        return new Traits(
                source.getIndex(),
                source.getUrl(),
                source.getName(),
                source.getDescription(),
                source.getSpecies(),
                source.getSubspecies(),
                source.getSpells(),
                source.getProficiencyChoices(),
                source.getSpeed()
        );
    }
}

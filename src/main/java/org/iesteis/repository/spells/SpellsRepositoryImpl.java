package org.iesteis.repository.spells;



import org.iesteis.model.spells.Component;
import org.iesteis.model.spells.AttackType;
import org.iesteis.model.spells.Damage;
import org.iesteis.model.spells.School;
import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.spells.Spells;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

/**
 * Persiste y reconstruye conjuros en la tabla {@code spells}.
 */
public class SpellsRepositoryImpl extends BaseRepository<Spells> implements SpellsRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public SpellsRepositoryImpl() { super(); }
    public SpellsRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "spells"; }

    @Override
    public Spells save(Spells item) {
        int result = db.insert(
                "INSERT INTO spells (`index`, `name`, `description`, `higher_level`, `range`, `components`, `material`, `ritual`, `duration`, `concentration`, `casting_time`, `level`, `attack_type`, `damage`, `dc`, `area_of_effect`, `heal_at_slot_level`, `school`, `classes`, `subclasses`, `url`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getDescription(), item.getHigherLevel(), item.getRange(), json(item.getComponents()), item.getMaterial(), item.getRitual(), item.getDuration(), item.getConcentration(), item.getCastingTime(), item.getLevel(), (item.getAttackType() == null ? null : item.getAttackType().toValue()), json(item.getDamage()), null, null, null, json(item.getSchool()), json(item.getClasses()), null, item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Spells updateItem(String index, Spells item) {
        int result = db.update(
                "UPDATE spells SET `index` = ?, `name` = ?, `description` = ?, `higher_level` = ?, `range` = ?, `components` = ?, `material` = ?, `ritual` = ?, `duration` = ?, `concentration` = ?, `casting_time` = ?, `level` = ?, `attack_type` = ?, `damage` = ?, `dc` = ?, `area_of_effect` = ?, `heal_at_slot_level` = ?, `school` = ?, `classes` = ?, `subclasses` = ?, `url` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getDescription(), item.getHigherLevel(), item.getRange(), json(item.getComponents()), item.getMaterial(), item.getRitual(), item.getDuration(), item.getConcentration(), item.getCastingTime(), item.getLevel(), (item.getAttackType() == null ? null : item.getAttackType().toValue()), json(item.getDamage()), null, null, null, json(item.getSchool()), json(item.getClasses()), null, item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Spells> findByName(String value) {
        return findMany("SELECT * FROM spells WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Spells> findByIndex(String value) {
        return findMany("SELECT * FROM spells WHERE `index` = ?", value);
    }
    @Override public List<Spells> findByUrl(String value) {
        return findMany("SELECT * FROM spells WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de spells deben recibirse como texto");
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
    protected Spells toModel(Map<String, Object> entity) {
        return new Spells(
                (String) entity.get("index"),
                (String) entity.get("url"),
                (String) entity.get("name"),
                ((Number) entity.get("level")).longValue(),
                read(entity.get("school"), School.class),
                read(entity.get("classes"), School[].class),
                (String) entity.get("casting_time"),
                (Boolean) entity.get("ritual"),
                (String) entity.get("range"),
                read(entity.get("components"), Component[].class),
                (String) entity.get("material"),
                (String) entity.get("duration"),
                (Boolean) entity.get("concentration"),
                enumValue(entity.get("attack_type"), AttackType.class),
                read(entity.get("damage"), Damage.class),
                (String) entity.get("description"),
                (String) entity.get("higher_level")
        );
    }

    @Override
    protected Spells copy(Spells source) {
        return new Spells(
                source.getIndex(),
                source.getUrl(),
                source.getName(),
                source.getLevel(),
                source.getSchool(),
                source.getClasses(),
                source.getCastingTime(),
                source.getRitual(),
                source.getRange(),
                source.getComponents(),
                source.getMaterial(),
                source.getDuration(),
                source.getConcentration(),
                source.getAttackType(),
                source.getDamage(),
                source.getDescription(),
                source.getHigherLevel()
        );
    }
}

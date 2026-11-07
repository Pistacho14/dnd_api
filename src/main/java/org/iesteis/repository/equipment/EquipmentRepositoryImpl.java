package org.iesteis.repository.equipment;



import org.iesteis.model.equipment.Content;
import org.iesteis.model.equipment.Utilize;
import org.iesteis.model.equipment.Ability;
import org.iesteis.model.equipment.ArmorClass;
import org.iesteis.model.equipment.Cost;
import org.iesteis.model.equipment.Damage;
import org.iesteis.model.equipment.Range;
import org.iesteis.model.equipment.Time;
import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.equipment.Equipment;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

/**
 * Persiste y reconstruye equipo en la tabla {@code equipment}.
 */
public class EquipmentRepositoryImpl extends BaseRepository<Equipment> implements EquipmentRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public EquipmentRepositoryImpl() { super(); }
    public EquipmentRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "equipment"; }

    @Override
    public Equipment save(Equipment item) {
        int result = db.insert(
                "INSERT INTO equipment (`index`, name, equipment_categories, cost, url, description, weight, ammunition, "
                        + "armor_class, contents, ability, craft, damage, doff_time, don_time, image, mastery, notes, "
                        + "properties, quantity, storage, `range`, stealth_disadvantage, str_minimum, throw_range, "
                        + "two_handed_damage, utilize) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                        + "?, ?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), json(item.getEquipmentCategories()), json(item.getCost()), item.getUrl(),
                text(item.getDescription()), item.getWeight(), json(item.getAmmunition()), json(item.getArmorClass()),
                json(item.getContents()), json(item.getAbility()), json(item.getCraft()), json(item.getDamage()),
                json(item.getDoffTime()), json(item.getDonTime()), item.getImage(), json(item.getMastery()),
                json(item.getNotes()), json(item.getProperties()), item.getQuantity(), json(item.getStorage()),
                json(item.getRange()), item.getStealthDisadvantage(), item.getStrMinimum(), json(item.getThrowRange()),
                json(item.getTwoHandedDamage()), json(item.getUtilize()));
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Equipment updateItem(String index, Equipment item) {
        int result = db.update(
                "UPDATE equipment SET `index` = ?, name = ?, equipment_categories = ?, cost = ?, url = ?, description = ?, "
                        + "weight = ?, ammunition = ?, armor_class = ?, contents = ?, ability = ?, craft = ?, damage = ?, "
                        + "doff_time = ?, don_time = ?, image = ?, mastery = ?, notes = ?, properties = ?, quantity = ?, "
                        + "storage = ?, `range` = ?, stealth_disadvantage = ?, str_minimum = ?, throw_range = ?, "
                        + "two_handed_damage = ?, utilize = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), json(item.getEquipmentCategories()), json(item.getCost()), item.getUrl(),
                text(item.getDescription()), item.getWeight(), json(item.getAmmunition()), json(item.getArmorClass()),
                json(item.getContents()), json(item.getAbility()), json(item.getCraft()), json(item.getDamage()),
                json(item.getDoffTime()), json(item.getDonTime()), item.getImage(), json(item.getMastery()),
                json(item.getNotes()), json(item.getProperties()), item.getQuantity(), json(item.getStorage()),
                json(item.getRange()), item.getStealthDisadvantage(), item.getStrMinimum(), json(item.getThrowRange()),
                json(item.getTwoHandedDamage()), json(item.getUtilize()), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Equipment> findByName(String value) {
        return findMany("SELECT * FROM equipment WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Equipment> findByIndex(String value) {
        return findMany("SELECT * FROM equipment WHERE `index` = ?", value);
    }
    @Override public List<Equipment> findByUrl(String value) {
        return findMany("SELECT * FROM equipment WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private String text(String[] value) {
        return value == null ? null : String.join(System.lineSeparator(), value);
    }

    @Override
    protected Equipment toModel(Map<String, Object> entity) {
        return new Equipment(
                (String) entity.get("index"),
                (String) entity.get("name"),
                read(entity.get("equipment_categories"), Ability[].class),
                read(entity.get("cost"), Cost.class),
                number(entity.get("weight"), Double.class),
                lines(entity.get("description")),
                (String) entity.get("url"),
                read(entity.get("ability"), Ability.class),
                read(entity.get("craft"), Ability[].class),
                read(entity.get("utilize"), Utilize[].class),
                number(entity.get("quantity"), Long.class),
                read(entity.get("storage"), Ability.class),
                (String) entity.get("image"),
                read(entity.get("damage"), Damage.class),
                read(entity.get("range"), Range.class),
                read(entity.get("properties"), Ability[].class),
                read(entity.get("mastery"), Ability.class),
                read(entity.get("two_handed_damage"), Damage.class),
                read(entity.get("ammunition"), Ability.class),
                read(entity.get("armor_class"), ArmorClass.class),
                read(entity.get("don_time"), Time.class),
                read(entity.get("doff_time"), Time.class),
                (Boolean) entity.get("stealth_disadvantage"),
                number(entity.get("str_minimum"), Long.class),
                read(entity.get("contents"), Content[].class),
                read(entity.get("throw_range"), Range.class),
                read(entity.get("notes"), String[].class));
    }

    private <V> V read(Object value, Class<V> type) {
        return value == null ? null : JSON_MAPPER.readValue((String) value, type);
    }

    private String[] lines(Object value) {
        return value == null ? null : ((String) value).split("\\R", -1);
    }

    @SuppressWarnings("unchecked")
    private <V> V number(Object value, Class<V> type) {
        if (value == null) return null;
        Number number = (Number) value;
        if (type == Double.class) {
            return (V) Double.valueOf(number.doubleValue());
        }
        return (V) Long.valueOf(number.longValue());
    }

    @Override protected Equipment copy(Equipment source) {
        return new Equipment(
                source.getIndex(), source.getName(), source.getEquipmentCategories(), source.getCost(),
                source.getWeight(), source.getDescription(), source.getUrl(), source.getAbility(),
                source.getCraft(), source.getUtilize(), source.getQuantity(), source.getStorage(), source.getImage(),
                source.getDamage(), source.getRange(), source.getProperties(), source.getMastery(),
                source.getTwoHandedDamage(), source.getAmmunition(), source.getArmorClass(), source.getDonTime(),
                source.getDoffTime(), source.getStealthDisadvantage(), source.getStrMinimum(), source.getContents(),
                source.getThrowRange(), source.getNotes());
    }
}

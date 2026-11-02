package org.iesteis.repository.classes;



import org.iesteis.model.classes.Proficiency;
import org.iesteis.model.classes.ProficiencyChoice;
import org.iesteis.model.classes.StartingEquipmentOption;
import org.iesteis.model.classes.MultiClassing;
import org.iesteis.model.classes.PrimaryAbility;
import org.iesteis.model.classes.Spellcasting;
import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.classes.Classes;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

public class ClassesRepositoryImpl extends BaseRepository<Classes> implements ClassesRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public ClassesRepositoryImpl() { super(); }
    public ClassesRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "classes"; }

    @Override
    public Classes save(Classes item) {
        int result = db.insert(
                "INSERT INTO classes (`index`, name, primary_ability, hit_die, class_levels, multi_classing, "
                        + "proficiencies, proficiency_choices, saving_throws, starting_equipment_options, subclasses, "
                        + "spellcasting, spells, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), json(item.getPrimaryAbility()), item.getHitDie(), item.getClassLevels(),
                json(item.getMultiClassing()), json(item.getProficiencies()), json(item.getProficiencyChoices()),
                json(item.getSavingThrows()), json(item.getStartingEquipmentOptions()), json(item.getSubclasses()),
                json(item.getSpellcasting()), item.getSpells(), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Classes updateItem(String index, Classes item) {
        int result = db.update(
                "UPDATE classes SET `index` = ?, name = ?, primary_ability = ?, hit_die = ?, class_levels = ?, "
                        + "multi_classing = ?, proficiencies = ?, proficiency_choices = ?, saving_throws = ?, "
                        + "starting_equipment_options = ?, subclasses = ?, spellcasting = ?, spells = ?, url = ? "
                        + "WHERE `index` = ?",
                item.getIndex(), item.getName(), json(item.getPrimaryAbility()), item.getHitDie(), item.getClassLevels(),
                json(item.getMultiClassing()), json(item.getProficiencies()), json(item.getProficiencyChoices()),
                json(item.getSavingThrows()), json(item.getStartingEquipmentOptions()), json(item.getSubclasses()),
                json(item.getSpellcasting()), item.getSpells(), item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Classes> findByName(String value) {
        return findMany("SELECT * FROM classes WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Classes> findByIndex(String value) {
        return findMany("SELECT * FROM classes WHERE `index` = ?", value);
    }
    @Override public List<Classes> findByUrl(String value) {
        return findMany("SELECT * FROM classes WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    @Override
    protected Classes toModel(Map<String, Object> entity) {
        return new Classes(
                (String) entity.get("index"),
                (String) entity.get("name"),
                read(entity.get("primary_ability"), PrimaryAbility.class),
                ((Number) entity.get("hit_die")).longValue(),
                read(entity.get("proficiency_choices"), ProficiencyChoice[].class),
                read(entity.get("proficiencies"), Proficiency[].class),
                read(entity.get("saving_throws"), Proficiency[].class),
                read(entity.get("starting_equipment_options"),
                        StartingEquipmentOption[].class),
                (String) entity.get("class_levels"),
                read(entity.get("multi_classing"), MultiClassing.class),
                read(entity.get("subclasses"), Proficiency[].class),
                (String) entity.get("url"),
                read(entity.get("spellcasting"), Spellcasting.class),
                (String) entity.get("spells"));
    }

    private <V> V read(Object value, Class<V> type) {
        return value == null ? null : JSON_MAPPER.readValue((String) value, type);
    }

    @Override protected Classes copy(Classes source) {
        return new Classes(
                source.getIndex(),
                source.getName(),
                source.getPrimaryAbility(),
                source.getHitDie(),
                source.getProficiencyChoices(),
                source.getProficiencies(),
                source.getSavingThrows(),
                source.getStartingEquipmentOptions(),
                source.getClassLevels(),
                source.getMultiClassing(),
                source.getSubclasses(),
                source.getUrl(),
                source.getSpellcasting(),
                source.getSpells());
    }
}

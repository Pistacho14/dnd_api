package org.iesteis.repository.monsters;



import org.iesteis.model.monsters.ArmorClass;
import org.iesteis.model.monsters.BonusAction;
import org.iesteis.model.monsters.ConditionImmunity;
import org.iesteis.model.monsters.DamageImmunityElement;
import org.iesteis.model.monsters.LegendaryAction;
import org.iesteis.model.monsters.MonsterAction;
import org.iesteis.model.monsters.Proficiency;
import org.iesteis.model.monsters.Reaction;
import org.iesteis.model.monsters.SpecialAbility;
import org.iesteis.model.monsters.Alignment;
import org.iesteis.model.monsters.MonsterType;
import org.iesteis.model.monsters.Senses;
import org.iesteis.model.monsters.Size;
import org.iesteis.model.monsters.Speed;
import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.monsters.Monster;
import org.iesteis.repository.BaseRepository;

import tools.jackson.databind.ObjectMapper;

/**
 * Persiste y reconstruye monstruos en la tabla {@code monsters}.
 */
public class MonstersRepositoryImpl extends BaseRepository<Monster> implements MonstersRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public MonstersRepositoryImpl() { super(); }
    public MonstersRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "monsters"; }

    @Override
    public Monster save(Monster item) {
        int result = db.insert(
                "INSERT INTO monsters (`index`, `name`, `size`, `type`, `subtype`, `alignment`, `armor_class`, `hit_points`, `hit_dice`, `hit_points_roll`, `speed`, `strength`, `dexterity`, `constitution`, `intelligence`, `wisdom`, `charisma`, `proficiencies`, `damage_vulnerabilities`, `damage_resistances`, `damage_immunities`, `condition_immunities`, `senses`, `languages`, `challenge_rating`, `gear`, `proficiency_bonus`, `xp`, `xp_in_lair`, `special_abilities`, `actions`, `bonus_actions`, `legendary_actions`, `reactions`, `forms`, `image`, `url`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), (item.getSize() == null ? null : item.getSize().toValue()), (item.getType() == null ? null : item.getType().toValue()), null, (item.getAlignment() == null ? null : item.getAlignment().toValue()), json(item.getArmorClass()), item.getHitPoints(), item.getHitDice(), item.getHitPointsRoll(), json(item.getSpeed()), item.getStrength(), item.getDexterity(), item.getConstitution(), item.getIntelligence(), item.getWisdom(), item.getCharisma(), json(item.getProficiencies()), json(item.getDamageVulnerabilities()), json(item.getDamageResistances()), json(item.getDamageImmunities()), json(item.getConditionImmunities()), json(item.getSenses()), item.getLanguages(), item.getChallengeRating(), item.getGear(), item.getProficiencyBonus(), item.getXP(), item.getXPInLair(), json(item.getSpecialAbilities()), json(item.getActions()), json(item.getBonusActions()), json(item.getLegendaryActions()), json(item.getReactions()), json(item.getForms()), item.getImage(), item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Monster updateItem(String index, Monster item) {
        int result = db.update(
                "UPDATE monsters SET `index` = ?, `name` = ?, `size` = ?, `type` = ?, `subtype` = ?, `alignment` = ?, `armor_class` = ?, `hit_points` = ?, `hit_dice` = ?, `hit_points_roll` = ?, `speed` = ?, `strength` = ?, `dexterity` = ?, `constitution` = ?, `intelligence` = ?, `wisdom` = ?, `charisma` = ?, `proficiencies` = ?, `damage_vulnerabilities` = ?, `damage_resistances` = ?, `damage_immunities` = ?, `condition_immunities` = ?, `senses` = ?, `languages` = ?, `challenge_rating` = ?, `gear` = ?, `proficiency_bonus` = ?, `xp` = ?, `xp_in_lair` = ?, `special_abilities` = ?, `actions` = ?, `bonus_actions` = ?, `legendary_actions` = ?, `reactions` = ?, `forms` = ?, `image` = ?, `url` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), (item.getSize() == null ? null : item.getSize().toValue()), (item.getType() == null ? null : item.getType().toValue()), null, (item.getAlignment() == null ? null : item.getAlignment().toValue()), json(item.getArmorClass()), item.getHitPoints(), item.getHitDice(), item.getHitPointsRoll(), json(item.getSpeed()), item.getStrength(), item.getDexterity(), item.getConstitution(), item.getIntelligence(), item.getWisdom(), item.getCharisma(), json(item.getProficiencies()), json(item.getDamageVulnerabilities()), json(item.getDamageResistances()), json(item.getDamageImmunities()), json(item.getConditionImmunities()), json(item.getSenses()), item.getLanguages(), item.getChallengeRating(), item.getGear(), item.getProficiencyBonus(), item.getXP(), item.getXPInLair(), json(item.getSpecialAbilities()), json(item.getActions()), json(item.getBonusActions()), json(item.getLegendaryActions()), json(item.getReactions()), json(item.getForms()), item.getImage(), item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Monster> findByName(String value) {
        return findMany("SELECT * FROM monsters WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Monster> findByIndex(String value) {
        return findMany("SELECT * FROM monsters WHERE `index` = ?", value);
    }
    @Override public List<Monster> findByUrl(String value) {
        return findMany("SELECT * FROM monsters WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de monsters deben recibirse como texto");
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
    protected Monster toModel(Map<String, Object> entity) {
        return new Monster(
                (String) entity.get("name"),
                enumValue(entity.get("size"), Size.class),
                enumValue(entity.get("type"), MonsterType.class),
                enumValue(entity.get("alignment"), Alignment.class),
                read(entity.get("armor_class"), ArmorClass[].class),
                ((Number) entity.get("hit_points")).longValue(),
                (String) entity.get("hit_dice"),
                read(entity.get("speed"), Speed.class),
                ((Number) entity.get("strength")).longValue(),
                ((Number) entity.get("dexterity")).longValue(),
                ((Number) entity.get("constitution")).longValue(),
                ((Number) entity.get("intelligence")).longValue(),
                ((Number) entity.get("wisdom")).longValue(),
                ((Number) entity.get("charisma")).longValue(),
                read(entity.get("damage_resistances"), DamageImmunityElement[].class),
                read(entity.get("damage_vulnerabilities"), String[].class),
                read(entity.get("damage_immunities"), DamageImmunityElement[].class),
                read(entity.get("condition_immunities"), ConditionImmunity[].class),
                read(entity.get("senses"), Senses.class),
                (String) entity.get("languages"),
                ((Number) entity.get("challenge_rating")).doubleValue(),
                read(entity.get("special_abilities"), SpecialAbility[].class),
                read(entity.get("actions"), MonsterAction[].class),
                read(entity.get("legendary_actions"), LegendaryAction[].class),
                (String) entity.get("index"),
                (String) entity.get("url"),
                (String) entity.get("image"),
                (String) entity.get("hit_points_roll"),
                read(entity.get("proficiencies"), Proficiency[].class),
                ((Number) entity.get("proficiency_bonus")).longValue(),
                ((Number) entity.get("xp")).longValue(),
                number(entity.get("xp_in_lair")),
                read(entity.get("bonus_actions"), BonusAction[].class),
                (String) entity.get("gear"),
                read(entity.get("reactions"), Reaction[].class),
                read(entity.get("forms"), ConditionImmunity[].class)
        );
    }

    @Override
    protected Monster copy(Monster source) {
        return new Monster(
                source.getName(),
                source.getSize(),
                source.getType(),
                source.getAlignment(),
                source.getArmorClass(),
                source.getHitPoints(),
                source.getHitDice(),
                source.getSpeed(),
                source.getStrength(),
                source.getDexterity(),
                source.getConstitution(),
                source.getIntelligence(),
                source.getWisdom(),
                source.getCharisma(),
                source.getDamageResistances(),
                source.getDamageVulnerabilities(),
                source.getDamageImmunities(),
                source.getConditionImmunities(),
                source.getSenses(),
                source.getLanguages(),
                source.getChallengeRating(),
                source.getSpecialAbilities(),
                source.getActions(),
                source.getLegendaryActions(),
                source.getIndex(),
                source.getUrl(),
                source.getImage(),
                source.getHitPointsRoll(),
                source.getProficiencies(),
                source.getProficiencyBonus(),
                source.getXP(),
                source.getXPInLair(),
                source.getBonusActions(),
                source.getGear(),
                source.getReactions(),
                source.getForms()
        );
    }
}

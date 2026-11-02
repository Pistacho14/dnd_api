package org.iesteis.repository.background;

import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.background.Background;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

public class BackgroundRepositoryImpl extends BaseRepository<Background> implements BackgroundRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public BackgroundRepositoryImpl() { super(); }
    public BackgroundRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "backgrounds"; }

    @Override
    public Background save(Background item) {
        int result = db.insert(
                "INSERT INTO backgrounds (`index`, name, ability_scores, feat, proficiencies, proficiency_choices, "
                        + "equipment_options, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), json(item.getAbilityScores()), json(item.getFeat()),
                json(item.getProficiencies()), json(item.getProficiencyChoices()), json(item.getEquipmentOptions()),
                item.getUrl());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected Background updateItem(String index, Background item) {
        int result = db.update(
                "UPDATE backgrounds SET `index` = ?, name = ?, ability_scores = ?, feat = ?, proficiencies = ?, "
                        + "proficiency_choices = ?, equipment_options = ?, url = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), json(item.getAbilityScores()), json(item.getFeat()),
                json(item.getProficiencies()), json(item.getProficiencyChoices()), json(item.getEquipmentOptions()),
                item.getUrl(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<Background> findByName(String value) {
        return findMany("SELECT * FROM backgrounds WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<Background> findByIndex(String value) {
        return findMany("SELECT * FROM backgrounds WHERE `index` = ?", value);
    }
    @Override public List<Background> findByUrl(String value) {
        return findMany("SELECT * FROM backgrounds WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    @Override
    protected Background toModel(Map<String, Object> entity) {
        return new Background(
                (String) entity.get("index"),
                (String) entity.get("name"),
                read(entity.get("ability_scores"), org.iesteis.model.background.Feat[].class),
                read(entity.get("feat"), org.iesteis.model.background.Feat.class),
                read(entity.get("proficiencies"), org.iesteis.model.background.Feat[].class),
                read(entity.get("equipment_options"), org.iesteis.model.background.EquipmentOption[].class),
                (String) entity.get("url"),
                read(entity.get("proficiency_choices"),
                        org.iesteis.model.background.ProficiencyChoice[].class));
    }

    private <V> V read(Object value, Class<V> type) {
        return value == null ? null : JSON_MAPPER.readValue((String) value, type);
    }

    @Override protected Background copy(Background source) {
        return new Background(
                source.getIndex(),
                source.getName(),
                source.getAbilityScores(),
                source.getFeat(),
                source.getProficiencies(),
                source.getEquipmentOptions(),
                source.getUrl(),
                source.getProficiencyChoices());
    }
}

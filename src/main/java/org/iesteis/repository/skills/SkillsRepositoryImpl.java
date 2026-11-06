package org.iesteis.repository.skills;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.skills.AbilityScore;
import org.iesteis.model.skills.Skills;
import org.iesteis.repository.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.databind.ObjectMapper;

public class SkillsRepositoryImpl extends BaseRepository<Skills>
        implements SkillsRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private final Logger logger = LoggerFactory.getLogger(SkillsRepositoryImpl.class.getName());

    public SkillsRepositoryImpl() {
        super();
    }

    public SkillsRepositoryImpl(DatabaseManager db) {
        super(db);
    }

    @Override
    public Skills save(Skills skill) {
        logger.debug("Guardando skill: " + skill.getIndex());

        String sql = "INSERT INTO skills "
                + "(`index`, name, description, url, ability_score_index) VALUES (?, ?, ?, ?, ?, ?)";
        int result = db.insert(
                sql,
                skill.getIndex(),
                skill.getName(),
                skill.getDescription(),
                skill.getUrl(),
                skill.getAbilityScore() != null ? skill.getAbilityScore().getName() : null);
        if (result <= 0) {
            return null;
        }

        return copy(skill);
    }

    @Override
    protected Skills updateItem(String index, Skills skill) {
        logger.debug("Actualizando skill por index: " + index);

        if (findById(index) == null) {
            return null;
        }

        String sql = "UPDATE skills SET `index` = ?, name = ?, description = ?, "
                + "ability_score = ?, url = ? WHERE `index` = ?";
        int result = db.update(
                sql,
                skill.getIndex(),
                skill.getName(),
                skill.getDescription(),
                JSON_MAPPER.writeValueAsString(skill.getAbilityScore()),
                skill.getUrl(),
                index);
        if (result <= 0) {
            return null;
        }

        return copy(skill);
    }

    @Override
    public List<Skills> findByName(String name) {
        logger.debug("Buscando skills por nombre: " + name);

        String sql = "SELECT * FROM skills WHERE LOWER(name) LIKE LOWER(?)";
        return findMany(sql, "%" + name + "%");
    }

    @Override
    public List<Skills> findByIndex(String index) {
        logger.debug("Buscando skills por index: " + index);

        String sql = "SELECT * FROM skills WHERE `index` = ?";
        return findMany(sql, index);
    }

    @Override
    public List<Skills> findByDescription(String description) {
        logger.debug("Buscando skills por descripción: " + description);

        String sql = "SELECT * FROM skills WHERE LOWER(description) LIKE LOWER(?)";
        return findMany(sql, "%" + description + "%");
    }

    @Override
    public List<Skills> findByAbilityScoreIndex(String abilityScoreIndex) {
        logger.debug("Buscando skills por ability score: " + abilityScoreIndex);

        return findAll().stream()
                .filter(skill -> skill.getAbilityScore() != null
                        && abilityScoreIndex.equals(skill.getAbilityScore().getIndex()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Skills> findByUrl(String url) {
        logger.debug("Buscando skills por url: " + url);

        String sql = "SELECT * FROM skills WHERE url = ?";
        return findMany(sql, url);
    }

    @Override
    protected String tableName() {
        return "skills";
    }

    @Override
    protected Skills toModel(Map<String, Object> entity) {
        Object abilityScore = entity.get("ability_score");

        return new Skills(
                (String) entity.get("index"),
                (String) entity.get("name"),
                (String) entity.get("description"),
                abilityScore == null ? null : JSON_MAPPER.readValue((String) abilityScore, AbilityScore.class),
                (String) entity.get("url")
        );
    }

    @Override
    protected Skills copy(Skills source) {
        return new Skills(
                source.getIndex(),
                source.getName(),
                source.getDescription(),
                source.getAbilityScore(),
                source.getUrl()
        );
    }
}

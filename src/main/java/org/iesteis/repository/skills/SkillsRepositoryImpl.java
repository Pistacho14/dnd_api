package org.iesteis.repository.skills;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.iesteis.database.DatabaseManager;
import org.iesteis.database.DatabaseService;
import org.iesteis.model.skills.AbilityScore;
import org.iesteis.model.skills.Skills;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkillsRepositoryImpl implements SkillsRepository {

    private final DatabaseManager db;

    private final Logger logger = LoggerFactory.getLogger(SkillsRepositoryImpl.class.getName());

    public SkillsRepositoryImpl() {
        this.db = new DatabaseService();
    }

    public SkillsRepositoryImpl(DatabaseManager db) {
        this.db = db;
    }

    @Override
    public List<Skills> findAll() {
        logger.debug("Buscando todas las skills");

        String sql = "SELECT * FROM skills";
        return db.select(sql).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Skills findById(String index) {
        logger.debug("Buscando skill por index: " + index);

        String sql = "SELECT * FROM skills WHERE `index` = ?";
        List<Map<String, Object>> result = db.select(sql, index);
        if (result.isEmpty()) {
            return null;
        }
        return toModel(result.get(0));
    }

    @Override
    public Skills save(Skills skill) {
        logger.debug("Guardando skill: " + skill.getIndex());

        String sql = "INSERT INTO skills "
                + "(`index`, name, description, ability_score_index, url) VALUES (?, ?, ?, ?, ?)";
        int result = db.insert(
                sql,
                skill.getIndex(),
                skill.getName(),
                skill.getDescription(),
                getAbilityScoreIndex(skill),
                skill.getUrl());
        if (result <= 0) {
            return null;
        }

        return toModel(skill);
    }

    @Override
    public Skills update(String index, Skills skill) {
        logger.debug("Actualizando skill por index: " + index);

        if (findById(index) == null) {
            return null;
        }

        String sql = "UPDATE skills SET `index` = ?, name = ?, description = ?, "
                + "ability_score_index = ?, url = ? WHERE `index` = ?";
        int result = db.update(
                sql,
                skill.getIndex(),
                skill.getName(),
                skill.getDescription(),
                getAbilityScoreIndex(skill),
                skill.getUrl(),
                index);
        if (result <= 0) {
            return null;
        }

        return toModel(skill);
    }

    @Override
    public Skills delete(String index) {
        logger.debug("Borrando skill por index: " + index);

        Skills skill = findById(index);
        if (skill == null) {
            return null;
        }

        String sql = "DELETE FROM skills WHERE `index` = ?";
        int result = db.delete(sql, index);
        if (result <= 0) {
            return null;
        }

        return skill;
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

        String sql = "SELECT * FROM skills WHERE ability_score_index = ?";
        return findMany(sql, abilityScoreIndex);
    }

    @Override
    public List<Skills> findByUrl(String url) {
        logger.debug("Buscando skills por url: " + url);

        String sql = "SELECT * FROM skills WHERE url = ?";
        return findMany(sql, url);
    }

    private List<Skills> findMany(String sql, Object parameter) {
        return db.select(sql, parameter).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private String getAbilityScoreIndex(Skills skill) {
        return skill.getAbilityScore() == null ? null : skill.getAbilityScore().getIndex();
    }

    private Skills toModel(Map<String, Object> entity) {
        Skills skill = new Skills();
        skill.setIndex((String) entity.get("index"));
        skill.setName((String) entity.get("name"));
        skill.setDescription((String) entity.get("description"));
        skill.setUrl((String) entity.get("url"));

        String abilityScoreIndex = (String) entity.get("ability_score_index");
        if (abilityScoreIndex != null) {
            AbilityScore abilityScore = new AbilityScore();
            abilityScore.setIndex(abilityScoreIndex);
            skill.setAbilityScore(abilityScore);
        }
        return skill;
    }

    private Skills toModel(Skills source) {
        Skills skill = new Skills();
        skill.setIndex(source.getIndex());
        skill.setName(source.getName());
        skill.setDescription(source.getDescription());
        skill.setAbilityScore(source.getAbilityScore());
        skill.setUrl(source.getUrl());
        return skill;
    }
}

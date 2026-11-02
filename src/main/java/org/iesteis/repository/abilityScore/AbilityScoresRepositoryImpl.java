package org.iesteis.repository.abilityScore;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.iesteis.database.DatabaseManager;
import org.iesteis.database.DatabaseService;
import org.iesteis.model.abilityScores.AbilityScores;
import org.iesteis.model.abilityScores.Skill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.databind.ObjectMapper;

public class AbilityScoresRepositoryImpl implements AbilityScoresRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private final DatabaseManager db;

    private final Logger logger = LoggerFactory.getLogger(AbilityScoresRepositoryImpl.class.getName());

    public AbilityScoresRepositoryImpl() {
        this.db = new DatabaseService();
    }

    public AbilityScoresRepositoryImpl(DatabaseManager db) {
        this.db = db;
    }

    @Override
    public List<AbilityScores> findAll() {
        logger.debug("Buscando todas las ability scores");

        String sql = "SELECT * FROM ability_scores";
        return db.select(sql).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public AbilityScores findById(String index) {
        logger.debug("Buscando ability score por index: " + index);

        String sql = "SELECT * FROM ability_scores WHERE `index` = ?";
        List<Map<String, Object>> result = db.select(sql, index);
        if (result.isEmpty()) {
            return null;
        }
        return toModel(result.get(0));
    }

    @Override
    public AbilityScores save(AbilityScores abilityScore) {
        logger.debug("Guardando ability score: " + abilityScore.getIndex());

        String sql = "INSERT INTO ability_scores "
                + "(`index`, name, full_name, description, skills, url) VALUES (?, ?, ?, ?, ?, ?)";
        int result = db.insert(
                sql,
                abilityScore.getIndex(),
                abilityScore.getName(),
                abilityScore.getFullName(),
                abilityScore.getDescription(),
                JSON_MAPPER.writeValueAsString(abilityScore.getSkills()),
                abilityScore.getUrl());
        if (result <= 0) {
            return null;
        }

        return toModel(abilityScore);
    }

    @Override
    public AbilityScores update(String index, AbilityScores abilityScore) {
        logger.debug("Actualizando ability score por index: " + index);

        if (findById(index) == null) {
            return null;
        }

        String sql = "UPDATE ability_scores SET `index` = ?, name = ?, full_name = ?, "
                + "description = ?, skills = ?, url = ? WHERE `index` = ?";
        int result = db.update(
                sql,
                abilityScore.getIndex(),
                abilityScore.getName(),
                abilityScore.getFullName(),
                abilityScore.getDescription(),
                JSON_MAPPER.writeValueAsString(abilityScore.getSkills()),
                abilityScore.getUrl(),
                index);
        if (result <= 0) {
            return null;
        }

        return toModel(abilityScore);
    }

    @Override
    public AbilityScores delete(String index) {
        logger.debug("Borrando ability score por index: " + index);

        AbilityScores abilityScore = findById(index);
        if (abilityScore == null) {
            return null;
        }

        String sql = "DELETE FROM ability_scores WHERE `index` = ?";
        int result = db.delete(sql, index);
        if (result <= 0) {
            return null;
        }

        return abilityScore;
    }

    @Override
    public List<AbilityScores> findByName(String name) {
        logger.debug("Buscando ability scores por nombre: " + name);

        String sql = "SELECT * FROM ability_scores WHERE LOWER(name) LIKE LOWER(?)";
        return findMany(sql, "%" + name + "%");
    }

    @Override
    public List<AbilityScores> findByIndex(String index) {
        logger.debug("Buscando ability scores por index: " + index);

        String sql = "SELECT * FROM ability_scores WHERE `index` = ?";
        return findMany(sql, index);
    }

    @Override
    public List<AbilityScores> findByFullName(String fullName) {
        logger.debug("Buscando ability scores por nombre completo: " + fullName);

        String sql = "SELECT * FROM ability_scores WHERE LOWER(full_name) LIKE LOWER(?)";
        return findMany(sql, "%" + fullName + "%");
    }

    @Override
    public List<AbilityScores> findByDescription(String description) {
        logger.debug("Buscando ability scores por descripción: " + description);

        String sql = "SELECT * FROM ability_scores WHERE LOWER(description) LIKE LOWER(?)";
        return findMany(sql, "%" + description + "%");
    }

    @Override
    public List<AbilityScores> findByUrl(String url) {
        logger.debug("Buscando ability scores por url: " + url);

        String sql = "SELECT * FROM ability_scores WHERE url = ?";
        return findMany(sql, url);
    }

    private List<AbilityScores> findMany(String sql, Object parameter) {
        return db.select(sql, parameter).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private AbilityScores toModel(Map<String, Object> entity) {
        AbilityScores abilityScore = new AbilityScores();
        abilityScore.setIndex((String) entity.get("index"));
        abilityScore.setName((String) entity.get("name"));
        abilityScore.setFullName((String) entity.get("full_name"));
        abilityScore.setDescription((String) entity.get("description"));
        Object skills = entity.get("skills");
        if (skills != null) {
            if (!(skills instanceof String)) {
                throw new IllegalStateException("El campo skills debe recibirse como JSON en formato texto");
            }
            abilityScore.setSkills(JSON_MAPPER.readValue((String) skills, Skill[].class));
        }
        abilityScore.setUrl((String) entity.get("url"));
        return abilityScore;
    }

    private AbilityScores toModel(AbilityScores source) {
        AbilityScores abilityScore = new AbilityScores();
        abilityScore.setIndex(source.getIndex());
        abilityScore.setName(source.getName());
        abilityScore.setFullName(source.getFullName());
        abilityScore.setDescription(source.getDescription());
        abilityScore.setSkills(source.getSkills());
        abilityScore.setUrl(source.getUrl());
        return abilityScore;
    }
}

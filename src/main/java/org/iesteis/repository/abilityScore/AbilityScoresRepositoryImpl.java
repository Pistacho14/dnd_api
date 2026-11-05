package org.iesteis.repository.abilityScore;


import org.iesteis.model.abilityScores.AbilityScores;
import org.iesteis.model.abilityScores.Skill;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.iesteis.database.DatabaseManager;
import org.iesteis.repository.BaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.databind.ObjectMapper;

public class AbilityScoresRepositoryImpl extends BaseRepository<AbilityScores>
        implements AbilityScoresRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    private final Logger logger = LoggerFactory.getLogger(AbilityScoresRepositoryImpl.class.getName());

    public AbilityScoresRepositoryImpl() {
        super();
    }

    public AbilityScoresRepositoryImpl(DatabaseManager db) {
        super(db);
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

        return copy(abilityScore);
    }

    @Override
    protected AbilityScores updateItem(String index, AbilityScores abilityScore) {
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

        return copy(abilityScore);
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

    @Override
    protected String tableName() {
        return "ability_scores";
    }

    @Override
    protected AbilityScores toModel(Map<String, Object> entity) {
        Object skills = entity.get("skills");
        if (skills != null) {
            if (!(skills instanceof String)) {
                throw new IllegalStateException("El campo skills debe recibirse como JSON en formato texto");
            }

        }

        return new AbilityScores(
                (String) entity.get("index"),
                (String) entity.get("name"),
                (String) entity.get("full_name"),
                (String) entity.get("description"),
                skills == null ? null : JSON_MAPPER.readValue((String) skills, Skill[].class),
                (String) entity.get("url")
        );
    }

    @Override
    protected AbilityScores copy(AbilityScores source) {
        return new AbilityScores(
                source.getIndex(),
                source.getName(),
                source.getFullName(),
                source.getDescription(),
                source.getSkills(),
                source.getUrl()
        );
    }
}

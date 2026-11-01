package org.iesteis.repository.abilityScore;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.iesteis.database.DatabaseManager;
import org.iesteis.database.DatabaseService;
import org.iesteis.model.abilityScore.Skill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkillRepositoryImpl implements SkillRepository {

    private final DatabaseManager db;

    private final Logger logger = LoggerFactory.getLogger(SkillRepositoryImpl.class.getName());

    public SkillRepositoryImpl() {
        this.db = new DatabaseService();
    }

    public SkillRepositoryImpl(DatabaseManager db) {
        this.db = db;
    }

    @Override
    public List<Skill> findAll() {
        logger.debug("Buscando todas las skills");

        String sql = "SELECT * FROM skills";
        return db.select(sql).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Skill findById(String index) {
        logger.debug("Buscando skill por index: " + index);

        String sql = "SELECT * FROM skills WHERE `index` = ?";
        List<Map<String, Object>> result = db.select(sql, index);
        if (result.isEmpty()) {
            return null;
        }
        return toModel(result.get(0));
    }

    @Override
    public Skill save(Skill skill) {
        logger.debug("Guardando skill: " + skill);

        String sql = "INSERT INTO skills (`index`, name, url) VALUES (?, ?, ?)";
        int result = db.insert(sql, skill.getIndex(), skill.getName(), skill.getUrl());
        if (result <= 0) {
            return null;
        }

        return new Skill(skill.getIndex(), skill.getName(), skill.getUrl());
    }

    @Override
    public Skill update(String index, Skill skill) {
        logger.debug("Actualizando skill por index: " + index);

        if (findById(index) == null) {
            return null;
        }

        String sql = "UPDATE skills SET `index` = ?, name = ?, url = ? WHERE `index` = ?";
        int result = db.update(sql, skill.getIndex(), skill.getName(), skill.getUrl(), index);
        if (result <= 0) {
            return null;
        }

        return new Skill(skill.getIndex(), skill.getName(), skill.getUrl());
    }

    @Override
    public Skill delete(String index) {
        logger.debug("Borrando skill por index: " + index);

        Skill skill = findById(index);
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
    public List<Skill> findByName(String name) {
        logger.debug("Buscando skills por nombre: " + name);

        String sql = "SELECT * FROM skills WHERE LOWER(name) LIKE LOWER(?)";
        return db.select(sql, "%" + name + "%").stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Skill> findByUrl(String url) {
        logger.debug("Buscando skills por url: " + url);

        String sql = "SELECT * FROM skills WHERE url = ?";
        return db.select(sql, url).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Skill> findByIndex(String index) {
        logger.debug("Buscando skills por index: " + index);

        String sql = "SELECT * FROM skills WHERE `index` = ?";
        return db.select(sql, index).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private Skill toModel(Map<String, Object> entity) {
        return new Skill(
                (String) entity.get("index"),
                (String) entity.get("name"),
                (String) entity.get("url"));
    }
}

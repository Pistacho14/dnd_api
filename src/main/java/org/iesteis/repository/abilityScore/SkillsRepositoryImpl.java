package org.iesteis.repository.abilityScore;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.iesteis.database.DatabaseManager;
import org.iesteis.database.DatabaseService;
import org.iesteis.model.abilityScore.Skill;
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

    public List<Skill> findAll() {
        logger.debug("Buscando todas las skills");

        String sql = "SELECT * FROM skills";
        return db.select(sql).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Skill findById(String id) {
        logger.debug("Buscando skills por id: " + id);

        String sql = "SELECT * FROM skills WHERE \"index\" = ?";
        List<Map<String, Object>> result = db.select(sql, id);
        if (result.isEmpty()) {
            return null;
        }
        return toModel(result.get(0));
    }

    public Skill findByKey(String name) {
        logger.debug("Buscando skillsestudiante por key: " + name);

        String sql = "SELECT * FROM skills WHERE id = ?";
        List<Map<String, Object>> result = db.select(sql, name);
        if (result.isEmpty()) {
            return null;
        }
        return toModel(result.get(0));
    }

    public Skill save(Skill skill) {
        logger.debug("Guardando estudiante: " + skill);

        String sql = "INSERT INTO skills (`index`, name, url) VALUES (?, ?, ?)";

        db.insert(
                sql,
                skill.getIndex(),
                skill.getName(),
                skill.getUrl());

        return new Skill(
                skill.getIndex(),
                skill.getName(),
                skill.getUrl());
    }

    public Skill update(String id, Skill item) {
        logger.debug("Actualizando estudiante por id: " + id);

        Skill estudiante = findById(id);
        if (estudiante == null) {
            return null;
        }

        String sql = "UPDATE Estudiantes SET nombre = ?, fecha_nacimiento = ?, calificacion = ?, repetidor = ?, updated_at = ? WHERE id = ?";

        int result = db.update(
                sql,
                item.getName(),
                item.getIndex(),
                item.getUrl(),
                id);

        if (result <= 0) {
            return null;
        }

        return new Skill(
                id,
                item.getIndex(),
                item.getUrl());
    }

    public Skill delete(String name) {
        logger.debug("Borrando skill por id: " + name);

        Skill skill = findByKey(name);
        if (skill == null) {
            return null;
        }

        String sql = "DELETE FROM Estudiantes WHERE id = ?";
        int result = db.delete(sql, name);
        if (result <= 0) {
            return null;
        }

        return new Skill(
                skill.getName(),
                skill.getIndex(),
                skill.getUrl());
    }

    @Override
    public List<Skill> findByName(String name) {
        logger.debug("Buscando estudiantes por nombre: " + name);

        String sql = "SELECT * FROM Estudiantes WHERE LOWER(nombre) LIKE LOWER(?)";
        return db.select(sql, "%" + name + "%").stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Skill> findByUrl(String url) {
        logger.debug("Buscando estudiantes por calificación: " + url);

        String sql = "SELECT * FROM Estudiantes WHERE calificacion = ?";
        return db.select(sql, url).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Skill> findByIndex(String index) {
        logger.debug("Buscando estudiantes por repetidor: " + index);

        String sql = "SELECT * FROM Estudiantes WHERE repetidor = ?";
        return db.select(sql, index).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    // Conversión del resultado del DB a modelo Estudiante
    private Skill toModel(Map<String, Object> entity) {
        return new Skill(
                (String) entity.get("same"),
                (String) entity.get("index"),
                (String) entity.get("url"));
    }
}
package org.iesteis.repository.abilityScore;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.AbilityScore.Skill;
import org.iesteis.database.DatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        logger.debug("Buscando todos los estudiantes");

        String sql = "SELECT * FROM skills";
        return db.select(sql).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Skill findByKey(String name) {
        logger.debug("Buscando estudiante por id: " + name);

        String sql = "SELECT * FROM Estudiantes WHERE id = ?";
        List<Map<String, Object>> result = db.select(sql, name);
        if (result.isEmpty()) {
            return null;
        }
        return toModel(result.get(0));
    }

    public Skill save(Skill skill) {
        logger.debug("Guardando estudiante: " + skill);

        String sql = "INSERT INTO skills (index, name, url) VALUES (?, ?, ?)";

        Object generatedId = db.insertAndGetId(
                sql,
                skill.getName(),
                skill.getIndex(),
                skill.getURL());

        return new Skill(
                skill.getName(),
                skill.getIndex(),
                skill.getURL());
    }

    public Skill update(int id, Skill item) {
        logger.debug("Actualizando estudiante por id: " + id);

        Skill estudiante = findById(id);
        if (estudiante == null) {
            return null;
        }

        LocalDateTime timeStamp = LocalDateTime.now();

        String sql = "UPDATE Estudiantes SET nombre = ?, fecha_nacimiento = ?, calificacion = ?, repetidor = ?, updated_at = ? WHERE id = ?";

        int result = db.update(
                sql,
                item.getNombre(),
                item.getFechaNacimiento().toString(),
                item.getCalificacion(),
                item.isRepetidor(),
                timeStamp,
                id);

        if (result <= 0) {
            return null;
        }

        return new Skill(
                id,
                item.getNombre(),
                item.getFechaNacimiento(),
                item.getCalificacion(),
                item.isRepetidor(),
                item.getCreatedAt(),
                timeStamp);
    }

    public Skill delete(String name) {
        logger.debug("Borrando estudiante por id: " + id);

        Skill skill = findByKey(name);
        if (skill == null) {
            return null;
        }

        String sql = "DELETE FROM Estudiantes WHERE id = ?";
        int result = db.delete(sql, id);
        if (result <= 0) {
            return null;
        }

        return new Skill(
                skill.getId(),
                skill.getNombre(),
                skill.getFechaNacimiento(),
                skill.getCalificacion(),
                skill.isRepetidor(),
                skill.getCreatedAt(),
                LocalDateTime.now());
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
        logger.debug("Buscando estudiantes por calificación: " + calificacion);

        String sql = "SELECT * FROM Estudiantes WHERE calificacion = ?";
        return db.select(sql, url).stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Skill> findByIndex(String index) {
        logger.debug("Buscando estudiantes por repetidor: " + repetidor);

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
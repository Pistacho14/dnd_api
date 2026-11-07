package org.iesteis.repository.skills;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.iesteis.database.DatabaseManager;
import org.iesteis.database.DatabaseService;
import org.iesteis.model.skills.AbilityScore;
import org.iesteis.model.skills.Skills;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkillsRepositoryCrudTest {

    private final DatabaseManager database = DatabaseService.getInstance();

    private SkillsRepositoryImpl repository;
    private String skillIndex;
    private AbilityScore abilityScore;

    @BeforeEach
    void setUp() {
        repository = new SkillsRepositoryImpl(database);
        skillIndex = "test-skill-" + UUID.randomUUID();

        List<Map<String, Object>> abilityScores =
                database.select("SELECT `index` FROM ability_scores LIMIT 1");
        assertFalse(abilityScores.isEmpty(), "The database needs at least one ability score");

        String abilityScoreIndex = abilityScores.get(0).get("index").toString();
        abilityScore = new AbilityScore(abilityScoreIndex, null, null);
    }

    @AfterEach
    void cleanUp() {
        repository.delete(skillIndex);
    }

    @Test
    void shouldMapDatabaseRowToSkill() {
        assertNotNull(repository.save(newSkill()));

        Skills savedSkill = repository.findById(skillIndex);
        assertNotNull(savedSkill);
        assertEquals(skillIndex, savedSkill.getIndex());
        assertEquals("Test skill", savedSkill.getName());
        assertEquals("Original description", savedSkill.getDescription());
        assertEquals("/api/skills/" + skillIndex, savedSkill.getUrl());
        assertNotNull(savedSkill.getAbilityScore());
        assertEquals(abilityScore.getIndex(), savedSkill.getAbilityScore().getIndex());
    }

    @Test
    void shouldUpdateSkill() {
        repository.save(newSkill());

        Skills changedSkill = new Skills(
                skillIndex,
                "Updated skill",
                "Updated description",
                abilityScore,
                "/api/skills/" + skillIndex);

        assertNotNull(repository.update(skillIndex, changedSkill));
        assertEquals("Updated skill", repository.findById(skillIndex).getName());
    }

    @Test
    void shouldDeleteSkill() {
        repository.save(newSkill());

        assertNotNull(repository.delete(skillIndex));
        assertNull(repository.findById(skillIndex));
    }

    private Skills newSkill() {
        return new Skills(
                skillIndex,
                "Test skill",
                "Original description",
                abilityScore,
                "/api/skills/" + skillIndex);
    }
}

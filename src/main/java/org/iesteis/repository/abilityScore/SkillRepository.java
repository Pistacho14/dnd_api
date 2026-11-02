package org.iesteis.repository.abilityScore;

import org.iesteis.model.abilityScores.Skill;
import org.iesteis.repository.CrudRepository;

import java.util.List;

public interface SkillRepository extends CrudRepository<Skill> {
    List<Skill> findByName(String name);
    List<Skill> findByIndex(String index);
    List<Skill> findByUrl(String url);
}

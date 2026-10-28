package org.iesteis.repository.abilityScore;

import org.iesteis.repository.CrudRepository;
import org.iesteis.model.AbilityScore.Skill;

import java.util.List;

public interface SkillsRepository extends CrudRepository<Skill> {
    List<Skill> findByName(String name);
    List<Skill> findByIndex(String index);
    List<Skill> findByUrl(String url);
}

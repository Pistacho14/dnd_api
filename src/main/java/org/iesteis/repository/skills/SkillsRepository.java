package org.iesteis.repository.skills;

import java.util.List;

import org.iesteis.model.skills.Skills;
import org.iesteis.repository.CrudRepository;

public interface SkillsRepository extends CrudRepository<Skills> {
    List<Skills> findByName(String name);

    List<Skills> findByIndex(String index);

    List<Skills> findByDescription(String description);

    List<Skills> findByAbilityScoreIndex(String abilityScoreIndex);

    List<Skills> findByUrl(String url);
}

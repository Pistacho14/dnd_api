package org.iesteis.repository.abilityScore;


import org.iesteis.model.abilityScores.AbilityScores;
import java.util.List;

import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de las puntuaciones de característica y sus búsquedas específicas.
 */
public interface AbilityScoresRepository extends CrudRepository<AbilityScores> {
    List<AbilityScores> findByName(String name);

    List<AbilityScores> findByIndex(String index);

    List<AbilityScores> findByFullName(String fullName);

    List<AbilityScores> findByDescription(String description);

    List<AbilityScores> findByUrl(String url);
}

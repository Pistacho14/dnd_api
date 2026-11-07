package org.iesteis.repository.conditions;

import java.util.List;

import org.iesteis.model.conditions.Conditions;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de las condiciones y sus búsquedas específicas.
 */
public interface ConditionsRepository extends CrudRepository<Conditions> {
    List<Conditions> findByName(String name);
    List<Conditions> findByIndex(String index);
    List<Conditions> findByUrl(String url);
}

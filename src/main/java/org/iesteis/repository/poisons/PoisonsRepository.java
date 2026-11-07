package org.iesteis.repository.poisons;

import java.util.List;

import org.iesteis.model.poisons.Poisons;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de los venenos y sus búsquedas específicas.
 */
public interface PoisonsRepository extends CrudRepository<Poisons> {
    List<Poisons> findByName(String name);
    List<Poisons> findByIndex(String index);
    List<Poisons> findByUrl(String url);
}

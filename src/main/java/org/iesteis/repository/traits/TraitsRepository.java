package org.iesteis.repository.traits;

import java.util.List;

import org.iesteis.model.traits.Traits;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de los rasgos y sus búsquedas específicas.
 */
public interface TraitsRepository extends CrudRepository<Traits> {
    List<Traits> findByName(String name);
    List<Traits> findByIndex(String index);
    List<Traits> findByUrl(String url);
}

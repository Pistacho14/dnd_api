package org.iesteis.repository.species;

import java.util.List;

import org.iesteis.model.species.Species;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de las especies y sus búsquedas específicas.
 */
public interface SpeciesRepository extends CrudRepository<Species> {
    List<Species> findByName(String name);
    List<Species> findByIndex(String index);
    List<Species> findByUrl(String url);
}

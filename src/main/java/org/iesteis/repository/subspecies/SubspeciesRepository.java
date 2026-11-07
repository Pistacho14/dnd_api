package org.iesteis.repository.subspecies;

import java.util.List;

import org.iesteis.model.subspecies.Subspecies;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de las subespecies y sus búsquedas específicas.
 */
public interface SubspeciesRepository extends CrudRepository<Subspecies> {
    List<Subspecies> findByName(String name);
    List<Subspecies> findByIndex(String index);
    List<Subspecies> findByUrl(String url);
}

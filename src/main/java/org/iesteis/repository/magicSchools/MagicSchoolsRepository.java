package org.iesteis.repository.magicSchools;

import java.util.List;

import org.iesteis.model.magicSchools.MagicSchools;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de las escuelas de magia y sus búsquedas específicas.
 */
public interface MagicSchoolsRepository extends CrudRepository<MagicSchools> {
    List<MagicSchools> findByName(String name);
    List<MagicSchools> findByIndex(String index);
    List<MagicSchools> findByUrl(String url);
}

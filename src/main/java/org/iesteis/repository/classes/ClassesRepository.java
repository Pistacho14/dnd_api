package org.iesteis.repository.classes;


import org.iesteis.model.classes.Classes;
import java.util.List;

import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de las clases de personaje y sus búsquedas específicas.
 */
public interface ClassesRepository extends CrudRepository<Classes> {
    List<Classes> findByName(String name);
    List<Classes> findByIndex(String index);
    List<Classes> findByUrl(String url);
}

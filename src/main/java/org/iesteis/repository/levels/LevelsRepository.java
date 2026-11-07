package org.iesteis.repository.levels;

import java.util.List;

import org.iesteis.model.levels.Levels;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de los niveles de clase y sus búsquedas específicas.
 */
public interface LevelsRepository extends CrudRepository<Levels> {
    List<Levels> findByName(String name);
    List<Levels> findByIndex(String index);
    List<Levels> findByUrl(String url);
}

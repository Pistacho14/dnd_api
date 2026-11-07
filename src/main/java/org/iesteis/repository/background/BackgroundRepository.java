package org.iesteis.repository.background;


import org.iesteis.model.background.Background;
import java.util.List;

import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de los trasfondos y sus búsquedas específicas.
 */
public interface BackgroundRepository extends CrudRepository<Background> {
    List<Background> findByName(String name);
    List<Background> findByIndex(String index);
    List<Background> findByUrl(String url);
}

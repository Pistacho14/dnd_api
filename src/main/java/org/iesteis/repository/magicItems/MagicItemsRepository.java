package org.iesteis.repository.magicItems;

import java.util.List;

import org.iesteis.model.magicItems.MagicItems;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de los objetos mágicos y sus búsquedas específicas.
 */
public interface MagicItemsRepository extends CrudRepository<MagicItems> {
    List<MagicItems> findByName(String name);
    List<MagicItems> findByIndex(String index);
    List<MagicItems> findByUrl(String url);
}

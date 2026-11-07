package org.iesteis.repository.feats;

import java.util.List;

import org.iesteis.model.feats.Feats;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de las dotes y sus búsquedas específicas.
 */
public interface FeatsRepository extends CrudRepository<Feats> {
    List<Feats> findByName(String name);
    List<Feats> findByIndex(String index);
    List<Feats> findByUrl(String url);
}

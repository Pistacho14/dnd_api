package org.iesteis.repository.spells;

import java.util.List;

import org.iesteis.model.spells.Spells;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de los conjuros y sus búsquedas específicas.
 */
public interface SpellsRepository extends CrudRepository<Spells> {
    List<Spells> findByName(String name);
    List<Spells> findByIndex(String index);
    List<Spells> findByUrl(String url);
}

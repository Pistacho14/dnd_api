package org.iesteis.repository.spells;

import java.util.List;

import org.iesteis.model.spells.Spells;
import org.iesteis.repository.CrudRepository;

public interface SpellsRepository extends CrudRepository<Spells> {
    List<Spells> findByName(String name);
    List<Spells> findByIndex(String index);
    List<Spells> findByUrl(String url);
}

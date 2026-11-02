package org.iesteis.repository.monsters;

import java.util.List;

import org.iesteis.model.monsters.Monster;
import org.iesteis.repository.CrudRepository;

public interface MonstersRepository extends CrudRepository<Monster> {
    List<Monster> findByName(String name);
    List<Monster> findByIndex(String index);
    List<Monster> findByUrl(String url);
}

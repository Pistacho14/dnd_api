package org.iesteis.repository.poisons;

import java.util.List;

import org.iesteis.model.poisons.Poisons;
import org.iesteis.repository.CrudRepository;

public interface PoisonsRepository extends CrudRepository<Poisons> {
    List<Poisons> findByName(String name);
    List<Poisons> findByIndex(String index);
    List<Poisons> findByUrl(String url);
}

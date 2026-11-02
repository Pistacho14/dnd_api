package org.iesteis.repository.damageTypes;

import java.util.List;

import org.iesteis.model.damageTypes.DamageTypes;
import org.iesteis.repository.CrudRepository;

public interface DamageTypesRepository extends CrudRepository<DamageTypes> {
    List<DamageTypes> findByName(String name);
    List<DamageTypes> findByIndex(String index);
    List<DamageTypes> findByUrl(String url);
}

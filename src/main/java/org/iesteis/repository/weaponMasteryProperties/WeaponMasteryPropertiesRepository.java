package org.iesteis.repository.weaponMasteryProperties;

import java.util.List;

import org.iesteis.model.weaponMasteryProperties.WeaponMasteryProperties;
import org.iesteis.repository.CrudRepository;

public interface WeaponMasteryPropertiesRepository extends CrudRepository<WeaponMasteryProperties> {
    List<WeaponMasteryProperties> findByName(String name);
    List<WeaponMasteryProperties> findByIndex(String index);
    List<WeaponMasteryProperties> findByUrl(String url);
}

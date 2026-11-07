package org.iesteis.repository.weaponProperties;

import java.util.List;

import org.iesteis.model.weaponProperties.WeaponProperties;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de las propiedades de armas y sus búsquedas específicas.
 */
public interface WeaponPropertiesRepository extends CrudRepository<WeaponProperties> {
    List<WeaponProperties> findByName(String name);
    List<WeaponProperties> findByIndex(String index);
    List<WeaponProperties> findByUrl(String url);
}

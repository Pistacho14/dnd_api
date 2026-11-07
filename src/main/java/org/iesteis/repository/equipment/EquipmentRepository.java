package org.iesteis.repository.equipment;

import java.util.List;

import org.iesteis.model.equipment.Equipment;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos del equipo y sus búsquedas específicas.
 */
public interface EquipmentRepository extends CrudRepository<Equipment> {
    List<Equipment> findByName(String name);
    List<Equipment> findByIndex(String index);
    List<Equipment> findByUrl(String url);
}

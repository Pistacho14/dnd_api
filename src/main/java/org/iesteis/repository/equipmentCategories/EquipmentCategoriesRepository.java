package org.iesteis.repository.equipmentCategories;

import java.util.List;

import org.iesteis.model.equipmentCategories.EquipmentCategories;
import org.iesteis.repository.CrudRepository;

public interface EquipmentCategoriesRepository extends CrudRepository<EquipmentCategories> {
    List<EquipmentCategories> findByName(String name);
    List<EquipmentCategories> findByIndex(String index);
    List<EquipmentCategories> findByUrl(String url);
}

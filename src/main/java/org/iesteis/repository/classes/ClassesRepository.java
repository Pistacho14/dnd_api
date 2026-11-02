package org.iesteis.repository.classes;

import java.util.List;

import org.iesteis.model.classes.Classes;
import org.iesteis.repository.CrudRepository;

public interface ClassesRepository extends CrudRepository<Classes> {
    List<Classes> findByName(String name);
    List<Classes> findByIndex(String index);
    List<Classes> findByUrl(String url);
}

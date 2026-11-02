package org.iesteis.repository.subclasses;

import java.util.List;

import org.iesteis.model.subclasses.Subclasses;
import org.iesteis.repository.CrudRepository;

public interface SubclassesRepository extends CrudRepository<Subclasses> {
    List<Subclasses> findByName(String name);
    List<Subclasses> findByIndex(String index);
    List<Subclasses> findByUrl(String url);
}

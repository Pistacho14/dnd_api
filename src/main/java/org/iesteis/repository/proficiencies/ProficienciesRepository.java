package org.iesteis.repository.proficiencies;

import java.util.List;

import org.iesteis.model.proficiencies.Proficiencies;
import org.iesteis.repository.CrudRepository;

public interface ProficienciesRepository extends CrudRepository<Proficiencies> {
    List<Proficiencies> findByName(String name);
    List<Proficiencies> findByIndex(String index);
    List<Proficiencies> findByUrl(String url);
}

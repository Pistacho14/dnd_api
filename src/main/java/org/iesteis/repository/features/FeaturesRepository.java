package org.iesteis.repository.features;

import java.util.List;

import org.iesteis.model.features.Features;
import org.iesteis.repository.CrudRepository;

public interface FeaturesRepository extends CrudRepository<Features> {
    List<Features> findByName(String name);
    List<Features> findByIndex(String index);
    List<Features> findByUrl(String url);
}

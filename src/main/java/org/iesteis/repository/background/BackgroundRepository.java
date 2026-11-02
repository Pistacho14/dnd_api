package org.iesteis.repository.background;

import java.util.List;

import org.iesteis.model.background.Background;
import org.iesteis.repository.CrudRepository;

public interface BackgroundRepository extends CrudRepository<Background> {
    List<Background> findByName(String name);
    List<Background> findByIndex(String index);
    List<Background> findByUrl(String url);
}

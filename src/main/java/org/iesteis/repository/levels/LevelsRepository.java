package org.iesteis.repository.levels;

import java.util.List;

import org.iesteis.model.levels.Levels;
import org.iesteis.repository.CrudRepository;

public interface LevelsRepository extends CrudRepository<Levels> {
    List<Levels> findByName(String name);
    List<Levels> findByIndex(String index);
    List<Levels> findByUrl(String url);
}

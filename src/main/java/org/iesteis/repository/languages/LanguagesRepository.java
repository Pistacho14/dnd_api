package org.iesteis.repository.languages;

import java.util.List;

import org.iesteis.model.languages.Languages;
import org.iesteis.repository.CrudRepository;

public interface LanguagesRepository extends CrudRepository<Languages> {
    List<Languages> findByName(String name);
    List<Languages> findByIndex(String index);
    List<Languages> findByUrl(String url);
}

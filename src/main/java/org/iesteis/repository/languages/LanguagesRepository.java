package org.iesteis.repository.languages;

import java.util.List;

import org.iesteis.model.languages.Languages;
import org.iesteis.repository.CrudRepository;

/**
 * Define el acceso a datos de los idiomas y sus búsquedas específicas.
 */
public interface LanguagesRepository extends CrudRepository<Languages> {
    List<Languages> findByName(String name);
    List<Languages> findByIndex(String index);
    List<Languages> findByUrl(String url);
}

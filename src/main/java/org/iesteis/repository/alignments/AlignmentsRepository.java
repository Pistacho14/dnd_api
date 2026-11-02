package org.iesteis.repository.alignments;


import org.iesteis.model.alignments.Alignments;
import java.util.List;

import org.iesteis.repository.CrudRepository;

public interface AlignmentsRepository extends CrudRepository<Alignments> {
    List<Alignments> findByName(String name);
    List<Alignments> findByIndex(String index);
    List<Alignments> findByUrl(String url);
}

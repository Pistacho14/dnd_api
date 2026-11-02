package org.iesteis.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    T findById(String id);
    T save(T item);
    T update(String id, T item);
    T delete(String id);
}

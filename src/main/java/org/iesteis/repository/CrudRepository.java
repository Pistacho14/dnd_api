package org.iesteis.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    T findById(T id);
    T save(T item);
    T update(int id, T item);
    T delete(int id);
}

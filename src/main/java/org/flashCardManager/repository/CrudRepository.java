package org.flashCardManager.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    T save(T entity);
    Optional<T> findById(String id);
    List<T> findAll();
    T update (T entity);
    void deleteById(String id);
}

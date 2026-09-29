package org.flashCardManager.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

    T save(T entity);
    Optional<T> findById(String id);
    List<T> findAll();
    boolean existsById(String id);
    T update (T entity);
    void deleteById(String id);
}

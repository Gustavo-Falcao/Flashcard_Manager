package org.flashCardManager.repository;

import org.flashCardManager.model.entity.Example;

import java.util.List;

public interface ExampleRepository extends CrudRepository<Example> {
    List<Example> findByMeaningId(String meaningId);
}

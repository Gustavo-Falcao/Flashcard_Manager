package org.flashCardManager.jsonRepository;

import org.flashCardManager.model.entity.Example;
import org.flashCardManager.repository.ExampleRepository;

import java.util.List;

public class ExampleJsonRepository extends AbstractJsonRepository<Example> implements ExampleRepository {
    public ExampleJsonRepository() {
        super("src/main/java/org.flashCardManager/db/examples.json");
    }

    @Override
    public List<Example> findByMeaningId(String meaningId) {
        return findAll()
                .stream()
                .filter(example -> example.getMeaningId().equals(meaningId))
                .toList();
    }

    @Override
    public boolean existsById(String id) {
        return findAll()
                .stream()
                .anyMatch(example -> example.getId().equals(id));
    }
}

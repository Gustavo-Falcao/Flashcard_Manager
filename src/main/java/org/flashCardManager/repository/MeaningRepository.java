package org.flashCardManager.repository;

import org.flashCardManager.model.entity.Meaning;

import java.util.List;

public interface MeaningRepository extends CrudRepository<Meaning> {
    List<Meaning> findByCardId(String cardId);
}

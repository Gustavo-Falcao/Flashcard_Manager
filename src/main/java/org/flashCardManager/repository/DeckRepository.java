package org.flashCardManager.repository;

import org.flashCardManager.model.entity.Deck;

import java.util.List;

public interface DeckRepository extends CrudRepository<Deck> {
    List<Deck> findByUserId(String userId);
}

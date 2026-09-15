package org.flashCardManager.repository;

import org.flashCardManager.model.entity.Card;

import java.util.List;

public interface CardRepository extends CrudRepository<Card> {
    List<Card> findByDeckId(String deckId);
}

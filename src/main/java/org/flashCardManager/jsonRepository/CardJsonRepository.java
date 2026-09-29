package org.flashCardManager.jsonRepository;

import org.flashCardManager.model.entity.Card;
import org.flashCardManager.repository.CardRepository;

import java.util.List;

public class CardJsonRepository extends AbstractJsonRepository<Card> implements CardRepository {
    public CardJsonRepository() {
        super("src/main/java/org.flashCardManager/db/cards.json");
    }

    @Override
    public List<Card> findByDeckId(String deckId) {
        return findAll()
                .stream()
                .filter(card -> card.getDeckId().equals(deckId))
                .toList();
    }

    @Override
    public boolean existsById(String id) {
        return findAll()
                .stream()
                .anyMatch(card -> card.getId().equals(id));
    }
}

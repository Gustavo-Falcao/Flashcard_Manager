package org.flashCardManager.jsonRepository;

import org.flashCardManager.model.entity.Deck;
import org.flashCardManager.repository.DeckRepository;

import java.util.List;

public class DeckJsonRepository extends AbstractJsonRepository<Deck> implements DeckRepository {

    public DeckJsonRepository() {
        super("src/main/java/org.flashCardManager/db/decks.json");
    }

    @Override
    public List<Deck> findByUserId(String userId) {
        return findAll()
                .stream()
                .filter(deck -> deck.getUserId().equals(userId))
                .toList();
    }

    @Override
    public boolean existsByUserIdAndName(String userId, String name) {
        return findAll()
                .stream()
                .anyMatch(deck ->
                        deck.getUserId().equals(userId) && deck.getName().equals(name)
                );
    }

    @Override
    public boolean existsById(String id) {
        return findAll()
                .stream()
                .anyMatch(deck -> deck.getId().equals(id));
    }
}

package org.flashCardManager.jsonRepository;

import org.flashCardManager.model.entity.Deck;
import org.flashCardManager.repository.DeckRepository;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DeckJsonRepository extends AbstractJsonRepository<Deck> implements DeckRepository {

    public DeckJsonRepository() {
        super(Path.of("src/main/java/org.flashCardManager/db/decks.json"));
    }

    @Override
    protected String getId(Deck deck) {
        return deck.getId();
    }

    @Override
    protected List<Deck> readFile() {
        return new ArrayList<>();
    }

    @Override
    protected void writeFile(List<Deck> decks) {

    }

    @Override
    public List<Deck> findByUserId(String userId) {
        return findAll()
                .stream()
                .filter(deck -> deck.getUserId().equals(userId))
                .toList();
    }

    @Override
    public void save(Deck entity) {

    }

    @Override
    public void update(Deck entity) {

    }
}

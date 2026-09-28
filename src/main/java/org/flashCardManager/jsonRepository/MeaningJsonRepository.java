package org.flashCardManager.jsonRepository;

import org.flashCardManager.model.entity.Meaning;
import org.flashCardManager.repository.MeaningRepository;

import java.util.List;

public class MeaningJsonRepository extends AbstractJsonRepository<Meaning> implements MeaningRepository {
    public MeaningJsonRepository() {
        super("src/main/java/org.flashCardManager/db/meanings.json");
    }

    @Override
    public List<Meaning> findByCardId(String cardId) {
        return findAll()
                .stream()
                .filter(meaning -> meaning.getCardId().equals(cardId))
                .toList();
    }
}

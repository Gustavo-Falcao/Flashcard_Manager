package org.flashCardManager.service;

import org.flashCardManager.model.dto.deckDto.DeckRequestCreate;
import org.flashCardManager.model.dto.deckDto.DeckRequestUpdate;
import org.flashCardManager.model.dto.deckDto.DeckResponse;
import org.flashCardManager.model.entity.Deck;
import org.flashCardManager.repository.CardRepository;
import org.flashCardManager.repository.DeckRepository;

import java.util.List;

public class DeckService {
    private final DeckRepository deckRepository;
    private final CardRepository cardRepository;

    public DeckService(DeckRepository repository, CardRepository cardRepository) {
        this.deckRepository = repository;
        this.cardRepository = cardRepository;
    }

    public DeckResponse create(DeckRequestCreate deckRequest) {
        Deck deck = new Deck(deckRequest.userId(), deckRequest.name());
        return toDeckResponse(deckRepository.save(deck));
    }

    public DeckResponse update(DeckRequestUpdate deckRequest) {
        Deck deck = deckRepository.findById(deckRequest.id())
                .orElseThrow(() -> new IllegalArgumentException("Deck not found"));
        //mudar para exception especifica

        deck.changeUserId(deckRequest.userId());
        deck.changeName(deckRequest.name());

        return toDeckResponse(deckRepository.update(deck));
    }

    public Deck getById(String id) {
        return deckRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Deck not found"));
        //mudar para exception especifica
    }

    private DeckResponse toDeckResponse(Deck deck) {
        int cardCount = cardRepository.findByDeckId(deck.getId()).size();
        return new DeckResponse(deck.getId(), deck.getUserId(), deck.getName(), cardCount);
    }

    public List<Deck> getAll() {
        return deckRepository.findAll();
    }

    public List<DeckResponse> getByUserId(String userId) {
        return deckRepository.findByUserId(userId)
                .stream()
                .map(this::toDeckResponse)
                .toList();
    }

    public void deleteById(String id) {
        deckRepository.deleteById(id);
    }
}

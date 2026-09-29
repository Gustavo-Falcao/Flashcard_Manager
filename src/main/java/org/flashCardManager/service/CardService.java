package org.flashCardManager.service;

import org.flashCardManager.model.dto.cardDto.CardRequestCreate;
import org.flashCardManager.model.dto.cardDto.CardRequestResponse;
import org.flashCardManager.model.dto.cardDto.CardRequestUpdate;
import org.flashCardManager.model.entity.Card;
import org.flashCardManager.repository.CardRepository;
import org.flashCardManager.repository.DeckRepository;

import java.util.List;

public class CardService {
    private final CardRepository cardRepository;
    private final DeckRepository deckRepository;

    public CardService(CardRepository cardRepository, DeckRepository deckRepository) {
        this.cardRepository = cardRepository;
        this.deckRepository = deckRepository;
    }

    public CardRequestResponse create(CardRequestCreate cardRequestCreate) {
        Card card = new Card.Builder()
                .deckId(cardRequestCreate.deckId())
                .name(cardRequestCreate.name())
                .context(cardRequestCreate.context())
                .synonym(cardRequestCreate.synonym())
                .phonetic(cardRequestCreate.phonetic())
                .build();

        return toCardRequestResponse(cardRepository.save(card));
    }

    private CardRequestResponse toCardRequestResponse(Card card) {
        return new CardRequestResponse(
                card.getId(),
                card.getDeckId(),
                card.getName(),
                card.getContext(),
                card.getSynonym(),
                card.getPhonetic()
        );
    }

    public CardRequestResponse update(CardRequestUpdate cardRequestUpdate) {
        Card card = cardRepository.findById(cardRequestUpdate.id())
                .orElseThrow(() -> new IllegalArgumentException("Card not found"));
        //mudar para exception especifica

        if(!deckRepository.existsById(cardRequestUpdate.deckId())) {
            throw new IllegalArgumentException("Deck nao encontrado");
            //mudar para exception especifica
        }

        card.changeDeckId(cardRequestUpdate.deckId());
        card.changeName(cardRequestUpdate.name());
        card.changeContext(cardRequestUpdate.context());
        card.changeSynonym(cardRequestUpdate.synonym());
        card.changePhonetic(cardRequestUpdate.phonetic());

        return toCardRequestResponse(cardRepository.update(card));
    }

    public CardRequestResponse getById(String id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Card not found"));
        //mudar para exception especifica

        return toCardRequestResponse(card);
    }

    public List<CardRequestResponse> getByDeckId(String deckId) {
        return cardRepository.findByDeckId(deckId)
                .stream()
                .map(this::toCardRequestResponse)
                .toList();
    }

    public void deleteById(String id) {
        cardRepository.deleteById(id);
    }
}

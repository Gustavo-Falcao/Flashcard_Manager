package org.flashCardManager.service;

import org.flashCardManager.repository.CardRepository;

public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


}

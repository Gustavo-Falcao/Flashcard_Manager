package org.flashCardManager.model.dto.deckDto;

public record DeckRequestCreate(
        String userId,
        String name
) {
}

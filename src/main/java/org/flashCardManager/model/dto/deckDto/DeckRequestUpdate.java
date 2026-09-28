package org.flashCardManager.model.dto.deckDto;

public record DeckRequestUpdate(
        String id,
        String userId,
        String name
) {
}

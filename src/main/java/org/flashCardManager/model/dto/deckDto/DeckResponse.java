package org.flashCardManager.model.dto.deckDto;

public record DeckResponse(
        String id,
        String userId,
        String name,
        int cardCount
) {
}

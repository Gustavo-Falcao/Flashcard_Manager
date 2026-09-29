package org.flashCardManager.model.dto.cardDto;

import org.flashCardManager.model.entity.Context;

public record CardRequestCreate(
        String deckId,
        String name,
        Context context,
        String synonym,
        String phonetic
) {
}

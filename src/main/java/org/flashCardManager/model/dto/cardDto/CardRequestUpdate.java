package org.flashCardManager.model.dto.cardDto;

import org.flashCardManager.model.entity.Context;

public record CardRequestUpdate(
        String id,
        String deckId,
        String name,
        Context context,
        String synonym,
        String phonetic
) {
}

package org.flashCardManager.model.dto.meaningDto;

import org.flashCardManager.model.entity.Context;

import java.util.Set;

public record MeaningRequestCreate(
        String cardId,
        String definition,
        Set<Context> contexts
) {
}

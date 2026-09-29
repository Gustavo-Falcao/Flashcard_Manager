package org.flashCardManager.model.dto.meaningDto;

import org.flashCardManager.model.entity.Context;

import java.util.Set;

public record MeaningRequestResponse(
        String id,
        String cardId,
        String definition,
        Set<Context> contexts
) {
    public MeaningRequestResponse {
        contexts = Set.copyOf(contexts);
    }
}

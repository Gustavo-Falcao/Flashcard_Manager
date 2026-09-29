package org.flashCardManager.model.dto.meaningDto;

import org.flashCardManager.model.entity.Context;

import java.util.Set;

public record MeaningRequestUpdate(
        String id,
        String definition,
        Set<Context> contexts
) {
}

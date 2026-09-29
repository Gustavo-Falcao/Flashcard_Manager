package org.flashCardManager.model.dto.exampleDto;

import org.flashCardManager.model.entity.VerbTense;

public record ExampleRequestUpdate(
        String id,
        String text,
        String targetToBeHidden,
        VerbTense verbTense
) {
}

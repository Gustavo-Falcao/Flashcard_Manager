package org.flashCardManager.model.dto.exampleDto;

import org.flashCardManager.model.entity.VerbTense;

public record ExampleRequestCreate(
        String meaningId,
        String text,
        String targetToBeHidden,
        VerbTense verbTense
) {
}

package org.flashCardManager.model.dto.exampleDto;

import org.flashCardManager.model.entity.VerbTense;

public record ExampleRequestResponse(
        String id,
        String text,
        VerbTense verbTense
) {
}

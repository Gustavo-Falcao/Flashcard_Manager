package org.flashCardManager.controller;

import org.flashCardManager.controller.common.ControllerExecutor;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.model.dto.deckDto.DeckRequestCreate;
import org.flashCardManager.model.dto.deckDto.DeckRequestUpdate;
import org.flashCardManager.model.dto.deckDto.DeckResponse;
import org.flashCardManager.service.DeckService;

import java.util.List;

public class DeckController {

    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    public Result<DeckResponse> create(DeckRequestCreate deckRequestCreate) {
        return ControllerExecutor.execute(
                () -> deckService.create(deckRequestCreate)
        );
    }

    public Result<DeckResponse> update(DeckRequestUpdate deckRequestUpdate) {
        return ControllerExecutor.execute(
                () -> deckService.update(deckRequestUpdate)
        );
    }

    public Result<DeckResponse> findById(String id) {
        return ControllerExecutor.execute(
                () -> deckService.findById(id)
        );
    }

    public Result<List<DeckResponse>> getByUserId(String userId) {
        return ControllerExecutor.execute(
                () -> deckService.getByUserId(userId)
        );
    }

    public Result<Void> deleteById(String id) {
        return ControllerExecutor.execute(
                () -> deckService.deleteById(id)
        );
    }
}

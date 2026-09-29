package org.flashCardManager.controller;

import org.flashCardManager.controller.common.ControllerExecutor;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.model.dto.cardDto.CardRequestCreate;
import org.flashCardManager.model.dto.cardDto.CardRequestResponse;
import org.flashCardManager.model.dto.cardDto.CardRequestUpdate;
import org.flashCardManager.service.CardService;

import java.util.List;

public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    public Result<CardRequestResponse> create(CardRequestCreate cardRequestCreate) {
        return ControllerExecutor.execute(
                () -> cardService.create(cardRequestCreate)
        );
    }

    public Result<CardRequestResponse> update(CardRequestUpdate cardRequestUpdate) {
        return ControllerExecutor.execute(
                () -> cardService.update(cardRequestUpdate)
        );
    }

    public Result<CardRequestResponse> findById(String id) {
        return ControllerExecutor.execute(
                () -> cardService.findById(id)
        );
    }

    public Result<List<CardRequestResponse>> getByDeckId(String deckId) {
        return ControllerExecutor.execute(
                () -> cardService.getByDeckId(deckId)
        );
    }

    public Result<Void> delete(String id) {
        return ControllerExecutor.execute(
                () -> cardService.deleteById(id)
        );
    }
}

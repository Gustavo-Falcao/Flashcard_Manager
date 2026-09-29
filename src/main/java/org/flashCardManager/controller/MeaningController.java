package org.flashCardManager.controller;

import org.flashCardManager.controller.common.ControllerExecutor;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.model.dto.meaningDto.MeaningRequestCreate;
import org.flashCardManager.model.dto.meaningDto.MeaningRequestResponse;
import org.flashCardManager.model.dto.meaningDto.MeaningRequestUpdate;
import org.flashCardManager.service.MeaningService;

import java.util.List;

public class MeaningController {

    private final MeaningService meaningService;

    public MeaningController(MeaningService meaningService) {
        this.meaningService = meaningService;
    }

    public Result<MeaningRequestResponse> create(MeaningRequestCreate meaningRequestCreate) {
        return ControllerExecutor.execute(
                () -> meaningService.create(meaningRequestCreate)
        );
    }

    public Result<MeaningRequestResponse> update(MeaningRequestUpdate meaningRequestUpdate) {
        return ControllerExecutor.execute(
                () -> meaningService.update(meaningRequestUpdate)
        );
    }

    public Result<MeaningRequestResponse> findById(String id) {
        return ControllerExecutor.execute(
                () -> meaningService.findById(id)
        );
    }

    public Result<List<MeaningRequestResponse>> getByCardId(String cardid) {
        return ControllerExecutor.execute(
                () -> meaningService.getByCardId(cardid)
        );
    }

    public Result<Void> delete(String id) {
        return ControllerExecutor.execute(
                () -> meaningService.deleteById(id)
        );
    }
}

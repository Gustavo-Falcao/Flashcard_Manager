package org.flashCardManager.controller;

import org.flashCardManager.controller.common.ControllerExecutor;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.model.dto.exampleDto.ExampleRequestCreate;
import org.flashCardManager.model.dto.exampleDto.ExampleRequestResponse;
import org.flashCardManager.model.dto.exampleDto.ExampleRequestUpdate;
import org.flashCardManager.service.ExampleService;

import java.awt.*;
import java.util.List;

public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    public Result<ExampleRequestResponse> create(ExampleRequestCreate exampleRequestCreate) {
        return ControllerExecutor.execute(
                () -> exampleService.create(exampleRequestCreate)
        );
    }

    public Result<ExampleRequestResponse> update(ExampleRequestUpdate exampleRequestUpdate) {
        return ControllerExecutor.execute(
                () -> exampleService.update(exampleRequestUpdate)
        );
    }

    public Result<ExampleRequestResponse> findById(String id) {
        return ControllerExecutor.execute(
                () -> exampleService.findById(id)
        );
    }

    public Result<List<ExampleRequestResponse>> getByMeaningId(String meaningId) {
        return ControllerExecutor.execute(
                () -> exampleService.getByMeaningId(meaningId)
        );
    }

    public Result<Void> delete(String id) {
        return ControllerExecutor.execute(
                () -> exampleService.deleteById(id)
        );
    }
}

package org.flashCardManager.service;

import org.flashCardManager.exceptions.NotFoundException;
import org.flashCardManager.model.dto.exampleDto.ExampleRequestCreate;
import org.flashCardManager.model.dto.exampleDto.ExampleRequestResponse;
import org.flashCardManager.model.dto.exampleDto.ExampleRequestUpdate;
import org.flashCardManager.model.entity.Example;
import org.flashCardManager.repository.ExampleRepository;
import org.flashCardManager.repository.MeaningRepository;

import java.util.List;

public class ExampleService {
    private final ExampleRepository exampleRepository;
    private final MeaningRepository meaningRepository;

    public ExampleService(ExampleRepository exampleRepository, MeaningRepository meaningRepository) {
        this.exampleRepository = exampleRepository;
        this.meaningRepository = meaningRepository;
    }

    public ExampleRequestResponse create(ExampleRequestCreate exampleRequestCreate) {
        if(meaningRepository.existsById(exampleRequestCreate.meaningId())) {
            throw new NotFoundException("Meaning não encontrado");
        }

        Example example = new Example.Builder()
                .meaningId(exampleRequestCreate.meaningId())
                .text(exampleRequestCreate.text())
                .targetToBeHidden(exampleRequestCreate.targetToBeHidden())
                .verbTense(exampleRequestCreate.verbTense())
                .build();

        return toExampleRequestResponse(example);
    }

    public ExampleRequestResponse update(ExampleRequestUpdate exampleRequestUpdate) {
        Example example = exampleRepository.findById(exampleRequestUpdate.id())
                .orElseThrow(() -> new NotFoundException("Example not found"));

        example.changeText(exampleRequestUpdate.text());
        example.changeTargetToBeHidden(exampleRequestUpdate.targetToBeHidden());
        example.changeVerbTense(example.getVerbTense());

        return toExampleRequestResponse(exampleRepository.update(example));
    }

    public ExampleRequestResponse findById(String id) {
        Example example = exampleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Example not found"));

        return toExampleRequestResponse(example);
    }

    public List<ExampleRequestResponse> getByMeaningId(String meaningId) {
        return exampleRepository.findByMeaningId(meaningId)
                .stream()
                .map(this::toExampleRequestResponse)
                .toList();
    }

    public void deleteById(String id) {
        exampleRepository.deleteById(id);
    }

    public ExampleRequestResponse toExampleRequestResponse(Example example) {
        return new ExampleRequestResponse.Builder()
                .id(example.getId())
                .text(example.getText())
                .targetToBeHidden(example.getTargetToBeHidden())
                .verbTense(example.getVerbTense())
                .build();
    }
}

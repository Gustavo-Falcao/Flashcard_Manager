package org.flashCardManager.service;

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
            throw new IllegalArgumentException("Meaning não encontrado");
        }
        //mudar para exception especifica

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
                .orElseThrow(() -> new IllegalArgumentException("Example not found"));
        //mudar para exception especifica

        example.changeText(exampleRequestUpdate.text());
        example.changeTargetToBeHidden(exampleRequestUpdate.targetToBeHidden());
        example.changeVerbTense(example.getVerbTense());

        return toExampleRequestResponse(exampleRepository.update(example));
    }

    public ExampleRequestResponse findById(String id) {
        Example example = exampleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Example not found"));
        //mudar para exception especifica

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
        return new ExampleRequestResponse(example.getId(), example.getText(), example.getVerbTense());
    }
}

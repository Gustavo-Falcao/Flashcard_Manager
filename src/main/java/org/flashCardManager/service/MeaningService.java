package org.flashCardManager.service;

import org.flashCardManager.model.dto.meaningDto.MeaningRequestCreate;
import org.flashCardManager.model.dto.meaningDto.MeaningRequestResponse;
import org.flashCardManager.model.dto.meaningDto.MeaningRequestUpdate;
import org.flashCardManager.model.entity.Meaning;
import org.flashCardManager.repository.CardRepository;
import org.flashCardManager.repository.MeaningRepository;

import java.util.List;

public class MeaningService {
    private final MeaningRepository meaningRepository;
    private final CardRepository cardRepository;

    public MeaningService(MeaningRepository meaningRepository, CardRepository cardRepository) {
        this.meaningRepository = meaningRepository;
        this.cardRepository = cardRepository;
    }

    public MeaningRequestResponse create(MeaningRequestCreate meaningRequestCreate) {
        if(!cardRepository.existsById(meaningRequestCreate.cardId())) {
            throw new IllegalArgumentException("Card invalido");
            //mudar para exception especifica
        }

        Meaning meaning = new Meaning(
                meaningRequestCreate.cardId(),
                meaningRequestCreate.definition(),
                meaningRequestCreate.contexts()
        );

        return toMeaningRequestResponse(meaningRepository.save(meaning));
    }

    public MeaningRequestResponse update(MeaningRequestUpdate meaningRequestUpdate) {
        Meaning meaning = meaningRepository.findById(meaningRequestUpdate.id())
                .orElseThrow(() -> new IllegalArgumentException("Meaning not found"));
        //mudar para exception especifica

        meaning.changeDefinition(meaningRequestUpdate.definition());
        meaning.changeContexts(meaningRequestUpdate.contexts());

        return toMeaningRequestResponse(meaningRepository.update(meaning));
    }

    public MeaningRequestResponse getById(String id) {
        Meaning meaning = meaningRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Meaning not found"));
        //mudar para exception especifica

        return toMeaningRequestResponse(meaning);
    }

    public List<MeaningRequestResponse> getByCardId(String cardId) {
        return meaningRepository.findByCardId(cardId)
                .stream()
                .map(this::toMeaningRequestResponse)
                .toList();
    }

    public void deleteById(String id) {
        meaningRepository.deleteById(id);
    }

    public MeaningRequestResponse toMeaningRequestResponse(Meaning meaning) {
        return new MeaningRequestResponse(
                meaning.getId(),
                meaning.getCardId(),
                meaning.getDefinition(),
                meaning.getContexts()
                );
    }


}

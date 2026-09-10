package org.flashCardManager.model.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Meaning {
    private String id;
    private String cardId;
    private String definition;
    //contexts
    //examples
    private LocalDate nextReviewDate;
    private int interval;
    private int repetitions;
    private float easeFactor;
    private PracticeMode practiceMode;
    private LocalDate creationDate;

    public Meaning(){}

    public Meaning(
            String id,
            String cardId,
            String definition,
            LocalDate nextReviewDate,
            int interval,
            int repetitions,
            float easeFactor,
            PracticeMode practiceMode,
            LocalDate creationDate
    ) {
        setId(id);
        setCardId(cardId);
        setDefinition(definition);
        setNextReviewDate(nextReviewDate);
        setInterval(interval);
        setRepetitions(repetitions);
        setEaseFactor(easeFactor);
        setPracticeMode(practiceMode);
        setCreationDate(creationDate);
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getCardId() {
        return cardId;
    }

    public String getDefinition() {
        return definition;
    }

    public LocalDate getNextReviewDate() {
        return nextReviewDate;
    }

    public int getInterval() {
        return interval;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public float getEaseFactor() {
        return easeFactor;
    }

    public PracticeMode getPracticeMode() {
        return practiceMode;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }


    //Setters
    private void setId(String id) {
        this.id = Objects.requireNonNull(id, "Id nao pode ser nulo");
    }

    private void setCardId(String cardId) {
        this.cardId = Objects.requireNonNull(cardId, "CardId nao pode ser nulo");
    }

    private void setDefinition(String definition) {
        Objects.requireNonNull(definition, "Definition nao pode ser nulo");
        if(definition.trim().length() < 10)
            throw new IllegalArgumentException("Definicao deve ter pelo menos 10 caracteres");
        this.definition = definition;
    }

    private void setNextReviewDate(LocalDate nextReviewDate) {
        Objects.requireNonNull(nextReviewDate, "NextReviewDate nao pode ser nulo");
        if(nextReviewDate.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("O nextReviewDate nao pode ser no passado");
        this.nextReviewDate = nextReviewDate;
    }

    private void setInterval(int interval) {
        this.interval = Objects.requireNonNull(interval, "Interval nao pode ser nulo");
    }

    private void setRepetitions(int repetitions) {
        this.repetitions = Objects.requireNonNull(repetitions, "Repetitions nao pode ser nulo");
    }

    private void setEaseFactor(float easeFactor) {
        this.easeFactor = Objects.requireNonNull(easeFactor, "EaseFactor nao pode ser nulo");
    }

    private void setPracticeMode(PracticeMode practiceMode) {
        this.practiceMode = Objects.requireNonNull(practiceMode, "PracticeMode nao pode ser nulo");
    }

    private void setCreationDate(LocalDate creationDate) {
        this.creationDate = Objects.requireNonNull(creationDate, "Data de criacao é obrigatória");
    }
}

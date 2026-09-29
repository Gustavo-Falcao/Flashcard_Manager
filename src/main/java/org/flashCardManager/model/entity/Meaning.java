package org.flashCardManager.model.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class Meaning implements Identifiable {
    private String id;
    private String cardId;
    private String definition;
    private Set<Context> contexts;
    private LocalDate nextReviewDate;
    private int interval;
    private int repetitions;
    private float easeFactor;
    private PracticeMode practiceMode;
    private LocalDate creationDate;

    public Meaning(){}

    public Meaning(
            String cardId,
            String definition,
            Set<Context> contexts
    ) {
        setId(UUID.randomUUID().toString().substring(0,8));
        setCardId(cardId);
        setDefinition(definition);
        setContexts(contexts);
        setNextReviewDate(LocalDate.now());
        setInterval(0);
        setRepetitions(0);
        setEaseFactor(2.5f);
        setPracticeMode(PracticeMode.PRACTICE);
        setCreationDate(LocalDate.now());
    }

    //Getters
    @Override
    public String getId() {
        return id;
    }

    public String getCardId() {
        return cardId;
    }

    public String getDefinition() {
        return definition;
    }

    public Set<Context> getContexts() {
        return contexts;
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

    private void setContexts(Set<Context> contexts) {
        Objects.requireNonNull(contexts, "Contexts nao pode ser nulo");

        if(contexts.contains(null)) {
            throw new IllegalArgumentException("Contexts nao pode ter valores nulos");
        }
        this.contexts = Set.copyOf(contexts);
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

    public void changeDefinition(String definition) {
        setDefinition(definition);
    }

    public void changeContexts(Set<Context> contexts) {
        setContexts(contexts);
    }

    @Override
    public String toString() {
        return "Meaning{" +
                "id='" + id + '\'' +
                ", cardId='" + cardId + '\'' +
                ", definition='" + definition + '\'' +
                ", nextReviewDate=" + nextReviewDate +
                ", interval=" + interval +
                ", repetitions=" + repetitions +
                ", easeFactor=" + easeFactor +
                ", practiceMode=" + practiceMode +
                ", creationDate=" + creationDate +
                '}';
    }
}

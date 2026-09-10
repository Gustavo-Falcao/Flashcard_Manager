package org.flashCardManager.model.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Example {
    private String id;
    private String meaningId;
    private String text;
    private String targetToBeHidden;
    private VerbTense verbTense;
    private LocalDate creationDate;

    public Example(){}

    private Example(Builder builder) {
        this(builder.meaningId, builder.text, builder.targetToBeHidden, builder.verbTense);
    }

    private Example(String meaningId, String text, String targetToBeHidden, VerbTense verbTense) {
        setId(UUID.randomUUID().toString().substring(0,8));
        setMeaningId(meaningId);
        setText(text);
        setTargetToBeHidden(targetToBeHidden);
        setVerbTense(verbTense);
        setCreationDate(LocalDate.now());
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getMeaningIdP(){
        return  meaningId;
    };

    public String getText() {
        return text;
    }

    public String getTargetToBeHidden() {
        return targetToBeHidden;
    }

    public VerbTense getVerbTense() {
        return verbTense;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    //Setters
    private void setId(String id) {
        this.id = Objects.requireNonNull(id, "Id nao pode ser nulo");
    }

    private void setMeaningId(String meaningId) {
        this.meaningId = Objects.requireNonNull(meaningId, "MeaningId nao pode ser nulo");
    }

    private void setText(String text) {
        Objects.requireNonNull(text, "Exemplo nao pode ser nulo");
        if(text.trim().length() < 10)
            throw new IllegalArgumentException("Exemplo deve ter pelo menos 10 caracteres");
        this.text = text;
    }

    private void setTargetToBeHidden(String targetToBeHidden) {
        if(targetToBeHidden != null && targetToBeHidden.trim().length() < 2)
            throw new IllegalArgumentException("Target deve ter pelo menos 2 caracteres");
        this.targetToBeHidden = targetToBeHidden;
    }

    private void setVerbTense(VerbTense verbTense) {
        this.verbTense = verbTense;
    }

    private void setCreationDate(LocalDate creationDate) {
        this.creationDate = Objects.requireNonNull(creationDate, "Data de criacao é obrigatória");
    }

    //Builder
    public static class Builder {
        private String meaningId;
        private String text;
        private String targetToBeHidden;
        private VerbTense verbTense;

        public Builder meaningId(String meaningId) {
            this.meaningId = meaningId;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder targetToBeHidden(String targetToBeHidden) {
            this.targetToBeHidden = targetToBeHidden;
            return this;
        }

        public Builder verbTense(VerbTense verbTense) {
            this.verbTense = verbTense;
            return this;
        }

        public Example build() {
            return new Example(this);
        }
    }
}

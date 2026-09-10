package org.flashCardManager.model.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Card {
    private String id;
    private String deckId;
    private String name;
    private String contextId;
    private String synonym;
    private String phonetic;
    private LocalDate creationDate;

    public Card(){}

    private Card(Builder builder) {
        this(builder.deckId, builder.name, builder.contextId, builder.synonym, builder.phonetic);
    }

    private Card(String deckId, String name, String contextId, String synonym, String phonetic) {
        setId(UUID.randomUUID().toString().substring(0,8));
        setDeckId(deckId);
        setName(name);
        setContextId(contextId);
        setSynonym(synonym);
        setPhonetic(phonetic);
        setCreationDate(LocalDate.now());
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getDeckId() {
        return deckId;
    }

    public String getName() {
        return name;
    }

    public String getContextId() {
        return contextId;
    }

    public String getSynonym() {
        return synonym;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    //Setters
    private void setId(String id) {
        this.id = Objects.requireNonNull(id, "Id nao pode ser nulo");
    }

    private void setDeckId(String deckId) {
        this.deckId = Objects.requireNonNull(deckId, "DeckId nao pode ser nulo");
    }

    private void setName(String name) {
        Objects.requireNonNull(name, "Nome nao pode ser nulo");
        if(name.trim().length() < 2)
            throw new IllegalArgumentException("Nome deve ter pelo menos 2 caracteres");
        this.name = name;
    }

    private void setContextId(String contextId) {
        Objects.requireNonNull(contextId, "ContextId nao pode ser nulo");
        this.contextId = contextId;
    }

    private void setSynonym(String synonym) {
        if(synonym != null && synonym.trim().isEmpty()) throw new IllegalArgumentException("Sinonimo deve ter pelo menos 1 caractere");
        this.synonym = synonym;
    }

    private void setPhonetic(String phonetic) {
        if(phonetic != null && phonetic.trim().isEmpty()) throw new IllegalArgumentException("Fonetica deve ter pelo menos 1 caractere");
        this.phonetic = phonetic;
    }

    private void setCreationDate(LocalDate creationDate) {
        this.creationDate = Objects.requireNonNull(creationDate, "Data de criacao é obrigatória");
    }

    //Builder
    public static class Builder {
        private String deckId;
        private String name;
        private String contextId;
        private String synonym;
        private String phonetic;

        public Builder deckId(String deckId) {
            this.deckId = deckId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder contextId(String contextId) {
            this.contextId = contextId;
            return this;
        }

        public Builder synonym(String synonym) {
            this.synonym = synonym;
            return this;
        }

        public Builder phonetic(String phonetic) {
            this.phonetic = phonetic;
            return this;
        }

        public Card build() {
            return new Card(this);
        }
    }


}

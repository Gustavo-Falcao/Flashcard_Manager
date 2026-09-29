package org.flashCardManager.model.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Card implements Identifiable {
    private String id;
    private String deckId;
    private String name;
    private Context context;
    private String synonym;
    private String phonetic;
    private LocalDate creationDate;

    public Card(){}

    private Card(Builder builder) {
        this(builder.deckId, builder.name, builder.context, builder.synonym, builder.phonetic);
    }

    private Card(String deckId, String name, Context context, String synonym, String phonetic) {
        setId(UUID.randomUUID().toString().substring(0,8));
        setDeckId(deckId);
        setName(name);
        setContext(context);
        setSynonym(synonym);
        setPhonetic(phonetic);
        setCreationDate(LocalDate.now());
    }

    //Getters
    @Override
    public String getId() {
        return id;
    }

    public String getDeckId() {
        return deckId;
    }

    public String getName() {
        return name;
    }

    public Context getContext() {
        return context;
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

    private void setContext(Context context) {
        Objects.requireNonNull(context, "Context nao pode ser nulo");
        this.context = context;
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

    public void changeDeckId(String deckId) {
        setDeckId(deckId);
    }

    public void changeName(String name) {
        setName(name);
    }

    public void changeContext(Context context) {
        setContext(context);
    }

    public void changeSynonym(String synonym) {
        setSynonym(synonym);
    }

    public void changePhonetic(String phonetic) {
        setPhonetic(phonetic);
    }

    //Builder
    public static class Builder {
        private String deckId;
        private String name;
        private Context context;
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

        public Builder context(Context context) {
            this.context = context;
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

package org.flashCardManager.model.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Deck {
    private String id;
    private String userId;
    private String name;
    private LocalDate creationDate;

    public Deck(){}

    public Deck(String userId, String name) {
        setId(UUID.randomUUID().toString().substring(0,8));

        setName(name);
        setCreationDate(LocalDate.now());
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    //Setters
    private void setId(String id) {
        this.id = Objects.requireNonNull(id, "Id do deck não pode ser nulo.");
    }

    private void setUserId(String userId) {
        this.userId = Objects.requireNonNull(userId, "Id do usuário não pode ser nulo.");
    }

    private void setName(String name) {
        Objects.requireNonNull(name, "Nome do deck não pode ser nulo.");
        if(name.trim().isEmpty()) throw new IllegalArgumentException("Nome deve ter pelo menos 1 caractere");
        this.name = name;
    }

    private void setCreationDate(LocalDate creationDate) {
        this.creationDate = Objects.requireNonNull(creationDate, "Data criação não pode ser nula.");
    }
}

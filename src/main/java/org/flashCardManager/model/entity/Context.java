package org.flashCardManager.model.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Context {
    private String id;
    private String name;
    private LocalDate creationDate;

    public Context(){}

    public Context(String name) {
        setId(UUID.randomUUID().toString().substring(0,8));
        setName(name);
        setCreationDate(LocalDate.now());
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    //Setters
    public void setId(String id) {
        this.id = Objects.requireNonNull(id, "Id nao pode ser nulo");
    }

    public void setName(String name) {
        Objects.requireNonNull(name, "Nome nao pode ser nulo");
        if(name.trim().length() < 2) throw new IllegalArgumentException("Nome deve ter pelo menos 2 caracteres");
        this.name = name;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = Objects.requireNonNull(creationDate, "Data de criacao é obrigatória");
    }
}

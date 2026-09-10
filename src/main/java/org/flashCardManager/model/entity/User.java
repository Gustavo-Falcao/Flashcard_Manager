package org.flashCardManager.model.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private LocalDate creationDate;

    public User(){}

    public User(String name, String email, String password) {
        setId(UUID.randomUUID().toString().substring(0,8));
        setName(name);
        setEmail(email);
        setPassword(password);
        setCreationDate(LocalDate.now());
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    //Setters
    private void setId(String id) {
        //throws NullPointerException
        this.id = Objects.requireNonNull(id, "Id nao pode ser nulo");
    }

    private void setName(String name) {
        Objects.requireNonNull(name, "Nome nao pode ser nulo");
        if(name.length() < 3) throw new IllegalArgumentException("Nome deve ter 3 ou mais caracteres");
        this.name = name;
    }

    private void setEmail(String email) {
        this.email = Objects.requireNonNull(email, "Email nao pode ser nulo");
        //puxar metdodo de validacao para email
    }

    private void setPassword(String password) {
        this.password = Objects.requireNonNull(password, "Senha nao pode ser nula");
        //puxar metodo de validacao para password
    }

    private void setCreationDate(LocalDate date) {
        this.creationDate = Objects.requireNonNull(date, "Data da criacao é obrigatoria");
    }

    @Override
    public String toString() {
        return
                name
                + ", "
                + email
                + ", "
                + password
                + ", "
                + creationDate;
    }
}

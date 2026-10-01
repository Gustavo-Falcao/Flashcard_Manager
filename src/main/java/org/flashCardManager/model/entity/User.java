package org.flashCardManager.model.entity;

import org.flashCardManager.exceptions.ValidationException;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class User implements Identifiable {
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
    @Override
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
        if(name.length() < 3) throw new ValidationException("Nome deve ter 3 ou mais caracteres");
        this.name = name;
    }

    private void setEmail(String email) {
        Objects.requireNonNull(email, "Email nao pode ser nulo");
        if(!email.matches("^[a-z._0-9+-]+@[a-z]{3,}+\\.[a-z]{2,}$")) {
            throw new ValidationException("Formato de email invalido");
        }
        this.email = email;
    }

    private void setPassword(String password) {
        Objects.requireNonNull(password, "Senha nao pode ser nula");
        if(!password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$")) {
            throw new ValidationException("Formato de senha invalido");
        }
        this.password = password;
    }

    private void setCreationDate(LocalDate date) {
        this.creationDate = Objects.requireNonNull(date, "Data da criacao é obrigatoria");
    }

    public void changeName(String name) {
        setName(name);
    }

    public void changeEmail(String email) {
        setEmail(email);
    }

    public void changePassword(String password) {
        setPassword(password);
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

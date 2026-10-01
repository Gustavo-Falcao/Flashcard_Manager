package org.flashCardManager.model.dto.userDto;

public class UserRequestUpdate {

    private String id;
    private String name;
    private String email;
    private String password;

    private UserRequestUpdate(Builder builder) {
        this(builder.id, builder.name, builder.email, builder.password);
    }

    private UserRequestUpdate(String id, String name, String email, String password) {
        setId(id);
        setName(name);
        setEmail(email);
        setPassword(password);
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

    //Setters
    private void setId(String id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    //Builder
    public static class Builder {
        private String id;
        private String name;
        private String email;
        private String password;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public UserRequestUpdate build() {
            return new UserRequestUpdate(this);
        }
    }
}

package org.flashCardManager.jsonRepository;

import org.flashCardManager.model.entity.User;
import org.flashCardManager.repository.UserRepository;

import java.util.Optional;

public class UserJsonRepository extends AbstractJsonRepository<User> implements UserRepository {
    public UserJsonRepository() {
        super("src/main/java/org.flashCardManager/db/users.json");
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return findAll()
                .stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public boolean existsByEmail(String email) {
        return findAll()
                .stream()
                .anyMatch(user -> user.getEmail().equals(email));
    }

    @Override
    public boolean existsByEmail(String email, String idToIgnore) {
        return findAll()
                .stream()
                .anyMatch(user ->
                        user.getEmail().equals(email) &&
                        !user.getId().equals(idToIgnore));
    }
}

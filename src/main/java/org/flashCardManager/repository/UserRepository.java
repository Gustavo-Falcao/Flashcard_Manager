package org.flashCardManager.repository;

import org.flashCardManager.model.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}

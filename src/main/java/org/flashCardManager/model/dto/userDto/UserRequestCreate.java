package org.flashCardManager.model.dto.userDto;

public record UserRequestCreate(
        String name,
        String email,
        String password
) {
}

package org.flashCardManager.model.dto.userDto;

public record UserRequestLogin(
        String email,
        String password
) {
}

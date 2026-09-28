package org.flashCardManager.model.dto.userDto;

public record UserRequestUpdate(
        String id,
        String name,
        String email,
        String password
) {
}

package org.flashCardManager.mapper;

import org.flashCardManager.model.dto.userDto.UserRequestCreate;
import org.flashCardManager.model.dto.userDto.UserResponse;
import org.flashCardManager.model.entity.User;

public class UserMapper {

    private UserMapper() {}

    public static User toEntity(UserRequestCreate userRequestCreate) {
        return new User(
                userRequestCreate.name(),
                userRequestCreate.email(),
                userRequestCreate.password()
        );
    }

    public static UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }


}

package org.flashCardManager.controller;

import org.flashCardManager.controller.common.ControllerExecutor;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.model.dto.userDto.UserRequestCreate;
import org.flashCardManager.model.dto.userDto.UserRequestUpdate;
import org.flashCardManager.model.dto.userDto.UserResponse;
import org.flashCardManager.service.UserService;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public Result<UserResponse> create(UserRequestCreate userRequestCreate) {
        return ControllerExecutor.execute(
                () -> userService.create(userRequestCreate)
        );
    }

    public Result<UserResponse> update(UserRequestUpdate userRequestUpdate) {
        return ControllerExecutor.execute(
                () -> userService.update(userRequestUpdate)
        );
    }

    public Result<UserResponse> findById(String id) {
        return ControllerExecutor.execute(
                () -> userService.findById(id)
        );
    }

    public Result<Void> delete(String id) {
        return ControllerExecutor.execute(
                () -> userService.deleteById(id)
        );
    }
}

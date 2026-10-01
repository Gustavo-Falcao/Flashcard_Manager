package org.flashCardManager.controller;

import org.flashCardManager.controller.common.ControllerExecutor;
import org.flashCardManager.controller.common.Result;
import org.flashCardManager.model.dto.userDto.UserRequestLogin;
import org.flashCardManager.model.dto.userDto.UserResponse;
import org.flashCardManager.service.AuthService;

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public Result<UserResponse> authenticate(UserRequestLogin userRequestLogin) {
        return ControllerExecutor.execute(
                () -> authService.authenticate(userRequestLogin)
        );
    }
}

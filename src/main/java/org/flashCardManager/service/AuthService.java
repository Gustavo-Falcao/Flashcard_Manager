package org.flashCardManager.service;

import org.flashCardManager.exceptions.AuthenticationException;
import org.flashCardManager.mapper.UserMapper;
import org.flashCardManager.model.dto.userDto.UserRequestLogin;
import org.flashCardManager.model.dto.userDto.UserResponse;
import org.flashCardManager.model.entity.User;
import org.flashCardManager.repository.UserRepository;

public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse authenticate(UserRequestLogin userRequestLogin) {
        User user = userRepository.findByEmail(userRequestLogin.email())
                .orElseThrow(() -> new AuthenticationException("Email ou senha invalido"));

        if(!user.getPassword().equals(userRequestLogin.password())) {
            throw new AuthenticationException("Email ou senha invalido");
        }

        return UserMapper.toUserResponse(user);
    }
}

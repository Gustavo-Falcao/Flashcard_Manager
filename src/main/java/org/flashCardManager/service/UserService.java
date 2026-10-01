package org.flashCardManager.service;


import org.flashCardManager.exceptions.NotFoundException;
import org.flashCardManager.exceptions.ValidationException;
import org.flashCardManager.mapper.UserMapper;
import org.flashCardManager.model.dto.userDto.UserRequestCreate;
import org.flashCardManager.model.dto.userDto.UserRequestUpdate;
import org.flashCardManager.model.dto.userDto.UserResponse;
import org.flashCardManager.model.entity.User;
import org.flashCardManager.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse create(UserRequestCreate userRequestCreate) {
        if(userRepository.existsByEmail(userRequestCreate.email())) {
            throw new IllegalArgumentException("Email ja cadastrado");
            //mudar para exception especifica
        }

        User user = UserMapper.toEntity(userRequestCreate);

        return UserMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse update(UserRequestUpdate userRequestUpdate) {
        User user = userRepository.findById(userRequestUpdate.getId())
                .orElseThrow(() -> new NotFoundException("User not found"));

        if(userRequestUpdate.getEmail() != null && !userRequestUpdate.getEmail().isBlank()) {
            if(userRepository.existsByEmail(userRequestUpdate.getEmail(), userRequestUpdate.getId())) {
                throw new ValidationException("Email ja cadastrado");
            }
        }

        if(userRequestUpdate.getName() != null && !userRequestUpdate.getName().isBlank()) {
            user.changeName(userRequestUpdate.getName());
        }

        if(userRequestUpdate.getEmail() != null && !userRequestUpdate.getEmail().isBlank()) {
            user.changeEmail(userRequestUpdate.getEmail());
        }

        if(userRequestUpdate.getPassword() != null && !userRequestUpdate.getPassword().isBlank()) {
            user.changePassword(userRequestUpdate.getPassword());
        }

        return UserMapper.toUserResponse(userRepository.update(user));
    }

    public UserResponse findById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Deck not found"));
        //mudar para exception especifica

        return UserMapper.toUserResponse(user);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}

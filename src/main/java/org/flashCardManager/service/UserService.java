package org.flashCardManager.service;


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
        User user = userRepository.findById(userRequestUpdate.id())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        //mudar para exception especifica

        if(userRepository.existsByEmail(userRequestUpdate.email(), userRequestUpdate.id())) {
            throw new IllegalArgumentException("Email ja cadastrado");
            //mudar para exception especifica
        }

        user.changeName(userRequestUpdate.name());
        user.changeEmail(userRequestUpdate.email());
        user.changePassword(userRequestUpdate.password());

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

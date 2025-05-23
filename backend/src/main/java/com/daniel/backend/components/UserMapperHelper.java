package com.daniel.backend.components;

import com.daniel.backend.entities.UserEntity;
import com.daniel.backend.repositories.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserMapperHelper {

    private final UserRepository userRepository;

    public UserMapperHelper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity fromId(Long id) {
        if (id <= 0) throw new IllegalArgumentException("Id deve ser maior que zero");
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }
}



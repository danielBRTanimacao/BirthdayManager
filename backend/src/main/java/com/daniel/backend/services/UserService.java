package com.daniel.backend.services;

import com.daniel.backend.dtos.NewUserDTO;
import com.daniel.backend.dtos.UserEntityDTO;
import com.daniel.backend.entities.UserEntity;
import com.daniel.backend.mappers.UserMapper;
import com.daniel.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    public UserEntityDTO create(NewUserDTO userDTO) {
        UserEntity user = mapper.toEntity(userDTO);
        user = userRepository.save(user);
        return mapper.toDTO(user);
    }
}

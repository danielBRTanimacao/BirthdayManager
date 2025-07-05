package com.daniel.backend.services.impl;

import com.daniel.backend.dtos.createUserDTOs.RequestUserDTO;
import com.daniel.backend.dtos.loginDTOs.ResponseTokenDTO;
import com.daniel.backend.dtos.loginDTOs.RequestLoginDTO;
import com.daniel.backend.dtos.createUserDTOs.ResponseUserDTO;
import com.daniel.backend.entities.UserEntity;
import com.daniel.backend.infra.security.TokenService;
import com.daniel.backend.mappers.UserMapper;
import com.daniel.backend.repositories.UserRepository;
import com.daniel.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Override
    public ResponseUserDTO create(RequestUserDTO userDTO) {
        UserEntity user = mapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return mapper.toDTO(user);
    }

    @Override
    public ResponseTokenDTO login(RequestLoginDTO userDTO) {

        UserEntity user = userRepository.findByEmail(userDTO.email())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email"));

        if (!passwordEncoder.matches(userDTO.password(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        String token = tokenService.generateToken(user);

        return new ResponseTokenDTO(user.getId(), user.getEmail(), token);
    }
}

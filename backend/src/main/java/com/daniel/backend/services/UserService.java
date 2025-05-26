package com.daniel.backend.services;

import com.daniel.backend.dtos.LoginUserDTO;
import com.daniel.backend.dtos.NewLoginUserDTO;
import com.daniel.backend.dtos.NewUserDTO;
import com.daniel.backend.dtos.UserEntityDTO;
import com.daniel.backend.entities.UserEntity;
import com.daniel.backend.infra.security.TokenService;
import com.daniel.backend.mappers.UserMapper;
import com.daniel.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public UserEntityDTO create(NewUserDTO userDTO) {
        UserEntity user = mapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return mapper.toDTO(user);
    }

    public LoginUserDTO login(NewLoginUserDTO userDTO) {

        UserEntity user = userRepository.findByEmail(userDTO.email())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email"));

        if (!passwordEncoder.matches(userDTO.password(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        String token = tokenService.generateToken(user);

        return new LoginUserDTO(user.getId(), token);
    }
}

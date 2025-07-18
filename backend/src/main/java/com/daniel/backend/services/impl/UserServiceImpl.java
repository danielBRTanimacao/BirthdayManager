package com.daniel.backend.services.impl;

import com.daniel.backend.components.UserMailSender;
import com.daniel.backend.dtos.createUserDTOs.RequestUserDTO;
import com.daniel.backend.dtos.emailDTOs.RequestEmailTokenDTO;
import com.daniel.backend.dtos.loginDTOs.ResponseTokenDTO;
import com.daniel.backend.dtos.loginDTOs.RequestLoginDTO;
import com.daniel.backend.dtos.createUserDTOs.ResponseUserDTO;
import com.daniel.backend.entities.UserEntity;
import com.daniel.backend.entities.UserStatus;
import com.daniel.backend.infra.security.TokenService;
import com.daniel.backend.mappers.UserMapper;
import com.daniel.backend.repositories.UserRepository;
import com.daniel.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    private final JavaMailSender javaMailSender;

    @Override
    public ResponseUserDTO create(RequestUserDTO userDTO) {
        UserEntity user = mapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UserMailSender.mailSender(user, javaMailSender);

        user = userRepository.save(user);
        return mapper.toDTO(user);
    }

    @Override
    public ResponseUserDTO update(RequestUserDTO userDTO, Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid user")
        );

        String beforeMail = user.getEmail();

        user = mapper.partialUpdate(userDTO, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUpdatedDate(LocalDateTime.now());

        if (!beforeMail.equals(userDTO.email())) {
            UserMailSender.mailSender(user, javaMailSender);
            user.setExpireTimerToken(LocalDateTime.now().plusMinutes(30));
            user.setStatus(UserStatus.DRAFT);
        }

        userRepository.save(user);
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

    @Override
    public void validateUserToken(RequestEmailTokenDTO tokenDTO, Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Invalid user")
        );
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime plusHours = user.getCreatedDate().plusMinutes(30);

        if (now.isBefore(plusHours)) {
            if (tokenDTO.token().equals(user.getTokenUserMail())) {
                user.setValid(true);
                user.setTokenUserMail("");
                user.setStatus(UserStatus.ACTIVE);
            } else {
                throw new IllegalArgumentException("Invalid token");
            }
        } else {
            throw new IllegalArgumentException("Token expired");
        }

    }
}

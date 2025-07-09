package com.daniel.backend.controllers.impl;

import com.daniel.backend.controllers.UserController;
import com.daniel.backend.dtos.createUserDTOs.RequestUserDTO;
import com.daniel.backend.dtos.emailDTOs.RequestEmailTokenDTO;
import com.daniel.backend.dtos.loginDTOs.ResponseTokenDTO;
import com.daniel.backend.dtos.loginDTOs.RequestLoginDTO;
import com.daniel.backend.dtos.createUserDTOs.ResponseUserDTO;
import com.daniel.backend.entities.UserEntity;
import com.daniel.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public ResponseEntity<ResponseUserDTO> createUser(RequestUserDTO dto) {
        return new ResponseEntity<>(userService.create(dto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseUserDTO> updateUser(RequestUserDTO dto, Long id) {
        return new ResponseEntity<>(userService.update(dto, id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseTokenDTO> loginUser(RequestLoginDTO dto) {
        return ResponseEntity.ok(userService.login(dto));
    }

    @Override
    public ResponseEntity<?> validateUser(RequestEmailTokenDTO dto, Long id) {
        userService.validateUserToken(dto, id);
        return ResponseEntity.ok().build();
    }

}

package com.daniel.backend.controllers.impl;

import com.daniel.backend.controllers.UserController;
import com.daniel.backend.dtos.createUserDTOs.RequestUserDTO;
import com.daniel.backend.dtos.loginDTOs.ResponseTokenDTO;
import com.daniel.backend.dtos.loginDTOs.RequestLoginDTO;
import com.daniel.backend.dtos.createUserDTOs.ResponseUserDTO;
import com.daniel.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<ResponseUserDTO> createUser(RequestUserDTO dto) {
        return new ResponseEntity<>(userService.create(dto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseTokenDTO> loginUser(RequestLoginDTO dto) {
        return ResponseEntity.ok(userService.login(dto));
    }

    @Override
    public ResponseEntity<?> logoutUser(Long id) {
        userService.logout(id);
        return ResponseEntity.ok().body("Log out");
    }
}

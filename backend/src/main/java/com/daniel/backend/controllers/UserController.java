package com.daniel.backend.controllers;

import com.daniel.backend.dtos.NewUserDTO;
import com.daniel.backend.dtos.UserEntityDTO;
import com.daniel.backend.repositories.UserRepository;
import com.daniel.backend.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserEntityDTO> createUser(@Valid @RequestBody NewUserDTO dto) {
        return new ResponseEntity<>(userService.create(dto), HttpStatus.CREATED);
    }
}

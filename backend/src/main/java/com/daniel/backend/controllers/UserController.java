package com.daniel.backend.controllers;

import com.daniel.backend.dtos.RequestUserDTO;
import com.daniel.backend.dtos.ResponseTokenDTO;
import com.daniel.backend.dtos.RequestLoginDTO;
import com.daniel.backend.dtos.ResponseUserDTO;
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

    @PostMapping("/create")
    public ResponseEntity<ResponseUserDTO> createUser(@Valid @RequestBody RequestUserDTO dto) {
        return new ResponseEntity<>(userService.create(dto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseTokenDTO> loginUser(@Valid @RequestBody RequestLoginDTO dto) {
        return ResponseEntity.ok(userService.login(dto));
    }
}

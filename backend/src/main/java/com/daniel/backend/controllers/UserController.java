package com.daniel.backend.controllers;

import com.daniel.backend.dtos.createUserDTOs.RequestUserDTO;
import com.daniel.backend.dtos.createUserDTOs.ResponseUserDTO;
import com.daniel.backend.dtos.emailDTOs.RequestEmailTokenDTO;
import com.daniel.backend.dtos.loginDTOs.RequestLoginDTO;
import com.daniel.backend.dtos.loginDTOs.ResponseTokenDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/user")
public interface UserController {
    @PostMapping("/create")
    ResponseEntity<ResponseUserDTO> createUser(@Valid @RequestBody RequestUserDTO dto);

    @PostMapping("/login")
    ResponseEntity<ResponseTokenDTO> loginUser(@Valid @RequestBody RequestLoginDTO dto);

    @PostMapping("/validate/{id}")
    ResponseEntity<?> validateUser(@Valid @RequestBody RequestEmailTokenDTO dto, @PathVariable Long id);
}

package com.daniel.backend.dtos.createUserDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestUserDTO(
        Long id,
        @NotBlank
        String name,

        @Email
        String email,

        @NotBlank
        @Size(min = 6, message = "deve conter no minimo 6 caracteres")
        String password) {
}

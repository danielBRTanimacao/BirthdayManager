package com.daniel.backend.dtos.loginDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record RequestLoginDTO(
        @Email
        String email,
        @Size(min = 6, message = "Deve conter no minimo 6 caracteres")
        String password) {
}

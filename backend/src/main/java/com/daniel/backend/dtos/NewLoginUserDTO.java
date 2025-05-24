package com.daniel.backend.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record NewLoginUserDTO(
        @Email
        String email,
        @Size(min = 6, message = "Deve conter no minimo 6 caracteres")
        String password) {
}

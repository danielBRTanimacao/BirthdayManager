package com.daniel.backend.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NewUserDTO(
        Long id,
        @NotBlank
        String name,
        @Email
        String email,
        @NotBlank
        @Size(min = 6)
        String password) {
}

package com.daniel.backend.dtos.emailDTOs;

import jakarta.validation.constraints.NotBlank;

public record RequestEmailTokenDTO(
        @NotBlank String token) {
}

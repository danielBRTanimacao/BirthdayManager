package com.daniel.backend.dtos;

import jakarta.validation.constraints.NotBlank;

public record RequestEmailDTO(
        @NotBlank String senderMail,
        @NotBlank String subject,
        @NotBlank String body) {
}

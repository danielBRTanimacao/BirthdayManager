package com.daniel.backend.dtos.birthdaysDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record RequestBirthdayDTO(
        Long id,

        @NotNull
        Long userId,

        @NotBlank
        String name,

        @NotBlank
        @Pattern(regexp = "\\d{2}-\\d{2}", message = "Use o formato MM-DD")
        String birthday,

        String notes,

        String colors,

        String textColor

) {
}

package com.daniel.backend.dtos;

import com.daniel.backend.entities.UserEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/*
    DTO para criação e update da entidade
    Pode ser separado em outro DTO quando houver mais atributos.
 */
public record NewBirthdayDTO(
        Long id,

        @NotNull
        Long userId,

        @NotBlank
        String name,

        @NotBlank
        @Pattern(regexp = "\\d{2}-\\d{2}", message = "Use o formato MM-DD")
        String birthday,

        String notes
) {
}

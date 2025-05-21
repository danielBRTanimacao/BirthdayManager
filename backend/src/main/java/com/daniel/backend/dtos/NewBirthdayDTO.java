package com.daniel.backend.dtos;

/*
    DTO para criação e update da entidade
    Pode ser separado em outro DTO quando houver mais atributos.
 */
public record NewBirthdayDTO(
        Long id,
        String name,
        String birthday,
        String notes
) {
}

package com.daniel.backend.dtos.createUserDTOs;

import java.time.LocalDateTime;

public record ResponseUserDTO(
        String name,
        String email,
        LocalDateTime createdDate,
        LocalDateTime updatedDate) {
}
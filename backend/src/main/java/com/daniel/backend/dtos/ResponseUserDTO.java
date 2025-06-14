package com.daniel.backend.dtos;

import java.time.LocalDateTime;

public record ResponseUserDTO(
        String name,
        String email,
        LocalDateTime createdDate,
        LocalDateTime updatedDate) {
}
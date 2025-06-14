package com.daniel.backend.dtos;

import java.time.LocalDateTime;

public record ResponseBirthdayDTO(
        String name,
        String birthday,
        String notes,
        String colors,
        LocalDateTime createdDate,
        LocalDateTime updatedDate) {
}

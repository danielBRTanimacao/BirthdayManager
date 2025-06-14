package com.daniel.backend.dtos;

import java.time.LocalDateTime;

public record ResponseBirthdayDTO(
        String name,
        String birthday,
        String notes,
        LocalDateTime createdDate,
        LocalDateTime updatedDate) {
}

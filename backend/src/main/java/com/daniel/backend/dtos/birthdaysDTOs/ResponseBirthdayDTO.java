package com.daniel.backend.dtos.birthdaysDTOs;

import java.time.LocalDateTime;

public record ResponseBirthdayDTO(
        String name,
        String birthday,
        String notes,
        String colors,
        String textColor,
        LocalDateTime createdDate,
        LocalDateTime updatedDate) {
}

package com.daniel.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.*;

@Data
@Entity
public class BirthdayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne @JoinColumn(name = "user_id") User user;

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "\\d{2}-\\d{2}", message = "Use o formato MM-DD")
    private String birthday;

    private String notes;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @PrePersist
    public void prePersist() {
        if (createdDate == null) {
            createdDate = LocalDateTime.now();
        }
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = LocalDateTime.now();
    }
}

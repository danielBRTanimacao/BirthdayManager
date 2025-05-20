package com.daniel.backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.*;

// Recomendado não usar o @Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

    @CreationTimestamp // Cria o createdDate automaticamente
    private Timestamp createdDate;

    @UpdateTimestamp // Cria o updatedDate automaticamente
    private Timestamp updatedDate;

//    @PrePersist
//    public void prePersist() {
//        if (createdDate == null) {
//            createdDate = LocalDateTime.now();
//        }
//        updatedDate = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        updatedDate = LocalDateTime.now();
//    }
}

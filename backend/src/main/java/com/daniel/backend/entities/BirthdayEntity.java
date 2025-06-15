package com.daniel.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

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

    @ManyToOne(optional = false)
    @JsonBackReference
    private UserEntity user;

    private String name;

    private String birthday;

    private String notes;

    private String colors;

    private String textColor;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    @PrePersist
    public void prePersist() {
        if (colors == null) {
            colors = "#fada7a";
        }
        if (textColor == null) {
            textColor = "#fff";
        }
    }
}

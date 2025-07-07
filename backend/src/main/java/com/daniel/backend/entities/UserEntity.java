package com.daniel.backend.entities;

import com.daniel.backend.components.TokenGenerate;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString(exclude = "birthdays")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<BirthdayEntity> birthdays;

    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    private String tokenUserMail;

    private boolean isValid;

    private boolean isSubmitted;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    @PrePersist
    void createTokenMail() {
        this.tokenUserMail = TokenGenerate.generateToken();
        this.isValid = false;
    }
}

package com.daniel.backend.entities;

import com.daniel.backend.components.TokenGenerate;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    // private UserStatus status;

    private String tokenUserMail;

    private boolean isValid;

    @CreationTimestamp
    private Timestamp createdDate;

    @UpdateTimestamp
    private Timestamp updatedDate;

    @CreationTimestamp
    private Timestamp expireTimerToken;
    // Alterar timestamp
    // pesquisar como fazer o tempo atual menos o tempo da expiração
    // aplicar status para usuario ser alterado

    @PrePersist
    void createTokenMail() {
        this.isValid = false;
        // this.status = UserStatus.DRAFT;
    }
}

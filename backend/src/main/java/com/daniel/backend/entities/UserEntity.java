package com.daniel.backend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;
import java.util.List;

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

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    private LocalDateTime expireTimerToken;

    @PrePersist
    void createTokenMail() {
        this.isValid = false;
        this.createdDate  = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
        this.expireTimerToken = LocalDateTime.now();
        // this.status = UserStatus.DRAFT;
    }
}

package com.daniel.backend.repositories;

import com.daniel.backend.entities.BirthdayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthdayRepository extends JpaRepository<BirthdayEntity, Long> {
}

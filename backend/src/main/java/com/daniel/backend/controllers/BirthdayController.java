package com.daniel.backend.controllers;

import com.daniel.backend.entities.BirthdayEntity;
import com.daniel.backend.repositories.BirthdayRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BirthdayController {
    private final BirthdayRepository birthdayRepository;

    @GetMapping
    public List<BirthdayEntity> getAllBirthdays() {
        return birthdayRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<BirthdayEntity> addBirthday(@Valid @RequestBody BirthdayEntity entity) {
        return ResponseEntity.ok().body(birthdayRepository.save(entity));
    }
}

package com.daniel.backend.controllers;

import com.daniel.backend.entities.BirthdayEntity;
import com.daniel.backend.repositories.BirthdayRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/birthday")
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

    @PutMapping("{id}")
    public ResponseEntity<BirthdayEntity> updateBirthday(
            @PathVariable("id") Long id,
            @Valid @RequestBody BirthdayEntity entity
    ) {
        return birthdayRepository.findById(id).map(e -> {
            e.setName(entity.getName());
            e.setBirthday(entity.getBirthday());
            e.setNotes(entity.getNotes());
            return ResponseEntity.ok().body(birthdayRepository.save(e));
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    public void delBirthday(@PathVariable Long id) {
        var entity = birthdayRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        birthdayRepository.delete(entity);
    }
}

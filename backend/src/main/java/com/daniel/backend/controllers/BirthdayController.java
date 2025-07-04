package com.daniel.backend.controllers;

import com.daniel.backend.dtos.birthdaysDTOs.RequestBirthdayDTO;
import com.daniel.backend.dtos.birthdaysDTOs.ResponseBirthdayDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/birthday")
public interface BirthdayController {
    @GetMapping
    ResponseEntity<List<ResponseBirthdayDTO>> getAllBirthdays();

    @PostMapping("/add")
    ResponseEntity<ResponseBirthdayDTO> addBirthday(@Valid @RequestBody RequestBirthdayDTO dto);

    @PutMapping("/{id}")
    ResponseEntity<ResponseBirthdayDTO> updateBirthday(
            @PathVariable("id") Long id,
            @Valid @RequestBody RequestBirthdayDTO updateDTO
    );

    @DeleteMapping("/{id}")
    void delBirthday(@PathVariable Long id);
}

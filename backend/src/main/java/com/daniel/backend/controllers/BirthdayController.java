package com.daniel.backend.controllers;

import com.daniel.backend.dtos.BirthdayEntityDTO;
import com.daniel.backend.dtos.NewBirthdayDTO;
import com.daniel.backend.services.BirthdayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/birthday")
@RequiredArgsConstructor
public class BirthdayController {

    // Instância apenas o service, sem outras dependências (baixo acoplamento, boa prática)
    private final BirthdayService birthdayService;

    @GetMapping
    public ResponseEntity<List<BirthdayEntityDTO>> getAllBirthdays() {
        return new ResponseEntity<>(birthdayService.listAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BirthdayEntityDTO> addBirthday(@Valid @RequestBody NewBirthdayDTO dto) {
        return new ResponseEntity<>(birthdayService.create(dto), HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<BirthdayEntityDTO> updateBirthday(
            @PathVariable("id") Long id,
            @Valid @RequestBody NewBirthdayDTO updateDTO
    ) {
        return new ResponseEntity<>(birthdayService.update(id, updateDTO), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void delBirthday(@PathVariable Long id) {
        birthdayService.delete(id);

    }
}

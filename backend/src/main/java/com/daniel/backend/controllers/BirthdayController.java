package com.daniel.backend.controllers;

import com.daniel.backend.dtos.ResponseBirthdayDTO;
import com.daniel.backend.dtos.RequestBirthdayDTO;
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

    private final BirthdayService birthdayService;

    @GetMapping
    public ResponseEntity<List<ResponseBirthdayDTO>> getAllBirthdays() {
        return new ResponseEntity<>(birthdayService.listAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseBirthdayDTO> addBirthday(@Valid @RequestBody RequestBirthdayDTO dto) {
        return new ResponseEntity<>(birthdayService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseBirthdayDTO> updateBirthday(
            @PathVariable("id") Long id,
            @Valid @RequestBody RequestBirthdayDTO updateDTO
    ) {
        return new ResponseEntity<>(birthdayService.update(id, updateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delBirthday(@PathVariable Long id) {
        birthdayService.delete(id);

    }
}

package com.daniel.backend.controllers.impl;

import com.daniel.backend.controllers.BirthdayController;
import com.daniel.backend.dtos.birthdaysDTOs.ResponseBirthdayDTO;
import com.daniel.backend.dtos.birthdaysDTOs.RequestBirthdayDTO;
import com.daniel.backend.services.BirthdayService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BirthdayControllerImpl implements BirthdayController {

    private final BirthdayService birthdayService;

    @Override
    public ResponseEntity<List<ResponseBirthdayDTO>> getAllBirthdays() {
        return new ResponseEntity<>(birthdayService.listAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseBirthdayDTO> addBirthday(RequestBirthdayDTO dto) {
        return new ResponseEntity<>(birthdayService.create(dto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseBirthdayDTO> updateBirthday(
            @PathVariable("id") Long id,
            @Valid @RequestBody RequestBirthdayDTO updateDTO
    ) {
        return new ResponseEntity<>(birthdayService.update(id, updateDTO), HttpStatus.OK);
    }

    @Override
    public void delBirthday(Long id) {
        birthdayService.delete(id);

    }
}

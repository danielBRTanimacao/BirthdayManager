package com.daniel.backend.services;

import com.daniel.backend.dtos.birthdaysDTOs.RequestBirthdayDTO;
import com.daniel.backend.dtos.birthdaysDTOs.ResponseBirthdayDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface BirthdayService {
    ResponseBirthdayDTO create(RequestBirthdayDTO dto);

    @Transactional
    ResponseBirthdayDTO update(Long id, RequestBirthdayDTO dto);

    List<ResponseBirthdayDTO> listAll();

    @Transactional
    void delete(Long id);
}

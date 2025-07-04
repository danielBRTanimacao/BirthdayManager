package com.daniel.backend.services.impl;

import com.daniel.backend.dtos.birthdaysDTOs.ResponseBirthdayDTO;
import com.daniel.backend.dtos.birthdaysDTOs.RequestBirthdayDTO;
import com.daniel.backend.entities.BirthdayEntity;
import com.daniel.backend.mappers.BirthdaysMapper;
import com.daniel.backend.repositories.BirthdayRepository;
import com.daniel.backend.services.BirthdayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BirthdayServiceImpl implements BirthdayService {

    private final BirthdayRepository repo;
    private final BirthdaysMapper mapper;

    @Override
    public ResponseBirthdayDTO create(RequestBirthdayDTO dto) {
        BirthdayEntity birthday = mapper.toEntity(dto);
        birthday = repo.save(birthday);
        return mapper.toDTO(birthday);
    }

    @Override
    public ResponseBirthdayDTO update(Long id, RequestBirthdayDTO dto) {
        BirthdayEntity toUpdate = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        toUpdate = mapper.partialUpdate(dto, toUpdate);
        toUpdate = repo.save(toUpdate);
        return mapper.toDTO(toUpdate);
    }

    @Override
    public List<ResponseBirthdayDTO> listAll() {
        return mapper.toDTOs(repo.findAll());
    }

    @Override
    public void delete(Long id) {
        BirthdayEntity toDelete = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repo.delete(toDelete);
    }
}

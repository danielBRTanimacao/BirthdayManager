package com.daniel.backend.services;

import com.daniel.backend.dtos.BirthdayEntityDTO;
import com.daniel.backend.dtos.NewBirthdayDTO;
import com.daniel.backend.entities.BirthdayEntity;
import com.daniel.backend.mappers.BirthdaysMapper;
import com.daniel.backend.repositories.BirthdayRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BirthdayService {

    private final BirthdayRepository repo;
    private final BirthdaysMapper mapper;

    public BirthdayEntityDTO create(NewBirthdayDTO dto) {
        BirthdayEntity birthday = mapper.toEntity(dto);
        birthday = repo.save(birthday);
        return mapper.toDTO(birthday);
    }

    @Transactional // Caso de erro no metodo, não salva nenhuma alteração no banco.
    public BirthdayEntityDTO update(Long id, NewBirthdayDTO dto) {
        BirthdayEntity toUpdate = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        toUpdate = mapper.partialUpdate(dto, toUpdate);
        toUpdate = repo.save(toUpdate);
        return mapper.toDTO(toUpdate);
    }

    public List<BirthdayEntityDTO> listAll() {
        return mapper.toDTOs(repo.findAll());
    }

    @Transactional
    public void delete(Long id) {
        BirthdayEntity toDelete = repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repo.delete(toDelete);
    }
}

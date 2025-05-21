package com.daniel.backend.mappers;

import com.daniel.backend.dtos.BirthdayEntityDTO;
import com.daniel.backend.dtos.NewBirthdayDTO;
import com.daniel.backend.entities.BirthdayEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring") // Diz para o MapStruct que é um mapper em um projeto Spring
public interface BirthdaysMapper {
    BirthdayEntity toEntity (NewBirthdayDTO dto); // Transforma o DTO em entidade
    BirthdayEntityDTO toDTO (BirthdayEntity entity); // Transforma a entidade em DTO

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // Ignora campos vázios que vierem do DTO
    BirthdayEntity partialUpdate(NewBirthdayDTO dto, @MappingTarget BirthdayEntity entity); // Faz o set com os dados do DTO

    List<BirthdayEntityDTO> toDTOs (List<BirthdayEntity> list); // Converte uma lista de entidades para uma lista de DTOs
}

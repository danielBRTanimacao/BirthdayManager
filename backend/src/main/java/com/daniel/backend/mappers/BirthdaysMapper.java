package com.daniel.backend.mappers;

import com.daniel.backend.components.UserMapperHelper;
import com.daniel.backend.dtos.BirthdayEntityDTO;
import com.daniel.backend.dtos.NewBirthdayDTO;
import com.daniel.backend.entities.BirthdayEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapperHelper.class}) // Diz para o MapStruct que é um mapper em um projeto Spring
public interface BirthdaysMapper {
    @Mapping(source = "userId", target = "user")
    BirthdayEntity toEntity (NewBirthdayDTO dto); // Transforma o DTO em entidade
    BirthdayEntityDTO toDTO (BirthdayEntity entity); // Transforma a entidade em DTO

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // Ignora campos vázios que vierem do DTO
    BirthdayEntity partialUpdate(NewBirthdayDTO dto, @MappingTarget BirthdayEntity entity); // Faz o set com os dados do DTO

    List<BirthdayEntityDTO> toDTOs (List<BirthdayEntity> list); // Converte uma lista de entidades para uma lista de DTOs
}

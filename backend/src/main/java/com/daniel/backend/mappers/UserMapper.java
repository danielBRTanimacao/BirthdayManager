package com.daniel.backend.mappers;

import com.daniel.backend.dtos.BirthdayEntityDTO;
import com.daniel.backend.dtos.NewBirthdayDTO;
import com.daniel.backend.dtos.NewUserDTO;
import com.daniel.backend.dtos.UserEntityDTO;
import com.daniel.backend.entities.BirthdayEntity;
import com.daniel.backend.entities.UserEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity (NewUserDTO dto);
    UserEntityDTO toDTO (UserEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity partialUpdate(NewUserDTO dto, @MappingTarget UserEntity entity);

    List<UserEntityDTO> toDTOs (List<UserEntity> list);
}

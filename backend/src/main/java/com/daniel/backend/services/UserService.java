package com.daniel.backend.services;

import com.daniel.backend.dtos.createUserDTOs.RequestUserDTO;
import com.daniel.backend.dtos.createUserDTOs.ResponseUserDTO;
import com.daniel.backend.dtos.emailDTOs.RequestEmailTokenDTO;
import com.daniel.backend.dtos.loginDTOs.RequestLoginDTO;
import com.daniel.backend.dtos.loginDTOs.ResponseTokenDTO;

public interface UserService {
    ResponseUserDTO create(RequestUserDTO userDTO);

    ResponseUserDTO update(RequestUserDTO userDTO, Long id);

    ResponseTokenDTO login(RequestLoginDTO userDTO);

    void validateUserToken(RequestEmailTokenDTO tokenDTO, Long id);
}

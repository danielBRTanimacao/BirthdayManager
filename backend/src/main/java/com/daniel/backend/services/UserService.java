package com.daniel.backend.services;

import com.daniel.backend.dtos.createUserDTOs.RequestUserDTO;
import com.daniel.backend.dtos.createUserDTOs.ResponseUserDTO;
import com.daniel.backend.dtos.loginDTOs.RequestLoginDTO;
import com.daniel.backend.dtos.loginDTOs.ResponseTokenDTO;

public interface UserService {
    ResponseUserDTO create(RequestUserDTO userDTO);

    ResponseTokenDTO login(RequestLoginDTO userDTO);

    void logout(Long id);
}

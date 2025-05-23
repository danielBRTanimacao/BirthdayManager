package com.daniel.backend.components;

import com.daniel.backend.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapperHelper {
    public UserEntity fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        return userEntity;
    }
}

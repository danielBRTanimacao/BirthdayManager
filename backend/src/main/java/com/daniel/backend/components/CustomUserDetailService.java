package com.daniel.backend.components;

import com.daniel.backend.entities.UserEntity;
import com.daniel.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}

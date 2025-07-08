package com.daniel.backend.components;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TokenGenerate {
    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generateToken() {
        Random random = new Random();

        StringBuilder token = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            token.append(
                    characters.charAt(
                            random.nextInt(characters.length())
                    )
            );
        }

        return token.toString();
    }
}

package com.daniel.backend.components;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TokenGenerate {
    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generateToken() {
        Random random = new Random();

        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < characters.length(); i++) {
            map.put(i, characters.charAt(random.nextInt(characters.length())));
        }

        return map.toString();
    }
}

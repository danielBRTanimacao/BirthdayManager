package com.daniel.backend.components;

import com.daniel.backend.entities.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserMailSender {
    @Value("${spring.mail.username}")
    private static String senderMail;

    public static void mailSender(UserEntity user, JavaMailSender javaMailSender) {

        user.setTokenUserMail(TokenGenerate.generateToken());

        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(senderMail);
            message.setTo(user.getEmail());
            message.setSubject("Token validar email");
            message.setText(user.getTokenUserMail());

            javaMailSender.send(message);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}

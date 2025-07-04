package com.daniel.backend.services.impl;

import com.daniel.backend.dtos.emailDTOs.RequestEmailDTO;
import com.daniel.backend.dtos.emailDTOs.ResponseEmailDTO;
import com.daniel.backend.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderMail;

    public ResponseEmailDTO sendEmail(RequestEmailDTO details) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            System.out.println(details.body());
            message.setFrom(senderMail);
            message.setTo(details.senderMail());
            message.setSubject(details.subject());
            message.setText(details.body());

            javaMailSender.send(message);
            return new ResponseEmailDTO(details.senderMail(), details.subject(), details.body());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}

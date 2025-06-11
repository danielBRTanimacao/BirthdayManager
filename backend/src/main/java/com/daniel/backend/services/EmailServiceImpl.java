package com.daniel.backend.services;

import com.daniel.backend.components.EmailDetails;
import com.daniel.backend.services.servicesInterface.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderMail;

    public String sendEmail(EmailDetails details) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(senderMail);
            message.setTo(details.getRecipient());
            message.setSubject(details.getMsgBody());
            message.setText(details.getSubject());

            javaMailSender.send(message);
            return  "Email enviado com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

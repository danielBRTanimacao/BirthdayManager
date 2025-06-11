package com.daniel.backend.controllers;

import com.daniel.backend.components.EmailDetails;
import com.daniel.backend.services.interfacesFactory.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendMail(@RequestBody EmailDetails emailDetails) {
        return emailService.sendEmail(emailDetails);
    }
}

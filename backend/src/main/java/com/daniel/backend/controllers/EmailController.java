package com.daniel.backend.controllers;

import com.daniel.backend.dtos.RequestEmailDTO;
import com.daniel.backend.dtos.ResponseEmailDTO;
import com.daniel.backend.services.EmailService;
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
    public ResponseEmailDTO sendingMail(@RequestBody RequestEmailDTO emailDetails) {
        return emailService.sendEmail(emailDetails);
    }
}

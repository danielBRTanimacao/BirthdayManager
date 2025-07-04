package com.daniel.backend.controllers.impl;

import com.daniel.backend.controllers.EmailController;
import com.daniel.backend.dtos.emailDTOs.RequestEmailDTO;
import com.daniel.backend.dtos.emailDTOs.ResponseEmailDTO;
import com.daniel.backend.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailControllerImpl implements EmailController {
    private final EmailService emailService;

    @Override
    public ResponseEmailDTO sendingMail(RequestEmailDTO emailDetails) {
        return emailService.sendEmail(emailDetails);
    }
}

package com.daniel.backend.controllers;

import com.daniel.backend.dtos.emailDTOs.RequestEmailDTO;
import com.daniel.backend.dtos.emailDTOs.ResponseEmailDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/mail")
public interface EmailController {
    @PostMapping("/send")
    ResponseEmailDTO sendingMail(@RequestBody RequestEmailDTO emailDetails);
}

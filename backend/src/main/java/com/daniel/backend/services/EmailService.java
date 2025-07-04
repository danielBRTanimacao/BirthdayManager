package com.daniel.backend.services;

import com.daniel.backend.dtos.emailDTOs.RequestEmailDTO;
import com.daniel.backend.dtos.emailDTOs.ResponseEmailDTO;


public interface EmailService {
    ResponseEmailDTO sendEmail(RequestEmailDTO details);
}

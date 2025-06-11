package com.daniel.backend.services.servicesInterface;

import com.daniel.backend.components.EmailDetails;

public interface EmailService {
    String sendEmail(EmailDetails details);

    // String sendMailWithAttachment(EmailDetails details);
}

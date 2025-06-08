package com.daniel.backend.services.interfacesFactory;

import com.daniel.backend.components.EmailDetails;

public interface EmailService {
    String sendEmail(EmailDetails details);

    // String sendMailWithAttachment(EmailDetails details);
}

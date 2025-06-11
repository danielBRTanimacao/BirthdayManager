package com.daniel.backend.dtos;

public record RequestEmailDTO(Long id,String senderMail, String subject, String body) {
}

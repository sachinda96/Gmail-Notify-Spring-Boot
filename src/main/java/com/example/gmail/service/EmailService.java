package com.example.gmail.service;


import com.example.gmail.dto.EmailDto;
import org.springframework.http.ResponseEntity;

public interface EmailService {

    public ResponseEntity<?> sendEmail(EmailDto emailDto);
}

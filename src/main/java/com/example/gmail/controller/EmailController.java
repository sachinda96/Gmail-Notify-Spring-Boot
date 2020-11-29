package com.example.gmail.controller;


import com.example.gmail.dto.EmailDto;
import com.example.gmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> sendEmail(@RequestBody EmailDto emailDto){
        return emailService.sendEmail(emailDto);
    }

}

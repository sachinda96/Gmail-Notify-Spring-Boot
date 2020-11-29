package com.example.gmail.service.impl;

import com.example.gmail.dto.EmailDto;
import com.example.gmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public ResponseEntity<?> sendEmail(EmailDto emailDto) {

        try {


            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(emailDto.getToEmail());
            mail.setFrom(emailDto.getFromEmail());
            mail.setSubject(emailDto.getSubject());
            mail.setText(emailDto.getEmail());
            javaMailSender.send(mail);

            return new ResponseEntity<>("200",HttpStatus.OK);


        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

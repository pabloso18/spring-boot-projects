package com.pabloso18.mail.controller;

import com.pabloso18.mail.dto.MailTemplate;
import com.pabloso18.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;

import static com.pabloso18.mail.type.EmailTemplate.EXAMPLE_EMAIL_TEMPLATE;

/**
 * This the email controller
 * @author Jose_Solano
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/v1/send-email", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendEmail(@Valid @RequestBody MailTemplate email) throws IOException, MessagingException {

        emailService.sendEmail(email, EXAMPLE_EMAIL_TEMPLATE);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

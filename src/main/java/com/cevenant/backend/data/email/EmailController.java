package com.cevenant.backend.data.email;

import com.nylas.HostedAuthentication;
import com.nylas.NylasApplication;
import com.nylas.NylasClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Properties;

@RestController
public class EmailController {
    @Autowired
    final private EmailService emailService;

    @Autowired
    final private JavaMailSender javaMailSender;

    public EmailController(EmailService emailService, JavaMailSender javaMailSender ) {
        this.emailService = emailService;
        this.javaMailSender = javaMailSender;
    }



    @CrossOrigin( origins = "http://localhost:3000" )
    @RequestMapping( value = "/sendEmail", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public SimpleMailMessage sendEmail(@RequestBody Email email ) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom( email.getSender() );
        simpleMailMessage.setTo( email.getRecipient() );
        simpleMailMessage.setSubject( email.getSubject() );
        simpleMailMessage.setText( email.getMessage() );
        javaMailSender.send( simpleMailMessage );
        return simpleMailMessage;
    }
}

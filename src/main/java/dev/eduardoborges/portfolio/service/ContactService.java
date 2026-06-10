package dev.eduardoborges.portfolio.service;

import dev.eduardoborges.portfolio.model.ContactRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final JavaMailSender mailSender;

    @Value("${portfolio.contact.to-email}")
    private String toEmail;

    public ContactService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void send(ContactRequest request) {
        var message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setReplyTo(request.email());
        message.setSubject("[Portfolio] " + request.subject());
        message.setText("""
                De: %s <%s>

                %s
                """.formatted(request.name(), request.email(), request.message()));
        mailSender.send(message);
    }
}

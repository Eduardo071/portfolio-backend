package dev.eduardoborges.portfolio.controller;

import dev.eduardoborges.portfolio.model.ContactRequest;
import dev.eduardoborges.portfolio.model.ContactResponse;
import dev.eduardoborges.portfolio.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactResponse> contact(@Valid @RequestBody ContactRequest request) {
        contactService.send(request);
        return ResponseEntity.ok(new ContactResponse(true, "Mensagem enviada com sucesso!"));
    }
}

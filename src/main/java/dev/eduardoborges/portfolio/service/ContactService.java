package dev.eduardoborges.portfolio.service;

import dev.eduardoborges.portfolio.model.ContactRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Service
public class ContactService {

    private final RestClient restClient = RestClient.create();

    @Value("${resend.api-key}")
    private String apiKey;

    @Value("${portfolio.contact.to-email}")
    private String toEmail;

    public void send(ContactRequest request) {
        var body = Map.of(
            "from",     "Portfolio <onboarding@resend.dev>",
            "to",       List.of(toEmail),
            "reply_to", request.email(),
            "subject",  "[Portfolio] " + request.subject(),
            "text",     "De: %s <%s>\n\n%s".formatted(request.name(), request.email(), request.message())
        );

        restClient.post()
            .uri("https://api.resend.com/emails")
            .header("Authorization", "Bearer " + apiKey)
            .contentType(MediaType.APPLICATION_JSON)
            .body(body)
            .retrieve()
            .toBodilessEntity();
    }
}

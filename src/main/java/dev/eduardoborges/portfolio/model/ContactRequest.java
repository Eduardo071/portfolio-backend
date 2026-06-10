package dev.eduardoborges.portfolio.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ContactRequest(
    @NotBlank @Size(min = 2)  String name,
    @NotBlank @Email          String email,
    @NotBlank @Size(min = 4)  String subject,
    @NotBlank @Size(min = 20) String message
) {}

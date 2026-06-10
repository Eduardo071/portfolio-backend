package dev.eduardoborges.portfolio.model;

import java.util.List;

public record ProfileResponse(
    PersonalInfo personal,
    List<Experience> experience,
    List<SkillCategory> skills,
    List<Education> education
) {
    public record PersonalInfo(
        String name,
        String firstName,
        String lastName,
        String title,
        String company,
        String location,
        String bio,
        String email,
        String linkedin,
        String phone,
        boolean available
    ) {}

    public record Role(String title, String period, boolean current) {}

    public record Experience(
        String company,
        String location,
        List<Role> roles,
        List<String> bullets,
        List<String> tags
    ) {}

    public record SkillCategory(
        String name,
        String icon,
        List<String> primary,
        List<String> secondary
    ) {}

    public record Education(
        String degree,
        String institution,
        String period,
        String icon
    ) {}
}

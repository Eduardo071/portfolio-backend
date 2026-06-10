package dev.eduardoborges.portfolio.service;

import dev.eduardoborges.portfolio.model.ProfileResponse;
import dev.eduardoborges.portfolio.model.ProfileResponse.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    public ProfileResponse getProfile() {
        return new ProfileResponse(
            buildPersonal(),
            buildExperience(),
            buildSkills(),
            buildEducation()
        );
    }

    private PersonalInfo buildPersonal() {
        return new PersonalInfo(
            "Eduardo Borges",
            "Eduardo",
            "Borges",
            "Fullstack Engineer",
            "PicPay",
            "Uberlândia, MG",
            """
            <p>Fullstack Engineer com <strong>especialização backend</strong> em sistemas de alta \
            disponibilidade e alto volume no setor de pagamentos digitais. Atualmente na \
            <strong>PicPay</strong>, uma das maiores fintechs do Brasil.</p>
            <p>Trajetória em <strong>bigtech · consultoria · startup</strong> — arquitetura de microsserviços \
            com <strong>Java &amp; Spring Boot</strong>, mensageria com <strong>Apache Kafka</strong> \
            e <strong>Amazon SQS</strong>, e interfaces com <strong>Angular + TypeScript</strong>.</p>
            <p>Atuo com autonomia, forte <em>ownership</em> e comprometimento com boas práticas: \
            <strong>SOLID, Clean Code</strong> e arquitetura evolutiva orientada ao negócio.</p>
            """,
            "eduardoborges.developer@gmail.com",
            "https://linkedin.com/in/eduardopereiraborges",
            "+5534993398973",
            true
        );
    }

    private List<Experience> buildExperience() {
        return List.of(
            new Experience(
                "PicPay", "Remoto",
                List.of(
                    new Role("Backend Engineer II", "Jul/2025 – Presente", true),
                    new Role("Backend Engineer I", "Ago/2024 – Jun/2025", false)
                ),
                List.of(
                    "Desenvolve e mantém microsserviços com Java e Spring Boot em ambiente de <strong>alta escala</strong>, garantindo disponibilidade e performance em produção",
                    "Atua com autonomia e forte <strong>ownership</strong> na resolução de problemas complexos, conduzindo iniciativas de ponta a ponta",
                    "Colabora com times multidisciplinares na evolução da arquitetura de microsserviços, assegurando integração confiável entre sistemas",
                    "Suporte à produção: identificação e resolução de incidentes, reduzindo instabilidades e melhorando confiabilidade dos serviços"
                ),
                List.of("Java", "Spring Boot", "Microsserviços", "Kafka", "Amazon SQS", "AWS", "REST APIs")
            ),
            new Experience(
                "Ibrowse Consultoria e Informática", "Uberlândia, MG · Presencial",
                List.of(
                    new Role("Desenvolvedor de Software Júnior", "Out/2023 – Ago/2024", false)
                ),
                List.of(
                    "Atuou como desenvolvedor <strong>fullstack</strong>: backend com Java/Spring Boot e frontend com Angular/TypeScript",
                    "Projetou e consumiu APIs REST, garantindo integração eficiente entre camadas da aplicação",
                    "Escrita de testes unitários, correção de bugs e manutenção de código legado",
                    "Modelagem e consultas com PostgreSQL em ambiente relacional"
                ),
                List.of("Java", "Spring Boot", "Angular", "TypeScript", "PostgreSQL", "JUnit")
            )
        );
    }

    private List<SkillCategory> buildSkills() {
        return List.of(
            new SkillCategory("Backend",      "⚙️", List.of("Java", "Spring Boot"), List.of("Spring MVC", "Spring Security", "Spring Data JPA")),
            new SkillCategory("Frontend",     "🖥",  List.of("Angular", "TypeScript"), List.of("JavaScript")),
            new SkillCategory("Mensageria",   "📨", List.of("Apache Kafka"), List.of("Amazon SQS")),
            new SkillCategory("Banco de Dados","🗄", List.of("PostgreSQL"), List.of("MongoDB", "Redis")),
            new SkillCategory("Cloud & Infra","☁️", List.of("AWS"), List.of("Amazon S3", "ElastiCache", "Docker")),
            new SkillCategory("Testes",       "🧪", List.of(), List.of("JUnit", "Mockito", "Jest")),
            new SkillCategory("Arquitetura",  "🏛", List.of("Microsserviços"), List.of("REST APIs", "SOLID", "Clean Code")),
            new SkillCategory("Ferramentas",  "🛠",  List.of(), List.of("Git", "Scrum", "Kanban"))
        );
    }

    private List<Education> buildEducation() {
        return List.of(
            new Education(
                "Tecnólogo em Análise e Desenvolvimento de Sistemas",
                "UNIPAC — Centro Universitário Presidente Antônio Carlos",
                "Mar/2023 – Jun/2025",
                "🎓"
            ),
            new Education(
                "Formação Fullstack — DevQuest",
                "Dev em Dobro · JavaScript, TypeScript, Angular, Node.js, Jest, CI/CD",
                "Jan/2022 – Jan/2023",
                "📜"
            )
        );
    }
}

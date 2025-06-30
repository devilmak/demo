package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaConfig {

    @Bean(name = "auditorProvider") // 👈 bean name must match `auditorAwareRef`
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.of("system"); // Replace with real user later
    }
}

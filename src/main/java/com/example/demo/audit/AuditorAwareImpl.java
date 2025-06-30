package com.example.demo.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // For now, just return a fixed value. Replace with actual user logic (e.g., from SecurityContext)
        return Optional.of("system");
    }
}

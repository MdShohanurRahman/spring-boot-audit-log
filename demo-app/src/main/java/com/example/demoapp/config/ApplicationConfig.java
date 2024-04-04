package com.example.demoapp.config;

import com.example.demoapp.component.SpringSecurityAuditorAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ApplicationConfig {

    @Bean
    public AuditorAware<Integer> auditorAware() {
        return new SpringSecurityAuditorAware();
    }
}

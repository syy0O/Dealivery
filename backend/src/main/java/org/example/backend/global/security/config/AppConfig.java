package org.example.backend.global.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Bean
    public String contextPath() {
        return contextPath;
    }
}

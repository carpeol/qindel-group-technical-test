package com.qindel.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private final String[] allowedOrigins;
    private final String[] allowedMethods;
    private final String[] allowedHeaders;

    public CorsConfig(
            @Value("${app.cors.allowed-origins}") String allowedOrigins,
            @Value("${app.cors.allowed-methods}") String allowedMethods,
            @Value("${app.cors.allowed-headers}") String allowedHeaders
    ) {
        this.allowedOrigins = split(allowedOrigins);
        this.allowedMethods = split(allowedMethods);
        this.allowedHeaders = split(allowedHeaders);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(allowedOrigins)
                .allowedMethods(allowedMethods)
                .allowedHeaders(allowedHeaders);
    }

    private String[] split(String value) {
        return Arrays.stream(value.split(","))
                .map(String::trim)
                .filter(origin -> !origin.isBlank())
                .toArray(String[]::new);
    }
}


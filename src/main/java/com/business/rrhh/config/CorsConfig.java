package com.business.rrhh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods(
                                HttpMethod.DELETE.name(),
                                HttpMethod.POST.name(),
                                HttpMethod.GET.name(),
                                HttpMethod.PATCH.name()
                        )
                        .allowedOrigins("*");

            }
        };
    }

}

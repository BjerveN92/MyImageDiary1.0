package com.example.MyImageDiary10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// ===== IMPORTANT INFO ===== // 
// This configuration will probably face some changes during the buildup for this projects //

@Configuration
public class WebConfig {
    @Bean

    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**") // allows all endpoints
                        .allowedOrigins("http://localhost:3000") // localhost to Frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true); // behövs vid senare tillfälle om web tokens skall användas
            }
        };
    }
}

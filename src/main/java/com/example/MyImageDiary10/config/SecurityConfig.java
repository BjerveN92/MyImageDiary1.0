package com.example.MyImageDiary10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

// ===== IMPORTANT INFO ===== // 
// This configuration will probably face some changes during the buildup for this projects //

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // tillåter alla att komma åt dessa endpoints då spring security blockar alla
    // som default om man inte implementerar
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // avaktivera csrf för test
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/entry/**").permitAll()
                        .requestMatchers("/api/user/**").permitAll()
                        .anyRequest().authenticated());
        return http.build();
    }
}

package br.com.aulas.escolaapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/usuarios").permitAll()
                        .requestMatchers("/GET", "alunos").hasAnyRole("ADMIN", "PROFESSOR")
                        .requestMatchers("/POST", "alunos").hasAnyRole("ADMIN", "PROFESSOR")
                        .requestMatchers("/DELETE", "alunos").hasAnyRole("ADMIN", "PROFESSOR")
                        .requestMatchers("/GET", "professores").hasAnyRole("ADMIN", "PROFESSOR")
                        .anyRequest().authenticated());

        return http.build();
    }

    @Bean
    public SecurityConfig securityConfig() {
        return new SecurityConfig();
    }
}

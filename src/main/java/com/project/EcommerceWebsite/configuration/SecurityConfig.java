package com.project.EcommerceWebsite.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Authorize requests using the new method
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/admin").authenticated()
                        .anyRequest().permitAll()
                )
                // Login and Logout configuration
                .formLogin(form -> form
                        .defaultSuccessUrl("/admin", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .permitAll()
                )
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}


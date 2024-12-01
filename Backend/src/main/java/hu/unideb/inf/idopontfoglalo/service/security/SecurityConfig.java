package hu.unideb.inf.idopontfoglalo.service.security;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http

                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers("login", "register", "index").permitAll()
                                .requestMatchers("/actuator/**").permitAll()

                                .anyRequest().permitAll() //.authenticated()
                )
                //.formLogin(Customizer.withDefaults())
                //.httpBasic(Customizer.withDefaults())

                .build();
    }
}

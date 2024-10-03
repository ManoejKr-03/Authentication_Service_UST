package com.example.authentication_service.config;

import com.example.authentication_service.service.CustomUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class AuthConfig {
@Bean
public UserDetailsService userDetailsService() {
    return new CustomUserDetailsService();
}
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    System.out.println("INSIDE THE SECURITY CHAIN ----------------------------------------------------------------");
    http
    .csrf(csrf -> csrf.disable())
    .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
    .headers((headers) -> headers.frameOptions((frame) -> frame.sameOrigin()));
    // .authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/register","/api/auth/validate/token","/h2-console/**").permitAll()
    // .requestMatchers("/api/auth/validate/user").hasRole("USER").anyRequest().authenticated())

    

    return http.build();
}
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

//what is the use AuthenticationManager
@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
}
@Bean
public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
}
}

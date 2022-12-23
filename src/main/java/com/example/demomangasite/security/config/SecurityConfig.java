package com.example.demomangasite.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return  http
                    .csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests((auth) -> {
                                try {
                                    auth
                                            .requestMatchers("/users", "/login").authenticated()
                                            .requestMatchers("/singUp").permitAll()
                                            .and()
                                                .formLogin()
                                                .loginPage("/singIn")
                                                .usernameParameter("email")
                                                .passwordParameter("password")
                                                .defaultSuccessUrl("/users")
                                                .failureUrl("/singIn")
                                                .permitAll()
                                            .and()
                                                .logout()
                                                .permitAll();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            })
                    .userDetailsService(userDetailsService)
                    .httpBasic(Customizer.withDefaults())
                    .build();
    }



}

package com.galaxy.bakendapirest.config;

import com.galaxy.bakendapirest.exception.CustomAccessDeniedHandler;
import com.galaxy.bakendapirest.exception.CustomBasicAuthenticationEntryPoint;
import com.galaxy.bakendapirest.filter.JwtGeneratorFilter;
import com.galaxy.bakendapirest.filter.JwtValidatorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable);

        http.addFilterBefore(new JwtValidatorFilter(), BasicAuthenticationFilter.class);
        http.addFilterAfter(new JwtGeneratorFilter(), BasicAuthenticationFilter.class);

        http.authorizeHttpRequests(request -> request
                .requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/v3/api-docs*/**").permitAll()
                .requestMatchers("/actuator/**").permitAll()

                .requestMatchers(HttpMethod.POST, "/user").permitAll()
                .requestMatchers("/user/**").authenticated()

                .requestMatchers(HttpMethod.POST, "/picture").hasRole("admin")
                .requestMatchers(HttpMethod.PUT, "/picture/**").hasRole("admin")
                .requestMatchers(   "/picture/**").hasAnyRole("admin", "seller")
        );

        http.formLogin(AbstractHttpConfigurer::disable);
        /* Logic response of authentication and authorization */
        http.httpBasic(hbc -> hbc.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));
        http.exceptionHandling(ehc -> ehc.accessDeniedHandler(new CustomAccessDeniedHandler()));
        //http.httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

package com.fsb.pharmassist.config;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authRequest) -> {
            authRequest.requestMatchers("/", "/css/**", "/js/**", "/lib/**", "/img/**", "/scss/**", "/browse-mp/**",
                    "/login", "/register-client/**", "/register-pharmacist/**", "/404", "/browse-pharmacies",
                    "/medicine-details/**",
                    "/contact", "/mission", "/register-client", "/register-pharmacist", "/services", "/team", "/index",
                    "/search-medicines/**")
                    .permitAll();
            authRequest.requestMatchers("/dashboard", "/inventory", "/add-mp", "/update-mp/**", "{id}/delete")
                    .hasRole("PHARMACIST");
            authRequest.requestMatchers("/logout").authenticated();

        });
        http.cors(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);

        http.headers(AbstractHttpConfigurer::disable);

        http.formLogin(formLogin -> {
            formLogin
                    .loginPage("/login") // Page de connexion personnalisée
                    .loginProcessingUrl("/login") // URL pour le traitement du formulaire
                    .successHandler((request, response, authentication) -> {
                        String redirectUrl = "/"; // Default for clients

                        // Access user information (assuming you have a UserDetailsService)
                        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

                        // Check for pharmacist role and redirect to dashboard
                        if (authorities.stream()
                                .anyMatch(authority -> authority.getAuthority().equals("ROLE_PHARMACIST"))) {
                            redirectUrl = "/dashboard";
                        }

                        response.sendRedirect(redirectUrl);
                    })
                    .failureUrl("/404"); // Page après connexion échouée
        })
                .logout(logout -> {
                    logout.logoutUrl("/logout").logoutSuccessUrl("/"); // URL de déconnexion
                });

        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}

package com.idat.neo.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration // -> Se usa para configurar la seguridad del sistema
@EnableWebSecurity // -> Para usar reglas de seguridad personalizadas para las rutas de mi aplicación web
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    @Bean // -> Le dice a Spring que el resultado del método debe ser gestionado como un "servicio"
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desactiva la protección CSRF (útil si no usas formularios, por ejemplo, con Postman o API REST).
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults()) // <--- ¡Habilita CORS en Spring Security!
                // Protege todas las rutas y pide que el usuario esté autenticado.
                .authorizeHttpRequests(auth -> auth
                        //.requestMatchers("/api/v1/neo/user").permitAll()
                        .requestMatchers("/api/v1/neo/user/**", "/api/v1/neo/enrollment/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/neo/**").hasAnyRole("ADMIN", "TEACHER")
                        .requestMatchers("/api/v1/neo/course/**", "/api/v1/neo/task/**", "/api/v1/neo/enrollment/**").hasRole("STUDENT")
                )
                // Usa autenticación básica (usuario y contraseña en cada request, como Postman o navegador).
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    // Crea un usuario en la memoria
   /* @Bean
    public UserDetailsService users() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("1234"))
                .roles()
                .build();
        return new InMemoryUserDetailsManager(user);
    }*/

    // Encriptar la contraseña
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true); // Necesario si usamos cookies/autenticación básica

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
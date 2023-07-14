package com.library.libraryApi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/**").fullyAuthenticated();
                })
                .oauth2ResourceServer((oauth2) -> oauth2
                        .jwt(Customizer.withDefaults())).addFilterBefore(new TokenRequestFilter(),
                        BearerTokenAuthenticationFilter.class);

        return http.build();
    }

//    @Bean
//    public JwtAuthenticationConverter jwtAuthenticationConverterForKeycloak() {
//        @Autowired AuthorizationRepository _repository;
//        Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter = jwt -> {
////            List<String> resourceAccess = jwt.getClaim("groups");
//
//            List<String> groups = new ArrayList<>(jwt.getClaim("groups"));
//
//            List<String> authorizations =  authorizationLogic.getAuthorizationList(groups.stream().
//                    map(g->g.replace("/","")).collect(Collectors.toList()));
//
//
//            return authorizations.stream()
//                    .map(SimpleGrantedAuthority::new)
//                    .collect(Collectors.toList());
//        };
//
//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//
//        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
//
//        return jwtAuthenticationConverter;
//    }

    @Bean
    public CorsConfigurationSource getCorsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;


    }
}
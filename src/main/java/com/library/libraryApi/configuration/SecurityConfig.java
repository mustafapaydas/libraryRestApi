package com.library.libraryApi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;


@Configuration
@EnableWebSecurity
@CrossOrigin
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig{
    @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
    private String clientId;
    @Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
    private String clientSecret;
    @Value("${spring.security.oauth2.client.resourceserver.jwt.opaque.introspection-uri}")
    private String introspectUri;
    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwkSetUri;

    private final JwtAuthConverter jwtAuthConverter;
    public SecurityConfig(JwtAuthConverter jwtAuthConverter) {
        this.jwtAuthConverter = jwtAuthConverter;
    }


    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception  {

        return http
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwtAuthConverter))).authorizeHttpRequests(auth -> {
                    auth.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults())
                .build();

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

//    @Bean
//    public CorsConfigurationSource getCorsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
//        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("*"));
//        configuration.setAllowCredentials(true);
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//
//
//    }
//
//    @Override
//    public boolean matches(HttpServletRequest request) {
//        return false;
//    }
//
//    @Override
//    public List<Filter> getFilters() {
//        List<Filter> filters = new ArrayList<>();
//        filters.add(new TokenRequestFilter());
//        return filters;
//    }
}


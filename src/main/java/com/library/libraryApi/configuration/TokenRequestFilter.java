package com.library.libraryApi.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
//public class TokenRequestFilter  {
//
//    private final Logger LOGGER = LoggerFactory.getLogger(TokenRequestFilter.class);
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        Jwt.withTokenValue(request.getHeader("Authorization"));
////        Authentication authentication = new BearerTokenAuthentication();
////        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//
//
//
////        UnirestInstance unirest = Unirest.spawnInstance();
////
////            unirest.config().socketTimeout(7000)
////                    .connectTimeout(7000);
////            HttpResponse res =
////                    unirest.get("http://localhost:5001/auth/realms/library/protocol/openid-connect/userinfo")
////                            .header("Authorization", request.getHeader("Authorization"))
////                            .asString();
////            HttpHeaders headers = new HttpHeaders();
////            headers.add("Content-Type", "application/json");
////
////            String body = res.getBody().toString();
////            ObjectMapper mapper = new ObjectMapper();
////            KeycloakUser result =
////                    mapper.readValue(body, KeycloakUser.class);
////            unirest.close();
////        System.out.println(result.getEmail());
//
////        Jwt jwt = (Jwt) ((JwtAuthenticationToken) UserPrincipal.create(result);
//
//
//
////        Principal principal = (Principal) authentication.getPrincipal();
////        UserDetails details =new User()
//        if(request.getUserPrincipal() != null){
//
//        }
//        LOGGER.debug("xxxxxxxxxxx");
//        filterChain.doFilter(request,response);
//
//    }
//
//}

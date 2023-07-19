package com.library.libraryApi.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
@Component
public class TokenRequestFilter extends OncePerRequestFilter {
    private final Logger LOGGER = LoggerFactory.getLogger(TokenRequestFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getUserPrincipal() != null){

        }
        LOGGER.debug("xxxxxxxxxxx");
        filterChain.doFilter(request,response);

    }

}

package com.library.libraryApi.configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {


    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .components(
                        new Components()
                                .addSecuritySchemes(
                                        "Token",
                                        new SecurityScheme()
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                                .description("Test ortamı için token : " + "testToken")))
                .info(
                        new Info()
                                .version("1")
                                .contact(new Contact().email("").name(""))
                                .description("description")
                                .title("title"));
    }
}
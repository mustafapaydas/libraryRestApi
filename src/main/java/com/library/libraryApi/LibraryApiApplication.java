package com.library.libraryApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication(exclude = {SecurityFilterAutoConfiguration.class})
public class LibraryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApiApplication.class, args);
	}

}

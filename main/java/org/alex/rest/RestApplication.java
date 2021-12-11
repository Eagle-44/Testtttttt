package org.alex.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.io.IOException;

@SpringBootApplication
@ComponentScan({"org.alex.rest.controllers", "org.alex.rest.service","org.alex.rest.exception"})
@EntityScan("org.alex.rest.models")
@EnableJpaRepositories("org.alex.rest.dal")
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);

    }
}

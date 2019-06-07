package com.merchez.heatercontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.merchez.heatercontrol.controllers", "com.merchez.heatercontrol.services"})
@EntityScan(basePackages = "com.merchez.heatercontrol.beans",
        basePackageClasses = { Jsr310JpaConverters.class }
)
@EnableJpaRepositories("com.merchez.heatercontrol.repositories")
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

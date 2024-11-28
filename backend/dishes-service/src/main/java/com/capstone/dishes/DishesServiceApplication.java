package com.capstone.dishes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.capstone.dishes")
@EntityScan(basePackages = "com.capstone.dishes.entity")
@EnableJpaRepositories(basePackages = "com.capstone.dishes.repository")
public class DishesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DishesServiceApplication.class, args);
    }

}

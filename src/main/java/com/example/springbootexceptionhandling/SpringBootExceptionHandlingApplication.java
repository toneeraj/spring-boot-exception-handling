package com.example.springbootexceptionhandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExceptionHandlingApplication {

    public static void main(String[] args) {
    	System.setProperty("spring.profiles.active", "no-handler");
        SpringApplication.run(SpringBootExceptionHandlingApplication.class, args);
    }
}

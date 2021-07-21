package com.example.gatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaTestApplication.class, args);
    }

}

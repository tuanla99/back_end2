package com.it5420.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        // http://localhost:8082/v3/api-docs/ to show api document as a json
        // http://localhost:8082/swagger-ui to show api in the web-view
        SpringApplication.run(BackendApplication.class, args);
    }

}

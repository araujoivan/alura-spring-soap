package com.mycompany.spring.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// must be in a superior level related to others beans that you want spring scanning
// or in the other hand you must define scanPackages {} explicitly
@SpringBootApplication
public class SpringBootClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootClientApplication.class, args);
    }

}

package com.techprimers.springbootsoapexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.techprimers.spring_boot_soap_example")
public class SpringBootSoapExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSoapExampleApplication.class, args);
    }

}

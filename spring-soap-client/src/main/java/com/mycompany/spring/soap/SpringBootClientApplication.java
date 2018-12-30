package com.mycompany.spring.soap;

import com.mycompany.spring.soap.client.UserClient;
import domain.GetUserResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootClientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(UserClient quoteClient) {
        return args -> {
            String name = "Ryan";

            if (args.length > 0) {
                name = args[0];
            }
            GetUserResponse response = quoteClient.getClient(name);
            System.err.println(response.getUser().getSalary());
        };
    }

}

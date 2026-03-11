package com.example.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.security.model.Role;
import com.example.security.model.User;
import com.example.security.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {

        SpringApplication.run(SecurityApplication.class, args);

    }

    @Bean
    public CommandLineRunner init(
            UserRepository repository,
            PasswordEncoder encoder){

        return args -> {

            if(repository.findByEmail("pedro@email.com").isEmpty()){

                User user = new User();

                user.setName("Pedro");
                user.setEmail("pedro@email.com");

                // senha real criptografada
                user.setPassword(encoder.encode("123456"));

                user.setRole(Role.USER);

                repository.save(user);

                System.out.println("USER CRIADO");

            }

        };

    }

}
package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository) {
        return args -> {
            // Check if there are already users in the database
            if (userRepository.count() > 0) {
                return;
            }

            // Create and save 5 users
            for (int i = 1; i <= 5; i++) {
                User user = new User("User" + i, "user" + i + "@example.com");
                userRepository.save(user);
            }

            System.out.println("Seed data loaded.");
        };
    }
}

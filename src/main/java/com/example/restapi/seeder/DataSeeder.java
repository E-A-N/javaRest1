package com.example.restapi.seeder;

import com.example.restapi.entity.User;
import com.example.restapi.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner seedDatabase(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                userRepository.save(new User("Alice", "alice@example.com"));
                userRepository.save(new User("Bob", "bob@example.com"));
                userRepository.save(new User("Charlie", "charlie@example.com"));
                userRepository.save(new User("Diana", "diana@example.com"));
                userRepository.save(new User("Eve", "eve@example.com"));
            }
        };
    }
}

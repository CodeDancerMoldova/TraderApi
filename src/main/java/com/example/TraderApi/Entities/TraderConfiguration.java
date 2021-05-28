package com.example.TraderApi.Entities;

import com.example.TraderApi.Repositories.TraderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TraderConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(TraderRepository traderRepository) {

        return args -> {
            Trader Mario = new Trader(
                    190L, "Mario",
                    "Milan");
            Trader Alan = new Trader(
                    100L, "Alan",
                    "Cambridge");

            traderRepository.saveAll(List.of(Mario,Alan));

        };
    }
}

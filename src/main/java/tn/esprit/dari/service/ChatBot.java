package tn.esprit.dari.service;

import org.alicebot.ab.Bot;
import org.alicebot.ab.configuration.BotConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ChatBot {
    @Bean // default scope is singleton
    public Bot alice() {
        return new Bot(BotConfiguration.builder()
                .name("alice")
                .path("src/main/resources")
                .build()
        );
    }
}

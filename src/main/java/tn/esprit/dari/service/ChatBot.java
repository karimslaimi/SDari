package tn.esprit.dari.service;

import org.alicebot.ab.Bot;
import org.alicebot.ab.configuration.BotConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

 public class ChatBot {
    private static Bot bot;

    public ChatBot() {
        if(bot==null){
            bot = new Bot(BotConfiguration.builder()
                    .name("RealEstate").name("alice")
                    .path("src/main/resources")
                    .build());
        }

    }

     public Bot alice() {
        return bot;

    }
}

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
                    //.name("standard")//
                    //.name("RealEstate")
                      .name("alice") //alice folder have a lot of aiml file so my QA won't be considered so i will use real estate folder less files
                    .path("src/main/resources")
                    .build());
        }

    }

     public Bot alice() {
        return bot;

    }
}

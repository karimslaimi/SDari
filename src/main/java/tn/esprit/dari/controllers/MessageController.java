package tn.esprit.dari.controllers;


import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.configuration.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.ChatMessage;
import tn.esprit.dari.entities.Message;
import tn.esprit.dari.service.ChatBot;
import tn.esprit.dari.service.IMessageService;
import tn.esprit.dari.service.MessageService;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @PostMapping("/add")
    public ResponseEntity<?> Create(@RequestParam String message, @RequestParam Long by, @RequestParam Long to){

        if(messageService.AddMessage(message,by,to)){
            return new ResponseEntity<>("sent", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error occured",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getmessages")
    public ResponseEntity<?> GetMessage(@RequestParam int by,@RequestParam int to){
        return new ResponseEntity<>(messageService.GetMessage(by,to),HttpStatus.OK);
    }

    @GetMapping("getUsers/{id}")
    public ResponseEntity<?> getUsers(@PathVariable int id){
        return new ResponseEntity<>(messageService.getUsers(id),HttpStatus.OK);
    }

    @PostMapping("chatbot")
    public ResponseEntity<?> chatBot(@RequestBody String input){


        ChatBot chatBot=new ChatBot();

        Chat chatSession = new Chat(chatBot.alice());
        String answer = chatSession.multisentenceRespond(input);
        return new ResponseEntity<>(answer,HttpStatus.OK);

    }

    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }
}

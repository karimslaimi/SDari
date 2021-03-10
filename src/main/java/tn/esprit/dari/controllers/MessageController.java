package tn.esprit.dari.controllers;


import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.configuration.BotConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.entities.Message;
import tn.esprit.dari.service.IMessageService;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @PostMapping("/add")
    public ResponseEntity<?> Create(@RequestBody Message message, @RequestBody Long by, @RequestBody Long to){

        if(messageService.AddMessage(message,by,to)){
            return new ResponseEntity<>("sent", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Error occured",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getmessages")
    public ResponseEntity<?> GetMessage(@RequestBody int by,@RequestBody int to){
        return new ResponseEntity<>(messageService.GetMessage(by,to),HttpStatus.OK);
    }

    @GetMapping("getUsers/{id}")
    public ResponseEntity<?> getUsers(@PathVariable int id){
        return new ResponseEntity<>(messageService.getUsers(id),HttpStatus.OK);
    }

    @PostMapping("chatbot")
    public ResponseEntity<?> chatBot(@RequestBody String input,Bot bot){


        Chat chatSession = new Chat(bot);
        String answer = chatSession.multisentenceRespond(input);
        return new ResponseEntity<>(answer,HttpStatus.OK);

    }

}

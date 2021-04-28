package tn.esprit.dari.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.dto.RegisterRequest;
import tn.esprit.dari.entities.Customer;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.service.AuthService;
import tn.esprit.dari.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/Auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest registerRequest){
        authService.signUp(registerRequest);

        return new ResponseEntity<>("Admin Registration succeed", HttpStatus.OK);

    }
    @PostMapping("/signupAgent")
    public ResponseEntity<String> signUpAgent(@RequestBody RegisterRequest registerRequest){
        authService.signUpAgent(registerRequest);

        return new ResponseEntity<>("Agent Registration succeed", HttpStatus.OK);

    }

    @PostMapping("/signupCustomer")
    public ResponseEntity<String> signUpCustomer(@RequestBody RegisterRequest registerRequest){
        authService.signUpCustomer(registerRequest);

        return new ResponseEntity<>("Customer Registration succeed", HttpStatus.OK);

    }
    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable("token") String token){
        authService.verifyAccount(token);

        return new ResponseEntity<>("Account activated successfully", HttpStatus.OK);

    }

}

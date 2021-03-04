package tn.esprit.dari.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.dto.RegisterRequest;
import tn.esprit.dari.service.AuthService;

import java.util.List;

@RestController
@RequestMapping("/User/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest registerRequest){
        authService.signUp(registerRequest);

        return new ResponseEntity<>("Admin Registration succeed", HttpStatus.OK);

    }
    @PostMapping("/signupAgent")
    @ResponseBody
    public ResponseEntity<String> signUpAgent(@RequestBody RegisterRequest registerRequest){
        authService.signUpAgent(registerRequest);

        return new ResponseEntity<>("Agent Registration succeed", HttpStatus.OK);

    }
    List<String> list;
    @GetMapping("/hello")
    public List<String> hello(){
        list.add("test");
        return list;
    }

    @PostMapping("/signupCustomer")
    @ResponseBody
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

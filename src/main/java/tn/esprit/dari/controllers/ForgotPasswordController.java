package tn.esprit.dari.controllers;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tn.esprit.dari.Config.Utility;
import tn.esprit.dari.Exceptions.DariException;
import tn.esprit.dari.dto.ForgotPasswordRequest;
import tn.esprit.dari.dto.ResetPassword;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.service.UtilisateurService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/forgotpssd")
public class ForgotPasswordController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UtilisateurService utilisateurService;

  /*  @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
        return "forgot_password_form";
    }*/

  /*  @PostMapping("/forgot_passwordp")
    public String processForgotPassword(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String token = RandomString.make(30);

        try {
            utilisateurService.updateResetPasswordToken(token, email);
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
            sendEmail(email, resetPasswordLink);
            model.addAttribute("message", "We have sent a reset password link to your email. Please check.");

        } catch (DariException ex) {
            model.addAttribute("error", ex.getMessage());
        } catch (UnsupportedEncodingException | MessagingException e) {
            model.addAttribute("error", "Error while sending email");
        }

        return "forgot_password_form";
    }*/
    @PostMapping("/forgot_passwordp")
    public ResponseEntity<String> processForgotPassword(@RequestBody ForgotPasswordRequest forgotPasswordRequest,HttpServletRequest request){
        String email = forgotPasswordRequest.getEmail();
        String token = RandomString.make(30).replaceAll("0","o");

        try {
            utilisateurService.updateResetPasswordToken(token, email);
           // String resetPasswordLink = Utility.getSiteURL(request) + "/forgotpssd/reset_password?token=" + token;
            String resetPasswordLink = "https://localhost:44307/ForgotPassword" + "/resetPassword?token=" + token;

            sendEmail(email, resetPasswordLink);
             return new ResponseEntity<>("reset password email has been sent successfully", HttpStatus.OK);
        }
     catch (DariException ex) {
        return new ResponseEntity<>("we can't find an account with this email address", HttpStatus.BAD_REQUEST);
    } catch (UnsupportedEncodingException | MessagingException e) {
            return new ResponseEntity<>("error while sending email", HttpStatus.BAD_REQUEST);

        }
    }

    public void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("beheddine.akermi@esprit.tn", "Dari support");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);


    }


    @GetMapping("/reset_password")
    public ResponseEntity<ResetPassword> showResetPasswordForm(@Param(value = "token") String token) {
        Utilisateur utilisateur = utilisateurService.getByResetPasswordToken(token);
       // model.addAttribute("token", token);
        ResetPassword resetPassword = new ResetPassword();
        if (utilisateur == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
        resetPassword.setToken(token);
        //return "reset_password_form";
        return new ResponseEntity<>(resetPassword,HttpStatus.OK);
    }
    @PostMapping("/reset_password")
    public ResponseEntity<String> processResetPassword(HttpServletRequest request, @RequestBody ResetPassword resetPassword) {
        //String token = request.getParameter("token");
        //String password = request.getParameter("password");
        String password = resetPassword.getPassword();
        Utilisateur utilisateur = utilisateurService.getByResetPasswordToken(resetPassword.getToken());
        //  model.addAttribute("title", "Reset your password");

        if (utilisateur == null) {
           // model.addAttribute("message", "Invalid Token");
            return new ResponseEntity<>("user not found",HttpStatus.BAD_REQUEST);

        } else {
            utilisateurService.updatePassword(utilisateur, password);

          //  model.addAttribute("message", "You have successfully changed your password.");
            return new ResponseEntity<>("password updated successfully ",HttpStatus.OK);

        }

       // return "reset_password_form";

    }
}

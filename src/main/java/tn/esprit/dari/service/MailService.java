package tn.esprit.dari.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import tn.esprit.dari.Exceptions.DariException;
import tn.esprit.dari.entities.NotificationEmail;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    private final MailContentBuilder mailContentBuilder;
    private final JavaMailSender mailSender;

    @Async
    public void sendEmail(NotificationEmail notificationEmail){

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("beheddine5@gmail.com");
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));

        };
        try {
            mailSender.send(messagePreparator);
            log.info("Activation Email sent successfully");
        }catch (MailException e){
            throw new DariException("Error while sending email to " + notificationEmail.getRecipient(), e);
        }

    }

}

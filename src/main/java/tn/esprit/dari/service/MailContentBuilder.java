package tn.esprit.dari.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@AllArgsConstructor
@Service
public class MailContentBuilder {


    private final TemplateEngine templateEngine;

    String build(String message){
        Context context = new Context();
        context.setVariable("message", message);
        return templateEngine.process("mailTemplate",context);
    }

}

package tn.esprit.dari.dto;

import lombok.Data;

@Data
public class ResetPassword {
    private String password;
    private String token;
}

package tn.esprit.dari.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long utilisateurId;

    @NotBlank(message = "LastName is required")
    private String lastName;
    @NotBlank(message = "FirstName is required")
    private String firstName;
    @NotBlank(message = "Password is required")
    private String password;
    private String picture;
    private String phone;
    private Region Region;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    private Instant created;
    private boolean enabled;


    @OneToMany
    private List<Reclamation> reclamations;

    @OneToMany(mappedBy ="sentTo")
    private List<Message> sentMessages;
    @OneToMany(mappedBy = "sentBy")
    private List<Message> ReceivedMessages;

}

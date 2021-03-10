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
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "U_type")
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
    @Enumerated(EnumType.STRING)
    private Region Region;
    private String username;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    private Instant created;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private AuthenticationProvider authenticationProvider;
    @Enumerated(EnumType.STRING)
    private Role role;




    @OneToMany(mappedBy ="sentTo")
    private List<Message> sentMessages;
    @OneToMany(mappedBy = "sentBy")
    private List<Message> ReceivedMessages;



}

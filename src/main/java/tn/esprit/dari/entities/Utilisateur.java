package tn.esprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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




    @OneToMany(mappedBy ="first")
    @JsonBackReference
    private List<ChatRoom> sent;

    @OneToMany(mappedBy = "second")
    @JsonBackReference
    private List<ChatRoom> received;


    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Reclamation> reclamations;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Notification> notifications;

}

package tn.esprit.dari.entities;

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
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "U_type")
public  class Utilisateur implements Serializable {

    public Utilisateur(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

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
    @Enumerated(EnumType.ORDINAL)
    private Region Region;
    private String username;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    private Instant created;
    private boolean enabled;
    @Enumerated(EnumType.STRING)
    private AuthenticationProvider authenticationProvider;
    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "utilisateur_id",referencedColumnName = "utilisateurId")
      //      , inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "roleId"))
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy ="first")
  // @JsonBackReference(value = "sent")
    private List<ChatRoom> sent;
    @JsonIgnore
    @OneToMany(mappedBy = "second")
    //@JsonBackReference(value = "received")
    private List<ChatRoom> received;


    @OneToMany(mappedBy = "user")
   // @JsonBackReference(value = "reclam")
    private List<Reclamation> reclamations;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
   //@JsonBackReference(value = "notif")
    private List<Notification> notifications;

    @Override
    public String toString() {
        return "Utilisateur{" +
                "utilisateurId=" + utilisateurId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", phone='" + phone + '\'' +

                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", enabled=" + enabled +
                ", authenticationProvider=" + authenticationProvider +
                ", resetPasswordToken='" + resetPasswordToken + '\'' +
                ", roles=" + roles +
                ", sent=" + sent +
                ", received=" + received +
                ", reclamations=" + reclamations +
                ", notifications=" + notifications +
                '}';
    }
}

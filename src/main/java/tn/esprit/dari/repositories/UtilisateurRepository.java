package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.AuthenticationProvider;
import tn.esprit.dari.entities.Utilisateur;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {

    public Utilisateur getUtilisateurByEmail(String email);
    Utilisateur getUtilisateurByResetPasswordToken(String reset);

    @Query("SELECT u.authenticationProvider as p from Utilisateur u where u.email=?1")
    AuthenticationProvider getUtProviderByEmail(String email);
    //Utilisateur getUtilisateurByEmail(String email);
}

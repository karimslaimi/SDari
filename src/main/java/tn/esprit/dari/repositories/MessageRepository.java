package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Message;
import tn.esprit.dari.entities.Utilisateur;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

    @Query("select m.sentBy, m.sentTo from Message m where m.sentTo.utilisateurId=:id or m.sentBy.utilisateurId=:id")
    public List<Utilisateur> getUsers(@Param("id")int id);
}

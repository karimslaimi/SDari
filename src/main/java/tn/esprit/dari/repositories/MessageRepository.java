package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.ChatRoom;
import tn.esprit.dari.entities.Message;
import tn.esprit.dari.entities.Utilisateur;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {


    //get all the user that doesn't have my id , get the chatrooms where i m participating
    @Query("select u from Utilisateur u, ChatRoom c where u.utilisateurId<>:id and (c.first.utilisateurId=:id or c.second.utilisateurId=:id)" +
            //join the user and the chat room
            " and (c.second.utilisateurId=u.utilisateurId or c.first.utilisateurId=u.utilisateurId)")
    public List<Utilisateur> getUsers(@Param("id")Long id);

    @Query("select c.messageList  from ChatRoom c where (c.first.utilisateurId=:sentBy and c.second.utilisateurId=:sentTo) or " +
            "(c.second.utilisateurId=:sentBy and c.first.utilisateurId=:sentTo)")
    public List<Message> getMessages(@Param("sentBy")Long sentBy, @Param("sentTo") Long sentTo);

    @Query("select c from ChatRoom c where (c.first.utilisateurId=:first and c.second.utilisateurId=:second) or " +
            "(c.second.utilisateurId=:first and c.first.utilisateurId=:second)")
    public ChatRoom getChatRoom(@Param("first")Long first, @Param("second")Long second);

}

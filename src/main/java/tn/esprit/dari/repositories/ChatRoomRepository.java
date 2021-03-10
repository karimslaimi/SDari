package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.ChatRoom;
import tn.esprit.dari.entities.Message;
@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom,Integer> {

}

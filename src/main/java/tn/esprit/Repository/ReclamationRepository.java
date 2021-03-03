package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.Reclamation;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Integer> {

    @Query("select  r from Reclamation r where r.state=false")
    public List<Reclamation> findNotTreated();

    @Query("select  r from Reclamation r where r.user.utilisateurId=:id")
    public List<Reclamation> findMyReclams(@Param("id")int id);

    @Query("select r from Reclamation r where r.title like %:filter% ")
    public List<Reclamation> findByFilter(@Param("filter") String filter);

    @Query("select r from Reclamation r where r.dateTime>=:start and r.dateTime<=:end")
    public List<Reclamation> findBetweenDate(@Param("start")LocalDateTime start,@Param("end") LocalDateTime end);

    @Query("select r from Reclamation r where r.type like %:filter% ")
    public List<Reclamation> findByType(@Param("type") String type);
}

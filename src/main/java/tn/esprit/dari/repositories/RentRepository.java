package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Buy;
import tn.esprit.dari.entities.Reclamation;
import tn.esprit.dari.entities.Rent;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent,Integer> {

    List<Rent> findByPricePerMonthAndNbrooms(float price, int nbr);
    List<Rent> findBySuperficieAndPricePerMonth(float superficie,float price);
    List<Rent> findByNbroomsAndPricePerMonth(int nbr,float price);
    List<Rent> findByPricePerDayAndNbrooms(float price, int nbr);
    List<Rent> findBySuperficieAndPricePerDay(float superficie,float price);
    List<Rent> findByNbroomsAndPricePerDay(int nbr,float price);
    @Query("select b from Buy b where b.price>=:lower and b.price<=:higher")
    List<Buy> findBetweenPricePerDay(@Param("lower")float p1, @Param("higher") float p2);
    @Query("select b from Buy b where b.price>=:lower and b.price<=:higher")
    List<Buy> findBetweenPricePerMonth(@Param("lower")float p1, @Param("higher") float p2);
    @Modifying
    @Query("update Contract_Rent cr set cr.rented = false where cr.dateFin < :date")
    void setAvailable(@Param("date") LocalDate date);

}

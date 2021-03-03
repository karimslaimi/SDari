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
public interface RentRepository extends CrudRepository<Rent,Integer> {

    List<Buy> findByPricePerMonthAndNbrooms(float price, int nbr);
    List<Buy> findBySuperficieAndPricePerMonth(float superficie,float price);
    List<Buy> findByNbroomsAndPricePerMonth(int nbr,float price);
    List<Buy> findByPricePerDayAndNbrooms(float price, int nbr);
    List<Buy> findBySuperficieAndPricePerDay(float superficie,float price);
    List<Buy> findByNbroomsAndPricePerDay(int nbr,float price);
    @Query("select b from Buy b where b.price>=:lower and b.price<=:higher")
    List<Buy> findBetweenPricePerDay(@Param("lower")float p1, @Param("higher") float p2);
    @Query("select b from Buy b where b.price>=:lower and b.price<=:higher")
    List<Buy> findBetweenPricePerMonth(@Param("lower")float p1, @Param("higher") float p2);
    float differenceBetwenPerDayAndMonth(float pricePerMonth,float pricePerDay);
    @Modifying
    @Query("update Contract_Rent cr set cr.rented = false where cr.dateFin < :date")
    void setAvailable(@Param("date") LocalDate date);

}

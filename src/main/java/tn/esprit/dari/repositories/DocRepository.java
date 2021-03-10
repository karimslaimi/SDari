package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.dari.entities.Doc;


@Repository
public interface DocRepository extends JpaRepository <Doc,Integer> {
}

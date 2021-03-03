package tn.esprit.dari.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.entities.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {

}

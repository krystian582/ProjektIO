package edu.uph.ii.platformy.repositories;

import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.Wizyta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface WizytaRepository extends JpaRepository<Wizyta, Long> {
    //Wizyta findByDate(Date dataWizyty);
}

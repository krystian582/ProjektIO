package edu.uph.ii.platformy.repositories;

import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.Usluga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UslugaRepository extends JpaRepository<Usluga, Long> {
}

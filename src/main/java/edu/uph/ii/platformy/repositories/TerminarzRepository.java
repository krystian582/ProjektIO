package edu.uph.ii.platformy.repositories;

import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.Terminarz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminarzRepository extends JpaRepository<Terminarz, Long> {
}

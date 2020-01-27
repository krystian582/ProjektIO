package edu.uph.ii.platformy.repositories;

import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.StatusWizyty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusWizytyRepository extends JpaRepository<StatusWizyty, Long> {
}

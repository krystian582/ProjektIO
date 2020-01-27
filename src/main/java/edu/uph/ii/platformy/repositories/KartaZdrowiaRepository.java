package edu.uph.ii.platformy.repositories;

import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KartaZdrowiaRepository extends JpaRepository<KartaZdrowia, Long> {
}

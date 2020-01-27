package edu.uph.ii.platformy.repositories;

import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.Refundacja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundacjaRepository extends JpaRepository<Refundacja, Long> {
}

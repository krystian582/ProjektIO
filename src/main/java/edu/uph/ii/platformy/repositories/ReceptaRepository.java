package edu.uph.ii.platformy.repositories;

import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.Recepta;
import edu.uph.ii.platformy.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReceptaRepository extends JpaRepository<Recepta, Long> {

    @Query("SELECT v FROM Recepta v WHERE " +
            "(" +
            ":pesel is null OR :pesel = '' OR "+
            "upper(v.user) LIKE upper(:pesel)" +
            ") ")

    Page<User> findAllUserUsingFilter(@Param("pesel") String p, Pageable pageable);

}

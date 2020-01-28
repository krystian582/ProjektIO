package edu.uph.ii.platformy.repositories;

import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.Terminarz;
import edu.uph.ii.platformy.models.User;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface TerminarzRepository extends JpaRepository<Terminarz, Long> {


    @Query("SELECT v FROM Terminarz v WHERE " +
            "(" +
            ":data_wizyty is null OR :data_wizyty = '' OR "+
            "(v.wizyta.dataWizyty) LIKE (:data_wizyty)" +
            ") ")


    List<Terminarz> findAllTerminarzUsingFilter(@Param("data_wizyty") String p);


}

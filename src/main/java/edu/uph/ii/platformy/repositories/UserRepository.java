package edu.uph.ii.platformy.repositories;

import edu.uph.ii.platformy.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {



    User findByPesel(String pesel);

    @Query("SELECT v FROM User v WHERE " +
            "(" +
            ":pesel is null OR :pesel = '' OR "+
            "upper(v.pesel) LIKE upper(:pesel)" +
            ") ")

    Page<User> findAllUserUsingFilter(@Param("pesel") String p, Pageable pageable);


}

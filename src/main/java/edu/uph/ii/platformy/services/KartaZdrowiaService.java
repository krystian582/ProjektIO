package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KartaZdrowiaService {

    Page<KartaZdrowia> getAllKartaZdrowia(Pageable pageable);
    List<KartaZdrowia> getAllKartaZdrowia();
    KartaZdrowia getKartaZdrowia(long id);
    void deleteKartaZdrowia(long id);
    void saveKartaZdrowia(KartaZdrowia kartaZdrowia);

    List<User> getAllUser();

}

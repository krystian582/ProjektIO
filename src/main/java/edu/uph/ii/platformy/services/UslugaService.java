package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.models.Terminarz;
import edu.uph.ii.platformy.models.Usluga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UslugaService {

    Page<Usluga> getAllUsluga(Pageable pageable);
    List<Usluga> getAllUsluga();
    Usluga getUsluga(long id);
    void deleteUsluga(long id);
    void saveUsluga(Usluga usluga);

}

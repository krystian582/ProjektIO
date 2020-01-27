package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.controllers.commands.ReceptaFilter;
import edu.uph.ii.platformy.controllers.commands.UserFilter;
import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.Recepta;
import edu.uph.ii.platformy.models.Refundacja;
import edu.uph.ii.platformy.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReceptaService {

    Page<Recepta> getAllRecepta(Pageable pageable);
    List<Recepta> getAllRecepta();
    Recepta getRecepta(long id);
    void deleteRecepta(long id);
    void saveRecepta(Recepta recepta);

    List<Refundacja> getAllRefundacja();
    Page<Recepta> getAllRecepta(ReceptaFilter filter, Pageable pageable);

}

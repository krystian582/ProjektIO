package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.models.Recepta;
import edu.uph.ii.platformy.models.Terminarz;
import edu.uph.ii.platformy.models.User;
import edu.uph.ii.platformy.models.Wizyta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TerminarzService {

    Page<Terminarz> getAllTerminarz(Pageable pageable);
    List<Terminarz> getAllTerminarz();
    Terminarz getTerminarz(long id);
    void deleteTerminarz(long id);
    void saveTerminarz(Terminarz terminarz);

    List<User> getAllUser();
    List<Wizyta> getAllWizyta();

}

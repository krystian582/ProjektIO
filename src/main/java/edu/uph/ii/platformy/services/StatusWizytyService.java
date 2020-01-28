package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.models.Recepta;
import edu.uph.ii.platformy.models.StatusWizyty;

import java.util.List;

public interface StatusWizytyService {

    List<StatusWizyty> getAllStatusWizyty();
    StatusWizyty getStatusWizyty(long id);
    void deleteStatusWizyty(long id);
    void saveStatusWizyty(StatusWizyty statusWizyty);

}

package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.models.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WizytaService {

    Page<Wizyta> getAllWizyta(Pageable pageable);
    List<Wizyta> getAllWizyta();
    Wizyta getWizyta(long id);
    void deleteWizyta(long id);
    void saveWizyta(Wizyta wizyta);

    List<User> getAllUser();
    List<Usluga> getAllUsluga();
    List<StatusWizyty> getAllStatusWizyty();

}

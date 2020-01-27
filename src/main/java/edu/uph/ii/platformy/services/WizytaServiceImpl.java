package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.exceptions.NotFoundException;
import edu.uph.ii.platformy.models.StatusWizyty;
import edu.uph.ii.platformy.models.User;
import edu.uph.ii.platformy.models.Usluga;
import edu.uph.ii.platformy.models.Wizyta;
import edu.uph.ii.platformy.repositories.StatusWizytyRepository;
import edu.uph.ii.platformy.repositories.UserRepository;
import edu.uph.ii.platformy.repositories.UslugaRepository;
import edu.uph.ii.platformy.repositories.WizytaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WizytaServiceImpl implements WizytaService {

    @Autowired
    WizytaRepository wizytaRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UslugaRepository uslugaRepository;

    @Autowired
    StatusWizytyRepository statusWizytyRepository;

    @Override
    public Page<Wizyta> getAllWizyta(Pageable pageable) {
        Page page;
        page = wizytaRepository.findAll(pageable);
        return page;
    }

    @Override
    public List<Wizyta> getAllWizyta() {
        return wizytaRepository.findAll();
    }

    @Override
    public Wizyta getWizyta(long id) {
        Optional<Wizyta> optionalWizyta = wizytaRepository.findById(id);
        Wizyta wizyta = optionalWizyta.orElseThrow(()->new NotFoundException(id));
        return wizyta;
    }

    @Override
    public void deleteWizyta(long id) {
        if(wizytaRepository.existsById(id) == true){
            wizytaRepository.deleteById(id);
        }else{
            throw new NotFoundException(id);
        }
    }

    @Override
    public void saveWizyta(Wizyta wizyta) {
        wizytaRepository.save(wizyta);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<Usluga> getAllUsluga() {
        return uslugaRepository.findAll();
    }

    @Override
    public List<StatusWizyty> getAllStatusWizyty() {
        return statusWizytyRepository.findAll();
    }
}

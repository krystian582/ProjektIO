package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.exceptions.NotFoundException;
import edu.uph.ii.platformy.models.StatusWizyty;
import edu.uph.ii.platformy.repositories.StatusWizytyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusWizytyServiceImpl implements StatusWizytyService {
    @Autowired
    StatusWizytyRepository statusWizytyRepository;

    @Override
    public List<StatusWizyty> getAllStatusWizyty() {
        return statusWizytyRepository.findAll();
    }

    @Override
    public StatusWizyty getStatusWizyty(long id) {
        Optional<StatusWizyty> optionalStatusWizyty = statusWizytyRepository.findById(id);
        StatusWizyty statusWizyty = optionalStatusWizyty.orElseThrow(()->new NotFoundException(id));
        return statusWizyty;
    }

    @Override
    public void deleteStatusWizyty(long id) {
        if(statusWizytyRepository.existsById(id) == true){
            statusWizytyRepository.deleteById(id);
        }else{
            throw new NotFoundException(id);
        }
    }

    @Override
    public void saveStatusWizyty(StatusWizyty statusWizyty) {
        statusWizytyRepository.save(statusWizyty);
    }
}

package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.exceptions.NotFoundException;
import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.User;
import edu.uph.ii.platformy.repositories.KartaZdrowiaRepository;
import edu.uph.ii.platformy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class KartaZdrowiaServiceImpl implements KartaZdrowiaService {

    @Autowired
    KartaZdrowiaRepository kartaZdrowiaRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<KartaZdrowia> getAllKartaZdrowia(Pageable pageable) {
        Page page;
        page = kartaZdrowiaRepository.findAll(pageable);
        return page;
    }

    @Override
    public List<KartaZdrowia> getAllKartaZdrowia() {
        return kartaZdrowiaRepository.findAll();
    }

    @Override
    public KartaZdrowia getKartaZdrowia(long id) {
        Optional<KartaZdrowia> optionalKartaZdrowia = kartaZdrowiaRepository.findById(id);
        KartaZdrowia kartaZdrowia = optionalKartaZdrowia.orElseThrow(()->new NotFoundException(id));
        return kartaZdrowia;
    }

    @Override
    public void deleteKartaZdrowia(long id) {
        if(kartaZdrowiaRepository.existsById(id) == true){
            kartaZdrowiaRepository.deleteById(id);
        }else{
            throw new NotFoundException(id);
        }
    }

    @Override
    public void saveKartaZdrowia(KartaZdrowia kartaZdrowia) {
        kartaZdrowiaRepository.save(kartaZdrowia);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}

package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.exceptions.NotFoundException;
import edu.uph.ii.platformy.models.Usluga;
import edu.uph.ii.platformy.repositories.UslugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UslugaServiceImpl implements UslugaService {

    @Autowired
    UslugaRepository uslugaRepository;

    @Override
    public Page<Usluga> getAllUsluga(Pageable pageable) {
        Page page;
        page = uslugaRepository.findAll(pageable);
        return page;
    }

    @Override
    public List<Usluga> getAllUsluga() {
        return uslugaRepository.findAll();
    }

    @Override
    public Usluga getUsluga(long id) {
        Optional<Usluga> optionalUsluga = uslugaRepository.findById(id);
        Usluga usluga = optionalUsluga.orElseThrow(()->new NotFoundException(id));
        return usluga;
    }

    @Override
    public void deleteUsluga(long id) {
        if(uslugaRepository.existsById(id) == true){
            uslugaRepository.deleteById(id);
        }else{
            throw new NotFoundException(id);
        }
    }

    @Override
    public void saveUsluga(Usluga usluga) {
        uslugaRepository.save(usluga);
    }
}

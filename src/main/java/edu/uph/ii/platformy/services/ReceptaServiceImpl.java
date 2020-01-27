package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.controllers.commands.ReceptaFilter;
import edu.uph.ii.platformy.controllers.commands.UserFilter;
import edu.uph.ii.platformy.exceptions.NotFoundException;
import edu.uph.ii.platformy.models.Recepta;
import edu.uph.ii.platformy.models.Refundacja;
import edu.uph.ii.platformy.repositories.ReceptaRepository;
import edu.uph.ii.platformy.repositories.RefundacjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReceptaServiceImpl implements ReceptaService {

    @Autowired
    ReceptaRepository receptaRepository;

    @Autowired
    RefundacjaRepository refundacjaRepository;

    @Override
    public Page<Recepta> getAllRecepta(Pageable pageable) {
        Page page;
        page = receptaRepository.findAll(pageable);
        return page;
    }

    @Override
    public List<Recepta> getAllRecepta() {
        return receptaRepository.findAll();
    }

    @Override
    public Recepta getRecepta(long id) {
        Optional<Recepta> optionalRecepta = receptaRepository.findById(id);
        Recepta recepta = optionalRecepta.orElseThrow(()->new NotFoundException(id));
        return recepta;
    }

    @Override
    public void deleteRecepta(long id) {
        if(receptaRepository.existsById(id) == true){
            receptaRepository.deleteById(id);
        }else{
            throw new NotFoundException(id);
        }
    }

    @Override
    public void saveRecepta(Recepta recepta) {
        receptaRepository.save(recepta);
    }

    @Override
    public List<Refundacja> getAllRefundacja() {
        return refundacjaRepository.findAll();
    }

    @Override
    public Page<Recepta> getAllRecepta(ReceptaFilter filter, Pageable pageable) {
        Page page;
        if(filter.isEmpty()){
            page = receptaRepository.findAll(pageable);
        }else{
            page = receptaRepository.findAllUserUsingFilter(filter.getPhraseLIKE(), pageable);
        }
        return page;
    }

}

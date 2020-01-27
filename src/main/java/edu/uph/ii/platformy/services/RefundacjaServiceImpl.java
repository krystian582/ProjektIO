package edu.uph.ii.platformy.services;

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
public class RefundacjaServiceImpl implements RefundacjaService {

    @Autowired
    RefundacjaRepository refundacjaRepository;

    @Override
    public List<Refundacja> getAllRefundacja() {
        return refundacjaRepository.findAll();
    }

    @Override
    public Refundacja getRefundacja(long id) {
        Optional<Refundacja> optionalRefundacja = refundacjaRepository.findById(id);
        Refundacja refundacja = optionalRefundacja.orElseThrow(()->new NotFoundException(id));
        return refundacja;
    }

    @Override
    public void deleteRefundacja(long id) {
        if(refundacjaRepository.existsById(id) == true){
            refundacjaRepository.deleteById(id);
        }else{
            throw new NotFoundException(id);
        }
    }

    @Override
    public void saveRecepta(Refundacja refundacja) {
        refundacjaRepository.save(refundacja);
    }
}

package edu.uph.ii.platformy.services;

import edu.uph.ii.platformy.controllers.commands.TerminarzFilter;
import edu.uph.ii.platformy.controllers.commands.UserFilter;
import edu.uph.ii.platformy.exceptions.NotFoundException;
import edu.uph.ii.platformy.models.Terminarz;
import edu.uph.ii.platformy.models.User;
import edu.uph.ii.platformy.models.Wizyta;
import edu.uph.ii.platformy.repositories.TerminarzRepository;
import edu.uph.ii.platformy.repositories.UserRepository;
import edu.uph.ii.platformy.repositories.WizytaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class TerminarzServiceImpl implements TerminarzService {

    @Autowired
    TerminarzRepository terminarzRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    WizytaRepository wizytaRepository;



    @Override
    public Page<Terminarz> getAllTerminarz(Pageable pageable) {

        Page page;
        page = terminarzRepository.findAll(pageable);
        return page;
    }

    @Override
    public List<Terminarz> getAllTerminarz() {
        return terminarzRepository.findAll();
    }

    @Override
    public Terminarz getTerminarz(long id) {
        Optional<Terminarz> optionalTerminarz = terminarzRepository.findById(id);
        Terminarz terminarz = optionalTerminarz.orElseThrow(()->new NotFoundException(id));
        return terminarz;
    }

    @Override
    public void deleteTerminarz(long id) {
        if(terminarzRepository.existsById(id) == true){
            terminarzRepository.deleteById(id);
        }else{
            throw new NotFoundException(id);
        }
    }

    @Override
    public void saveTerminarz(Terminarz terminarz) {
        terminarzRepository.save(terminarz);
    }

    @Override
    public long getDoctorId() {
        Authentication id = SecurityContextHolder.getContext().getAuthentication();
         User u = userRepository.findByPesel(id.getName());
        return u.getId();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<Wizyta> getAllWizyta() {
        return wizytaRepository.findAll();
    }

    @Override
    public List<Terminarz> getAllTerminarz(TerminarzFilter filter) {
        List<Terminarz> l = null;

        if(filter.isEmpty()){
            l = terminarzRepository.findAll();
        }else{
          //Timestamp t =  Timestamp.valueOf(String.valueOf(Timestamp.valueOf(filter.getPesel())));
            String pattern = "MM/dd/yyyy HH:mm:ss";
            DateFormat df = new SimpleDateFormat(pattern);


            String todayAsString = df.format(filter.getData());

            // l = terminarzRepository.findAllTerminarzUsingFilter(t);
            l = terminarzRepository.findAllTerminarzUsingFilter(todayAsString ) ;
           // l = userRepository.findAllUserUsingFilter(filter.getPhraseLIKE(), pageable);
        }
        return l;
    }


}

package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.controllers.commands.ReceptaFilter;
import edu.uph.ii.platformy.controllers.commands.UserFilter;
import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.Recepta;
import edu.uph.ii.platformy.models.Refundacja;
import edu.uph.ii.platformy.models.User;
import edu.uph.ii.platformy.repositories.ReceptaRepository;
import edu.uph.ii.platformy.repositories.UserRepository;
import edu.uph.ii.platformy.services.ReceptaService;
import edu.uph.ii.platformy.services.RefundacjaService;
import edu.uph.ii.platformy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReceptaListController {

    @Autowired
    ReceptaService receptaService;
    @Autowired
    RefundacjaService refundacjaService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;


    @ModelAttribute("refundacjaList")
    public List<Refundacja> loadRefundacjaList(){
        List<Refundacja> types = receptaService.getAllRefundacja();
        return types;
    }

    /*@ModelAttribute("kartazdrowia")
    public List<KartaZdrowia> loadKartaZdrowiaList(){
        List<KartaZdrowia> types = kartaZdrowiaService.getAllKartaZdrowia();
        return types;
    }*/

    @GetMapping(value="/receptaList.html")
    public List<Recepta> loadReceptaUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int id = userService.findByUserName(authentication.getName());
        List<Recepta> types = receptaService.getAllRecepta();
        List<Recepta> receptaList = new ArrayList<>();
        for(int i = 0; i < types.size();i++) {
            if (types.get(i).getUser().getId() == id) {
                receptaList.add(types.get(i));
            }
        }
        return receptaList;
    }
}

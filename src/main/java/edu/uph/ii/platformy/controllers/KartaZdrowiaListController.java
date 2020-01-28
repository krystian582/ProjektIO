package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.controllers.commands.ReceptaFilter;
import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.Recepta;
import edu.uph.ii.platformy.services.KartaZdrowiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
public class KartaZdrowiaListController {

    @Autowired
    KartaZdrowiaService kartaZdrowiaService;

    /*@RequestMapping(value="/kartaZdrowiaList.html", method = {RequestMethod.GET, RequestMethod.POST}, params = {"idu"})
    public String showKartaZdrowiaList(Model model, Pageable pageable, long idu){
        model.addAttribute("kartaZdrowiaListPage", kartaZdrowiaService.getAllKartaZdrowia(pageable));
        return "kartaZdrowiaList";
    }*/

    @ModelAttribute("kartazdrowia")
    public List<KartaZdrowia> loadKartaZdrowiaList(){
        List<KartaZdrowia> types = kartaZdrowiaService.getAllKartaZdrowia();
        return types;
    }

    @GetMapping(value="/kartaZdrowiaList.html",params = {"idu"})
    public List<KartaZdrowia> loadKartaZdrowiaUser(long idu){
        List<KartaZdrowia> types = kartaZdrowiaService.getAllKartaZdrowia();
        List<KartaZdrowia> kartaZdrowiaList = new ArrayList<>();
        for(int i = 0;i < types.size();i++) {
            if (types.get(i).getUser().getId() == idu) {
                kartaZdrowiaList.add(types.get(i));
            }
        }
        return kartaZdrowiaList;
    }

}

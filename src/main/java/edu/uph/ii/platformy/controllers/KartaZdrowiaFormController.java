package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.models.KartaZdrowia;
import edu.uph.ii.platformy.models.Recepta;
import edu.uph.ii.platformy.models.Refundacja;
import edu.uph.ii.platformy.models.User;
import edu.uph.ii.platformy.services.KartaZdrowiaService;
import edu.uph.ii.platformy.services.ReceptaService;
import edu.uph.ii.platformy.services.RefundacjaService;
import edu.uph.ii.platformy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@SessionAttributes(names = {"kartaZdrowia","informacja"})
public class KartaZdrowiaFormController {

    @Autowired
    KartaZdrowiaService kartaZdrowiaService;

    @Autowired
    UserService userService;

    public KartaZdrowiaFormController(KartaZdrowiaService kartaZdrowiaService){
        this.kartaZdrowiaService = kartaZdrowiaService;
    }

    @GetMapping(value="/kartaZdrowiaForm.html",params = {"idu"})
    public String showForm(Model model, Long idu) {

        KartaZdrowia z = new KartaZdrowia();
        z.setUser(userService.getUser(idu));
        User u = userService.getUser(idu);
        model.addAttribute("informacja", u);
        model.addAttribute("kartaZdrowia", z);

        return "kartaZdrowiaForm";
    }

    @RequestMapping(value="/kartaZdrowiaForm.html", method = RequestMethod.POST)
    public String processForm(@ModelAttribute(name = "kartaZdrowia") KartaZdrowia z, BindingResult errors){

        if(errors.hasErrors()){
            return "kartaZdrowiaForm";
        }

        kartaZdrowiaService.saveKartaZdrowia(z);
        long userId = z.getUser().getId();

        return "redirect:kartaZdrowiaList.html?idu="+userId;//po udanym dodaniu/edycji przekierowujemy na listę
    }
}

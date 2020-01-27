package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.models.Recepta;
import edu.uph.ii.platformy.models.Refundacja;
import edu.uph.ii.platformy.repositories.UserRepository;
import edu.uph.ii.platformy.services.ReceptaService;
import edu.uph.ii.platformy.services.RefundacjaService;
import edu.uph.ii.platformy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes(names = {"recepta"})
public class ReceptaFormController {

    @Autowired
    ReceptaService receptaService;
    @Autowired
    RefundacjaService refundacjaService;
    @Autowired
    UserService userService;

    public ReceptaFormController(ReceptaService receptaService){
        this.receptaService = receptaService;
    }

    @GetMapping(value="/receptaForm.html",params = {"idu"})
    public String showForm(Model model, Long idu) {

        Recepta r = new Recepta();
        r.setUser(userService.getUser(idu));
        model.addAttribute("recepta", r);

        return "receptaForm";
    }

    @ModelAttribute("refundacjaList")
    public List<Refundacja> loadRefundacjaList(){
        List<Refundacja> types = refundacjaService.getAllRefundacja();
        return types;
    }

    @RequestMapping(value="/receptaForm.html", method = RequestMethod.POST)
    public String processForm(@ModelAttribute("recepta") Recepta r, BindingResult errors){

        if(errors.hasErrors()){
            return "receptaForm";
        }

        receptaService.saveRecepta(r);
        return "redirect:receptaList.html";//po udanym dodaniu/edycji przekierowujemy na listę
    }

}

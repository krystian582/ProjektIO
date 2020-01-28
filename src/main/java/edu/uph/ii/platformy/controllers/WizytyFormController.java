package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.models.User;
import edu.uph.ii.platformy.models.Usluga;
import edu.uph.ii.platformy.models.Wizyta;
import edu.uph.ii.platformy.repositories.UserRepository;
import edu.uph.ii.platformy.services.StatusWizytyService;
import edu.uph.ii.platformy.services.UserService;
import edu.uph.ii.platformy.services.UslugaService;
import edu.uph.ii.platformy.services.WizytaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes(names = {"wizyta", "uslugiWizytyForm"})
public class WizytyFormController {

    @Autowired
    WizytaService wizytaService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UslugaService uslugaService;
    @Autowired
    StatusWizytyService statusWizytyService;

    //@Secured("ROLE_ADMIN")
    @RequestMapping(value="/wizytyForm.html", method= RequestMethod.GET)
    public String showForm(Model model, Optional<Integer> id){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("wizyta",
                id.isPresent()?
                        wizytaService.getWizyta(id.get()):
                        new Wizyta(userRepository.findByPesel(authentication.getName()), statusWizytyService.getStatusWizyty(1)));

        return "wizytyForm";
    }

    //@Secured("ROLE_ADMIN")
    @RequestMapping(value="/wizytyForm.html", method= RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("wizyta") Wizyta v, BindingResult errors){

        if(errors.hasErrors()){
            return "wizytyForm";
        }

        wizytaService.saveWizyta(v);

        return "redirect:wizytyList.html";
    }

    @ModelAttribute(name = "uslugiWizytyForm")
    public List<Usluga> loadUslugi() {
        return uslugaService.getAllUsluga();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, false);
        binder.registerCustomEditor(Date.class, "dataWizyty", dateEditor);
    }

}

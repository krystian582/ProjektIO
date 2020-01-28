package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.models.Wizyta;
import edu.uph.ii.platformy.services.TerminarzService;
import edu.uph.ii.platformy.services.UserService;
import edu.uph.ii.platformy.services.WizytaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class WizytyListController {

    @Autowired
    WizytaService wizytaService;
    @Autowired
    UserService userService;
    @Autowired
    TerminarzService terminarzService;

    private int getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.findByUserName(authentication.getName());
    }

    @ModelAttribute("wizyty")
    public List<Wizyta> loadWizytyList(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int id = getUserId();
        List<Wizyta> wizyty = wizytaService.getAllWizyta(id);
        return wizyty;
    }

    @GetMapping(path="/wizytyList.html", params={"did"})
    public String deleteItem(int did, HttpServletRequest request){
        terminarzService.deleteTerminarz(did); //todo
        wizytaService.deleteWizyta(did);

        return String.format("redirect:wizytyList.html");
    }

    @GetMapping(value="/wizytyList.html", params={"id"})
    public String showWizytyListRecepcja(Model m, int id){
        m.addAttribute("wizyty", wizytaService.getAllWizyta(id));
        return "wizytyList";
    }

    @RequestMapping(value="/wizytyList.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String showWizytyList(@Valid @ModelAttribute("wizyty") List<Wizyta> w){
        return "wizytyList";
    }
}

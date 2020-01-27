package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.controllers.commands.ReceptaFilter;
import edu.uph.ii.platformy.controllers.commands.UserFilter;
import edu.uph.ii.platformy.models.Recepta;
import edu.uph.ii.platformy.repositories.ReceptaRepository;
import edu.uph.ii.platformy.services.ReceptaService;
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
@Controller
public class ReceptaListController {

    @Autowired
    ReceptaService receptaService;

    @ModelAttribute("searchCommand")
    public ReceptaFilter getSimpleSearch(){
        return new ReceptaFilter();
    }

    @GetMapping(value="/receptaList.html", params = {"all"})
    public String resetUserList(@ModelAttribute("searchCommand") ReceptaFilter search){
        search.clear();
        return "redirect:receptaList.html";
    }

    @RequestMapping(value="/receptaList.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String showReceptaList(Model model, Pageable pageable, @Valid @ModelAttribute("searchCommand") ReceptaFilter search, BindingResult result){
        model.addAttribute("receptaListPage", receptaService.getAllRecepta(search, pageable));
        return "receptaList";
    }
}

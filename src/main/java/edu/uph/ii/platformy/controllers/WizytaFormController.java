package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.controllers.commands.UserFilter;
import edu.uph.ii.platformy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@SessionAttributes("wizyta")
public class WizytaFormController {

    @Autowired
    UserService userService;

    @GetMapping(value="/userWizytaForm.html", params = {"id"})
    public String getUserList(@ModelAttribute("searchCommand") UserFilter search){
        search.clear();
        return "redirect:userList.html";
    }

    @RequestMapping(value="/userList.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String showUserList(Model model, Pageable pageable, @Valid @ModelAttribute("searchCommand") UserFilter search, BindingResult result){
        model.addAttribute("userListPage", userService.getAllUser(search, pageable));
        return "userList";
    }


    /*@RequestMapping(value="/userList.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String showUserList(Model model, Pageable pageable){
        model.addAttribute("userListPage", userService.getAllUser(pageable));
        return "userList";
    }*/

    /*@ModelAttribute("userList")
    public List<User> loadUserList(){
        List<User> user = userService.getAllUser();
        return user;
    }*/


}

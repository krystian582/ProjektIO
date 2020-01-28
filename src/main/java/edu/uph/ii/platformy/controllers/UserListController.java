package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.controllers.commands.UserFilter;
import edu.uph.ii.platformy.models.User;
import edu.uph.ii.platformy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.data.domain.Pageable;
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

@Controller
@SessionAttributes("searchCommand")
public class UserListController {

    @Autowired
    UserService userService;

    @ModelAttribute("searchCommand")
    public UserFilter getSimpleSearch(){
        return new UserFilter();
    }

    @GetMapping(value="/userList.html", params = {"all"})
    public String resetUserList(@ModelAttribute("searchCommand") UserFilter search){
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

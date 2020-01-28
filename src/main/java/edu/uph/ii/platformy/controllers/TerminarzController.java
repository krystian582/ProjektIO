package edu.uph.ii.platformy.controllers;

import edu.uph.ii.platformy.controllers.commands.TerminarzFilter;
import edu.uph.ii.platformy.controllers.commands.UserFilter;
import edu.uph.ii.platformy.models.Terminarz;
import edu.uph.ii.platformy.models.User;
import edu.uph.ii.platformy.repositories.UserRepository;
import edu.uph.ii.platformy.services.TerminarzService;
import edu.uph.ii.platformy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.data.domain.Pageable;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("Terminarz")
public class TerminarzController {

    @Autowired
    UserService userService;

    @Autowired
    TerminarzService terminarzService;

    @RequestMapping(value="/terminarz.html", method = {RequestMethod.GET, RequestMethod.POST})
    public String showUserList(Model model, Pageable pageable, @Valid @ModelAttribute("searchCommand") TerminarzFilter search, BindingResult result){
        //model.addAttribute("userListPage", userService.getAllUser(search, pageable));

        ArrayList<Terminarz> lis = new ArrayList<Terminarz>() ;

        //List<Terminarz> tak = terminarzService.getAllTerminarz();
        List<Terminarz> tak = terminarzService.getAllTerminarz(search);

        long ii = terminarzService.getDoctorId();
        for(int i = 0 ; i < tak.size() ; i ++){
            if(tak.get(i).getUser().getId().equals(ii)){
                lis.add(tak.get(i));
            }
        }
                 model.addAttribute("terminarzList",lis );
        return "terminarz";

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {//Rejestrujemy edytory właściwości

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        CustomDateEditor dateEditor = new CustomDateEditor(dateFormat, false);
        binder.registerCustomEditor(Date.class, "data", dateEditor);


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

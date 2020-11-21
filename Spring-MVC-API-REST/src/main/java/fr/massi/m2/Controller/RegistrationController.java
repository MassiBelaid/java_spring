package fr.massi.m2.Controller;


import fr.massi.m2.Bean.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {

    @GetMapping("registration")
    public String getRedistration(@ModelAttribute("registration") Registration user){

        return "registration";
    }

    @GetMapping("home")
    public String getRegistration(Map<String,Object> model){
        model.put("message", "Fantastic Thymeleaf.");

        return "home";
    }


    @PostMapping("registration")
    public String addRedistration(@Valid @ModelAttribute("registration")Registration user, BindingResult result){
        if(result.hasErrors()){
            System.out.println("erreur remplissage formulaire  ");
            return "registration";
        }else {
            System.out.println("Pseudo : " + user.getPseudo());
            System.out.println("Email : " + user.getEmail());
            return "redirect:registration";
        }


    }
}

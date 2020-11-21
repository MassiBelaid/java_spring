package fr.massi.m2.Controller;

import fr.massi.m2.Bean.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(
            @RequestParam(value = "nom", defaultValue="Jean") String nom,
            @RequestParam(value = "prenom", defaultValue="Du jardin") String prenom,
            @RequestParam(value = "age", defaultValue="30") int age
    ){
        User u = new User();
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setAge(age);
        return u;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        List<User> listUser = new ArrayList<User>();
        for(int i = 1; i <= 100 ; i++ ){
            User u = new User();
            u.setNom("Nom user"+i);
            u.setPrenom("Prenom user"+i);
            u.setAge(i);
            listUser.add(u);
        }

        if(id <= listUser.size() && id > 0){
            return listUser.get(id-1);
        }else{
            return null;
        }

    }


    @CrossOrigin(origins = "*")
    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> listUser = new ArrayList<User>();
        for(int i = 1; i <= 100 ; i++ ){
            User u = new User();
            u.setNom("Nom user"+i);
            u.setPrenom("Prenom user"+i);
            u.setAge(i);
            listUser.add(u);
        }

        return listUser;

    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        user.printUser();
        System.out.println("Utilisateur ajouté avec succé");

        return user;
    }

}

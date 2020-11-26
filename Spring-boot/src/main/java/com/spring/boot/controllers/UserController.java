package com.spring.boot.controllers;

import com.spring.boot.models.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.boot.repositories.UserRepository;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;



    @GetMapping
    public List<User> list(){
        return userRepository.findAll();
    }


    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<User> get(@PathVariable Long id){
        Optional<User> userSearched = userRepository.findById(id);
        if(userSearched.isPresent()){
            return new ResponseEntity<User>(userSearched.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody final User user){
        return userRepository.saveAndFlush(user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        userRepository.deleteById(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
        Optional<User> existingUser = userRepository.findById(id);
        if(existingUser.isPresent()){
            User userEx = existingUser.get();

            BeanUtils.copyProperties(user, userEx, "user_id"); //Le champs user_id va être ignoré
            userRepository.saveAndFlush(userEx);
            return new ResponseEntity<User>(userEx, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

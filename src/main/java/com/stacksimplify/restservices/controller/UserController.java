package com.stacksimplify.restservices.controller;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @GetMapping("/user/{id}")
    public Optional<User> findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PutMapping("/user/update/{id}")
    public void updateById(@PathVariable Long id, @RequestBody User user){
        userService.updateById(id, user);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteById(@PathVariable Long id){
        if(userService.findById(id).isPresent()) {
            userService.deleteById(id);
        }
    }
}

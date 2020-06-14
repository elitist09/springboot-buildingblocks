package com.stacksimplify.restservices.service;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user){
        userRepository.save(user);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public void updateById(Long id, User user){
        user.setId(id);
        userRepository.save(user);

    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}

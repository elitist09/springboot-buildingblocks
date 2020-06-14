package com.stacksimplify.restservices.service;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addNewUser(User user) throws UserExistsException {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if(existingUser != null){
            throw new UserExistsException("User already exists");
        }
        userRepository.save(user);
    }

    public Optional<User> findById(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("user not found");
        }

        return user;
    }

    public void updateById(Long id, User user) throws UserNotFoundException{
        Optional <User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("User not found");
        }
        user.setId(id);
        userRepository.save(user);

    }

    public void deleteById(Long id) {
        Optional <User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
        }

        userRepository.deleteById(id);
    }

}

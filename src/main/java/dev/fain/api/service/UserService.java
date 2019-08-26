package dev.fain.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fain.api.model.User;
import dev.fain.api.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {}

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
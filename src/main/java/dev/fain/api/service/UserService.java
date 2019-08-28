package dev.fain.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.fain.api.model.User;
import dev.fain.api.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<User> getAllUsers(){
      return userRepository.findAll();
  }

  public User getUserByEmail(String email) {
      return userRepository.findByEmail(email);
  }

  public void createUser(User user) {
      userRepository.save(user);
  }

  public String encodePassword(String password) {
    return passwordEncoder.encode(password);
  }

}
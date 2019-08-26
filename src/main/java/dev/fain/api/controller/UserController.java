package dev.fain.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dev.fain.api.model.LoginRequest;
import dev.fain.api.model.LoginResponse;
import dev.fain.api.model.User;
import dev.fain.api.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
  public LoginResponse login(@RequestBody LoginRequest userDetails) {
    userRepository.save(new User("daniel@example.com", "dankmemes123!"));
    System.out.println(userRepository.findAll().toString());
    return new LoginResponse("accessToken", "refreshToken");
  }

}
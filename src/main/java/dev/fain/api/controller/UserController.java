package dev.fain.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dev.fain.api.model.LoginRequest;
import dev.fain.api.model.LoginResponse;
import dev.fain.api.service.UserService;;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
  public LoginResponse login(@RequestBody LoginRequest userDetails) {
    System.out.println(userService.getAllUsers().toString());
    return new LoginResponse("accessToken", "refreshToken");
  }

}
package dev.fain.api.controller;

import org.springframework.web.bind.annotation.*;
import dev.fain.api.model.LoginRequest;

@RestController
@RequestMapping("/user")
public class UserController {

  @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
  public LoginRequest login(@RequestBody LoginRequest userDetails) {
    return userDetails;
  }

}
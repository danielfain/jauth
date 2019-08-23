package dev.fain.api.controller;

import org.springframework.web.bind.annotation.*;
import dev.fain.api.model.LoginRequest;
import dev.fain.api.model.LoginResponse;

@RestController
@RequestMapping("/user")
public class UserController {

  @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
  public LoginResponse login(@RequestBody LoginRequest userDetails) {
    return new LoginResponse("accessToken", "refreshToken");
  }

}
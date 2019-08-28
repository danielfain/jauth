package dev.fain.api.controller;

import dev.fain.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import dev.fain.api.model.LoginRequest;
import dev.fain.api.model.LoginResponse;
import dev.fain.api.service.UserService;
import dev.fain.api.model.SignupRequest;
import dev.fain.api.model.SignupResponse;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public LoginResponse login(@RequestBody LoginRequest userDetails) {
		return new LoginResponse("accessToken", "refreshToken");
	}

	@PostMapping(path = "/signup", consumes = "application/json", produces = "application/json")
	public SignupResponse signup(@RequestBody SignupRequest userDetails) {
		// encodes password with bcrypt and returns its hash
		String passwordHash = userService.encodePassword(userDetails.getPassword());
		userService.createUser(new User(userDetails.getEmail(), passwordHash));
		return new SignupResponse("accessToken", "refreshToken");
	}

}
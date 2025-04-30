package com.backend.getyourstart.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.getyourstart.api.service.UserService;
import com.backend.getyourstart.dto.AuthenticationRequest;
import com.backend.getyourstart.dto.UserRequest;
import com.backend.getyourstart.dto.UserResponse;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/user")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest, HttpSession session) {
        System.out.println(userRequest.getUsername());
        System.out.println(userRequest.getPassword());
        UserResponse userResponse = userService.createUser(userRequest, session);

        if (userResponse != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }  

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/user/authenticate")
    public ResponseEntity<UserResponse> Authenticate(@RequestBody AuthenticationRequest authenticationRequest, HttpSession session) {
        UserResponse userResponse = userService.Authenticate(authenticationRequest, session);

        if (userResponse != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/user/logout")
    public ResponseEntity<String> logOut(HttpSession session) {
        return userService.logOut(session);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/user/check")
    public ResponseEntity<UserResponse> getLoggedIn(HttpSession session) {
         UserResponse loggedIn = userService.getLoggedIn(session);

         if (loggedIn != null) {
            return ResponseEntity.ok(loggedIn);
         } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
         }
    }
}

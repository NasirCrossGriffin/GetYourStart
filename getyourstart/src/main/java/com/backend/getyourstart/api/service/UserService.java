package com.backend.getyourstart.api.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.backend.getyourstart.dto.AuthenticationRequest;
import com.backend.getyourstart.dto.UserRequest;
import com.backend.getyourstart.dto.UserResponse;
import com.backend.getyourstart.models.UserModel;
import com.backend.getyourstart.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import com.backend.getyourstart.api.service.SessionService;

@Service
public class UserService {
    private final UserRepository userRepository;
    private SessionService sessionService;


    public UserService(UserRepository userRepository, SessionService sessionService) {
        this.userRepository = userRepository;
        this.sessionService = sessionService;
    }

  
    public UserResponse createUser(UserRequest userRequest) {
        System.out.println(userRequest.getUsername());
        System.out.println(userRequest.getPassword());


        UserModel newUser = new UserModel();

        newUser.setUsername(userRequest.getUsername());

        String password = userRequest.getPassword();

        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        newUser.setPassword(hashed);

        UserModel savedUser = userRepository.save(newUser);

        return savedUser.createResponse();
    }

    public UserResponse Authenticate(AuthenticationRequest authenticationRequest, HttpSession session) {
        String password = authenticationRequest.getPassword();
        String username = authenticationRequest.getUsername();

        UserModel user;

        try {
            user = userRepository.getUserByUsername(username).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        String hashed = user.getPassword();

        if (BCrypt.checkpw(password, hashed)) {
            sessionService.createSession(session, user);
            return user.createResponse();
        } else {
            return null;
        }
    }

    public UserResponse getLoggedIn(HttpSession session) {
        Long userId = sessionService.getSession(session);

        if (userId != null) {
            try {
                UserModel user = userRepository.getUserById(userId).get();
                return user.createResponse();
            } catch(Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public ResponseEntity<String> logOut(HttpSession session) {
        return sessionService.invalidateSession(session);
    }
    
}

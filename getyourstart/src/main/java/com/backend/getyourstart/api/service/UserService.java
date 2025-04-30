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

@Service
public class UserService {
    private final UserRepository userRepository;
    private SessionService sessionService;


    public UserService(UserRepository userRepository, SessionService sessionService) {
        this.userRepository = userRepository;
        this.sessionService = sessionService;
    }

  
    public UserResponse createUser(UserRequest userRequest, HttpSession session) {
        System.out.println(userRequest.getUsername());
        System.out.println(userRequest.getPassword());


        UserModel newUser = new UserModel();

        newUser.setUsername(userRequest.getUsername());

        String password = userRequest.getPassword();

        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        newUser.setPassword(hashed);

        UserModel savedUser = null;

        try {        
            savedUser = userRepository.save(newUser);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        sessionService.createSession(session, savedUser);

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
    
    public boolean deleteUser(Long userId) {
        UserModel retrievedUser = getUserMiddleware(userId);

        if (retrievedUser == null) {
            return false;
        }

        try {
            userRepository.delete(retrievedUser); 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public UserModel getUserMiddleware(Long userId) {
        UserModel retrievedUser = null;

        try {
            retrievedUser = userRepository.getUserById(userId).get();
        } catch (Exception e) {
            return null;
        }

        return retrievedUser;
    }
    
}

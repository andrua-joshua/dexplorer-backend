package com.dhotels.hotelsbackend.controllers;

import com.dhotels.hotelsbackend.helpers.LoginRequest;
import com.dhotels.hotelsbackend.helpers.ProfileUpdateRequest;
import com.dhotels.hotelsbackend.helpers.SignUpRequest;
import com.dhotels.hotelsbackend.modules.User;
import com.dhotels.hotelsbackend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @ResponseBody
    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(
            @RequestBody SignUpRequest signUpRequest
            ){

        User user = authenticationService.signUp(
                signUpRequest
        );

        return new ResponseEntity<User>(
                user, HttpStatus.OK
        );
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(
            @RequestBody LoginRequest loginRequest
    ){

        User user = authenticationService.login(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        return new ResponseEntity<User>(
                user, HttpStatus.OK
        );
    }


    @ResponseBody
    @PostMapping("/updateUser/{id}")
    public ResponseEntity<User> updateUser(
            @RequestBody ProfileUpdateRequest profileUpdateRequest,
            @PathVariable("id") Integer userId
    ){

        User user = authenticationService.updateUser(
                userId,
                profileUpdateRequest.getFullName(),
                profileUpdateRequest.getEmail(),
                profileUpdateRequest.getPhone()
        );

        return new ResponseEntity<User>(
                user, HttpStatus.OK
        );
    }


    @ResponseBody
    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(
            @PathVariable("id") Integer userId
    ){

        User user = authenticationService.getUserById(
                userId
        );

        return new ResponseEntity<User>(
                user, HttpStatus.OK
        );
    }

}

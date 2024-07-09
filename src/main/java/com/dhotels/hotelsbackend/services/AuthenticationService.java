package com.dhotels.hotelsbackend.services;

import com.dhotels.hotelsbackend.exception.InvalidCredentialsException;
import com.dhotels.hotelsbackend.exception.ResourceNotFoubdException;
import com.dhotels.hotelsbackend.helpers.SignUpRequest;
import com.dhotels.hotelsbackend.modules.*;
import com.dhotels.hotelsbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;

    ///login
    ///signup
    ///delete account
    ///update profile
    ///get user profile
    //todo (account verifications) after the rest
    ///verify email
    ///password recovery
    ///account recovery

    public User signUp(SignUpRequest signUpRequest){

//        User theUser =

        User user = new User(
                signUpRequest.getFullName(),
                signUpRequest.getEmail(),
                signUpRequest.getPhone(),
                String.valueOf(signUpRequest.getPassword().hashCode()),
                new ArrayList<Booking>(),
                new ArrayList<Business>(),
                new ArrayList<DiningCart>(),
                new ArrayList<DiningOrder>(),
                new ArrayList<FavouriteBusiness>(),
                new ArrayList<FavouriteDiningItem>(),
                new ArrayList<Notification>(),
                new ArrayList<Transaction>(),
                new Date()
        );

        return userRepository.save(user);
    }

    public User login(String email, String password){

        User user = userRepository.findByEmail(email).orElseThrow(
                ResourceNotFoubdException::new
        );

        if(user.getPassword().equals(String.valueOf(password.hashCode()))){
            return user;
        }else{
            throw new InvalidCredentialsException();
        }
    }

    public void deleteAccount(Integer userId){

    }

    public User updateUser(Integer userId, String username, String email, String phone){
        User theUser = userRepository.findById(userId)
                .orElseThrow(
                        ResourceNotFoubdException::new
                );

        theUser.setFullName(username);
        theUser.setEmail(email);
        theUser.setPhone(phone);



        return userRepository.save(theUser);
    }


    public User getUserById(Integer userId){
        User user = userRepository.findById(userId)
                .orElseThrow(
                        ResourceNotFoubdException::new
                );


        return user;
    }

    public void verifyEmail(Integer userId){

    }

    public void SendOTP(Integer userId){

    }


}

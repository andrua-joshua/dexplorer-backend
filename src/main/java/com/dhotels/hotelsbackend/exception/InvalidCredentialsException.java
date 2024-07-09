package com.dhotels.hotelsbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidCredentialsException extends  RuntimeException{

    public InvalidCredentialsException(){
        super("Invalid credentials");
    }

    public InvalidCredentialsException(String message){
        super(message, null);
    }

    public InvalidCredentialsException(String message, Throwable throwable){
        super(message, throwable);
    }
}

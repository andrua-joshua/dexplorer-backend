package com.dhotels.hotelsbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnAuthorizedException extends  RuntimeException{

    public UnAuthorizedException(){
        super("UnAuthorized Exception");
    }

    public UnAuthorizedException(String message){
        super(message, null);
    }

    public UnAuthorizedException(String message, Throwable throwable){
        super(message, throwable);
    }
}

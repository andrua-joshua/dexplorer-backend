package com.dhotels.hotelsbackend.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoubdException extends RuntimeException {

    public ResourceNotFoubdException(){
        super("Resource not found");
    }

    public  ResourceNotFoubdException(String message){
        super(message, null);
    }

    public  ResourceNotFoubdException(String message, Throwable claus){
        super(message, claus);
    }

}

package com.zoory.userservice.exception;

public class InvalidException extends RuntimeException{
    public InvalidException(String message){
        super(message);
    }
}

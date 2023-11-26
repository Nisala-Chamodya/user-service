package com.zoory.userservice.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String messsage){
        super(messsage);
    }
}

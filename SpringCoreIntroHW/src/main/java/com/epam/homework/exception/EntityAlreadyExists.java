package com.epam.homework.exception;

public class EntityAlreadyExists extends RuntimeException{

    public EntityAlreadyExists(String message) {
        super(message);
    }

}

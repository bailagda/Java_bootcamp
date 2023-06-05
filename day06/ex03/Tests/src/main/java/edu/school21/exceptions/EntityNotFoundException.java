package edu.school21.exceptions;

public class EntityNotFoundException extends RuntimeException{
    EntityNotFoundException(){
        super("login is wrong");
    }
}
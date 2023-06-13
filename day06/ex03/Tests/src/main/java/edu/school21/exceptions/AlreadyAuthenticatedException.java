package edu.school21.exceptions;

public class AlreadyAuthenticatedException extends Throwable {
    public AlreadyAuthenticatedException(){
        super("------> User already registered <------");
    }
}

package it.epicode.u5w2d2pratica.exception;

import java.rmi.StubNotFoundException;

public class BlogNotFoundException extends Exception{
    public BlogNotFoundException(String message){
        super(message);
    }
}

package com.softtek.exceptions;


//EXCEPCION PERSONALIZADA
public class NoEncontrado extends RuntimeException{
    public NoEncontrado(String message) {
        super(message);
    }
}

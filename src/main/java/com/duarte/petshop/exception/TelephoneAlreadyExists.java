package com.duarte.petshop.exception;

public class TelephoneAlreadyExists extends RuntimeException {

    public TelephoneAlreadyExists(String message) {
        super(message);
    }
}

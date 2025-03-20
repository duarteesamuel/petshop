package com.duarte.petshop.exception;

public class CpfAlreadyExists extends RuntimeException {
    public CpfAlreadyExists(String message) {
        super(message);
    }
}

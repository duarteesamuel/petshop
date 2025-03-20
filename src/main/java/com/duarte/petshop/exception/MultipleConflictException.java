package com.duarte.petshop.exception;

public class MultipleConflictException extends RuntimeException {

    public MultipleConflictException(String msg){
        super(msg);
    }
}

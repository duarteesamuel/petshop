package com.duarte.petshop.exception;

import java.util.List;

public class MultipleConflictException extends RuntimeException {

    private final List<String> errors;

    public MultipleConflictException(List<String> errors){
        super("Multiple conflicts found");

        this.errors = errors;
    }

    public List<String> getErrors(){
        return errors;
    }
}

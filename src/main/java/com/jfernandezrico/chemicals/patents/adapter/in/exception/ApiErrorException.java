package com.jfernandezrico.chemicals.patents.adapter.in.exception;

import lombok.Data;

@Data
public class ApiErrorException extends Exception {
    private final int internalCode;

    public ApiErrorException(final int internalCode, final String message) {
        super(message);
        this.internalCode = internalCode;
    }
}


package com.jfernandezrico.chemicals.patents.adapter.in.exception;

public class ApiTagNotFoundException extends ApiErrorException {
    public ApiTagNotFoundException(String message) {
        super(804, message);
    }
}

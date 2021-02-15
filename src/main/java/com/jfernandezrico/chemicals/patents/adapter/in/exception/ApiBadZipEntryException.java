package com.jfernandezrico.chemicals.patents.adapter.in.exception;

public class ApiBadZipEntryException extends ApiErrorException {
    public ApiBadZipEntryException(String message) {
        super(802, "Multipart file uploaded has wrong entry: " + message);
    }
}

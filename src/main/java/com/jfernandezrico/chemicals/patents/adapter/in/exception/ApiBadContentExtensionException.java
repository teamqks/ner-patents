package com.jfernandezrico.chemicals.patents.adapter.in.exception;

public class ApiBadContentExtensionException extends ApiErrorException {
    public ApiBadContentExtensionException(String fileName) {
        super(801, "Multipart file uploaded has wrong content file extension " + fileName);
    }
}

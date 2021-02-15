package com.jfernandezrico.chemicals.patents.adapter.in.exception;

public class ApiBadZipExtensionException extends ApiErrorException {
    public ApiBadZipExtensionException(String fileExtension) {
        super(803, "Multipart file uploaded has wrong extension " + fileExtension);
    }
}

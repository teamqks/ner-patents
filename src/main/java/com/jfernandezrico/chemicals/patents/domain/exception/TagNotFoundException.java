package com.jfernandezrico.chemicals.patents.domain.exception;

public class TagNotFoundException extends Exception{

    public TagNotFoundException(String message) {
        super("XML Tag not found: " + message);
    }
}

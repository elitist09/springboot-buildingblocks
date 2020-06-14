package com.stacksimplify.restservices.exceptions;

public class UserExistsException extends Exception {

    public static final long serialVersionUID = 190L;

    public UserExistsException(String message) {
        super(message);
    }
}

package com.maxlvshv.pastebin.exceptions;

public class UserIsNotExistException extends Exception{
    public UserIsNotExistException(String message) {
        super(message);
    }
}

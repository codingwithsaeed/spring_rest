package com.ltp.contacts.exception;

public class ContactNotFoundException extends RuntimeException {
    
    public ContactNotFoundException(String id) {
        super("The contact with id: " + id + " is not exsits.");
    }
}

package com.validation.passwordValidator;

public class PasswordValidator {

    public boolean passwordDoesntContainSpecialCharacters(String password) {
        System.out.println("PASSWORD IS : " + password);

        if (password.matches("^[a-zA-Z0-9]*\\b$")) {
            System.out.println("Password contains no special characters");
            return true;
        } else {
            System.out.println("INVALID: Your password contains special characters");
            return false;
        }
    }

    public boolean passwordIsBetween5and12Characters(String password) {
        System.out.println("PASSWORD LENGTH = " + password.length());
        if((password.length() >= 5) && (password.length() <= 12 )) {
            System.out.println("Password is between 5 and 12 characters");
            return true;
        } else {
            System.out.println("INVALID: Your password needs to be between 5 and 12 characters long");
            return false;
        }
    }
}
/*
Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
Must be between 5 and 12 characters in length.
Must not contain any sequence of characters immediately followed by the same sequence.*/
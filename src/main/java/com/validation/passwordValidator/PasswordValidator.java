package com.validation.passwordValidator;

public class PasswordValidator {

/* Passwords must meet the following criteria:
Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each.
Must be between 5 and 12 characters in length.
Must not contain any sequence of characters immediately followed by the same sequence.*/

    public boolean passwordDoesNotContainSpecialCharacters(String password) {
        if (password.matches("^[a-zA-Z0-9]*\\b$")) {
            System.out.println("Password contains no special characters");
            return true;
        } else {
            System.out.println("INVALID: Your password contains special characters");
            return false;
        }
    }

    public boolean passwordIsBetween5and12Characters(String password) {
        if ((password.length() >= 5) && (password.length() <= 12)) {
            System.out.println("Password is between 5 and 12 characters");
            return true;
        } else {
            System.out.println("INVALID: Your password needs to be between 5 and 12 characters long");
            return false;
        }
    }
// Not necessary per the AC, but I like explicit null checks
    public boolean passwordIsNotEmptyStringOrNull(String password) {
        if (password == null) {
            System.out.println("INVALID: Password cannot be null");
            return false;
        } else if (password.equals("")) {
            System.out.println("INVALID: Password cannot be an empty String");
            return false;
        } else {
            System.out.println("Password is not null or an empty String");
            return true;
        }
    }

    public boolean passwordContainsUpperCaseAndLowerCaseLetterAndNumber(String password) {
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for (int x = 0; x < password.length(); x++) {
            char character = password.charAt(x);
            if (Character.isDigit(character)) {
                numberFlag = true;
            }
            if (Character.isAlphabetic(character) && Character.isUpperCase(character)) {
                upperCaseFlag = true;
            }
            if (Character.isAlphabetic(character) && Character.isLowerCase(character)) {
                lowerCaseFlag = true;
            }
        }
        if(numberFlag) {
            System.out.println("Password contains at least 1 number");
        }
        if(upperCaseFlag) {
            System.out.println("Password contains at least one uppercase letter");
        }
        if(lowerCaseFlag) {
            System.out.println("Password contains at least one lowercase letter");
        }
        if (numberFlag && upperCaseFlag && lowerCaseFlag) {
            System.out.println("Password contains at least one uppercase and lowercase letter and at least one number");
            return true;
        } else {
            System.out.println("INVALID: password must contain at least one uppercase and lowercase letter and at least one number");
            return false;
        }
    }

    public boolean passwordContainsNoImmediatelyRepeatingSequencesOfCharacters(String password) {
        boolean repeatingCharacterSequenceFlag = false;
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);

            if (i > 0 && character == password.charAt(i - 1)) {
                repeatingCharacterSequenceFlag = true;
            } else if (i > 1 && password.subSequence(i - 2, i).equals(password.subSequence(i - 1, i + 1))) {
                repeatingCharacterSequenceFlag = true;
            } else if (i > 2 && password.subSequence(i - 3, i - 1).equals(password.subSequence(i - 1, i + 1))) {
                repeatingCharacterSequenceFlag = true;
            } else if (i > 4 && password.subSequence(i - 5, i - 2).equals(password.subSequence(i - 2, i + 1))) {
                repeatingCharacterSequenceFlag = true;
            } else if (i > 6 && password.subSequence(i - 7, i - 3).equals(password.subSequence(i - 3, i + 1))) {
                repeatingCharacterSequenceFlag = true;
            } else if (i > 8 && password.subSequence(i - 9, i - 4).equals(password.subSequence(i - 4, i + 1))) {
                repeatingCharacterSequenceFlag = true;
            } else if (i > 10 && password.subSequence(i - 11, i - 5).equals(password.subSequence(i - 5, i + 1))) {
                repeatingCharacterSequenceFlag = true;
            }
        }
        if (repeatingCharacterSequenceFlag == true) {
            System.out.println("INVALID: Your password contains a sequence of repeating characters");
            return false;
        } else {
            System.out.println("Password contains no repeating strings of characters");
            return true;
        }
    }

    public boolean runAllValidationCases(String password) {
        if (passwordIsBetween5and12Characters(password)
                && passwordContainsUpperCaseAndLowerCaseLetterAndNumber(password)
                && passwordIsNotEmptyStringOrNull(password)
                && passwordDoesNotContainSpecialCharacters(password)
                && passwordContainsNoImmediatelyRepeatingSequencesOfCharacters(password)){
            System.out.println("\nWELL DONE! PASSWORD MEETS ALL REQUIREMENTS!\n");
            return true;
        }
        else {
            return false;
        }
    }
}


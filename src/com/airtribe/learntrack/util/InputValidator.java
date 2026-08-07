package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;

public final class InputValidator {
    private InputValidator() {
    }

    public static String requiredText(String value, String fieldName) throws InvalidInputException {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidInputException(fieldName + " cannot be blank.");
        }
        return value.trim();
    }

    public static int positiveNumber(int value, String fieldName) throws InvalidInputException {
        if (value <= 0) {
            throw new InvalidInputException(fieldName + " must be greater than zero.");
        }
        return value;
    }
}

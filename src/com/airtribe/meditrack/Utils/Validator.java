package com.airtribe.meditrack.Utils;

import com.airtribe.meditrack.Exceptions.InvalidDataException;

public class Validator {

    public static int parseIntInput (String input, String fieldName) throws InvalidDataException {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw  new InvalidDataException(fieldName + " must be a valid number.");
        }
    }

    public static String parseStringInput (String input, String fieldName) throws InvalidDataException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidDataException(fieldName + " cannot be empty");
        }
        return input.trim();
    }
}

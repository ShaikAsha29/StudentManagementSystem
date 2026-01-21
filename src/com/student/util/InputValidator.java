package com.student.util;

import java.util.regex.Pattern;

public class InputValidator {

    // ✅ Correct email regex
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile(EMAIL_REGEX);

    // ✅ Email validation
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    // ✅ Password validation
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    // ✅ Name validation
    public static boolean isValidName(String name) {
        return name != null && name.length() >= 3;
    }
}





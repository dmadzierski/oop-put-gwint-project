package com.gwint.card.util;

public class StringUtils {
    public static String capitalCaseOf(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}

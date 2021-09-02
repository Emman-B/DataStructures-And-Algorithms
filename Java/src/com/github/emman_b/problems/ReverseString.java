package com.github.emman_b.problems;

public class ReverseString {
    /* Problem description:
        Reverse a string.
     */
    public String reverseString(String input) {
        // Use string builder to build a string in reverse
        StringBuilder result = new StringBuilder(input.length());

        for (int i = input.length() - 1; i >= 0; --i) {
            result.append(input.toCharArray()[i]);
        }

        return result.toString();
    }
}

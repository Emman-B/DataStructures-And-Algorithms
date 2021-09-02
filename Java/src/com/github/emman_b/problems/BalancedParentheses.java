package com.github.emman_b.problems;

public class BalancedParentheses {
    public boolean isParenthesesBalanced(String input) {
        int counter = 0; // Increments on open parenthesis, Decrements on close
        for (Character c: input.toCharArray()) {
            if (c == '(') {
                ++counter;
            } else if (c == ')') {
                --counter;

                if (counter < 0) {
                    /*
                        If counter is less than 0, then there has been an extra closing parenthesis which means
                        it is unbalanced.
                     */
                    return false;
                }
            }
        }

        // If this point is reached, then the string is only balanced if the counter is still 0
        return counter == 0;
    }
}

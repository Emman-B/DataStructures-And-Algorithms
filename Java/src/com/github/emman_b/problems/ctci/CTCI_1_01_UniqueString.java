package com.github.emman_b.problems.ctci;

import java.util.HashSet;

public class CTCI_1_01_UniqueString {
    /*
        Problem: Implement an algorithm to determine if a string has
        all unique characters.

        Follow-up: Do not use an additional data-structures.
     */

    public static boolean stringHasUniqueCharacters(String input) {
        boolean doTestFollowUp = true;
        if (doTestFollowUp) {
            return stringHasUniqueCharactersFollowUp(input);
        }


        HashSet<Character> inputChars = new HashSet<>();

        for (char c: input.toCharArray()) {
            if (inputChars.contains(c)) {
                return false;
            } else {
                inputChars.add(c);
            }
        }

        return true;
    }

    public static boolean stringHasUniqueCharactersFollowUp(String input) {
        // Assumptions: only [a-z] and ASCII is being used
        int inputChars = 0; // using bit manipulation to handle storing info

        for (char c: input.toCharArray()) {
            // use c as int (subtract 'a' so that 'a' = 0, 'z' = 25)
            int idx = c - 'a';

            // Detect if char is in inputChars by testing bit at "index"
            if ( (1 << (idx) & inputChars) != 0) {
                /*
                    How this bit test works:
                        - we know idx is in the interval [0, 25] so we know integers can contain this info.
                        - we shift 1 to the left "idx" times which results in some number to a power of 2
                        - then, we check it against inputChars by using the bitwise AND operator
                        - if the bit at "idx" isn't set, then the bitwise AND should return 0
                        - otherwise, it will return some number that isn't 0
                 */
                return false;
            } else {
                /*
                    How we set the bit:
                        - we just use bitwise OR with inputChars and 1 bit-shifted "idx" times.
                 */
                inputChars = inputChars | (1 << (idx));
            }
        }

        return true;
    }
}

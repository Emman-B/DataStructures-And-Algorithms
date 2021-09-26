package com.github.emman_b.problems.ctci;

import java.util.HashMap;
import java.util.Map;

public class CTCI_1_05_OneAway {
    /*
        Problem: There are three types of edits that can be performed on strings: insert character,
        remove character, or replace character. Given two strings, identify whether one string is
        one edit or zero edits away from the other string.
     */
    public static boolean isOneAway(String input1, String input2) {
        // first, identify the difference in strings lengths
        int stringLengthDifference = Math.abs(input1.length() - input2.length());
        // case: if difference is 2 or greater, then both strings are not 1 edit away
        if (stringLengthDifference >= 2) return false;

        // case: if difference is 1, there may have been an edit, and it would relate to adding/removing a character
        if (stringLengthDifference == 1) {
            // make frequency map. first string will increment frequency, second will decrement
            HashMap<Character, Integer> frequencyMap = new HashMap<>();

            for (char c: input1.toCharArray()) {
                if (frequencyMap.containsKey(c)) {
                    frequencyMap.put(c, frequencyMap.get(c) + 1);
                } else {
                    frequencyMap.put(c, 1);
                }
            }

            // if decrementing puts a character's frequency to 0, the character should be removed
            for (char c: input2.toCharArray()) {
                if (frequencyMap.containsKey(c)) {
                    frequencyMap.put(c, frequencyMap.get(c) - 1);
                } else {
                    // this is if input2 has one extra character than input1
                    frequencyMap.put(c, -1);
                }

                // do removal on 0
                if (frequencyMap.get(c) == 0) {
                    frequencyMap.remove(c);
                }
            }

            // by the time this point is reached, if the frequency map has more than 1 item then
            //  ... there are more than two changes
            if (frequencyMap.size() > 1) {
                return false;
            } else if (frequencyMap.size() == 1){
                // get the item and return if that value is 1 or -1
                for (Map.Entry<Character, Integer> pair: frequencyMap.entrySet()) {
                    return Math.abs(pair.getValue()) == 1;
                }
            } else {
                // if the frequency map is empty (which wouldn't happen, return true)
                return true;
            }
        } else {
            // else statement is only reached if the difference between string lengths is 0
            // case: same length strings mean that each string's characters should be compared
            int differences = 0;
            for (int i = 0; i < input1.length(); ++i) {
                if (input1.charAt(i) != input2.charAt(i)) {
                    ++differences;
                }

                // if more than 1 difference was found, then we return false
                if (differences > 1) return false;
            }

            // if differences is 0 or 1 (which is only reached by the end of the previous loop), then we can return true
            return true;
        }

        // This will never be reached, but Java appears to be throwing an error otherwise
        return true;
    }
}

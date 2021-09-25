package com.github.emman_b.problems.ctci;

import java.util.HashMap;

public class CTCI_1_02_CheckPermutation {
    /*
        Check two strings and verify if one is a permutation of the other.

        Assumptions: case does not matter, whitespace does matter
     */

    public static boolean arePermutations(String input1, String input2) {
        // Idea: use one hashmap for first input, mapping characters to their frequencies
        //  ... then, when iterating through second input, decrement their frequencies

        HashMap<Character, Integer> charFrequencyMap = new HashMap<>();

        // keep track of frequency of characters of first input
        for (char c: input1.toCharArray()) {
            c = Character.toLowerCase(c); // see assumptions
            if (charFrequencyMap.containsKey(c)) {
                // increase frequency by 1
                charFrequencyMap.put(c, charFrequencyMap.get(c) + 1);
            } else {
                // new character, add to map
                charFrequencyMap.put(c, 1);
            }
        }

        // decrement frequencies depending on second input
        for (char c: input2.toCharArray()) {
            c = Character.toLowerCase(c); // see assumptions
            // case: if char is not in freqMap, then return false (character in second but not in first, or
            //  ... there is more of that character in second input but not in first)
            if (!charFrequencyMap.containsKey(c)) {
                return false;
            } else {
                // decrement frequency
                int newFrequency = charFrequencyMap.get(c) - 1;
                // remove the entry from map if frequency is 0
                if (newFrequency == 0) {
                    charFrequencyMap.remove(c);
                } else {
                    charFrequencyMap.put(c, newFrequency);
                }
            }
        }

        return true;
    }
}

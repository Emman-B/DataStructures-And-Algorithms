package com.github.emman_b.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// This class contains all problems involving removing duplicates
public class RemoveDuplicates {
    /* Problem Description:
        Create a new list from an existing unsorted list. This new list should not
        contain any duplicate elements.
     */

    public List<Integer> removeDuplicatesFromUnsorted(List<Integer> list) {
        HashSet<Integer> trackUniques = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int value: list) {
            // Only add the value to results if it's not in the HashSet
            if (!trackUniques.contains(value)) {
                trackUniques.add(value);
                result.add(value);
            }
        }

        return result;
    }
}

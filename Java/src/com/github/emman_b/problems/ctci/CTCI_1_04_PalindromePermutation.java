package com.github.emman_b.problems.ctci;

import java.util.HashSet;

public class CTCI_1_04_PalindromePermutation {
    /*
        Problem: Given a non-empty string, verify if it's a permutation of a palindrome. Only consider
        letters. Also, ignore casing as well.

        Example: "Tact Coa" --> permutation of "Taco cat" --> a palindrome "tac ocaT"
     */

    public static boolean isPalindromePermutation(String input) {
        /*
            Approach: Instead of testing for a palindrome (possibly using two pointers),
            test for the features of a palindrome.

            If we don't consider the order of the letters but consider the number of letters,
            a palindrome contains:
                1) zero or more letter frequencies that are even
                2) zero or one letter frequencies that are odd
                Example: "radar" --> (r, 2) (a, 2) (d, 1)
                    "taco cat" --> (t, 2) (a, 2) (c, 2) (o, 1)
                    "ABBA" --> (a, 2) (b, 2)

            Thus, we can easily test for the two cases.

            My approach is to maintain a HashSet for characters in the input and iterate through the input.
            - If a character is not in the set, add it to the set.
            - If a character is in the set, remove that item from the set. (This means characters that appear an even
              number of times will not be in the set after looping through the string).
            - If the set is empty or has 1 item, it is a palindrome. Otherwise, it is not a palindrome (since more than
              1 item means that there is more than 1 character that appears an odd number of times).
         */

        HashSet<Character> charFrequencies = new HashSet<>();

        for (char c: input.toCharArray()) {
            // ensure that we are only dealing with lowercase letters [a-z]
            c = Character.toLowerCase(c); // ignore case
            if (c < 'a' || c > 'z') continue; // ignore non-letters

            if (charFrequencies.contains(c)) {
                charFrequencies.remove(c);
            } else {
                charFrequencies.add(c);
            }
        }

        return charFrequencies.size() <= 1;
    }
}

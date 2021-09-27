package com.github.emman_b.problems.ctci;

public class CTCI_1_09_StringRotation {
    /*
        Problem: Assume that you have a method called isSubstring(substringQuery, string) (I will implement it with
        Java's contains() method). Given two strings, S1 and S2, write a function that verifies if S2 is a rotation of
        S1 using only one call to isSubstring.

        For example: "waterbottle" is a rotation of "erbottlewat"
     */

    private static boolean isSubstring(String substringQuery, String mainString) {
        return mainString.contains(substringQuery);
    }

    public static boolean isRotation(String s1, String s2) {
        /*
            Approach: An easy approach would be to have one string be appended to itself. Then,
            check if the other string in a substring of the doubled first string.
         */
        // Return false if strings differ in length
        if (s1.length() != s2.length()) return false;


        String doubledFirstString = s1 + s1;
        return isSubstring(s2, doubledFirstString);
    }
}

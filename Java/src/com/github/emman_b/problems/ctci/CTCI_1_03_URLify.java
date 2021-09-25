package com.github.emman_b.problems.ctci;

public class CTCI_1_03_URLify {
    /*
        Problem: Given a string with letters [a-z][A-Z] and spaces, convert the spaces into "%20" as
        it would be used for URLs. This needs to be done in-place.

        You will be given the string in the form of a character array. Since we are converting spaces to "%20",
        this character array will have extra space to support the extra characters. You will also be given the
        length of the actual string (not including the extra space).
     */
    public static void urlify(char[] input, int numChars) {
        /*
            Approach: Two pointers, one pointing to the end of the entire array and another pointing to the
            end of the string. I'll refer to these pointers as arrPtr and strPtr respectively.

            Then, iterate backwards from the array.
            If strPtr refers to an alphabetic character, set input[arrPtr] to input[strPtr].
            If strPtr refers to a space, we insert the "%20" like so:
                input[arrPtr--] = '0'
                input[arrPtr--] = '2'
                input[arrPtr] = '%'

            We can stop when strPtr and arrPtr are the same.
         */
        int arrPtr = input.length - 1;
        int strPtr = numChars - 1;

        while (arrPtr > strPtr && strPtr >= 0) {
            if (input[strPtr] != ' ') {
                // case: non-space, just move the character
                input[arrPtr] = input[strPtr];

                // move the pointers
                --arrPtr;
                --strPtr;
            } else {
                // case: space, insert "%20"
                input[arrPtr--] = '0';
                input[arrPtr--] = '2';
                input[arrPtr] = '%';

                // move the pointers
                --arrPtr;
                --strPtr;
            }
        }
    }
}

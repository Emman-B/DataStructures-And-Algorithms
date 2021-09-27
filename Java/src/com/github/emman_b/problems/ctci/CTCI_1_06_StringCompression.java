package com.github.emman_b.problems.ctci;

public class CTCI_1_06_StringCompression {
    /*
        Problem: Implement a basic string compression algorithm by counting repeated letters. An example of this
        would be the following: "aabcccccaaa" -> "a2b1c5a3". If the compressed string ends up being longer than
        the original string, just return the original string. An example of this would be:
        "HelloWorld"[10] -> "H1e1l2o1W1o1r1l1d1"[18]. You may assume that the string only has uppercase and
        lowercase letters [a-z][A-Z].
     */
    public static String compressString(String input) {
        /*
            Approach:
              - Maintain two variables: index of start of repeating characters and the character being repeated
                - idxStart and currentChar, respectively
              - Use a StringBuilder for efficient string building
              - Iterate through the whole string looking at every character.
              - Every new character (not matching currentChar) should result in currentChar and the # of times that
              character appears being appended to the string builder
              - The last iteration of the loop will not have the above step being done, so that should be done last
         */
        StringBuilder result = new StringBuilder();
        int start = 0;
        char current = '\0'; // default null

        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if (c != current) {
                // append to result
                if (current != '\0') {
                    result.append(current);
                    result.append(i - start);
                }
                start = i;
                current = c;
            }
        }

        // on final iteration, append the current character and its count to the result (only if current isn't null ptr)
        if (current != '\0') {
            result.append(current);
            result.append(input.length() - start);
        }

        // If the result is longer than the original, return the original instead
        if (result.length() > input.length()) {
            return input;
        }

        return result.toString();
    }
}

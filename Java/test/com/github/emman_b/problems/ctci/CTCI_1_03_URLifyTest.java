package com.github.emman_b.problems.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CTCI_1_03_URLifyTest {
    // Helper class and function for converting a string input to the proper parameters for the test
    class InputStruct {
        char[] inputArray;
        int numChars;
        public InputStruct(char[] inputArray, int numChars) {
            this.inputArray = inputArray;
            this.numChars = numChars;
        }
    }
    InputStruct generateInput(String input) {
        // count spaces in input
        int spaces = 0;
        for (char c: input.toCharArray()) {
            if (c == ' ') {
                ++spaces;
            }
        }

        // calculate extra space for char array
        int extraSpaces = spaces * 2;
        // create the char array with the extra space
        char[] arrayInput = new char[input.length() + extraSpaces];
        for (int i = 0; i < arrayInput.length; ++i) {
            if (i < input.length()) {
                // copy string until we reach end of string
                arrayInput[i] = input.charAt(i);
            } else {
                // if reaching end of string, just add spaces
                arrayInput[i] = ' ';
            }
        }
        return new InputStruct(arrayInput, input.length());
    }

    @Test
    void URLify_WithWordsAndSpaces_ShouldBeCorrect() {
        // Setup
        InputStruct inputStruct = generateInput("Mr John Smith");
        char[] input = inputStruct.inputArray; // this is to be converted to a String
        int numChars = inputStruct.numChars;
        String expected = "Mr%20John%20Smith";

        // Exercise
        CTCI_1_03_URLify.urlify(input, numChars);

        // Verify
        assertEquals(expected, new String(input));
    }
}
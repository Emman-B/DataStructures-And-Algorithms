package com.github.emman_b.problems.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CTCI_1_06_StringCompressionTest {
    @Test
    void StringCompress_WithLotsOfRepeatedCharacters_ShouldReturnCorrectCompressed() {
        // Setup
        String input = "aabcccccaaa";
        String expected = "a2b1c5a3";

        // Exercise
        String actualResult = CTCI_1_06_StringCompression.compressString(input);

        // Verify
        assertEquals(expected, actualResult);
    }

    @Test
    void StringCompress_WithFewRepeatedCharacters_ShouldReturnOriginal() {
        // Setup
        String input = "HelloWorld";
        String expected = "HelloWorld"; // The "compressed" string would be longer than the original, so we want
                                        // ... the original being returned

        // Exercise
        String actualResult = CTCI_1_06_StringCompression.compressString(input);

        // Verify
        assertEquals(expected, actualResult);
    }
}
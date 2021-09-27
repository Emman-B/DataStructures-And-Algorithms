package com.github.emman_b.problems.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CTCI_1_09_StringRotationTest {

    @Test
    void StringRotation_WithRotatedString_ShouldReturnTrue() {
        // Setup
        String original = "waterbottle";
        String rotated = "erbottlewat";

        // Exercise
        boolean result = CTCI_1_09_StringRotation.isRotation(original, rotated);

        // Verify
        assertTrue(result);
    }

    @Test
    void StringRotation_WithSameString_ShouldReturnTrue() {
        // Setup
        String original = "waterbottle";
        String rotated = "waterbottle";

        // Exercise
        boolean result = CTCI_1_09_StringRotation.isRotation(original, rotated);

        // Verify
        assertTrue(result);
    }

    @Test
    void StringRotation_WithDifferentStrings_ShouldReturnFalse() {
        // Setup
        String input = "helloworld";
        String input2 = "helloowrld";

        // Exercise
        boolean result = CTCI_1_09_StringRotation.isRotation(input, input2);

        // Verify
        assertFalse(result);
    }

    @Test
    void StringRotation_WithOneCharacterString_ShouldReturnTrue() {
        // Setup
        String original = "w";
        String rotated = "w";

        // Exercise
        boolean result = CTCI_1_09_StringRotation.isRotation(original, rotated);

        // Verify
        assertTrue(result);
    }
}
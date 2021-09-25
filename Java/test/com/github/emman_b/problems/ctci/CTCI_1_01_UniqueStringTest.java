package com.github.emman_b.problems.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CTCI_1_01_UniqueStringTest {
    @Test
    void UniqueString_WithNoCharacters_ShouldBeTrue() {
        // Setup
        String input = "";

        // Exercise
        boolean result = CTCI_1_01_UniqueString.stringHasUniqueCharacters(input);

        // Verify
        // We verify that the result is true since a string with no characters technically
        //  ... has no duplicate characters
        assertEquals(true, result);
    }

    @Test
    void UniqueString_WithOneCharacter_ShouldBeTrue() {
        // Setup
        String input = "X";

        // Exercise
        boolean result = CTCI_1_01_UniqueString.stringHasUniqueCharacters(input);

        // Verify
        assertEquals(true, result);
    }

    @Test
    void UniqueString_WithLongUniqueString_ShouldBeTrue() {
        // Setup
        String input = "hiworld";

        // Exercise
        boolean result = CTCI_1_01_UniqueString.stringHasUniqueCharacters(input);

        // Verify
        assertEquals(true, result);
    }

    @Test
    void UniqueString_WithLongStringWithDupes_ShouldBeFalse() {
        // Setup
        String input = "helloworld";

        // Exercise
        boolean result = CTCI_1_01_UniqueString.stringHasUniqueCharacters(input);

        // Verify
        assertEquals(false, result);
    }
}
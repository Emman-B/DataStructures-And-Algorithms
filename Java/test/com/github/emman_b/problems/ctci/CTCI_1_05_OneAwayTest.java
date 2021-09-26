package com.github.emman_b.problems.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CTCI_1_05_OneAwayTest {

    @Test
    void OneAway_WithOneMissingCharacter_ShouldReturnTrue() {
        // Setup
        String input1 = "pale";
        String input2 = "ple";

        // Exercise
        boolean result = CTCI_1_05_OneAway.isOneAway(input1, input2);

        // Verify
        assertTrue(result);
    }

    @Test
    void OneAway_WithOneMoreCharacter_ShouldReturnTrue() {
        // Setup
        String input1 = "pale";
        String input2 = "pales";

        // Exercise
        boolean result = CTCI_1_05_OneAway.isOneAway(input1, input2);

        // Verify
        assertTrue(result);
    }

    @Test
    void OneAway_WithOneChangedCharacter_ShouldReturnTrue() {
        // Setup
        String input1 = "pale";
        String input2 = "bale";

        // Exercise
        boolean result = CTCI_1_05_OneAway.isOneAway(input1, input2);

        // Verify
        assertTrue(result);
    }

    @Test
    void OneAway_WithTwoLessCharacters_ShouldReturnFalse() {
        // Setup
        String input1 = "pale";
        String input2 = "pa";

        // Exercise
        boolean result = CTCI_1_05_OneAway.isOneAway(input1, input2);

        // Verify
        assertFalse(result);
    }

    @Test
    void OneAway_WithTwoMoreCharacters_ShouldReturnFalse() {
        // Setup
        String input1 = "plan";
        String input2 = "planes";

        // Exercise
        boolean result = CTCI_1_05_OneAway.isOneAway(input1, input2);

        // Verify
        assertFalse(result);
    }

    @Test
    void OneAway_WithTwoChangedCharacters_ShouldReturnFalse() {
        // Setup
        String input1 = "pale";
        String input2 = "bake";

        // Exercise
        boolean result = CTCI_1_05_OneAway.isOneAway(input1, input2);

        // Verify
        assertFalse(result);
    }
}
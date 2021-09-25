package com.github.emman_b.problems.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CTCI_1_02_CheckPermutationTest {
    @Test
    void CheckPermutation_WithSameStrings_ShouldBeTrue() {
        // Setup
        String input1 = new String("hello");
        String input2 = new String("hello");

        // Exercise
        // using one string object for both parameters
        boolean sameParamResult = CTCI_1_02_CheckPermutation.arePermutations(input1, input1);
        // using two separate string objects with same content for both parameters
        boolean sameContentResult = CTCI_1_02_CheckPermutation.arePermutations(input1, input2);

        // Verify
        assertEquals(true, sameParamResult);
        assertEquals(true, sameContentResult);
    }

    @Test
    void CheckPermutation_WithSamePermutedString_ShouldBeTrue() {
        // Setup
        String input1 = new String("Hello");
        String input2 = new String("Ehlol");

        // Exercise
        boolean result = CTCI_1_02_CheckPermutation.arePermutations(input1, input2);

        // Verify
        assertEquals(true, result);
    }

    @Test
    void CheckPermutation_WithDifferentStrings_ShouldBeFalse() {
        // Setup
        String input1 = new String("Hello World");
        String input2 = new String("Hello Worlds");

        // Exercise
        boolean result = CTCI_1_02_CheckPermutation.arePermutations(input1, input2);

        // Verify
        assertEquals(false, result);
    }

    @Test
    void CheckPermutation_WithStringsDifferingByLength_ShouldBeFalse() {
        // Setup
        String input1 = new String("iiii");
        String input2 = new String("iiiii");

        // Exercise
        boolean result = CTCI_1_02_CheckPermutation.arePermutations(input1, input2);

        // Verify
        assertEquals(false, result);
    }

    @Test
    void CheckPermutation_WithStringsOfOneDifferingCharacter_ShouldBeFalse() {
        // Setup
        String input1 = new String("i");
        String input2 = new String("j");

        // Exercise
        boolean result = CTCI_1_02_CheckPermutation.arePermutations(input1, input2);

        // Verify
        assertEquals(false, result);
    }
}
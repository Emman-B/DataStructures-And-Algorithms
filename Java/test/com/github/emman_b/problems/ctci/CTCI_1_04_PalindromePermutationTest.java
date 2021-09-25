package com.github.emman_b.problems.ctci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CTCI_1_04_PalindromePermutationTest {

    @Test
    void PalindromePermutation_WithNormalPalindrome_ShouldReturnTrue() {
        // Setup
        String input = "Taco cat";

        // Exercise
        boolean result = CTCI_1_04_PalindromePermutation.isPalindromePermutation(input);

        // Verify
        assertTrue(result);
    }

    @Test
    void PalindromePermutation_WithNormalPalindrome2_ShouldReturnTrue() {
        // Setup
        String input = "radar";

        // Exercise
        boolean result = CTCI_1_04_PalindromePermutation.isPalindromePermutation(input);

        // Verify
        assertTrue(result);
    }

    @Test
    void PalindromePermutation_WithPermutationOfPalindrome_ShouldReturnTrue() {
        // Setup
        String input = "atco cta";

        // Exercise
        boolean result = CTCI_1_04_PalindromePermutation.isPalindromePermutation(input);

        // Verify
        assertTrue(result);
    }

    @Test
    void PalindromePermutation_WithPermutationOfPalindrome2_ShouldReturnTrue() {
        // Setup
        String input = "Tact Coa";

        // Exercise
        boolean result = CTCI_1_04_PalindromePermutation.isPalindromePermutation(input);

        // Verify
        assertTrue(result);
    }

    @Test
    void PalindromePermutation_WithPermutationOfPalindrome3_ShouldReturnTrue() {
        // Setup
        String input = "daarr"; // radar

        // Exercise
        boolean result = CTCI_1_04_PalindromePermutation.isPalindromePermutation(input);

        // Verify
        assertTrue(result);
    }

    @Test
    void PalindromePermutation_WithInvalidPalindrome_ShouldReturnFalse() {
        // Setup
        String input = "Taco cats";

        // Exercise
        boolean result = CTCI_1_04_PalindromePermutation.isPalindromePermutation(input);

        // Verify
        assertFalse(result);
    }

    @Test
    void PalindromePermutation_WithInvalidPalindrome2_ShouldReturnFalse() {
        // Setup
        String input = "ditto";

        // Exercise
        boolean result = CTCI_1_04_PalindromePermutation.isPalindromePermutation(input);

        // Verify
        assertFalse(result);
    }
}
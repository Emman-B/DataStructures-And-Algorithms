package com.github.emman_b.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedParenthesesTest {
    BalancedParentheses bp = new BalancedParentheses();

    @Test
    void BalancedParentheses_WithOneSetOfParentheses_ShouldReturnTrue() {
        String input = "()";

        assertTrue(bp.isParenthesesBalanced(input));
    }

    @Test
    void BalancedParentheses_WithSingleParenthesis_ShouldReturnFalse() {
        String input1 = "(";
        String input2 = ")";

        assertFalse(bp.isParenthesesBalanced(input1));
        assertFalse(bp.isParenthesesBalanced(input2));
    }

    @Test
    void BalancedParentheses_WithOneSetOfParenthesesBackwards_ShouldReturnFalse() {
        String input = ")(";

        assertFalse(bp.isParenthesesBalanced(input));
    }

    @Test
    void BalancedParentheses_WithValidAdjacentSetsOfParentheses_ShouldReturnTrue() {
        String input = "()()";

        assertTrue(bp.isParenthesesBalanced(input));
    }

    @Test
    void BalancedParentheses_WithValidNestedParentheses_ShouldReturnTrue() {
        String input = "(()())";

        assertTrue(bp.isParenthesesBalanced(input));
    }

    @Test
    void BalancedParentheses_WithInvalidNestedParentheses_ShouldReturnTrue() {
        String input = "(()()))";

        assertFalse(bp.isParenthesesBalanced(input));
    }
}
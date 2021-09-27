package com.github.emman_b.problems.ctci;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CTCI_1_08_ZeroMatrixTest {
    /**
     * Copies a 2D matrix (i.e., a 2D integer array)
     * @param input 2D matrix to copy
     * @return a copy of the 2D matrix
     */
    int[][] copyMatrix(int[][] input) {
        if (input.length == 0) return null;

        int[][] copy = new int[input.length][input[0].length];

        for (int i = 0; i < input.length; ++i) {
            for (int j = 0; j < input[0].length; ++j) {
                copy[i][j] = input[i][j];
            }
        }

        return copy;
    }

    @Test
    void ZeroMatrix_WithMatrixWithoutZeros_ShouldReturnSameMatrix() {
        // Setup
        int[][] original = new int[][] {
                {1, 2, 4, 5},
                {2, 9, 12, 11}
        };
        int[][] input = copyMatrix(original); // make a copy of the original matrix for comparison

        // Exercise
        CTCI_1_08_ZeroMatrix.zeroMatrix(input);

        // Verify: compare the input with the original
        assertTrue(Arrays.deepEquals(original, input));
    }

    @Test
    void ZeroMatrix_WithSomeZeroes_ShouldReturnCorrectMatrix() {
        // Setup
        int[][] input = new int[][] {
                {1,  2,  4,  5},
                {2,  9,  0,  11},
                {0,  7,  4,  2},
                {8,  27, 17, 0},
                {56, 1,  2,  3}
        };
        int[][] expected = new int[][] {
                {0,  2,  0,  0},
                {0,  0,  0,  0},
                {0,  0,  0,  0},
                {0,  0,  0,  0},
                {0,  1,  0,  0}
        };

        // Exercise
        CTCI_1_08_ZeroMatrix.zeroMatrix(input);

        // Verify
        assertTrue(Arrays.deepEquals(expected, input));
    }

    @Test
    void ZeroMatrix_WithAllZeroes_ShouldReturnCorrectMatrix() {
        // Setup
        int[][] input = new int[][] {
                {0,  0,  0,  0},
                {0,  0,  0,  0},
                {0,  0,  0,  0},
                {0,  0,  0,  0},
                {0,  0,  0,  0}
        };
        int[][] expected = copyMatrix(input);

        // Exercise
        CTCI_1_08_ZeroMatrix.zeroMatrix(input);

        // Verify
        assertTrue(Arrays.deepEquals(expected, input));
    }

    @Test
    void ZeroMatrix_WithOneRowMatrixAndNoZeroes_ShouldReturnCorrectMatrix() {
        // Setup
        int[][] input = new int[][] {
                {5, 2, 8, 7, 9, 1}
        };
        int[][] expected = copyMatrix(input);

        // Exercise
        CTCI_1_08_ZeroMatrix.zeroMatrix(input);

        // Verify
        assertTrue(Arrays.deepEquals(expected, input));
    }

    @Test
    void ZeroMatrix_WithOneRowMatrixAndSomeZeroes_ShouldReturnCorrectMatrix() {
        // Setup
        int[][] input = new int[][] {
                {5, 0, 8, 7, 0, 1}
        };
        int[][] expected = new int[][] {
                {0, 0, 0, 0, 0, 0}
        };

        // Exercise
        CTCI_1_08_ZeroMatrix.zeroMatrix(input);

        // Verify
        assertTrue(Arrays.deepEquals(expected, input));
    }

    @Test
    void ZeroMatrix_WithOneColumnMatrixAndNoZeroes_ShouldReturnCorrectMatrix() {
        // Setup
        int[][] input = new int[][] {
                {5},
                {2},
                {8},
                {7},
                {9}
        };
        int[][] expected = copyMatrix(input);

        // Exercise
        CTCI_1_08_ZeroMatrix.zeroMatrix(input);

        // Verify
        assertTrue(Arrays.deepEquals(expected, input));
    }

    @Test
    void ZeroMatrix_WithOneColumnMatrixAndSomeZeroes_ShouldReturnCorrectMatrix() {
        // Setup
        int[][] input = new int[][] {
                {0},
                {0},
                {8},
                {7},
                {9}
        };
        int[][] expected = new int[][] {
                {0},
                {0},
                {0},
                {0},
                {0}
        };

        // Exercise
        CTCI_1_08_ZeroMatrix.zeroMatrix(input);

        // Verify
        assertTrue(Arrays.deepEquals(expected, input));
    }
}
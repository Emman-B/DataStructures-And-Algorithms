package com.github.emman_b.problems.ctci;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CTCI_1_07_RotateMatrixTest {

    @Test
    void RotateMatrix_With1x1Matrix_ShouldProduceCorrectRotation() {
        // Setup
        int[][] input = new int[][] { { 1 } };
        int[][] expected = new int[][] { { 1 } };

        // Exercise
        CTCI_1_07_RotateMatrix.rotateMatrix(input); // rotation done in place

        // Verify
        boolean isEqual = Arrays.deepEquals(expected, input);
        assertTrue(isEqual);
    }

    @Test
    void RotateMatrix_With2x2Matrix_ShouldProduceCorrectRotation() {
        // Setup
        int[][] input = new int[][] {
                { 1, 2 },
                { 3, 4 }
        };
        int[][] expected = new int[][] {
                { 3, 1 },
                { 4, 2 }
        };

        // Exercise
        CTCI_1_07_RotateMatrix.rotateMatrix(input); // rotation done in place

        // Verify
        boolean isEqual = Arrays.deepEquals(expected, input);
        assertTrue(isEqual);
    }

    @Test
    void RotateMatrix_With3x3Matrix_ShouldProduceCorrectRotation() {
        // Setup
        int[][] input = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[][] expected = new int[][] {
                { 7, 4, 1 },
                { 8, 5, 2 },
                { 9, 6, 3 }
        };

        // Exercise
        CTCI_1_07_RotateMatrix.rotateMatrix(input); // rotation done in place

        // Verify
        boolean isEqual = Arrays.deepEquals(expected, input);
        assertTrue(isEqual);
    }

    @Test
    void RotateMatrix_With4x4Matrix_ShouldProduceCorrectRotation() {
        // Setup
        int[][] input = new int[][] {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 }
        };
        int[][] expected = new int[][] {
                { 15, 13, 2, 5 },
                { 14, 3, 4, 1 },
                { 12, 6, 8, 9 },
                { 16, 7, 10, 11 }
        };

        // Exercise
        CTCI_1_07_RotateMatrix.rotateMatrix(input); // rotation done in place

        // Verify
        boolean isEqual = Arrays.deepEquals(expected, input);
        assertTrue(isEqual);
    }
}
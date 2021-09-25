package com.github.emman_b.problems.ctci;

public class CTCI_1_07_RotateMatrix {
    /*
        Problem: You have an N x N matrix. Rotate the matrix 90 degrees clockwise.
        Try to complete this in place while allocating O(1) space (so no
        extra matrix).
     */

    public static void rotateMatrix(int[][] matrix) {
        /*
            Solution: Do rotations four cells at a time. This ensures we remain with O(1) space.

            Example of rotation order (matching cells are the four cells being rotated per iteration):
            A1  A2  A3  A1
            A3  B1  B1  A2
            A2  B1  B1  A3
            A1  A3  A2  A1

            We want to iterate from outer rings to inner rings. The letters represent these
            rings. The numbers are the iteration within rings.
         */

        // Rotate the border squares
        int size = matrix.length;
        // looping to go from outer ring to inner rings
        for (int r = 0; r < size / 2; ++r) {
            // looping within rings
            for (int c = r; c < size - 1 - r; ++c) {
                int first = matrix[r][c];
                int second = matrix[c][size - 1 - r];
                int third = matrix[size - 1 - r][size - 1 - c];
                int fourth = matrix[size - 1 - c][r];

                matrix[r][c] = fourth;
                matrix[c][size - 1 - r] = first;
                matrix[size - 1 - r][size - 1 - c] = second;
                matrix[size - 1 - c][r] = third;
            }
        }
    }
}

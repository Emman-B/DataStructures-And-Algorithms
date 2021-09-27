package com.github.emman_b.problems.ctci;

public class CTCI_1_08_ZeroMatrix {
    /*
        Problem: Given an M x N matrix, write a function where any zero in the matrix results in the corresponding
        row and column being zero. The matrix should be modified in-place (i.e., the function does not return a value).

        Follow Up: Use only O(1) additional space.
     */

    public static void zeroMatrix(int[][] matrix) {
        /*
            Approach:
              - Find all zeros first before zeroing the matrix (otherwise, you end up with a completely zeroed matrix)
              - Store the indices of rows and columns to zero out later.
              - For Follow Up: Instead of using additional arrays to store indices of rows and columns to zero out,
                    use the first row and column for storage. (e.g., if matrix[5][7] has a zero, store the following:
                    matrix[5][0] = 0, matrix[0][7] = 0).
                    - Then, iterate through the columns of the first row to find columns to zero out.
                      and iterate through the rows of the first column to find rows to zero out.
                    - There is a problem with this, though. With this method as it is, we would not really know if we
                      need to zero out the first row or first column.
                    - Use two booleans to check if we need to zero out the first row and first column. Then, after
                      zeroing out all the other rows and columns, use the booleans to test whether we need to zero
                      out the first row and/or first column.
         */

        // Error check, if matrix length is 0 then do nothing
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        // verify if zeroing out the first row or column is necessary
        boolean zeroFirstRow = false, zeroFirstColumn = false;
        // check first row
        for (int col = 0; col < matrix[0].length; ++col) {
            if (matrix[0][col] == 0) {
                zeroFirstRow = true;
                break;
            }
        }
        // check first column
        for (int row = 0; row < matrix.length; ++row) {
            if (matrix[row][0] == 0) {
                zeroFirstColumn = true;
                break;
            }
        }

        // Now, we can check the rest of the matrix
        for (int row = 1; row < matrix.length; ++row) {
            for (int col = 1; col < matrix[row].length; ++col) {
                int current = matrix[row][col];

                // if current number is 0, update the first row and column, setting the current's corresponding row
                //  ... and column to 0
                if (current == 0) {
                    matrix[0][col] = 0; // first row
                    matrix[row][0] = 0; // first col
                }
            }
        }

        // Now, check the first row and zero out the columns as needed
        for (int col = 1; col < matrix[0].length; ++col) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < matrix.length; ++row) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Now, check the first column and zero out the rows as needed
        for (int row = 1; row < matrix.length; ++row) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < matrix[0].length; ++col) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Finally, if we need to zero out the first row, do that
        if (zeroFirstRow) {
            for (int col = 0; col < matrix[0].length; ++col) {
                matrix[0][col] = 0;
            }
        }
        // Same with the first column, zero it out if necessary
        if (zeroFirstColumn) {
            for (int row = 0; row < matrix.length; ++row) {
                matrix[row][0] = 0;
            }
        }

        // We are done at this stage since we are updating the matrix in place
    }
}

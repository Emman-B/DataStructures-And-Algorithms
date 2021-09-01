package com.github.emman_b;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    @Test
    void MergeSort_WithNonEmptyEvenSizedArray_ShouldSort() {
        // create the data to sort
        Integer[] data = new Integer[] { 2, 4, 3, 1 };

        // sort the data
        MergeSort.sort(data);

        // create the expected data
        Integer[] expected = new Integer[] { 1, 2, 3, 4 };

        // expect the data to be sorted
        assertArrayEquals(expected, data);
    }

    @Test
    void MergeSort_WithNonEmptyOddSizedArray_ShouldSort() {
        // create the data to sort
        Integer[] data = new Integer[] { 2, 4, 5, 3, 1 };

        // sort the data
        MergeSort.sort(data);

        // create the expected data
        Integer[] expected = new Integer[] { 1, 2, 3, 4, 5};

        // expect the data to be sorted
        assertArrayEquals(expected, data);
    }

    @Test
    void MergeSort_WithEmptyArray_ShouldSort() {
        // create empty array
        Integer[] data = new Integer[0];

        // sort the data
        MergeSort.sort(data);

        // expect the array to still be empty
        assertArrayEquals(new Integer[0], data);
    }

    @Test
    void MergeSort_WithOneItemArray_ShouldSort() {
        // create array with 1 element
        Integer[] data = new Integer[] { 5 };

        // sort the data
        MergeSort.sort(data);

        // expect the array to contain that same element
        assertArrayEquals(new Integer[] { 5 }, data);
    }

    @Test
    void MergeSort_WithTwoItemArray_ShouldSort() {
        // create array with 2 elements
        Integer[] data = new Integer[] { 4, 2 };

        // sort the data
        MergeSort.sort(data);

        // expect the array to be sorted
        assertArrayEquals(data, new Integer[] { 2, 4 });
    }
}
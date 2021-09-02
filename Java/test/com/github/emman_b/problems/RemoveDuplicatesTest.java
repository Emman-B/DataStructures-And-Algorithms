package com.github.emman_b.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    @Test
    void RemoveDuplicates_WithUnsortedListOfOneItem_ShouldHaveDuplicatesRemoved() {
        List<Integer> input = new ArrayList<>();
        input.add(5);

        List<Integer> expected = new ArrayList<>();
        expected.add(5);

        assertArrayEquals(expected.toArray(), new RemoveDuplicates().removeDuplicatesFromUnsorted(input).toArray());
    }
    @Test
    void RemoveDuplicates_WithUnsortedList_ShouldHaveDuplicatesRemoved() {
        // provide input values
        List<Integer> input = new ArrayList<>();
        input.add(5);
        input.add(-2); // dupe, kept
        input.add(1);
        input.add(-5); // dupe, kept
        input.add(-2); // dupe, removed
        input.add(8);
        input.add(-5); // dupe, removed

        // create expected list
        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(-2);
        expected.add(1);
        expected.add(-5);
        expected.add(8);

        // test the remove-duplicates function
        assertArrayEquals(expected.toArray(), new RemoveDuplicates().removeDuplicatesFromUnsorted(input).toArray());
    }
}
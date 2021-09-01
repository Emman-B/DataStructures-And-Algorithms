package com.github.emman_b;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {
    // Test cases
    @Test
    void ArrayWithNoElements_WhenGettingAtIndex_ShouldReturnNull() {
        // create the array
        Array<Integer> array = new Array<>(5);

        // try to get an element
        assertNull(array.get(0));
    }

    @Test
    void ArrayWithOneElement_WhenAddingAnElement_ShouldHaveElementStored() {
        // create the array
        Array<String> array = new Array<>(5);

        // add an element
        array.set(3, "Hello world!");

        // check to see if it is stored correctly
        assertEquals("Hello world!", array.get(3));
    }

    @Test
    void ArrayWithTwoElements_WhenRetrievingBothElements_ShouldBeStoredCorrectly() {
        // create the array
        Array<String> array = new Array<>(5);

        // add both elements
        array.set(1, "Hello");
        array.set(3, "World");

        // verify that both elements have been added and stored
        assertEquals("Hello", array.get(1));
        assertEquals("World", array.get(3));
    }

    // Error cases
    @Test
    void Array_WhenConstructingWithInvalidSize_ShouldThrowError() {
        // Check to see if constructing Array of invalid size throws error
        assertThrows(IllegalArgumentException.class, () -> new Array<Integer>(-1));
    }

    @Test
    void Array_WhenGettingAtInvalidIndex_ShouldThrowError() {
        // make an array
        Array<Object> array = new Array<>(15);

        // expect an error if accessing at a negative index
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(-1));

        // expect an error if accessing at an index outside of the bounds of the array
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(30));
    }
}
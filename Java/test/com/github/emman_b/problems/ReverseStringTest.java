package com.github.emman_b.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseStringTest {

    @Test
    void ReverseString_WithShortString_ShouldReverseString() {
        String input = "hello world";

        String expected = "dlrow olleh";

        assertEquals(expected, new ReverseString().reverseString(input));
    }

    @Test
    void ReverseString_WithLongerString_ShouldReverseString() {
        String input = "The quick brown fox jumps over the lazy dog. Did the quick brown fox jump over the lazy dog?";

        String expected = "?god yzal eht revo pmuj xof nworb kciuq eht diD .god yzal eht revo spmuj xof nworb kciuq ehT";

        assertEquals(expected, new ReverseString().reverseString(input));
    }
}
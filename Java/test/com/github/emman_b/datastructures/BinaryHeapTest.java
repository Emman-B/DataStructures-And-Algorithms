package com.github.emman_b.datastructures;

import com.github.emman_b.datastructures.BinaryHeap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {
    @Test
    void BinaryMaxHeap_WhenPeekingHeapWithTwoElements_ShouldPeekTopCorrectly() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();

        heap.insert(20);
        heap.insert(50);

        assertEquals(50, heap.peekTop());
    }

    @Test
    void BinaryMinHeap_WhenPeekingHeapWithTwoElements_ShouldPeekTopCorrectly() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(true);

        heap.insert(50);
        heap.insert(20);

        assertEquals(20, heap.peekTop());
    }

    @Test
    void BinaryMaxHeap_WithLotsOfInsertedElements_ShouldPopMax() {
        BinaryHeap<Integer> heap = new BinaryHeap<>();

        heap.insert(89);
        heap.insert(11);
        heap.insert(19);
        heap.insert(84);
        heap.insert(80);
        heap.insert(88);
        heap.insert(97);
        heap.insert(46);
        heap.insert(81);
        heap.insert(16);

        assertEquals(97, heap.popTop());
        assertEquals(89, heap.popTop());
        assertEquals(88, heap.popTop());
        assertEquals(84, heap.popTop());
        assertEquals(81, heap.popTop());
        assertEquals(80, heap.popTop());
        assertEquals(46, heap.popTop());
        assertEquals(19, heap.popTop());
        assertEquals(16, heap.popTop());
        assertEquals(11, heap.popTop());
    }

    @Test
    void BinaryMinHeap_WithLotsOfInsertedElements_ShouldPopMax() {
        BinaryHeap<Integer> heap = new BinaryHeap<>(true);

        heap.insert(89);
        heap.insert(11);
        heap.insert(19);
        heap.insert(84);
        heap.insert(80);
        heap.insert(88);
        heap.insert(97);
        heap.insert(46);
        heap.insert(81);
        heap.insert(16);

        assertEquals(11, heap.popTop());
        assertEquals(16, heap.popTop());
        assertEquals(19, heap.popTop());
        assertEquals(46, heap.popTop());
        assertEquals(80, heap.popTop());
        assertEquals(81, heap.popTop());
        assertEquals(84, heap.popTop());
        assertEquals(88, heap.popTop());
        assertEquals(89, heap.popTop());
        assertEquals(97, heap.popTop());
    }
}
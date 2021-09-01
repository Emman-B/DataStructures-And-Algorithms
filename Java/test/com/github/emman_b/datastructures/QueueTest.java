package com.github.emman_b.datastructures;

import com.github.emman_b.datastructures.Queue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void EmptyQueue_ShouldReturnNull() {
        // create the empty queue
        Queue<Integer> queue = new Queue<>();

        // assert that the front is null
        assertNull(queue.front());
    }

    @Test
    void Queue_WithOneItemQueued_ShouldHaveItemStored() {
        // create the queue
        Queue<String> queue = new Queue<>();

        // create and enqueue the test data
        String expected = "Hello world!";
        queue.enqueue(expected);

        // verify that the data is equal
        assertEquals(expected, queue.front());
    }

    @Test
    void Queue_WithThreeItemsStored_ShouldHaveAllItemsStoredInOrder() {
        // create the queue
        Queue<Integer> queue = new Queue<>();

        // create the test data
        queue.enqueue(1);
        queue.enqueue(0);
        queue.enqueue(2);

        // retrieve the test data by dequeue-ing
        int one = queue.dequeue();
        int zero = queue.dequeue();
        int two = queue.dequeue();

        // verify the data is equal
        assertEquals(one, 1);
        assertEquals(zero, 0);
        assertEquals(two, 2);
    }
}
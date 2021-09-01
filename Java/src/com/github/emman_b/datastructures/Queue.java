package com.github.emman_b.datastructures;

import com.github.emman_b.Collections;

public class Queue <T> extends Collections {
    // fields
    private DoublyLinkedList<T> data;

    // constructors

    /**
     * initializes the data
     */
    public Queue() {
        data = new DoublyLinkedList<>();
    }

    // lookup methods

    /**
     * Retrieves the size of the queue
     * @return the size of the queue
     */
    public int size() {
        return data.size();
    }

    // retrieves the value at the front of the queue

    /**
     * Retrieves the item at the front of the queue
     * @return the item at the front of the queue
     */
    public T front() {
        if (size() == 0) {
            return null;
        }
        return data.get(0);
    }

    // manipulation methods

    /**
     * Pushes the value to the back of the queue
     * @param value value to push to the back of the queue
     */
    public void enqueue(T value) {
        data.pushBack(value);
    }

    /**
     * Removes the item from the front of the queue and returns it
     * @return the item that was removed from the front of the queue
     */
    public T dequeue() {
        return data.popFront();
    }

    /**
     * Turns the queue into an object array. It is ordered by how it was dequeued from the queue.
     * @return the object array
     */
    @Override
    public Object[] toObjectArray() {
        int size = size();

        Object[] result = new Object[size];

        for (int i = 0; i < size; ++i) {
            T data = dequeue();
            result[i] = data;
            enqueue(data); // re-queue the data
        }

        return result;
    }
}

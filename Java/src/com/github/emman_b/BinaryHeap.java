package com.github.emman_b;

import java.util.ArrayList;

public class BinaryHeap<T extends Comparable<T>> {
    // Fields
    /**
     * Represent the heap as an array.
     * For some item index i,
     *      its parent has indices:     Floor((i - 1) / 2)
     *      its children have indices:  2i + 1 and 2i + 2
     */
    private final ArrayList<T> data;
    private boolean isMinHeap;

    // Constructors

    /**
     * Creates a default binary max heap
     */
    public BinaryHeap() {
        data = new ArrayList<>();
        isMinHeap = false;
    }

    /**
     * Creates a binary heap that can be either a min heap or max heap
     */
    public BinaryHeap(boolean isMinHeap) {
        this();
        this.isMinHeap = isMinHeap;
    }

    // Access Methods

    /**
     * Retrieves the max|min element of the heap without modification
     * @return the max|min element of the heap
     */
    public T peekTop() {
        return data.get(0);
    }

    /**
     * Makes a copy of the data in the heap as an ArrayList
     * @return copy of data
     */
    public ArrayList<T> getCopyOfData() {
        return new ArrayList<>(data);
    }

    // Manipulation Methods

    /**
     * Inserts a new value into the heap while maintaining the heap property
     * @param value the value to be inserted
     */
    public void insert (T value) {
        // add value
        data.add(value);

        // maintain heap property by checking parents
        int currentIndex = data.size() - 1;

        // loop until currentIndex reaches the top of the heap (it may break sooner)
        while (currentIndex > 0) {
            // get parent index and value
            int currentParentIndex = (currentIndex - 1) / 2;
            T currentParentValue = data.get(currentParentIndex);

            // if current value is larger/smaller than parent (depending on max/min heap), make the swap
            if ((value.compareTo(currentParentValue) > 0 && !isMinHeap) ||
                    (value.compareTo(currentParentValue) < 0 && isMinHeap)) {
                data.set(currentIndex, currentParentValue);
                data.set(currentParentIndex, value);

                // set the current index to be the index that was just swapped with
                currentIndex = currentParentIndex;
            } else {
                // otherwise, stop swapping
                break;
            }
        }
    }

    /**
     * Removes the max|min value and maintains the heap property.
     * @return The value that was removed
     */
    public T popTop() {
        T max = data.get(0);

        // swap the max index with the last inserted item, and remove it
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);

        // if the heap becomes empty, leave the function
        if (data.size() == 0) {
            return max;
        }

        // start moving this item down
        int currentIndex = 0;
        T currentValue = data.get(currentIndex);
        // loop will break when there is no more need to swap
        while (true) {
            // calculate indices
            int leftChildIndex = (2 * currentIndex) + 1;
            int rightChildIndex = (2 * currentIndex) + 2;

            boolean hasLeftChild = leftChildIndex < data.size();
            boolean hasRightChild = rightChildIndex < data.size();

            // no children, so we break out of loop
            if (!hasLeftChild) {
                break;
            }


            // get values
            T leftChildValue = data.get(leftChildIndex);
            T rightChildValue = hasRightChild?data.get(rightChildIndex):null; // may be null or not null

            // case: no right child, so just look at left child for switching
            if (!hasRightChild) {
                // swap with left child if self is smaller (max heap) or larger (min heap)
                if ((currentValue.compareTo(leftChildValue) < 0 && !isMinHeap) ||
                        (currentValue.compareTo(leftChildValue) > 0 && isMinHeap)) {
                    // swap
                    data.set(leftChildIndex, currentValue);
                    data.set(currentIndex, leftChildValue);
                    // move the current index
                    currentIndex = leftChildIndex;
                } else {
                    // we're in the correct position, so leave loop
                    break;
                }
            } else {
                // case: both children are there, check whether to swap with left, or right, or maybe neither

                if ((!isMinHeap && currentValue.compareTo(leftChildValue) > 0 && currentValue.compareTo(rightChildValue) > 0) ||
                        (isMinHeap && currentValue.compareTo(leftChildValue) < 0 && currentValue.compareTo(rightChildValue) < 0)) {
                    // case: don't swap since current value is larger (max heap) or smaller (min heap) than children
                    break;
                } else {
                    // case: swap with the larger child
                    if ((leftChildValue.compareTo(rightChildValue) > 0 && !isMinHeap) ||
                            (leftChildValue.compareTo(rightChildValue) < 0 && isMinHeap)) {
                        // case: left child is larger (swap with left)
                        data.set(currentIndex, leftChildValue);
                        data.set(leftChildIndex, currentValue);

                        currentIndex = leftChildIndex;
                    } else {
                        // case: right child is larger (swap with right)
                        data.set(currentIndex, rightChildValue);
                        data.set(rightChildIndex, currentValue);

                        currentIndex = rightChildIndex;
                    }
                }
            }
        }

        return max;
    }
}

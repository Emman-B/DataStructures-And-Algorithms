package com.github.emman_b;

public abstract class Collections {
    /**
     * Validates the index in methods that take in an index
     * @param index the index to check
     */
    protected void validateIndex(int index, int collectionLength) {
        // if the index is invalid, throw an error
        if (index >= collectionLength || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        // otherwise, return true
    }

    /**
     * Turns the collection into an object array
     * @return the object array
     */
    public abstract Object[] toObjectArray();
}

package com.github.emman_b;

public class Array <T> extends Collections {
    // Fields
    private final Object[] collection;

    // Constructors

    /**
     * Constructs a new array of a defined size.
     * @param size number of elements for array to hold
     */
    public Array(int size) {
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        collection = new Object[size];
    }

    // Access Methods

    /**
     * Retrieves the length of the array (not necessarily the number of elements
     * in it).
     * @return returns the length of the string
     */
    public int length() {
        return collection.length;
    }

    /**
     * Retrieves an item at an index
     * @param index the index of the item
     * @return the item at the index
     */
    public T get(int index) {
        // validate the index
        validateIndex(index, collection.length);

        // otherwise, return the item at that index casted from Object to T
        return (T) collection[index];
    }

    /**
     * Copies the collection into another array
     * @return a copy of the collection
     */
    @Override
    public Object[] toObjectArray() {
        Object[] copyOfData = new Object[collection.length];
        int index = 0; // used for inserting into the data copy
        for (Object data: collection) {
            copyOfData[index++] = data;
        }
        return copyOfData;
    }

    // Modification Methods
    /**
     * Stores item into collection at a specified index
     * @param index the index to store a value into
     * @param item the value to store
     */
    public void set(int index, T item) {
        // validate the index
        validateIndex(index, collection.length);

        // set the item at this index
        collection[index] = item;
    }
}

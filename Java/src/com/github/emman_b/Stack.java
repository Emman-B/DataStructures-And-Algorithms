package com.github.emman_b;

public class Stack <T> extends Collections {
    // Fields
    private DoublyLinkedList<T> data;

    // Constructors

    /**
     * constructs an empty stack
     */
    public Stack() {
        data = new DoublyLinkedList<>();
    }

    // Access Methods

    /**
     * Gets the size of stack
     * @return the size of the stack
     */
    public int size() {
        return data.size();
    }

    /**
     * Looks at the top of the stack and returns the item
     * @return the item at the top of the stack without modifying the stack, or null if empty
     */
    public T peek() {
        if (data.size() == 0) {
            return null;
        }
        return data.get(data.size() - 1);
    }

    // Modification Methods

    /**
     * Pushes item to the top of the stack
     * @param item the item to push onto the stack
     */
    public void push(T item) {
        data.pushBack(item);
    }

    /**
     * Removes the item at the top of the stack and returns it
     * @return the item at the top of the stack that was removed
     */
    public T pop() {
        return data.popBack();
    }

    /**
     * Turns the stack into an object array. It is ordered by how it was popped from the stack.
     * @return the object array containing the items from the stack
     */
    @Override
    public Object[] toObjectArray() {
        // temporary stack for storing items
        Stack<T> temporary = new Stack<>();
        int size = size();
        Object[] result = new Object[size];

        for (int i = 0; i < size; ++i) {
            temporary.push(pop());
            result[i] = temporary.peek();
        }

        // put the items back onto the stack
        for (int i = 0; i < size; ++i) {
            push(temporary.pop());
        }

        return result;
    }
}

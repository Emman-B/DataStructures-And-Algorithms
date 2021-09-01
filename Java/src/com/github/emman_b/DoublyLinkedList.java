package com.github.emman_b;

import jdk.jshell.spi.ExecutionControl;

/**
 * This implementation of a doubly linked list has a head and tail that are not
 * considered part of the list.
 * @param <T> data type of list
 */
public class DoublyLinkedList <T> extends Collections{
    /**
     * Inner class for the nodes of the linked list
     */
    class ListNode {
        // Fields
        T data;         // data to be stored in node
        ListNode next;  // next node in list
        ListNode prev;  // previous node in list
        // Constructors
        ListNode() {
            // all values should be null
        }
        ListNode(T data) {
            this.data = data;
        }
    }

    // Fields
    private final ListNode head;
    private final ListNode tail;

    // Constructors
    DoublyLinkedList() {
        // initialize the head and tail
        head = new ListNode();
        tail = new ListNode();

        // let them point to each other
        head.next = tail;
        tail.prev = head;
    }

    // Access Methods

    /**
     * Returns the size of the list
     * @return size of the list
     */
    public int size() {
        // iterate through list
        ListNode iterator = head.next;

        // loop while maintaining count of elements
        int count = 0;
        while (iterator != tail) {
            ++count;
            iterator = iterator.next;
        }

        // return the count
        return count;
    }

    /**
     * Turns the DLL into an Object array
     * @return
     */
    @Override
    public Object[] toObjectArray() {
        // empty list case
        if (size() == 0) {
            return new Object[0];
        }

        // then, loop through the list using a ListNode as an iterator
        ListNode current = head.next;
        Object[] result = new Object[size()];
        int index = 0;
        while (current != tail) {
            result[index++] = current.data;
            current = current.next;
        }

        return result;
    }

    /**
     * Gets the item at the index of the list
     * @param index the index of the item
     * @return the item at the index
     */
    public T get(int index) {
        // validate index
        validateIndex(index, size());

        // figure out whether to start at the head of list or tail of list
        // by using the index in comparison to the size of list

        // if index is less than half the size, start from the head of the list
        if (index < size() / 2) {
            return getNodeStartingAtHead(index).data;
        }
        // otherwise, start from the tail of the list
        return getNodeStartingAtTail(index).data;
    }

    /**
     * Helper function to retrieve the node at the index starting from the head of the list
     * @param index the index of the item
     * @return the item at the index
     */
    private ListNode getNodeStartingAtHead(int index) {
        // validate index
        validateIndex(index, size());

        // make an iterator and store an index
        ListNode iterator = head;
        int currentIndex = -1;

        // loop through until the index is reached
        while (currentIndex < index) {
            // iterate to next item
            iterator = iterator.next;
            ++currentIndex;
        }

        // now the iterator is at the index. return the data at that index
        return iterator;
    }

    /**
     * Helper function to retrieve the node at the index starting from the tail of the list
     * @param index the index of the item
     * @return the item at the index
     */
    private ListNode getNodeStartingAtTail(int index) {
        // validate index
        validateIndex(index, size());

        // make an iterator and store an index
        ListNode iterator = tail;
        int currentIndex = size();

        // loop through until the index is reached
        while (currentIndex > index) {
            // iterate to next item
            iterator = iterator.prev;
            --currentIndex;
        }

        // now the iterator is at the index. return the data at that index
        return iterator;
    }

    // Manipulation Methods
    /**
     * Inserts an item at the specified index. The index specified is allowed to be equal to the
     * size of the list, but no more than that.
     * @param index index at list (can also be equal to the size of the list to indicate insertion at the end of list)
     * @param item item to insert
     */
    public void insert(int index, T item) {
        // validate the index (with the special case that index can be equal to size of the list)
        validateIndex(index, size() + 1);

        // if the index is closer to the head than the tail, then insert starting at the head
        if (index < (size() + 1) / 2) {
            insertStartingAtHead(index, item);
        }
        // otherwise, insert starting at the tail instead
        else {
            insertStartingAtTail(index, item);
        }
    }

    /**
     * Helper function for insertion, iterating through the front of the list before insertion
     * @param index the index to insert the item into
     * @param item the item to insert
     */
    private void insertStartingAtHead(int index, T item) {
        // validate the index (with the special case that index can be equal to size of the list)
        validateIndex(index, size() + 1);

        // create an iterator and keep track of the index
        ListNode iterator = head;
        int currentIndex = -1;

        // loop until the index is reached
        while (currentIndex < index) {
            iterator = iterator.next;
            ++currentIndex;
        }

        // so now the iterator is at the index
        // Make a new node to insert
        ListNode newNode = new ListNode(item);

        // insert it into the list
        newNode.prev = iterator.prev;
        newNode.next = iterator;
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
    }

    /**
     * Helper function for insertion, iterating through the back of the list before insertion
     * @param index the index to insert the item into
     * @param item the item to insert
     */
    private void insertStartingAtTail(int index, T item) {
        // validate the index (with the special case that index can be equal to size of the list)
        validateIndex(index, size() + 1);

        // create an iterator and keep track of the index
        ListNode iterator = tail;
        int currentIndex = size();

        // loop until 1 under the index is reached
        while (currentIndex >= index) {
            iterator = iterator.prev;
            --currentIndex;
        }

        // so now the iterator is at the index
        // Make a new node to insert
        ListNode newNode = new ListNode(item);

        // insert it into the list
        newNode.prev = iterator;
        newNode.next = iterator.next;
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
    }

    /**
     * Removes the item at the index and returns itt
     * @param index the index of the item to be removed
     * @return the item that was removed
     */
    public T remove(int index) {
        // validate the index
        validateIndex(index, size());

        // check whether to start searching at head or tail
        boolean startAtHead = (index < (size() + 1) / 2);

        // get the node that we need to remove
        ListNode nodeToRemove = null;
        if (startAtHead) {
            nodeToRemove = getNodeStartingAtHead(index);
        }
        else {
            nodeToRemove = getNodeStartingAtTail(index);
        }

        // copy the data before removal
        T copyOfData = nodeToRemove.data;
        // Do linked list manipulation to remove the node
        // i.e., For the node being removed, have its adjacent nodes point to each other instead of to the node
        //  being removed.
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = nodeToRemove.prev;
        // nullify what the nodeToRemove is pointing to
        nodeToRemove.prev = null;
        nodeToRemove.next = null;
        // return the data that is to be removed
        return copyOfData;
    }


    /**
     * Adds item to the end of the list
     * @param item item to add to end of list
     */
    public void pushBack(T item) {
        // use the insert function to insert at end of list
        insert(size(), item);
    }

    /**
     * Adds item to the front of the list
     * @param item item to add to front of list
     */
    public void pushFront(T item) {
        // use insert function to insert at front of list
        insert(0, item);
    }

    /**
     * Removes item at the back of the list
     * @return the item being removed from the back of the list
     */
    public T popBack() {
        return remove(size() - 1);
    }

    /**
     * Removes item at the front of the list
     * @return the item being removed from the front of the list
     */
    public T popFront() {
        return remove(0);
    }
}

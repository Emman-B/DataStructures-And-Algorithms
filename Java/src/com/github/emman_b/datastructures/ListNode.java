package com.github.emman_b.datastructures;

import java.util.Objects;

/**
 * This is a simple list node class for any problems that require
 * precise node manipulation. It can be used for Singly-Linked-Lists
 * or Doubly-Linked-Lists.
 */
public class ListNode <T> {
    // Fields
    public ListNode prev;
    public ListNode next;
    public T data;

    // Constructors
    public ListNode() {
        this(null, null, null);
    }
    public ListNode(T data) {
        this(data, null, null);
    }
    public ListNode(T data, ListNode next) {
        this(data, next, null);
    }
    public ListNode(T data, ListNode next, ListNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

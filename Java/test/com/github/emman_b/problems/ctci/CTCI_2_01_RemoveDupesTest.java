package com.github.emman_b.problems.ctci;

import com.github.emman_b.datastructures.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CTCI_2_01_RemoveDupesTest {

    <T> ListNode<T> makeSinglyLinkedList(T[] data) {
        // Case: no data so return null
        if (data.length == 0) return null;

        ListNode<T> head = new ListNode<>(data[0]);
        ListNode<T> iterator = head;
        for (int i = 1; i < data.length; ++i) {
            iterator.next = new ListNode<>(data[i]);
            iterator = iterator.next;
        }

        return head;
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void RemoveDupes_WithEmptyList_ShouldDoNothing() {
        // Setup
        ListNode<Integer> head = null;

        // Exercise
        CTCI_2_01_RemoveDupes.removeDupes(head);

        // Verify: head is still null
        assertNull(head);
    }

    @Test
    void RemoveDupes_WithListOfOneItem_ShouldDoNothing() {
        // Setup
        ListNode<Integer> head = new ListNode<>(53);

        // Exercise
        CTCI_2_01_RemoveDupes.removeDupes(head);

        // Verify
        assertEquals(53, head.data);
    }

    @Test
    void RemoveDupes_WithTwoDupeItems_ShouldReturnOneItem() {
        // Setup: Create two nodes, 24->24
        ListNode<Integer> head = new ListNode<>(24, new ListNode<Integer>(24));

        // Exercise
        CTCI_2_01_RemoveDupes.removeDupes(head);

        // Verify: Head is the only item
        assertEquals(24, head.data); // check if the head is still 24
        assertNull(head.next); // check if the next item is null
    }

    @Test
    void RemoveDupes_WithLotsOfUniqueItems_ShouldReturnSameList() {
        // Setup: Create list with array
        String[] data = new String[] {
                "Hello", "World", "Foo", "Bar", "Baz"
        };
        ListNode<String> head = makeSinglyLinkedList(data);

        // Exercise
        CTCI_2_01_RemoveDupes.removeDupes(head);

        // Verify: Iterate through list and compare each item
        ListNode<String> itor = head;
        for (String datum: data) {
            assertEquals(datum, itor.data);
            itor = itor.next;
        }
    }

    @Test
    void RemoveDupes_WithSomeDupes_ShouldReturnListWithNoDupes() {
        // Setup: Create list with array
        String[] data = new String[] {
                "Hello", "Foo", "World", "Foo", "Bar", "Hello"
        };
        ListNode<String> head = makeSinglyLinkedList(data);
        // Create expected results
        String[] expected = new String[] {
                "Hello", "Foo", "World", "Bar"
        };

        // Exercise
        CTCI_2_01_RemoveDupes.removeDupes(head);

        // Verify: compare each item
        ListNode<String> itor = head;
        for (String datum: expected) {
            assertEquals(datum, itor.data);
            itor = itor.next;
        }
    }
}
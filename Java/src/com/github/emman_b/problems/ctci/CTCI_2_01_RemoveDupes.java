package com.github.emman_b.problems.ctci;

import com.github.emman_b.datastructures.ListNode;

import java.util.HashSet;

public class CTCI_2_01_RemoveDupes {
    /*
        Problem: Write code to remove duplicates from an unsorted linked list. (I will
        remove items in-place). Assumption: This is a singly-linked-list

        Follow Up: How would you solve this problem if a temporary buffer is not allowed?
        - This would require the slower O(n^2) solution of having two pointers: the first
          pointer used to iterate over the entire list, and the second pointer used to
          point at all later elements in the list to compare.
     */
    public static <T> void removeDupes(ListNode<T> head) {
        /*
            Approach: Iterate through the list, storing unique values into a hashset.
            If a value is already in the hashset, we remove that value from the list instead.

            I will update this list in-place.
         */
        // Case: empty list or list of size 1
        if (head == null || head.next == null) {
            return;
        }

        HashSet<T> items = new HashSet<>();
        ListNode prev = null;
        ListNode itor = head;

        while (itor != null) {
            if (items.contains(itor.data)) {
                // case: do removal
                prev.next = prev.next.next;
                itor = prev.next;
            } else {
                // case: insert into set and iterate
                items.add((T)itor.data);
                prev = itor;
                itor = itor.next;
            }
        }
    }
}

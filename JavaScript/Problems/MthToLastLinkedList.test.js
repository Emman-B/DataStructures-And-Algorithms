const {SinglyLinkedList} = require('../DataStructures/LinkedList.js');

/*
    Problem: Given a singly-linked list, get the Mth-to-Last element
    of this linked list. For example, if M = 0, return the last item
    of the linked list.
*/

// Implementation of problem:
function getMthToLastElement(list, index) {
    /*
        Solution is to use two iterators. The reason being is the following:

        It's hard to figure out which index is the Mth-to-Last index with
        some arbitrary M. However, we can use two iterators that are
        M indices apart and then figure out the Mth-to-last element is.

        To get these iterators M indices apart, move 1 iterator M times.
        The other iterator should still be at the starting position.

        Next, we have to iterate both iterators until the first iterator
        reaches the last item of the list. They must iterate in sync
        and stop in sync.

        Once the first iterator reaches the last item, since both
        iterators are M-indices away, this means that the second
        iterator is pointing at the item that is Mth-to-last.
    */
    // case: empty list
    if (list == null || list.head == null) return null;

    // case: bad index (negative, or exceeds size)
    if (index < 0 || index > list.size()) {
        throw new Error('Bad index!');
    }

    const listHead = list.head;

    // we need two iterators, one that goes through the full list, and another that stops at the Mth index
    let fullListIterator = listHead;
    let mthIterator = listHead;

    // move the full-list-iterator M times
    for (let i = 0; i < index; ++i) {
        fullListIterator = fullListIterator.next;
    }

    // then, move both the full-list-iterator and mth-iterator until the full-list iterator is on the last item
    while (fullListIterator.next != null) {
        fullListIterator = fullListIterator.next;
        mthIterator = mthIterator.next;
    }

    // finally, return the value at that index
    return mthIterator.data;
}


// == Tests ==
test('Get the Mth-to-Last element, where M = 0 (last item)', () => {
    // Setup
    const list = new SinglyLinkedList();
    list.add(5);
    list.add(1);
    list.add(0);
    list.add(4); // M = 0

    // Exercise
    const result = getMthToLastElement(list, 0);

    // Verify
    expect(result).toBe(list.get(list.size() - 1));
});

test('Get the Mth-to-Last element, where M = size of list - 1 (first item)', () => {
    // Setup
    const list = new SinglyLinkedList();
    list.add(5); // M = 3
    list.add(1);
    list.add(0);
    list.add(4);

    // Exercise
    const result = getMthToLastElement(list, list.size() - 1);

    // Verify
    expect(result).toBe(list.get(0));
});

test('Get the Mth-to-Last element, where M = middle indices', () => {
    // Setup
    const list = new SinglyLinkedList();
    list.add(5);
    list.add(1); // M = 2
    list.add(0); // M = 1
    list.add(4);

    // Exercise
    const m1Result = getMthToLastElement(list, 1);
    const m2Result = getMthToLastElement(list, 2);

    // Verify
    expect(m1Result).toBe(0);
    expect(m2Result).toBe(1);
});

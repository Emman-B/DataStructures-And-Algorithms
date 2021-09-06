/*
    Problem: Detect if there is a cycle in a linked list (i.e., iterating
    through the linked list will not end in a null node).
*/

// Simple SLL data structure
var ListNode = function(data) {
    this.data = data;
    this.next = undefined;
}

const hasCycle = (root) => {
    /*
        The idea for this solution is that we have a fast
        and slow iterator. The fast iterator iterates through the list
        twice as fast as the slow iterator. In theory, we can detect
        if there is a cycle if both iterators point to the same
        node.
    */

    // case: empty list should return false
    if (root == null) return false;

    let slowItor = root; // iterates one by one
    let fastItor = root.next; // iterates two times

    // iterate both pointers
    while (slowItor != null && fastItor != null) {
        // if both iterators point at the same item, return true
        if (slowItor === fastItor) {
            return true;
        }

        // otherwise, try to iterate both items (fastItor iterates twice)
        slowItor = slowItor.next;
        fastItor = fastItor.next;
        // if the fast iterator is already null, then we can return that there is no cycle
        if (fastItor == null) {
            return false;
        }
        // otherwise, iterate the fast iterator a second time
        fastItor = fastItor.next;
    }

    // if this point is reached, then there is no cycle and we can leave
    return false;
};

test('Detect cycle in linked list with multiple items where there is no cycle', () => {
    // Setup SLL
    const dataInLinkedList = [3, 2, 4, 6, 2];
    const head = new ListNode(dataInLinkedList.splice(0, 1)[0]);
    let itor = head;
    for (let i = 0; i < dataInLinkedList.length; ++i) {
        itor.next = new ListNode(dataInLinkedList[i]);
        itor = itor.next;
    }

    // Exercise and Verify
    expect(hasCycle(head)).toBe(false);
});

test('Detect cycle in linked list with multiple items where there is a cycle', () => {
    // Setup SLL
    const dataInLinkedList = [3, 2, 4, 6, 2];
    const head = new ListNode(dataInLinkedList.splice(0, 1)[0]);
    let itor = head;
    for (let i = 0; i < dataInLinkedList.length; ++i) {
        itor.next = new ListNode(dataInLinkedList[i]);
        itor = itor.next;
    }
    // Let the itor point to somewhere in the linked list
    itor.next = head.next.next;

    // Exercise and Verify
    expect(hasCycle(head)).toBe(true);
});

test('Detect cycle in linked list with no items', () => {
    // (Empty linked list will call hasCycle with undefined as a param)
    // Setup, Exercise, and Verify
    expect(hasCycle(undefined)).toBe(false);
});

test('Detect cycle in linked list with one item', () => {
    // Setup, Exercise, and Verify
    expect(hasCycle(new ListNode(5))).toBe(false);
});

test('Detect cycle in linked list with two items where there is no cycle', () => {
    // Setup
    const head = new ListNode(5);
    head.next = new ListNode(10);
    
    // Exercise and Verify
    expect(hasCycle(head)).toBe(false);
});

test('Detect cycle in linked list with two items where there is a cycle', () => {
    // Setup
    const head = new ListNode(5);
    head.next = new ListNode(10);
    // create a cycle
    head.next.next = head;
    
    // Exercise and Verify
    expect(hasCycle(head)).toBe(true);
});

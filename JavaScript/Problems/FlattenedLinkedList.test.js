/*
    Problem: You are given a modified version of a doubly linked list, where
    each list ListNode can contain an extra field which is another doubly linked list.
    The list node may look like the following:
        ListNode {
            ListNode next,
            ListNode prev,
            ListNode child,
            TYPE data,
        }
    
    The idea is to turn this multi-level DLL into a flat, single-level DLL.
    This single level will contain all of the nodes from the lower levels,
    appended to the end of the first level
*/

// Data structure to use
class ListNode {
    constructor(data, prev) {
        this.data = data;
        this.next = undefined;
        this.prev = prev;
        this.child = undefined;
    }
}

// Implementation of list flattening
/**
 * Flattens a multi-layer list
 * @param {ListNode} head head of list
 */
function flattenList(head) {
    // given the head of the list, we need to find the children and append it to the end of each layer
    let lastElement = head;

    while (lastElement.next !== undefined) {
        lastElement = lastElement.next;
    }
    
    const levelorderTraversal = levelorderTraverse(head);

    // now that we have the levelorder traversal, append it to the last item
    levelorderTraversal.forEach((element) => {
        lastElement.next = element;
        element.prev = lastElement;
        lastElement = lastElement.next;
    });
}

/**
 * Does a levelorder traversal on a multi-level DLL.
 * It only returns an array of traversed elements not on the first level
 * @param {ListNode} root head of list
 */
function levelorderTraverse(root) {
    /*
        The idea behind this function is that we want to get all of the
        nodes that are not on the first level of the DLL, but we want them
        in level-order (or in depth-order).

        Thus, we do a levelorder traversal. We can think of the multi-level DLL
        as a tree, where each node is a DLL. When we traverse, we traverse
        into the children of the nodes in a DLL.

        For example, if the top level of the MLDLL (multi-level doubly-linked-list)
        has 5 nodes, and 3 of those nodes have a child node, then we
        traverse into those three nodes with children. We do not want to add
        the nodes without children into the traversal queue.
    */
    const result = []; // this is the levelorder traversal result

    const queue = []; // used for traversal

    // iterates over the first level, getting all the nodes with children
    //  ... and pushing them into the queue
    let firstItor = root;

    while (firstItor != null) {
        if (firstItor.child != null) {
            queue.push(firstItor.child);
        }
        firstItor = firstItor.next;
    }

    // queue now has all of the child elements

    // do traversal on them
    while (queue.length > 0) {
        // get the DLL in the queue
        const node = queue.splice(0, 1)[0];
        let currentItor = node;
        // iterate through this DLL
        while (currentItor != null) {
            // add the current item to the results array
            result.push(currentItor);
            // add any nodes with children to the queue array
            if (currentItor.child != null) {
                queue.push(currentItor.child);
            }
            currentItor = currentItor.next;
        }
    }

    // result should now have the level-order traversal
    return result;
}

test('Main Flatten List Test', () => {
    // Setup the test
    // setup layer 1
    const head = new ListNode(5);
    let iterator = head;
    iterator.next = new ListNode(33, iterator);
    iterator = iterator.next;
    iterator.next = new ListNode(17, iterator);
    iterator = iterator.next;
    iterator.next = new ListNode(2, iterator);
    iterator = iterator.next;
    iterator.next = new ListNode(1, iterator);

    // setup layer 2 (1 / 2)
    head.child = new ListNode(6);
    iterator = head.child;
    iterator.next = new ListNode(25, iterator);
    iterator = iterator.next;
    iterator.next = new ListNode(6, iterator);
    // setup layer 2 (2 / 2)
    head.next.next.next.child = new ListNode(2);
    iterator = head.next.next.next.child;
    iterator.next = new ListNode(7, iterator);
    
    // setup layer 3 (1 / 3)
    head.child.next.child = new ListNode(8);
    // setup layer 3 (2 / 3)
    head.child.next.next.child = new ListNode(9);
    // setup layer 3 (3 / 3)
    head.next.next.next.child.child = new ListNode(12);
    iterator = head.next.next.next.child.child;
    iterator.next = new ListNode(5, iterator);

    // setup layer 4 (1 / 2)
    head.child.next.next.child.child = new ListNode(7);
    // setup layer 4 (2 / 2)
    head.next.next.next.child.child.child = new ListNode(21);
    iterator = head.next.next.next.child.child.child;
    iterator.next = new ListNode(3, iterator);

    // Exercise
    flattenList(head);

    // generate the expected result
    const expected = [ 5, 33, 17, 2, 1, 6, 25, 6, 2, 7, 8, 9, 12, 5, 7, 21, 3 ];
    let expectedIterator = head;

    // Verify
    expected.forEach((element) => {
        expect(expectedIterator.data).toBe(element);
        expectedIterator = expectedIterator.next;
    });
});

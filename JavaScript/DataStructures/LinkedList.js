
// Create node object using function
const Node = function(data) {
    this.next = undefined;
    this.prev = undefined; // only used in DLL
    this.data = data;
}

// == Implemented SLL using prototypes ==

/**
 * Constructor for a singly linked list
 */
var SinglyLinkedList = function() {
    // constructor
    this.head = undefined;
}

/**
 * Retrieves an item from the linked list
 * @param {number} index index of item to retrieve
 * @returns the data stored at that index
 */
SinglyLinkedList.prototype.get = function(index) {
    // case: invalid negative index
    if (index < 0) {
        throw new Error('Invalid index used with get()!');
    }
    // case: get from empty list throws error
    if (this.head === undefined) {
        throw new Error('Cannot get() from empty list!');
    }

    let iterator = this.head;
    for (let i = 0; i < index && iterator !== undefined; ++i) {
        iterator = iterator.next;
    }

    // error case: iterator is null/undefined
    if (iterator === undefined) {
        throw new Error('Invalid index used with get()!');
    } else {
        return iterator.data;
    }
}

SinglyLinkedList.prototype.add = function(data) {
    // case: insert into empty list
    if (this.head === undefined) {
        this.head = new Node(data);
        return;
    }

    // case: insert into list with items
    let iterator = this.head;
    // iterate until at last item
    while (iterator.next !== undefined) {
        iterator = iterator.next;
    }
    // set the next of the current iterator
    iterator.next = new Node(data);
}

SinglyLinkedList.prototype.remove = function(index) {
    // case: invalid negative index
    if (index < 0) {
        throw new Error('Invalid index used with remove()!');
    }
    // case: remove from empty list throws error
    if (this.head === undefined) {
        throw new Error('Cannot remove() from empty list!');
    }

    // case: delete head
    if (index === 0) {
        const removedData = this.head.data;
        this.head = this.head.next;
        return removedData;
    }

    // case: delete other node
    let iterator = this.head; // iterate until one index before
    for (let i = 0; i < index - 1 && iterator !== undefined && iterator.next !== undefined; ++i) {
        iterator = iterator.next;
    }

    // error case: iterator is null/undefined
    if (iterator === undefined || iterator.next === undefined) {
        throw new Error('Invalid index used with remove()!');
    } else {
        const removedData = iterator.next.data;
        iterator.next = iterator.next.next;
        return removedData;
    }

}


// == Implemented DLL using ES6 Classes
class DoublyLinkedList {
    // constructor
    constructor() {
        // fields
        this.head = undefined;
    }

    get(index) {
        // case: invalid negative index
        if (index < 0) {
            throw new Error('Invalid index used with get()!');
        }
        // case: get from empty list throws error
        if (this.head === undefined) {
            throw new Error('Cannot get() from empty list!');
        }

        let iterator = this.head;
        for (let i = 0; i < index && iterator !== undefined; ++i) {
            iterator = iterator.next;
        }

        // error case: iterator is null/undefined
        if (iterator === undefined) {
            throw new Error('Invalid index used with get()!');
        } else {
            return iterator.data;
        }
    }

    add(data) {
        // case: add into empty list
        if (this.head === undefined) {
            this.head = new Node(data);
            return;
        }

        // case: insert into list with items
        let iterator = this.head;
        // iterate until at last item
        while (iterator.next !== undefined) {
            iterator = iterator.next;
        }
        // set the next of the current iterator
        iterator.next = new Node(data);
        // set the prev of the next item
        iterator.next.prev = iterator;
    }

    remove(index) {
        // case: invalid negative index
        if (index < 0) {
            throw new Error('Invalid index used with remove()!');
        }
        // case: remove from empty list throws error
        if (this.head === undefined) {
            throw new Error('Cannot remove() from empty list!');
        }

        // case: delete head
        if (index === 0) {
            const removedData = this.head.data;
            this.head = this.head.next;
            // only set head's prev if the list is not empty upon removal 
            if (this.head !== undefined) {
                this.head.prev = undefined;
            }
            return removedData;
        }

        // case: delete other node
        let iterator = this.head; // iterate until reaching the node
        for (let i = 0; i < index && iterator !== undefined; ++i) {
            iterator = iterator.next;
        }

        // error case: iterator is null/undefined
        if (iterator === undefined) {
            throw new Error('Invalid index used with remove()!');
        } else {
            const removedData = iterator.data;
            iterator.prev.next = iterator.next;
            // Set the next's previous only if it's not the last item
            if (iterator.next !== undefined) {
                iterator.next.prev = iterator.prev;
            }
            return removedData;
        }
    }
}


module.exports = {
    SinglyLinkedList,
    DoublyLinkedList,
};

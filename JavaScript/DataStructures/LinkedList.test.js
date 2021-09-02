// SLL tests

const { SinglyLinkedList, DoublyLinkedList } = require("./LinkedList");

test('SLL: Get from empty list should throw error', () => {
    // Setup
    const list = new SinglyLinkedList();

    // Exercise and Verify
    expect(() => list.get(0)).toThrowError();
});

test('SLL: Add one item should have item stored', () => {
    // Setup
    const list = new SinglyLinkedList();
    const dataToInsert = 53;
    
    // Exercise
    list.add(dataToInsert);

    // Verify
    expect(list.get(0)).toBe(dataToInsert);
});

test('SLL: Add two items should have item stored in order', () => {
    // Setup
    const list = new SinglyLinkedList();
    const dataToInsert = [22, 97];

    // Exercise
    for (const data of dataToInsert) {
        list.add(data);
    }

    // Verify
    expect(list.get(0)).toBe(dataToInsert[0]);
    expect(list.get(1)).toBe(dataToInsert[1]);
});

test('SLL: Add multiple items should have items stored in order', () => {
    // Setup
    const list = new SinglyLinkedList();
    const dataToInsert = [52, 15, 63, 9];

    // Exercise
    for (const data of dataToInsert) {
        list.add(data);
    }

    // Verify
    dataToInsert.forEach((element, index) => {
        expect(list.get(index)).toBe(element);
    });
});

test('SLL: Removing one item from one-item list should get item and list empty', () => {
    // Setup
    const list = new SinglyLinkedList();
    const dataToInsert = 62;
    list.add(dataToInsert);

    // Exercise
    const removedData = list.remove(0);

    // Verify
    expect(removedData).toBe(dataToInsert);
    expect(() => list.get(0)).toThrowError();
});

test('SLL: Removing head from multi-item list should get item and have list correct', () => {
    // Setup
    const list = new SinglyLinkedList();
    const dataToInsert = [54, 12, 57, 98, -10];
    dataToInsert.forEach((data) => {
        list.add(data);
    });
    const expectedRemovedData = dataToInsert[0];

    // Exercise
    const removedData = list.remove(0);

    // Verify
    expect(removedData).toBe(expectedRemovedData); // get removed item correctly
    expect(list.get(0)).not.toBe(dataToInsert[0]); // list at idx 0 shouldn't be the same
});

test('SLL: Removing tail from multi-item list should get item and have list correct', () => {
    // Setup
    const list = new SinglyLinkedList();
    const dataToInsert = [54, 12, 57, 98, -10];
    dataToInsert.forEach((data) => {
        list.add(data);
    });
    const indexToRemove = dataToInsert.length - 1;
    const expectedRemovedData = dataToInsert[indexToRemove];

    // Exercise
    const removedData = list.remove(indexToRemove);

    // Verify
    expect(removedData).toBe(expectedRemovedData); // get removed item correctly
    expect(() => list.get(indexToRemove)).toThrowError(); // list at idx 0 shouldn't be the same
});


// DLL Tests
test('DLL: Add multiple items should have items stored in order', () => {
    // Setup
    const list = new DoublyLinkedList();
    const dataToInsert = [52, 15, 63, 9];

    // Exercise
    for (const data of dataToInsert) {
        list.add(data);
    }

    // Verify
    dataToInsert.forEach((element, index) => {
        expect(list.get(index)).toBe(element);
    });
});

test('DLL: Removing one item from one-item list should get item and list empty', () => {
    // Setup
    const list = new DoublyLinkedList();
    const dataToInsert = 62;
    list.add(dataToInsert);

    // Exercise
    const removedData = list.remove(0);

    // Verify
    expect(removedData).toBe(dataToInsert);
    expect(() => list.get(0)).toThrowError();
});

test('DLL: Removing tail from multi-item list should get item and have list correct', () => {
    // Setup
    const list = new DoublyLinkedList();
    const dataToInsert = [54, 12, 57, 98, -10];
    dataToInsert.forEach((data) => {
        list.add(data);
    });
    const indexToRemove = dataToInsert.length - 1;
    const expectedRemovedData = dataToInsert[indexToRemove];

    // Exercise
    const removedData = list.remove(indexToRemove);

    // Verify
    expect(removedData).toBe(expectedRemovedData); // get removed item correctly
    expect(() => list.get(indexToRemove)).toThrowError(); // trying to get at the last index should throw error
});

test('DLL: Removing middle from multi-item list should get item and have list correct', () => {
    // Setup
    const list = new DoublyLinkedList();
    const dataToInsert = [54, 12, 57, 98, -10];
    dataToInsert.forEach((data) => {
        list.add(data);
    });
    const indexToRemove = 3;
    const expectedRemovedData = dataToInsert[indexToRemove];
    const expectedNewDataList = dataToInsert.filter((element, index) => {
        return index !== indexToRemove
    });

    // Exercise
    const removedData = list.remove(indexToRemove);

    // Verify
    expect(removedData).toBe(expectedRemovedData); // get removed item correctly
    expectedNewDataList.forEach((element, index) => {
        expect(list.get(index)).toBe(element);
    });
});

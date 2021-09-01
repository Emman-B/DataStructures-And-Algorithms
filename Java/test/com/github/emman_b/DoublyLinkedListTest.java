package com.github.emman_b;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    @Test
    void EmptyList_WhenGettingElement_ShouldThrowError() {
        // create the list
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // expect an error when trying to get an item from the list
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void List_WhenPushingBackOneElement_ShouldHaveElementStored() {
        // create the list
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        // store into list
        list.pushBack("Hello");

        // verify that the item stored into list is correct
        assertEquals("Hello", list.get(0));
    }

    @Test
    void List_WhenPushingBackTwoElements_ShouldHaveElementsStoredInOrder() {
        // create the list
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        // store both items into list
        list.pushBack("Hello");
        list.pushBack("World");

        // verify that both items are stored into list in order
        assertEquals("HelloWorld", list.get(0) + list.get(1));
    }

    @Test
    void List_WhenPushingFrontOneElement_ShouldHaveElementStored() {
        // create the list
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        // store into list
        list.pushFront("Hello");

        // verify that the item stored into list is correct
        assertEquals("Hello", list.get(0));
    }

    @Test
    void List_WhenPushingFrontTwoElements_ShouldHaveElementsStoredInOrder() {
        // create the list
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        // store both items into list
        list.pushFront("Hello");
        list.pushFront("World");

        // verify that both items are stored into list in order
        assertEquals("WorldHello", list.get(0) + list.get(1));
    }

    @Test
    void ListWithOneElement_WhenPushingBackOneElementAndPushingFrontAnotherElement_ShouldHaveElementsStoredInOrder() {
        // create the list
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        // store the initial item
        list.insert(0, "Initial");

        // now store two more items, one before and one after using the push-back/-front functions
        list.pushFront("Hello");
        list.pushBack("World");

        // verify that the order of the items is correct
        assertEquals("HelloInitialWorld", list.get(0) + list.get(1) + list.get(2));
    }

    @Test
    void ListWithOneElement_WhenPushingFrontTwoElementsAndPushingBackTwoElements_ShouldHaveElementsStoredInOrder() {
        // create the list
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        // store the initial item
        list.insert(0, "Initial");

        // now store 4 more items so that the result should look like: FirstSecondInitialThirdFourth
        list.pushFront("Second");
        list.pushBack("Third");
        list.pushBack("Fourth");
        list.pushFront("First");

        // verify the order of the items in list
        assertEquals("FirstSecondInitialThirdFourth", list.get(0) + list.get(1) + list.get(2) + list.get(3) + list.get(4));
    }

    @Test
    void List_WhenPushingBackManyElements_ShouldHaveElementsStoredInOrder() {
        // create the list
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // create the data that is to be stored in the list
        Integer[] data = new Integer[]{
                1, 3, 5, 7, 11, 14, 16, 20
        };

        // store the data into the list using the pushBack call
        for (Integer integer: data) {
            list.pushBack(integer);
        }

        // verify that the order of the elements is maintained
        for (int i = 0; i < list.size(); ++i) {
            assertEquals(data[i], list.get(i));
        }
    }

    @Test
    void List_WhenPushingFrontManyElements_ShouldHaveElementsStoredInOrder() {
        // create the list
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // create the data that is to be stored in the list
        Integer[] data = new Integer[]{
                1, 3, 5, 7, 11, 14, 16, 20
        };

        // store the data into the list using the push-front call
        for (Integer integer: data) {
            list.pushFront(integer);
        }

        // since push-front was used, the order of the elements is in reverse so ensure that the order is maintained in reverse
        for (int i = 0; i < list.size(); ++i) {
            assertEquals(data[i], list.get(list.size() - 1 - i));
        }
    }

    @Test
    void ListWithSomeElements_WhenInsertingIntoRightHalfOfList_ShouldInsertCorrectly() {
        // create list
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // insert five elements using pushback
        list.pushBack(1);
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);
        // -- this will be where the new item will be inserted
        list.pushBack(60);
        list.pushBack(100);

        // insert into the right half
        list.insert(4, 45);

        // assert that the insertion is correct
        assertEquals(45, list.get(4));

        // assert that the adjacent elements are as expected
        assertEquals(30, list.get(3));
        assertEquals(60, list.get(5));
    }

    @Test
    void ListWithSomeElements_WhenInsertingIntoLeftHalfOfList_ShouldInsertCorrectly() {
        // create list
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // insert five elements using pushback
        list.pushBack(1);
        list.pushBack(10);
        // -- this will be where the new item will be inserted
        list.pushBack(20);
        list.pushBack(30);
        list.pushBack(60);
        list.pushBack(100);

        // insert into the right half
        list.insert(2, 15);

        // assert that the insertion is correct
        assertEquals(15, list.get(2));

        // assert that the adjacent elements are as expected
        assertEquals(10, list.get(1));
        assertEquals(20, list.get(3));
    }

    @Test
    void ListWithSomeElements_WhenPoppingFromFrontOfList_ShouldRemoveElement() {
        // create the list
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // add some elements
        list.pushBack(5);
        list.pushBack(10);
        list.pushBack(15);

        // then pop the front of the list
        Integer poppedFront = list.popFront();

        // verify that this element was the front
        assertEquals(5, poppedFront);

        // then, verify that the list has been modified
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(15, list.get(1));
    }

    @Test
    void ListWithSomeElements_WhenPoppingFromBackOfList_ShouldRemoveElement() {
        // create the list
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // add some elements
        list.pushBack(5);
        list.pushBack(10);
        list.pushBack(15);

        // then pop the back of the list
        Integer poppedBack = list.popBack();

        // verify that this element was the front
        assertEquals(15, poppedBack);

        // then, verify that the list has been modified
        assertEquals(2, list.size());
        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
    }

    @Test
    void ListWithSomeElements_WhenRemovingFromMiddleOfList_ShouldRemoveElement() {
        // create the list
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        // add some data
        list.pushBack("foo");
        list.pushBack("bar");
        list.pushBack("Initial");
        list.pushBack("baz");

        // remove the third element
        String removedElement = list.remove(2);

        // verify that this was the correct element being removed
        assertEquals("Initial", removedElement);

        // then, verify that the list was modified
        assertEquals(3, list.size());
        assertEquals("foo", list.get(0));
        assertEquals("bar", list.get(1));
        assertEquals("baz", list.get(2));
    }
}
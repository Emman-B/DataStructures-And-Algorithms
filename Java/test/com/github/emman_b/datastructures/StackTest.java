package com.github.emman_b.datastructures;

import com.github.emman_b.datastructures.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void EmptyStack_WhenPeeking_ShouldReturnNull() {
        // make a stack
        Stack<Boolean> stack = new Stack<>();

        // verify that peeking returns null
        assertNull(stack.peek());
    }

    @Test
    void Stack_WhenPushingOneItemOntoStack_ShouldHaveItemStored() {
        // make a stack
        Stack<String> stack = new Stack<>();

        // add an item to the stack
        stack.push("Hello World");

        // look at the top of the stack to see if the information was stored correctly
        assertEquals("Hello World", stack.peek());
    }

    @Test
    void StackWithOneItem_WhenPoppingItem_ShouldResultInEmptyStack() {
        // make a stack
        Stack<String> stack = new Stack<>();

        // add an item to the stack
        stack.push("Hello World");

        // get the item from the stack using pop
        String item = stack.pop();

        // verify the item popped is the same that was stored
        assertEquals("Hello World", item);

        // also check if the stack no elements
        assertEquals(0, stack.size());
    }

    @Test
    void StackWithThreeItems_WhenPoppingItems_ShouldBePoppedInOrder() {
        // make a stack
        Stack<String> stack = new Stack<>();

        // add three items to the stack
        stack.push("Foo"); // bottom of stack
        stack.push("Bar"); // middle of stack
        stack.push("Baz"); // top of stack

        // pop the three items and store them into a string variable
        String actualResult = "";
        actualResult += stack.pop();
        actualResult += stack.pop();
        actualResult += stack.pop();

        // verify the string is in the correct order
        assertEquals("BazBarFoo", actualResult);
    }

    // Error cases
    @Test
    void EmptyStack_WhenPopping_ShouldThrowError() {
        // make a stack
        Stack<Integer> stack = new Stack<>();

        // expect an exception when popping an empty stack
        assertThrows(Exception.class, () -> stack.pop());
    }
}
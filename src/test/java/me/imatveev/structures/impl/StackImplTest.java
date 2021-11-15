package me.imatveev.structures.impl;

import me.imatveev.structures.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackImplTest {
    @Test
    void push01() {
        final Stack<Integer> stack = new StackImpl<>();
        assertEquals(0, stack.size());

        stack.push(12);
        assertEquals(1, stack.size());

        stack.push(42);
        assertEquals(2, stack.size());
    }

    @Test
    void push02() {
        final Stack<Integer> stack = new StackImpl<>();
        int initialArraySize = 15;

        for (int i = 0; i < initialArraySize; i++) {
            int finalI = i;
            assertDoesNotThrow(() -> stack.push(finalI));
        }
        assertEquals(initialArraySize, stack.size());

        assertDoesNotThrow(() -> stack.push(42));

        assertEquals(initialArraySize + 1, stack.size());
    }

    @Test
    void pop() {
        final Stack<Integer> stack = new StackImpl<>();
        assertEquals(0, stack.size());

        stack.push(12);
        stack.push(42);
        assertEquals(2, stack.size());

        assertEquals(42, assertDoesNotThrow(stack::pop));
        assertEquals(1, stack.size());
        assertEquals(12, assertDoesNotThrow(stack::pop));
        assertEquals(0, stack.size());
        assertNull(assertDoesNotThrow(stack::pop));
        assertEquals(0, stack.size());
        assertNull(assertDoesNotThrow(stack::pop));
        assertEquals(0, stack.size());
    }

    @Test
    void peek() {
        final Stack<Integer> stack = new StackImpl<>();
        assertEquals(0, stack.size());

        stack.push(12);
        stack.push(42);
        assertEquals(2, stack.size());

        assertEquals(42, assertDoesNotThrow(stack::peek));
        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(12, assertDoesNotThrow(stack::peek));
        assertEquals(1, stack.size());

        stack.pop();
        assertNull(assertDoesNotThrow(stack::peek));
        assertEquals(0, stack.size());
        assertNull(assertDoesNotThrow(stack::peek));
        assertEquals(0, stack.size());
    }

    @Test
    void toStringTest() {
        final Stack<Integer> stack = new StackImpl<>();
        assertEquals(0, stack.size());

        assertEquals("Stack[]", stack.toString());

        stack.push(42);
        assertEquals("Stack[42]", stack.toString());

        stack.push(42);
        assertEquals("Stack[42, 42]", stack.toString());

        stack.push(0);
        assertEquals("Stack[42, 42, 0]", stack.toString());
    }
}

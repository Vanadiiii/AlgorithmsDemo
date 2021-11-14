package me.imatveev.althorithms.impl;

import me.imatveev.althorithms.Sort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ChoseSortTest {
    private final Sort<Integer> sort = new ChoseSort<>();

    @Test
    @DisplayName("check empty array")
    void sort01() {
        Integer[] emptyArray = {};

        Integer[] result = assertDoesNotThrow(() -> sort.sort(emptyArray));

        assertArrayEquals(emptyArray, result);
    }

    @Test
    @DisplayName("check array with one element")
    void sort02() {
        Integer[] singleElementArray = {1};

        Integer[] result = assertDoesNotThrow(() -> sort.sort(singleElementArray));

        assertArrayEquals(singleElementArray, result);
    }

    @Test
    @DisplayName("check sorted array")
    void sort03() {
        Integer[] sortedArray = {1, 2, 12, 33, 42, 99, 100};

        Integer[] result = assertDoesNotThrow(() -> sort.sort(sortedArray));

        assertArrayEquals(sortedArray, result);
    }

    @Test
    @DisplayName("check shuffled array #0")
    void sort04() {
        Integer[] array = {100, 2, 42, 33, 12, 99, 1};

        Integer[] result = assertDoesNotThrow(() -> sort.sort(array));

        Integer[] sortedArray = new Integer[]{1, 2, 12, 33, 42, 99, 100};
        assertArrayEquals(sortedArray, result);
    }

    @Test
    @DisplayName("check shuffled array #1")
    void sort05() {
        Integer[] array = {1, 92, 5, 12, 2, 44};

        Integer[] result = assertDoesNotThrow(() -> sort.sort(array));

        Integer[] sortedArray = {1, 2, 5, 12, 44, 92};
        assertArrayEquals(sortedArray, result);
    }

    @Test
    @DisplayName("check reverse sorted array")
    void sort06() {
        Integer[] array = {100, 99, 42, 33, 12, 2, 1};

        Integer[] result = assertDoesNotThrow(() -> sort.sort(array));

        Integer[] sortedArray = {1, 2, 12, 33, 42, 99, 100};
        assertArrayEquals(sortedArray, result);
    }
}
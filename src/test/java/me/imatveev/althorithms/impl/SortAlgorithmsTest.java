package me.imatveev.althorithms.impl;

import me.imatveev.althorithms.SortAlgorithm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SortAlgorithmsTest {
    @ParameterizedTest(name = "{1}")
    @DisplayName("check empty array")
    @ArgumentsSource(AlgorithmProvider.class)
    void sort01(SortAlgorithm<Integer> algorithm, @SuppressWarnings("unused") String name) {
        Integer[] emptyArray = {};

        Integer[] result = assertDoesNotThrow(() -> algorithm.sort(emptyArray));

        assertArrayEquals(emptyArray, result);
    }

    @ParameterizedTest(name = "{1}")
    @DisplayName("check array with one element")
    @ArgumentsSource(AlgorithmProvider.class)
    void sort02(SortAlgorithm<Integer> algorithm, @SuppressWarnings("unused") String name) {
        Integer[] singleElementArray = {1};

        Integer[] result = assertDoesNotThrow(() -> algorithm.sort(singleElementArray));

        assertArrayEquals(singleElementArray, result);
    }

    @ParameterizedTest(name = "{1}")
    @DisplayName("check sorted array")
    @ArgumentsSource(AlgorithmProvider.class)
    void sort03(SortAlgorithm<Integer> algorithm, @SuppressWarnings("unused") String name) {
        Integer[] sortedArray = {1, 2, 12, 33, 42, 99, 100};

        Integer[] result = assertDoesNotThrow(() -> algorithm.sort(sortedArray));

        assertArrayEquals(sortedArray, result);
    }

    @ParameterizedTest(name = "{1}")
    @DisplayName("check shuffled array #0")
    @ArgumentsSource(AlgorithmProvider.class)
    void sort04(SortAlgorithm<Integer> algorithm, @SuppressWarnings("unused") String name) {
        Integer[] array = {100, 2, 42, 33, 12, 99, 1};

        Integer[] result = assertDoesNotThrow(() -> algorithm.sort(array));

        Integer[] sortedArray = new Integer[]{1, 2, 12, 33, 42, 99, 100};
        assertArrayEquals(sortedArray, result);
    }

    @ParameterizedTest(name = "{1}")
    @DisplayName("check shuffled array #1")
    @ArgumentsSource(AlgorithmProvider.class)
    void sort05(SortAlgorithm<Integer> algorithm, @SuppressWarnings("unused") String name) {
        Integer[] array = {1, 92, 5, 12, 2, 44};

        Integer[] result = assertDoesNotThrow(() -> algorithm.sort(array));

        Integer[] sortedArray = {1, 2, 5, 12, 44, 92};
        assertArrayEquals(sortedArray, result);
    }

    @ParameterizedTest(name = "{1}")
    @DisplayName("check reverse sorted array")
    @ArgumentsSource(AlgorithmProvider.class)
    void sort06(SortAlgorithm<Integer> algorithm, @SuppressWarnings("unused") String name) {
        Integer[] array = {100, 99, 42, 33, 12, 2, 1};

        Integer[] result = assertDoesNotThrow(() -> algorithm.sort(array));

        Integer[] sortedArray = {1, 2, 12, 33, 42, 99, 100};
        assertArrayEquals(sortedArray, result);
    }

    static class AlgorithmProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(new BubbleSortAlgorithm<>(), "bubble sort"),
                    Arguments.of(new ChoseSortAlgorithm<>(), "chose sort"),
                    Arguments.of(new InsertSortAlgorithm<>(), "insert sort")

            );
        }
    }
}
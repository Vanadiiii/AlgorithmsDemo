package me.imatveev.althorithms.impl;

/**
 * <h2>@complexity - O(N^2)</h2>
 */
public final class BubbleSortAlgorithm<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {
    @Override
    public T[] sort(T[] array) {
        // from second to last element (called 'smallestIdx')
        for (int smallestIdx = 1; smallestIdx < array.length; smallestIdx++) {
            for (int inner = array.length - 1; inner >= smallestIdx; inner--) {
                // swap all elements from next to previous, if they are suitable (like bubble in water))
                if (array[inner - 1].compareTo(array[inner]) > 0) {
                    swap(array, inner, inner - 1);
                }
            }
        }
        return array;
    }
}

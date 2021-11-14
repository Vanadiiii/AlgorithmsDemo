package me.imatveev.althorithms.impl;

/**
 * <h2>@complexity - O(N^2)</h2>
 * <h3>but it's faster then chose-sort in the big part of times</h3>
 */
public final class InsertSortAlgorithm<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {
    @Override
    public T[] sort(T[] array) {
        // lastUnsortedIdx - index of first element of unsorted right part of array
        // and while it's more than last array's index
        for (int lastUnsortedIdx = 1; lastUnsortedIdx < array.length; lastUnsortedIdx++) {

            // and swap them until element find its place
            for (int i = lastUnsortedIdx; i > 0; i--) {
                if (array[i].compareTo(array[i - 1]) < 0) {
                    swap(array, i, i - 1);
                } else {
                    break;
                }
            }

        }

        return array;
    }
}

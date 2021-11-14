package me.imatveev.althorithms.impl;

import me.imatveev.althorithms.SortAlgorithm;

public abstract class AbstractSortAlgorithm<T extends Comparable<T>> implements SortAlgorithm<T> {
    protected void swap(T[] array, int index0, int index1) {
        T swapped = array[index0];
        array[index0] = array[index1];
        array[index1] = swapped;
    }
}

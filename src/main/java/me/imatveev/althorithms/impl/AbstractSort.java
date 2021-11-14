package me.imatveev.althorithms.impl;

import me.imatveev.althorithms.Sort;

public abstract class AbstractSort<T extends Comparable<T>> implements Sort<T> {
    protected void swap(T[] array, int index0, int index1) {
        T swapped = array[index0];
        array[index0] = array[index1];
        array[index1] = swapped;
    }
}

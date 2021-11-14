package me.imatveev.althorithms;

public interface SortAlgorithm<T extends Comparable<T>> {
    T[] sort(T[] array);
}

package me.imatveev.althorithms;

public interface Sort<T extends Comparable<T>> {
    T[] sort(T[] array);
}

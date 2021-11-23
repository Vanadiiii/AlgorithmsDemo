package me.imatveev.structures;

public interface Queue<T> {
    T insert(T element) throws IllegalArgumentException;

    T remove();

    T peek();

    int size();

    String toString();
}

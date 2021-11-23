package me.imatveev.structures.impl;

import me.imatveev.structures.Queue;

import java.util.Arrays;

public class CircularQueue<T> implements Queue<T> {
    private final int maxSize;
    private final T[] data;
    private int first;
    private int last;
    private int size;

    public CircularQueue(int size) {
        this.maxSize = size;
        this.data = (T[]) new Object[size];
        this.first = 0;
        this.last = -1;
        this.size = 0;
    }

    @Override
    public T insert(T value) {
        if (last == maxSize - 1) {
            last = -1;
        }
        data[++last] = value;
        size++;

        return value;
    }

    @Override
    public T remove() {
        T value = data[first++];
        if (first == maxSize) {
            first = 0;
        }
        size--;

        return value;
    }

    @Override
    public T peek() {
        return data[first];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "CircularQueue{" +
                "\n\tdata=" + Arrays.toString(data) +
                "\n\tfirst=" + first +
                "\n\tlast=" + last +
                "\n\tsize=" + size +
                "\n}";
    }
}

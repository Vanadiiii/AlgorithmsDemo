package me.imatveev.structures.impl;

import me.imatveev.structures.Stack;

public class StackImpl<T> implements Stack<T> {
    private Object[] data;
    private int size;

    public StackImpl() {
        this.data = new Object[15];
        this.size = 0;
    }

    @Override
    public T push(T element) {
        if (data.length == 0 || size == data.length) {
            resize();
        }

        data[size] = element;
        size++;
        return element;
    }

    @Override
    @SuppressWarnings("all")
    public T pop() {
        if (size == 0) {
            return null;
        } else {
            size--;
            return (T) data[size];
        }
    }

    @Override
    @SuppressWarnings("all")
    public T peek() {
        if (size == 0) {
            return null;
        } else {
            return (T) data[size - 1];
        }
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("all")
    private void resize() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        this.data = newData;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Stack[");
        if (size == 1) {
            builder.append(data[0]);
        } else if (size > 1) {
            for (int i = 0; i < size - 1; i++) {
                builder.append(data[i]).append(", ");
            }
            builder.append(data[size - 1]);
        }
        return builder.append("]").toString();
    }
}

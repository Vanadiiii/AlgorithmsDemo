package me.imatveev.althorithms.impl;

public final class ChoseSort<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    public T[] sort(T[] array) {
        // from first to penultimate
        for (int left = 0; left < array.length - 1; left++) {

            int smallest = left;
            // find the smallest element in remaining part of array (from left to end of array)
            for (int current = left + 1; current < array.length; current++) {
                if (array[current].compareTo(array[smallest]) < 0) {
                    smallest = current;
                }
            }

            // and swap them if they are different
            if (smallest != left) {
                swap(array, smallest, left);
            }
        }
        return array;
    }
}

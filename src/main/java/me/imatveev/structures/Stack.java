package me.imatveev.structures;

/**
 * <h2>Complexity - O(1)</h2>
 * <h3>if there are no</h3>
 */
public interface Stack<T> {
    /**
     * add element to the top of the stack
     */
    T push(T element);


    /**
     * return last element from the top of the stack, with removing
     */
    T pop();

    /**
     * return last element, like pop, without removing
     */
    T peek();

    int size();
}

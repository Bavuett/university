import java.util.*;

/**
 * An implementation of a queue using a fixed, non-expandable array whose
 * capacity is set in its constructor.
 */

public class BoundedQueue<T> implements MyQueue<T> {
    private Object[] array;  // Recall: Java prohibits generic array creation
    private int size = 0;
    private int head = 0; // index of the current front item, if one exists
    private int tail = 0; // index of next item to be added

    public BoundedQueue(int capacity) {
        array = new Object[capacity];
    }

    public boolean offer(T item) {
        if (size == array.length) return false;
        array[tail] = item;
        tail = (tail + 1) % array.length;
        size++;
        return true;
    }

    public T remove() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot peek into empty queue");
        }
        T item = (T)array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;
        return item;
    }

    public T peek() {
        if (size == 0) return null;
        return (T)array[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
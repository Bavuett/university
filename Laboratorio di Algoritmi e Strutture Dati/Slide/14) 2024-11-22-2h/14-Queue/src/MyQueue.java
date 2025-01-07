/**
 * A small queue interface.  You can query the size of the queue and
 * ask whether it is empty, add and remove items, and peek at the front
 * item.
 */

public interface MyQueue<T> {

    /**
     * Adds the given item to the rear of the queue.
     */
    boolean offer(T item);

    /**
     * Removes the front item from the queue and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    T remove();   

    /**
     * Returns the front item from the queue without popping it.
     * Returns null if this queue is empty.
     */
    T peek();

    /**
     * Returns the number of items currently in the queue.
     */
    int size();

    /**
     * Returns whether the queue is empty or not.
     */
    boolean isEmpty();
}
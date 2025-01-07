/**
 * A small stack interface.  You can query the size of the stack and
 * ask whether it is empty, push items, pop items, and peek at the top
 * item.
 */

public interface MyStack<T> {

    /**
     * Adds the given item to the top of the stack.
     *
     * @param item the item to be pushed onto this stack.
     */
    void push(T item);

    /**
     * Removes the top item from the stack and returns it.
     *	
     * @return the item at the top of this stack.
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    T pop();

    /**
     * Returns the top item from the stack without popping it.
     *
     * @return the object at the top of this stack. 
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    T peek();

    /**
     * Returns the number of items currently in the stack.
     *
     * @return the number of elements in this stack.
     */
    int size();

    /**
     * Returns whether the stack is empty or not.
     *
     * @return true if this stack contains no items, false otherwise.
     */
    boolean isEmpty();
}
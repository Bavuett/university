import java.util.*;

/**
 * A stack class implemented as a wrapper around a java.util.ArrayList.
 * All stack methods simply delegate to ArrayList methods.
 */
public class ArrayListStack<T> implements MyStack<T> {

    private ArrayList<T> array= new ArrayList<T>();

    /**
     * Adds the given item to the top of the stack.
     *
     * @param item the item to be pushed onto this stack.
     */
    public void push(T item) { array.add(item); }

    /**
     * Removes the top item from the stack and returns it.
     *	
     * @return the item at the top of this stack.
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    public T pop() { return array.remove(array.size()-1); }

    /**
     * Returns the top item from the stack without popping it.
     *
     * @return the object at the top of this stack. 
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    public T peek() { return array.get(array.size()-1); }

    /**
     * Returns the number of items currently in the stack.
     *
     * @return the number of elements in this stack.
     */
    public int size() { return array.size(); }

    /**
     * Returns whether the stack is empty or not.
     *
     * @return true if this stack contains no items, false otherwise.
     */
    public boolean isEmpty() { return array.isEmpty(); }
}
import java.util.*;

/**
 * An implementation of a stack using an expandable array. 
 */
public class ArrayStack<T> implements MyStack<T> {
    private Object[] array = new Object[1]; 
    private int size = 0;


    /**
     * Adds the given item to the top of the stack.
     *
     * @param item the item to be pushed onto this stack.
     */
    public void push(T item) {
        if (size == array.length) {
    		/* 	Incrementiamo se necessario le dimensione dell'array del doppio 
    			static <T> T[] copyOf(T[] original, int newLength)
    		 	Copies the specified array, truncating or padding with nulls (if necessary) 
    		 	so the copy has the specified length. */
    			array = Arrays.copyOf(array, array.length * 2);
    		}
        array[size++] = item;
    }

    /**
     * Removes the top item from the stack and returns it.
     *	
     * @return the item at the top of this stack.
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot pop from empty stack");
        }
        T result = (T)array[size-1];
        array[--size] = null;  // facilitates garbage collection
        if (size > 1 && size == array.length/4){
		  array = Arrays.copyOf(array, array.length/2);
        }
        return result;
    } 
    

    /**
     * Returns the top item from the stack without popping it.
     *
     * @return the object at the top of this stack. 
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    public T peek() {
        if (size == 0) {
            throw new NoSuchElementException("Cannot peek into empty stack");
        }
        return (T)array[size - 1];
    }

    /**
     * Returns whether the stack is empty or not.
     *
     * @return true if this stack contains no items, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of items currently in the stack.
     *
     * @return the number of elements in this stack.
     */
    public int size() {
        return size;
    }
}
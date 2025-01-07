import java.util.*;

/**
 * A trivial implementation of the simple queue interface, built as
 * a wrapper around the ArrayList class from java.util.
 */
public class ArrayListQueue<T> implements MyQueue<T> {
    private ArrayList<T> alist = new ArrayList<T>();
    
    public boolean offer(T item) {
    	alist.add(item); 
    	return true;
    }
    
    public T remove() {
	return alist.remove(0); 
    }
    
    public T peek() {
	if (isEmpty()) return null;
	else return alist.get(0); 
    }
    
    public int size() {return alist.size();}
    
    public boolean isEmpty() {return alist.isEmpty();}

}
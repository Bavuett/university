import java.util.*;

/**
 * A trivial implementation of the simple queue interface, built as
 * a wrapper around the LinkedList class from java.util.
 */
public class LinkedQueue<T> implements MyQueue<T> {
    private LinkedList<T> list = new LinkedList<T>();
    
    public boolean offer(T item) {
    	list.add(item);  //list.offer(item); 
    	return true;
    	}
    
    public T remove() {
	return list.remove(); //removeFirst();
    }
    
    public T peek() {
	if (isEmpty()) return null;
	else return list.peek(); //getFirst()
    }
    
    public int size() {return list.size();}
    
    public boolean isEmpty() {return list.isEmpty();}

}
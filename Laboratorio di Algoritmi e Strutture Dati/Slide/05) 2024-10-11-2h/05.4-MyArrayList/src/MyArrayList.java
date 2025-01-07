import java.util.*;

public class MyArrayList <E> extends AbstractCollection<E> implements List<E> {
// Remark: All Implemented Interfaces:
//java.lang.Iterable<E>, java.util.Collection<E>, java.util.List<E> 

private E[] vettore = null;  // Notice that the array is defined parametrically 
private int size = 0;  //logical size (the number of cells that are currently being used)
private int initialSize = 10;  //initial physical size


/**
 *  Constructs an empty list with the specified initial capacity
 */
public MyArrayList (int initialCapacity) {
	initialSize = initialCapacity;
	//  Cannot create a generic array of E: 
	//  vettore = new E [initialSize];
	vettore = (E[])new Object[initialSize];
}

/**
 *  Constructs an empty list with an initial capacity of ten.
 */
public MyArrayList () {
	vettore = (E[])new Object[initialSize];
}

/**
 *  Returns true if the list is empty
 *
 */
public boolean isEmpty() {
	return size == 0;
}

/**
 *  Returns the length of the list
 *
 */
public int size() {
	return size;
}


/**
  *  Removes all nodes from the list.
  *
  */
 public void clear()
 {
	 vettore = (E[])new Object[initialSize];
	 size=0;
}
 
/**
  *  Replaces the element at the specified position in this list with the specified element.
  *  Returns the element previously at the specified position
  *
  */
public E set(int index, E item) {
	E previousItem = null;
	if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
	if (item != null) {
		previousItem = vettore[index];
		vettore[index] = item;
	}
	return previousItem;
}
  
  
/**
  *  Appends the specified element to the end of this arrayList.
  *
  */
public boolean add(E item)
{
	if (item == null) return false;
	if (size == vettore.length) {
	/* 	We increase the size of the array if necessary, doubling it
		static <T> T[] copyOf(T[] original, int newLength)
	 	Copies the specified array, truncating or padding with nulls (if necessary) 
	 	so the copy has the specified length. */
		vettore = Arrays.<E>copyOf(vettore, vettore.length * 2);
	}
	vettore[size++] = item;
	return true;
}
   
/**
  * Inserts the specified element at the specified position in this list.
  *  Shifts the element currently at that position (if any) and any subsequent
  *  elements to the right (adds one to their indices).
  *
  */
public void add(int index, E item) {
	if (index < 0 || index > size) throw new IndexOutOfBoundsException();
   	if (item == null) return;
	if (size == vettore.length) vettore = Arrays.<E>copyOf(vettore, vettore.length * 2);
	for (int i=size; i > index; i--) vettore[i] = vettore[i-1]; //shift
	vettore[index] = item;
	size++;
}

/**
 *  Returns the index of the first occurrence of the specified element in this list, 
 *  or -1 if this list does not contain the element.
 *
 */
public int	indexOf(Object x) {
	if (x != null) 
		for (int i=0; i < size; i++) if (x.equals(vettore[i])) return i; 
    return -1;
}


/**
 *  Returns true if this list contains the specified element.
 *
 */
public boolean contains(Object x) { 
	// return (indexOf(x) != -1); 
	if (x != null)
		for (int i=0; i < size; i++) if (x.equals(vettore[i])) return true; 
    return false;
}
 
 /**
  *  Removes the element at the specified position in this list.
  *  Throws: IndexOutOfBoundsException - if the index is out of range
  *  (index < 0 || index >= size())
  *
  */
public E remove(int index)
{
	if (index < 0 || index >= size ) throw new IndexOutOfBoundsException();
  	E item = vettore[index];
  	// vettore[index] = vettore[size-1]; // Theta(1)
    for (int i=index+1; i<size; i++) vettore[i-1]=vettore[i]; // O(size)
    vettore[--size] = null;
  	if (size <= vettore.length/4) {
  		// We decrease the size of the array if necessary, halving it
  		int newLength = (vettore.length/2 < initialSize ? initialSize: vettore.length/2);
  		vettore = Arrays.<E>copyOf(vettore, newLength);
  	}  		
    return item;
}
    
 
/**
  *  Removes the first occurrence of the specified element from this list, if it is present. 
  *  If the list does not contain the element, it is unchanged. More formally, removes the
  *  element with the lowest index i such that 
  *  (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
  *  Returns true if this list contained the specified element (or equivalently,
  *  if this list changed as a result of the call).
  *
  */
public boolean remove (Object o)
{
	if (isEmpty()) return false;
    int i = indexOf(o);
    if ( i == -1) return false; //the list does not contain the element
    else remove(i);
    return true;
}


/**
  *  Returns the data at the specified position in the list.
  *  IndexOutOfBoundsException - if the index is out of range 
  *  (index < 0 || index >= size())
  *
  */
public E get(int index)
{
	if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    return vettore[index];
}
  
  
/**
  *  Returns a string representation
  *
  */
public String toString()
{
	StringBuffer result = new StringBuffer();  
    for(E x : this) result.append(x + " ");
    return result.toString();
}
   

public boolean equals(Object obj) {
	   return this == obj;
}
   
    
public Iterator<E> iterator()
{
	return new ArrayIterator();
}

     
/** 
 * Returns a list iterator over the elements in this list (in proper sequence)
 * 
 */
public ListIterator<E> listIterator() { 
	return new ArrayIterator();   
}

     
/*******************************************************
 *
 *  The Iterator class
 *
 ********************************************************/
     
private class ArrayIterator  implements ListIterator<E>
{
	private int nextIndex;
	
	public ArrayIterator()
    {
		nextIndex = 0;
    }

	public boolean hasNext()
    {
		return nextIndex < size;
    }

    public E next()
    {
    	if (nextIndex >= size) throw new NoSuchElementException();
        return vettore[nextIndex++];
    }

    public void remove() { //remove the element at the position nextIndex-1
    	if (nextIndex == 0) throw new NoSuchElementException();
        for (int i=nextIndex; i<size; i++) vettore[i-1]=vettore[i];
        vettore[--size] = null;
        nextIndex--;
        if (size <= vettore.length/4) {
        	int newLength = (vettore.length/2 < initialSize ? initialSize: vettore.length/2);
          	vettore = Arrays.copyOf(vettore, newLength);
        }
    }      	
        
    public void set(E e)
 	{ 
    	// non si è ancora invocato next()
    	if (e == null || nextIndex == 0) throw new NoSuchElementException();
        vettore[nextIndex-1] = e;
 	}
        
    public void add(E e)  //insert the element at the position nextIndex
 	{
    	if (e == null) return;
        if (size == vettore.length) vettore = Arrays.<E>copyOf(vettore, vettore.length * 2);
        for (int i=size; i > nextIndex; i--) vettore[i] = vettore[i-1]; //shift
        vettore[nextIndex] = e;
        size++;
  	    nextIndex++;
 	}
        
        
        /* Esercizio: Implementare*/
        
        public boolean hasPrevious() 
        { throw new UnsupportedOperationException(); }
        
        public E previous()
        { throw new UnsupportedOperationException(); }

        public int nextIndex()
 	   	{ throw new UnsupportedOperationException(); }
        
        public int previousIndex()
 	   	{ throw new UnsupportedOperationException(); }

     }  //end class ArrayIterator
     
     
   public List<E> subList(int fromIndex, int toIndex)
   // Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. 
   { throw new UnsupportedOperationException(); }

   public int lastIndexOf(Object o)
   // Returns the index of the last occurrence of the specified element in this list,
   // or -1 if this list does not contain the element.
   { throw new UnsupportedOperationException(); }

   public ListIterator<E> listIterator(int index)
     	// Returns a list iterator over the elements in this list (in proper sequence),
	// starting at the specified position in the list.
   { throw new UnsupportedOperationException(); }

   public boolean addAll(Collection<? extends E> c)
   { throw new UnsupportedOperationException(); }

   public boolean addAll(int index, Collection<? extends E> c)
   { throw new UnsupportedOperationException(); }



} // end-class MyArrayLIst

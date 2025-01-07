/***************************************************************************
 * 
 * SortedLinkedList.java
 *
 * More advanced implementation of the Collection interface using a doubly
 * linked list with references to both the head and tail Node's in the list.
 *
 *****************************************************************************/

import java.util.*;

public class SortedLinkedList<E extends Comparable<? super E>> implements List<E> {
	// Remark: Implemented Interface: java.lang.Iterable<E> 


 /*******************************************************
 *
 *  The Node class
 *
 ********************************************************/
   private static class Node<E> {
	   private E data;
	   private Node<E> next;
	   private Node<E> prev;

      public Node(E data, Node<E> next, Node<E> prev) {
         this.data = data;
         this.next = next;
         this.prev = prev;
      }
   }  //end-class-Node
   
      
   private Node<E> head = null;
   private Node<E> tail = null;
   private int size = 0;
   private Comparator<? super E> c = null;

   /**
    *  Constructs an empty list
    */
    public SortedLinkedList() { }
    
    
    /**
     *  Constructs an empty list
     */
    public SortedLinkedList(Comparator<? super E> comparator) 
    {
      c = comparator;
    }
    
       
  /**
   *  Returns true if the list is empty
   */
   public boolean isEmpty()  {  return size == 0; }

  /**
   *  Returns the length of the list
   */
   public int size()  { return size; }
   
   /**
    *  Gets the value of the property comparator
    */
    Comparator<? super E> getComparator()  { return c; }
         
   /**
    *  Returns the first element in the list.
    *
    */
   public E getFirst()
   {
	   if(head == null) throw new NoSuchElementException();
       return head.data;
   }
   
   
  /**
    *  Removes the first element in the list.
    *
    */
    public E removeFirst()
    {
 	  if (head == null) throw new NoSuchElementException(); // size == 0
       E elem = head.data;
       if (size == 1) {
    	   head = tail = null;  //empty list
       } else {
    	   head = head.next;
    	   head.prev.next = null;
    	   head.prev = null;
       }
       size--;
       return elem;
    }
    
    /**
     *  Returns the last element in the list.
     *
     */
     public E getLast()
     {
        if (tail == null) throw new NoSuchElementException(); // size == 0
        return tail.data;
     }
     
     
   /**
     *  Removes the last element in the list.
     *
     */
     public E removeLast()
     {  
    	 if (tail == null) throw new NoSuchElementException();  // size == 0
    	 E elem = tail.data;
    	 if (size == 1) return removeFirst();
    	 else { // there are at least two nodes
    		 tail = tail.prev;
    		 tail.next.prev = null;
    		 tail.next = null;
    		 size--;
        	 return elem;
    	 }
     }


   /**
     *  Removes all nodes from the list.
     *
     */
     public void clear()
     {
    	 head = tail = null; size=0;
     }
       
   
   /**
    *  Returns the data at the specified position in the list.
    *  IndexOutOfBoundsException - if the index is out of range 
    *  (index < 0 || index >= size())
    *
    */
      public E get(int index)
     {
        if (head == null || index < 0 || index > size - 1 ) 
        	throw new IndexOutOfBoundsException();
        Node<E> cur;
        int count;
        if (index <= size/2)
        	for (cur = head, count = 0; count < index; count++) cur = cur.next;
        else 
        	for (cur = tail, count = size-1; count > index; count--) cur = cur.prev; 
        return cur.data;
     }
      
 
   /**
     *  Returns a string representation
     *
     */
     public String toString()
     {
    	 StringBuffer result = new StringBuffer();  
    	 for(Object x : this) result.append(x + " ");
    	 return result.toString();
     }
     
     
     /**
      *  Removes the first occurrence of the specified element in this list.
      *
      */
      
      private boolean lessThan(E x, E y){
     	   if (c == null) return (x.compareTo(y) < 0);
     	   else return (c.compare(x, y)) < 0;
      }
        

   /**
     *  Removes the first occurrence of the specified element in this list.
     *
     */
      
      public boolean remove(Object key)
      {
     	 return false;
      }
      
      public boolean remove(E obj)
      { 
    	 if ( obj == null || head == null || lessThan(obj, head.data) ) return false;
    	 Node<E> cur  = head;
    	 while(cur != null && lessThan(cur.data, obj)) cur = cur.next;
    	 //  this list does not contain the specified element
    	 if(cur == null || !cur.data.equals(obj)) return false;
    	 // removes the first occurrence of the specified element from this list,
    	 if (cur == head) removeFirst();
    	 else {
    		 if (cur == tail) removeLast();
    		 else {
    			 cur.prev.next = cur.next;
    			 cur.next.prev = cur.prev;
    			 cur.next = cur.prev = null;
    			 size--;
    		 }
    	 }
    	 return true;	
     }
     
     
  /**
   *  Removes the element at the specified position in this list
   */
  public E remove (int index) {
	  if ((head == null) || (index < 0) || (index > size-1))
		  throw new IndexOutOfBoundsException(); 
	  if (index == 0) return removeFirst();
	  if (index == size-1) return removeLast();
	  // 1 <= index <= size-2
	  int count;
      Node<E> cur; 
      if (index <= size/2)
        	for (cur = head, count = 0; count < index; count++) cur = cur.next;
        else 
        	for (cur = tail, count = size-1; count > index; count--) cur = cur.prev; 
      //removes current node
  	  E item = cur.data;
  	  cur.prev.next = cur.next;
      cur.next.prev = cur.prev;
      cur.next = cur.prev = null;
      size--;
      return item;
  }
          
  /**
   *  Returns true if this list contains the specified element.
   *
   */
  public boolean contains(Object obj) {return false;}
  

  public boolean contains(E obj)  
   {
	  for(E item : this)
   			if(item.equals(obj)) return true;
   			else if (lessThan(obj, item)) break;
      return false;
   }
  
  
  /** Inserts the element into the proper sorted location.
   */
  public boolean add(E item)
  { 
	   if (item == null) return false; 
	   else return add(item,c);
  }
  
  private boolean add(E item, Comparator<? super E> comparator) { 
   
   if (item == null) return false; 
   // we insert the first element
   if (size == 0) {  
	   tail = head = new Node<E>(item, null, null);
	   size++;
	   return true;
 	   }
   // we insert the element at the first position 
   if (lessThan(item, head.data)) {  
	   head = new Node<E>(item, head, null);
	   head.next.prev = head;
	   size++;
	   return true;
   }
   // we insert the element into the proper sorted location   
 	   Node<E> cur = head;
 	   /* We continue until cur reaches the node before which we need to make an insertion:
 	    * if cur reaches null, we insert the element at the last position (after tail), 
 	    * otherwise we insert the element between prev and cur
 	    */
 	   while (cur!= null && lessThan(cur.data, item)) cur = cur.next;
 	   if (cur == null) {
 		   // inserts the element at the last position
 		   tail.next = new Node<E>(item, null, tail);
 		   tail = tail.next;
 	   } else { 
 		   // (cur.data >= item) inserts the element between prev and cur
 		   Node<E> prev = cur.prev;
 		   Node<E> newnode = new Node<E>(item, cur, prev);
 		   cur.prev = newnode;
 		   // remark: prev could be null if item is equal to the first element
 		   if (prev!=null) prev.next= newnode; else head =  newnode;
 	   }
 	   size ++;
 	   return true;
  } //end-add 
        
   
   /**
    * toArray() method returns an array containing all of
    * the elements in this list in proper sequence (from
    * first to last element). 
    * */ 
    public Object[] toArray() {
 	   if (head == null) return null;
        Object[] array = new Object[size];
        int i=0;	
        for (E item: this) {array[i++] = item; }
        return array;
      }
   

   public boolean equals (Object obj) {
	   return (this == obj);
   }
    
    /** 
     * Two lists are equal if they contain equal objects
     * in the same order.
     * 
     */
    public boolean equals (SortedLinkedList<E> obj) {
 	   if (obj == null) return false;
 	   if (this.size != obj.size) return false;
 	   Iterator<E> itr1 =  this.iterator();
 	   Iterator<E> itr2 = obj.iterator();
 	   while (itr1.hasNext())
 		   if ( !itr1.next().equals(itr2.next()) ) return false;
 	   return true;
    }
   
   
   /** 
    * Appends the specified element to the end of this list.
    * 
    */
   public void append(E item)
   { 
   if (item == null) throw new NullPointerException();
	   // we insert the first element
	   if (size == 0) tail = head = new Node<E>(item, null, null); 
	   else {
	 	   // we insert the element at the last position 
		   tail.next = new Node<E>(item, null, tail);
		   tail = tail.next; 
	   }
	   size++;
   }
   
   
   public void sort() //O(n lgn)
   {
	   sort(null);
   }
   
   public void sort(Comparator<? super E> comparator) 
   //O(n lgn) Mergesort-based
   {
	   if (this.isEmpty()) return;
	   List<E> array = new ArrayList<E>(this);
       if (comparator == null) Collections.sort(array); 
       else  Collections.sort(array, comparator);
	   SortedLinkedList<E> list = new SortedLinkedList<E>();
	   for (E item: array) list.append(item);
	   head = list.head;
	   tail = list.tail;
	   c = comparator; 
   }
   
   
   /**
    *  Sets the value of the property comparator
    */
  public void  setComparator(Comparator<? super E> comparator)
  	{
  		sort(comparator); //O(n log n)
  	}
  
   
  public void add(int index, E item) //potrebbe violare l'ordinamento
  // Inserts the specified item at the specified position in this list.
  { throw new UnsupportedOperationException(); }
  
  public E set(int index, E element) //potrebbe violare l'ordinamento
  // Replaces the element at the specified position in this list with the specified element.
  { throw new UnsupportedOperationException(); }

   
   
   
   

   
   /*******************************************************
   *
   *  The Iterator class
   *
   ********************************************************/
   
 public Iterator<E> iterator()
 {
    return new MyLinkedListIterator();
 }
 
 /** 
  * Returns a list iterator over the elements in this list (in proper sequence)
  * 
  */
 public ListIterator<E> listIterator()
 { 
     return new MyLinkedListIterator();   
 }
 
 public ListIterator<E> listIterator(int index)
 { 
     return new MyLinkedListIterator(index);   
 }


 private class MyLinkedListIterator  implements ListIterator<E>
 {  
	/* Recall:  ListIterator has no current element; its cursor position 
    always lies between the element that would be returned by a call to 
    previous() and the element that would be returned by a call to next(). */
	 
	 private Node<E> nextNode;
     private Node<E> prevNode;
     private Node<E> lastNode = null; //last returned         
	 private int posNext;   	 

	 
    public MyLinkedListIterator()
    {
    	//reference to the node containing the element that 
    	//would be returned by a call to next()
    	nextNode = head;
    	//reference to the node containing the element that
    	//would be returned by a call to previous()
    	prevNode = null;
    	posNext = 0;  // position of the "next" node
    	// posNext-1 is the position of the "prev" node 
    }
           
    public MyLinkedListIterator(int index)
    {
    	if ((index < 0) || (index > size)) throw new IndexOutOfBoundsException(); 
  	  	if (index == size) {
  	  		nextNode = null;
  	  		prevNode = tail;
  	  		posNext = size;
  	  	} else {
  	  		for (nextNode = head, posNext = 0; posNext<index; posNext++)
  	  			nextNode = nextNode.next;
  	  		prevNode = nextNode.prev; 
  	  	}
    }
    

    public boolean hasNext()
    {
       return nextNode != null;
    }
    
    public boolean hasPrevious() 
    { 
    	return prevNode != null;
    }	

    public E next()
    {
       if (!hasNext()) throw new NoSuchElementException();
       E res = nextNode.data;
       prevNode = nextNode;
       nextNode = nextNode.next;
       // invariant that identifies the last call to next()
       lastNode = prevNode; 
       posNext++;
       return res; // in prevNode
    }
    
    public E previous()
    {
        if (!hasPrevious()) throw new NoSuchElementException();
        E res = prevNode.data;
        nextNode = prevNode;
        prevNode = prevNode.prev;
        // invariant that identifies the last call to previous()
        lastNode = nextNode; 
        posNext--;
        return res;  // in nextNode
    }

    public int nextIndex()
   	{ return posNext; }
    
    public int previousIndex()
   	{ return posNext-1; }
    
    
    /* Removes from the list the last element that was returned by next()
     * or previous() (optional operation).
     * This call can only be made once per call to next or previous. 
     * It can be made only if add(E) has not been called after the last
     * call to next or previous.
     */
    public void remove() {
    	/* next()/previous() has not been called yet or 
    	   remove has already been called */
    	if (lastNode == null) throw new NoSuchElementException();
    	
    	//if the last object is returned by a call to next()
    	if (lastNode == prevNode) prevNode = prevNode.prev;
    	else //the last object is returned by a call to previous()
    		nextNode = nextNode.next;
    	
    	// remove lastNode between prevNode and nextNode
   	  	if (lastNode == head) { //prevNode == null
   	  		head=head.next;
   	  		head.prev = null;
   	  		lastNode.next = null;
   	  	} else {
   	  		if (lastNode == tail) { //nextNode == null
   	  			tail = tail.prev; 
   	  			tail.next = null;
   	  			lastNode.prev = null;
   	  		} else {
   	  			prevNode.next = nextNode;
   	  			nextNode.prev = prevNode;
   	  			lastNode.next = lastNode.prev = null;
   	  		}
   	  	}
  		lastNode = null;
   	  	posNext--;
        size--;
    }
     
    /* Inserts the specified element into the list (optional operation). 
     * The element is inserted immediately before the element that would
     * be returned by next(), if any, and after the element that would be
     * returned by previous(), if any. 
     * (If the list contains no elements, the new element becomes the
     * sole element on the list.) 
     * The new element is inserted before the implicit cursor: a subsequent
     * call to next would be unaffected, and a subsequent call to previous
     * would return the new element. 
     * (This call increases by one the value that would be returned by a call
     * to nextIndex or previousIndex.)
     */
   public void add(E e) 
   { 
     if (e == null) throw new NullPointerException();  
   	 if (size == 0) {
   		 // we insert the first element
   		 tail = head = new Node<E>(e, null, null);
   		 prevNode = head;
   		 posNext = 1;
   	   	 size++;
   	   	 return;
   	 }
   	 if (prevNode == null) {  //addFirst
   		 head = new Node<E>(e, head, null);
    	 head.next.prev = head;
    	 prevNode = head;
    	 lastNode = null;
    	 posNext++;
    	 size++;
    	 return;
   	 }
   	 if (prevNode == tail) {  //addLast
   		 tail.next = new Node<E>(e, null, tail);
   		 tail = tail.next;
   		 prevNode = tail;
   		 lastNode = null;
    	 posNext++;
    	 size++;
    	 return;
   	   }
   	 
   	 Node<E> cur = new Node<E> (e, nextNode, prevNode);
   	 prevNode.next = cur;
   	 nextNode.prev = cur;
   	 prevNode = cur;
   	 lastNode = null;
	 posNext++;
	 size++;
   }
   		     
    /* Replaces the last element returned by next() or previous() with the
     * specified element (optional operation).
     * This call can be made only if neither remove() nor add(E) have been
     * called after the last call to next or previous.
     */
    public void set(E e)  
    {     	
    	if (lastNode == null) throw new NoSuchElementException();
        if (e == null) throw new NullPointerException();  
    	lastNode.data = e;
    }
        
 }  //end class LinkedListIterator


 /************************************************************************************
  *   			EXERCISE
  ************************************************************************************/
             
 /************************************************************************************
  *   					Esercizio
  * Scrivere il metodo 
  * public  SortedLinkedList<E> copy()
  * interno alla classe MyLinkeList<E> che restituisce una copia della lista.
  * 
  * 						Exercise
  * Write the method 
  * public  SortedLinkedList<E> copy()
	 * which returns a copy of the list. Complexity: O(n)
  * 
  ************************************************************************************/

 	public  SortedLinkedList<E> copy()
 	{
	    SortedLinkedList<E> twin = new SortedLinkedList<E>();
	    if (size == 0) return twin;
	    Iterator<E> itr = this.iterator();
	    // add first node
	    twin.tail = twin.head = new Node<E>(itr.next(), null, null);
	    twin.size++;
	    while (itr.hasNext()) {
	 	   // addLast
	        twin.tail.next = new Node<E>(itr.next(), null, twin.tail);
	        twin.tail = twin.tail.next;
	        twin.size++;
	    }
	    return twin;
}


 	//  version 2 append-based
 	public  SortedLinkedList<E> copy2()
 	{
	   SortedLinkedList<E> twin = new SortedLinkedList<E>();
	   for (E item: this) twin.append(item);
	   return twin;
 	}

   
/************************************************************************************
 *   					Esercizio (estratto dal I Parziale del 2020)
 * Implementare il metodo 
 * public boolean addAll(Collection<? extends E> coll), 
 * interno alla classe SortedLinkedList, che inserisce nella lista corrente
 * (this) tutti gli elementi nella collezione specificata in modo da non violare
 * l'ordinamento.
 * 
 * 						Exercise (extracted from the I partial exam of 2020)
 * Implement the 
 * public boolean addAll(Collection<? extends E> coll) 
 * method, internal to the SortedLinkedList class, which inserts all
 * the elements in the specified collection into the current list (this) so
 * as not to violate the sorting.
 * 
 ************************************************************************************/

  public boolean addAll(Collection<? extends E> coll) {
	   if (coll == null || coll.isEmpty()) return false;
	   for (E item: coll) add(item);
	   return true;
  }
 
  
 
 
 public List<E> subList(int fromIndex, int toIndex)
 // Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive. 
 { throw new UnsupportedOperationException(); }

 public int indexOf(Object o)
 // Returns the index of the first occurrence of the specified element in this list,
 // or -1 if this list does not contain the element.
 { throw new UnsupportedOperationException(); }

 public int lastIndexOf(Object o)
 // Returns the index of the last occurrence of the specified element in this list,
 // or -1 if this list does not contain the element.
 { throw new UnsupportedOperationException(); }
     
   public boolean retainAll(Collection<?> c)
   { throw new UnsupportedOperationException(); }

   public boolean removeAll(Collection<?> c)
   { throw new UnsupportedOperationException(); }
   
   public boolean addAll(int index, Collection<? extends E> c)
   { throw new UnsupportedOperationException(); }
   
   public boolean containsAll(Collection<?> c)
   { throw new UnsupportedOperationException(); }

   public <T> T[] toArray(T[] a)
   { throw new UnsupportedOperationException(); }
     
   
} // end-class 
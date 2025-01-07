/***************************************************************************
 * 
 * MyLinkedList.java
 *
 * More advanced implementation of the Collection interface using a doubly
 * linked list with references to both the head and tail Node's in the list.
 *
 *****************************************************************************/

import java.util.*;

public class MyLinkedList<E> extends AbstractSequentialList<E> implements List<E> {
   	// Remark: All Implemented Interfaces:
    //java.lang.Iterable<E>, java.util.Collection<E>, java.util.List<E> 


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

   /**
    *  Constructs an empty list
    */
    public MyLinkedList() { }
       
  /**
   *  Returns true if the list is empty
   */
   public boolean isEmpty()  {  return size == 0; }

  /**
   *  Returns the length of the list
   */
   public int size()  { return size; }
     
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
    * Inserts the specified element at the beginning of this list.
    * 
    */
	public void addFirst(E item)
	{
     if (item == null) throw new NullPointerException();  
	 if (size == 0)
		 // we insert the first element
		 tail = head = new Node<E>(item, null, null);
	 else {
		   // we insert the element at the first position 
		   head = new Node<E>(item, head, null);
		   head.next.prev = head;
		   /*  //alternativo
		   Node<E> cur =  new Node<E>(item, head, null);
		   head.prev = cur;
		   head = cur; 
		    */
		 }
	 size++; 		
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
      * Appends the specified element to the end of this list.
      * 
      */
     public void addLast(E item)
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
      * Appends the specified element to the end of this list.
      * 
      */
     public boolean add(E item)
     { 
  	   if (item == null) throw new NullPointerException();
  	   addLast(item);
  	   return true;
     }
     

   /**
   *  Inserts the specified item at the specified position in this list.
   *  Throws: IndexOutOfBoundsException - if the index is out of range
   *  (index < 0 || index > size())
   *
   */
   public void add(int index, E item)
   {
   if (item == null) throw new NullPointerException();
   if (index < 0 || index > size) throw new IndexOutOfBoundsException();
   if (index == 0)  {
     addFirst(item); 
     return;
   }
   if(index == size)  {
     addLast(item); 
     return;
   }
   Node<E> pre;
   int count;
   // la direzione dell'iterazione dipende dalla posizione index
   if (index <= size/2)
	   for (pre = head, count = 0; count < index-1; count++) pre = pre.next;
   else 
	   for (pre = tail, count = size-1; count > index-1; count--) pre = pre.prev;      
   Node<E> cur = new Node<E>(item, pre.next, pre);
   pre.next = cur;
   cur.next.prev = cur;
   size++;
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
       * Replaces the element at the specified position in this list with the specified element.
       * 
       */
      public E set(int index, E item) 
      {  
          if (index < 0 || index > size-1) throw new IndexOutOfBoundsException();
          if (item == null) throw new NullPointerException();
          Node<E> cur;
          int count;
          if (index <= size/2)
          	for (cur = head, count = 0; count < index; count++) cur = cur.next;
          else 
          	for (cur = tail, count = size-1; count > index; count--) cur = cur.prev; 
          E prevElem = cur.data;
          cur.data = item;
          return prevElem;
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
     public boolean remove(Object obj)
     { 
    	 if ( obj == null || head == null ) return false;
    	 Node<E> cur  = head;
    	 while(cur != null && !cur.data.equals(obj)) cur = cur.next;
    	 //  this list does not contain the specified element
    	 if(cur == null) return false;
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
      *  Removes the first occurrence of the specified element in this list.
      *  (for teaching purposes)
      *
      */
      public boolean removeRec (E obj)
      {
         if ( (obj == null) || (head == null)) return false;
         if (head.data.equals(obj)) { 
       	  removeFirst();
       	  return true; 
         } else return removeRec(head.next, obj);
      }


      private boolean removeRec (Node<E> cur, E obj){
         if (cur == null) return false;
         if (cur.data.equals(obj)) {
      	    if (cur == tail) removeLast();
      	    else {
      	    	  cur.prev.next = cur.next;
      	    	  cur.next.prev = cur.prev;
      	    	  cur.next = cur.prev = null;
      	    	  size--;
      	    }
       	  return true;
         }
         else return removeRec(cur.next, obj);
          	
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
      public boolean contains(Object obj)  
       {
    	  for(E item : this)
       			if(item.equals(obj)) return true;
          return false;
       }
        
   
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
  *   			HOMEWORK
  ************************************************************************************/
             
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
   
   public boolean addAll(Collection<? extends E> c)
   { throw new UnsupportedOperationException(); }
    

    
   
} // end-class 
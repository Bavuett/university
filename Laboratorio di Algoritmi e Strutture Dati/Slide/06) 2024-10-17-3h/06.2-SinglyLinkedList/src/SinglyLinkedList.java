 /***************************************************************************
 *
 * SinglyLinkedList.java
 *
 * An implementation of the List interface using a singly linked list.
 * 
 *
 *****************************************************************************/

import java.util.*;

public class SinglyLinkedList<E> extends AbstractSequentialList<E> implements List<E> {
   	// Remark: All Implemented Interfaces:
    //java.lang.Iterable<E>, java.util.Collection<E>, java.util.List<E> 


/*******************************************************
 *   					PARTE 1
 ********************************************************/
	
	
	
 /*******************************************************
 *
 *  The Node class
 *
 ********************************************************/
   private static class Node<E> {
      private E data;
      private Node<E> next;  

      public Node(E data, Node<E> next) {
         this.data = data;
         this.next = next;
      }
           
   }  //end-class-Node


   private Node<E> head = null;
   private Node<E> tail = null;
   private int size = 0;

 /**
   *  Constructs an empty list
   */
   public SinglyLinkedList() { }

 /**
   *  Returns true if the list is empty
   *
   */
   public boolean isEmpty()
   {
      return size == 0;
   }

 /**
   *  Returns the length of the list
   *
   */
   public int size()  
   {
      return size;
   }

 /**
   *  Inserts a new node at the beginning of this list.
   *
   */
   public void addFirst(E item)
   {
	  if (item == null) throw new NullPointerException();
	  head = new Node<E>(item, head);
      if (tail == null) tail = head;
      size++;	
   }

 /**
   *  Returns the first element in the list.
   *
   */
   public E getFirst()
   {
      if(size == 0) throw new NoSuchElementException();
      return head.data;
   }

 /**
   *  Removes the first element in the list.
   *
   */
   public E removeFirst()
   {
	  if(size == 0) throw new NoSuchElementException();
      E elem = getFirst();
      head = head.next;
      size--;
      if (size == 0 ) tail = null;
      return elem;
   }

 /**
   *  Inserts a new node to the end of this list.
   *
   */
   public void addLast(E item)
   {
      if (item == null) throw new NullPointerException();
	  if( size == 0)
         addFirst(item);
      else
      {
         /* //Notice: without tail reference \Theta(size)
    	 Node<E> tmp = head;
         while(tmp.next != null) tmp = tmp.next;
         tmp.next = new Node<E>(item, null);
         */
         tail.next = new Node<E>(item, null);
         tail = tail.next;
         size++;
      }
   }


 /**
   *  Returns the last element in the list.
   *
   */
   public E getLast()
   {
      if(size == 0) throw new NoSuchElementException();
      /* //Notice: without tail reference \Theta(size) 
      Node<E> tmp = head;
      while(tmp.next != null) tmp = tmp.next;
      return tmp.data;
      */
      return tail.data;
   }


 /**
   *  Removes the last element in the list.
   *
   */
   public E removeLast()
   {  

	  if (size == 0) throw new NoSuchElementException();
	  if (size == 1) return this.removeFirst();
 
      Node<E> prev = head;
      E elem = tail.data; 
      
      while (prev.next != tail) prev = prev.next;
      prev.next = null;
      tail = prev;
      size--;
      return elem;
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
   *  Inserts a new node to the end of this list.
   *
   */
   public boolean add(E item)
   {	 
	  this.addLast(item);
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
	   if(index == 0)  {
         addFirst(item); 
         return;
	   }
	   if(index == size)  {
	     addLast(item); 
	     return;
	   }
	  // if 1 <= index <= size-1
      Node<E> prev = head;
      for (int count = 0; count < index-1; count++) prev = prev.next;
      prev.next = new Node<E>(item, prev.next);
      size++;
   }


 /**
   *  Returns true if this list contains the specified element.
   *
   */
   public boolean contains(Object x)
   {
      for(E elem : this)
         if(elem.equals(x)) return true;
      return false;
   }


 /**
   *  Returns the data at the specified position in the list.
   *  IndexOutOfBoundsException - if the index is out of range 
   *  (index < 0 || index >= size())
   *
   */
   public E get(int index)
   {
      if (index < 0 || index > size-1) throw new IndexOutOfBoundsException();
      Node<E> cur = head;
      for (int count = 0; count < index; count++)  cur = cur.next;
      return cur.data;
   }


 /**
   *  Returns a string representation
   *
   */
   public String toString()
   {
      StringBuffer result = new StringBuffer();  
      for(Object x : this)
      	result.append(x + " ");

      return result.toString();
   }

 /**
   *  Removes the first occurrence of the specified element in this list.
   *  Returns true if this list contained the specified element
   *  (or equivalently, if this list changed as a result of the call).
   *
   */
   public boolean remove(Object key)
   {
      if(size == 0)  return false;
      if( head.data.equals(key) )
      {
    	  removeFirst();
    	  return true;
      }
      /*{
         head = head.next;
         size--;
         if (size == 0) tail = null;
         return true;
      }*/
      Node<E> prev = null;
      Node<E> cur  = head;
      while(cur != null && !cur.data.equals(key) )
      {
         prev = cur;
         cur = cur.next;
      }
      if(cur == null) return false;
      else { //delete cur node
    	  prev.next = cur.next;
    	  if (cur == tail) tail = prev;
    	  size--;
    	  return true;	
      }
   }
   
   
   /**
    *  Removes the element at the specified position in this list.
    *  Throws: IndexOutOfBoundsException - if the index is out of range
    *  (index < 0 || index >= size())
    *
    */
    public E remove(int index)
    {
      E item;
      if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
 	  if (index == 0) return removeFirst(); 
      if (index == size-1) return removeLast(); 

 	  Node<E> prev = head;
      for (int count = 0; count < index-1; count++) prev = prev.next;
      item = prev.next.data;
      prev.next = prev.next.next;
      size--;
      return item;  
    }
    
    
    /**
     *  Returns an array containing all of the elements in this list in proper
     *  sequence (from first to last element).
     *
     */
    public Object[] toArray() {
   	 if (size==0) return null;
   	 Object[] array = new Object[size];
   	 int i=0;
   	 for (E item: this) array[i++] = item;
   	 return array;
    }
    
    
    
    /************************************************************************************
     *   			HOMEWORK
     * Riscrivere il metodo equals() interno alla classe SinglyLinkeList<E>
     * per confrontare questa lista con un altro oggetto di tipo SinglyLinkeList<E>: 
     * due liste sono uguali se contengono oggetti uguali nel medesimo ordine.
     * 
     * Override the equals() method inside the SinglyLinkeList<E> class
     * to compare this list with another object of type SinglyLinkeList<E>:
     * two lists are equal if they contain equal objects in the same order.
     * 
     * 
     ************************************************************************************/
  
    
    
    /* public boolean equals(Object obj) { 
 	   return (this == obj);
    }
    */
    
    /*** Soluzione iterativa ***/
    

    public boolean equalsIt(Object obj) {
 	   if (this == obj) return true;
 	   if (obj == null) return false;
 	   if (!(obj instanceof SinglyLinkedList<?>)) return false; 
 	   SinglyLinkedList<?> otherList = (SinglyLinkedList<?>)obj;
 	   //confronto delle size
 	   if (size != otherList.size()) return false;
 	   //iterazione delle liste in parallelo
 	   Iterator<E> itr1 = this.iterator();
 	   Iterator<?> itr2 = otherList.iterator();
 	   while (itr1.hasNext()) {
 		   if (!itr1.next().equals(itr2.next())) return false;
 	   }
 	   return true;
    }
    
    /*** Soluzione ricorsiva alternativa (in caso d'uso, rinominare con equals())  ***/
    
 
    public boolean equalsRec(Object obj) {
       if (this == obj) return true;
       if (obj == null) return false;
       if (!(obj instanceof SinglyLinkedList<?>)) return false; 
       SinglyLinkedList<?> otherList = (SinglyLinkedList<?>)obj;
       //confronto delle size
       if (size != otherList.size()) return false;
       else return equals(this.head, (Node<?>)otherList.head);
    }

    private boolean equals(Node<?> n1, Node<?> n2) {
 	 //NB precondizione verificata a monte: le size delle liste coincidono  
       if (n1 == null && n2 == null) return true; 
       // passo ricorsivo
       if ( ! ((n1.data).equals(n2.data)) ) return false;
       else return equals(n1.next, n2.next);
    }
    
       
/*******************************************************
 *   					PARTE 2
 ********************************************************/

   /*******************************************************
   *
   *  The Iterator class
   *
   ********************************************************/
    
     public Iterator<E> iterator()
     {
        return new SinglyLinkedListIterator();
     }

     
     /** 
      * Returns a list iterator over the elements in this list (in proper sequence)
      * 
      */
     public ListIterator<E> listIterator()
     { 
         return new SinglyLinkedListIterator();   
     }


     private class SinglyLinkedListIterator  implements ListIterator<E>
     {  
        private Node<E> nextNode;
        private Node<E> prevNode;
        private int posNext;

        public SinglyLinkedListIterator()
        {
        	// riferimento al nodo contenente l'elemento accessibile invocando next()
        	nextNode = head;
        	// riferimento al nodo contenente l'elemento restituito con l'ultima invocazione di next()
        	prevNode = null;
        	posNext = 0;  // posizione del "next" node
        }

        public boolean hasNext()
        {
           return nextNode != null;
        }

        public E next()
        {
           if (nextNode == null) throw new NoSuchElementException();
           E res = nextNode.data;
           prevNode = nextNode;
           nextNode = nextNode.next;
           posNext++;
           return res;
        }

        public void remove() {
        	// non si è ancora invocato next()
        	if (nextNode == head) throw new NoSuchElementException();
        	// si cancella prevNode alla posizione posNext-1
       	  	Node<E> prev = head;
       	  	if (posNext == 1) head=head.next;
       	  	// cancellazione del nodo in posizione posNext-1
       	  	else {
       	  		for (int k = 0; k < posNext-2; k++) prev = prev.next;
       	  		prev.next = nextNode;
       	  	}
       	  	if (prevNode == tail) tail = prev;
       	  	prevNode = prev;
       	  	posNext--;
            size--;
        }
        
        public void set(E e)
 	   	{ 
        	// non si è ancora invocato next()
        	if (prevNode == null) throw new NoSuchElementException();
        	prevNode.data = e;
 	   	}
        
        public void add(E e)
 	   	{
        	if (nextNode == head) {
        	      head = new Node<E>(e, head);
        	      prevNode = head;  
        	} else {
        		prevNode.next = new Node<E>(e, nextNode);
        		prevNode = prevNode.next; 
        	}
        	if (nextNode == null) tail = prevNode;
  	      	size++;
  	      	posNext++;
 	   	}
        
        
        /* Esercizio: Implementare su liste doppiamente collegate */
        
        public boolean hasPrevious() 
        { throw new UnsupportedOperationException(); }
        
        public E previous()
        { throw new UnsupportedOperationException(); }

        public int nextIndex()
 	   	{ throw new UnsupportedOperationException(); }
        
        public int previousIndex()
 	   	{ throw new UnsupportedOperationException(); }

     }  //end class LinkedListIterator
     
     public ListIterator<E> listIterator(int index)
     // Returns a list iterator over the elements in this list (in proper sequence),
 	// starting at the specified position in the list.
    { throw new UnsupportedOperationException(); }
     
        
 /************************************************************************************
  *   			HOMEWORK
  ************************************************************************************/
   public E set(int index, E element)
   // Replaces the element at the specified position in this list with the specified element.
   { throw new UnsupportedOperationException(); }

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

   public boolean addAll(Collection<? extends E> c)
   { throw new UnsupportedOperationException(); }

   public boolean addAll(int index, Collection<? extends E> c)
   { throw new UnsupportedOperationException(); }

   public boolean containsAll(Collection<?> c)
   { throw new UnsupportedOperationException(); }

   public <T> T[] toArray(T[] a)
   { throw new UnsupportedOperationException(); }
   

   
 
} // end-class SinglyLInkedList



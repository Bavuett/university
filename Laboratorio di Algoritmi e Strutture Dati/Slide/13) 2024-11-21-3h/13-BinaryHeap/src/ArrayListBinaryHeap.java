
/***************************************************************************
 *
 * ListBinaryHeap.java
 *
 * The ListBinaryHeap.java class implements a binary heap (Max-Heap) according to
 * the element class's implementation of the Comparable and Comparator interfaces
 *
 *****************************************************************************/

import java.util.*;


public class ArrayListBinaryHeap<T extends Comparable<? super T>> implements BinaryHeap<T>
{
    private ArrayList<T> H = new ArrayList<T>(); 		  // The heap HList
    private Comparator<T> c = null;
    // Notice: we use a dummy node, the logical size is H.size()-1
    
    private boolean greaterThan(int i, int j, Comparator<T> comparator){
  	if (comparator == null) return H.get(i).compareTo(H.get(j)) > 0;
  	else return comparator.compare(H.get(i), H.get(j)) > 0;
    }
    
   
    /**
     * Construct the binary heap.
     */
    public ArrayListBinaryHeap( ) {
    	H.add(null);  // dummy element	
    }

    
    /**
     *  Constructs the binary heap given a comparator
     */
    public ArrayListBinaryHeap(Comparator<T> comparator)
    {
    	c = comparator;
        H.add(null);  // dummy element	
    }


	
    /**
      * Construct the binary heap given an H of items.
      */
     public ArrayListBinaryHeap( T [ ] items)
     {
         H.add(null);  // dummy element	
         for( T item : items ) H.add(item);  //Theta(n)
         heapify( );
     }
     

     /**
      * Construct the binary heap given an H of items and a comparator.
      */
     public ArrayListBinaryHeap( T [ ] items, Comparator<T> comparator)
     {
    	 c = comparator;
         H.add(null);  // dummy element	
         for( T item : items ) H.add(item); 
         heapify( );
     }
     
  
     /**
      * @return the heap size 
      */
     public int size() {return H.size()-1;}

     /**
      * Test if the heap is logically empty.
      * @return true if empty, false otherwise.
      */
     public boolean isEmpty( )
     {
         return H.size() == 1; // it contains only the dummy element
     }
	
	/**
     * Insert into the HList, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( T x )
    {
        // Fix up
    	H.set(0,x);  
    	H.add(x);
        int hole = H.size()-1;  //initial position of x
        while (greaterThan(0, hole/2, c) ) {	
        	H.set(hole, H.get( hole/2 ));
        	hole /= 2; 
        }
        H.set(hole, x);    	
     }


	/**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void fixHeap( int hole )  // Fix down
    {
        int child, currentsize = H.size()-1;
        T tmp = H.get( hole );
      
        while (hole * 2 <= currentsize)
        {
            child = hole * 2;
            if( child != currentsize && greaterThan(child + 1, child, c ) )
                child++;
            if( greaterThan(child, hole, c) ) {
                H.set( hole, H.get(child) );
                hole = child;
                H.set(hole, tmp);
            }
            else break;
        }
        
    }

    
    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    public void heapify( )
    {   int currentsize = H.size()-1;
        for( int i = currentsize / 2; i > 0; i-- )
            fixHeap( i );  // Fix down
    }

  
    
    
    /**
     * Find the greatest item in the heap.
     * @return the greatest item, or throw an exception if empty.
     */
    public T findMax( )
    {
        if( isEmpty( ) )
		throw new NoSuchElementException("The binary heap is empty");
        return H.get(1);
    }

	
    /**
     * Remove the greatest item from the heap.
     * @return the greatest item, or throw an exception if empty.
     */
    public T deleteMax( )
    {
        if( isEmpty( ) )
        	throw new NoSuchElementException("The binary heap is empty");
        T maxItem = H.get(1);  //findMax( );
        T lastItem = H.remove(H.size()-1 ); 
        if (H.size() > 1) {
        	H.set( 1, lastItem );
        	fixHeap( 1 );  // Fix down
        }
        return maxItem;
    }



    /**
     * Make the heap logically empty.
     */
    public void clear( )
    {
        H = new ArrayList<T>();
        H.add(null);
    }
    

}

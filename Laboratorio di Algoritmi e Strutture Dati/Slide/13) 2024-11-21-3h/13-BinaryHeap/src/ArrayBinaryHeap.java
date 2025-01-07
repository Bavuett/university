
/***************************************************************************
 *
 * ArrayBinaryHeap.java
 *
 * The ArrayBinaryHeap.java class implements a binary heap (Max-heap).
 * Note that all "matching" is based on the compareTo method.
 *
 *****************************************************************************/

import java.util.*;


public class ArrayBinaryHeap<T extends Comparable<? super T>> implements BinaryHeap<T>
{

    private static int DEFAULT_CAPACITY = 10;
    private int size;     // Number of elements in heap
    private Object [ ] H; // Notice: we use a dummy node (H[0]) 


    /**
     * Construct the binary heap.
     */
    public ArrayBinaryHeap( )
    {
        this( DEFAULT_CAPACITY );
    }


    /**
     * Construct the binary heap.
     * @param the capacity of the binary heap.
     */
    public ArrayBinaryHeap( int capacity )
    {
    	DEFAULT_CAPACITY = capacity;
    	size = 0;
        H = new Object[ capacity + 1 ];
    }
    
    
	
	/**
     * Insert into the H, maintaining heap order.
     * Duplicates are allowed.
     * @param x the item to insert.
     */
    public void insert( T x )
    {
        if( size == H.length - 1 )
        	H = Arrays.copyOf(H, H.length * 2);
        	// Recall: copyOf() method copies the specified array, truncating or padding
            // with zeros (if necessary) so the copy has the specified length

        // Fix up
        int hole = ++size; //initial position of x
        for( H[0] = x; x.compareTo( (T)H[hole/2] ) > 0; hole /= 2 )
            H[hole] = H[hole/2];
        H[hole] = x;
    } 
   	
	/**
     * Internal method to percolate down in the heap.
     * @param hole the index at which the percolate begins.
     */
    private void fixHeap( int hole )  // Fix down
    {
        int child;
        T item = (T)H[hole];
        while (hole*2 <= size) {  //there exists the left child
            child = hole * 2;  //left child
            if( child != size &&  //there exists the right child
                    ((T)H[child + 1]).compareTo((T)H[child] ) > 0 )
                child++;
            if( ((T)H[child]).compareTo(item) > 0 ) {
                H[hole] = H[child];
                hole = child; 
            } else break; 
        }
        H[hole] = item;
    }

    
    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    public void heapify( )
    {
        for( int i = size / 2; i > 0; i-- )
            fixHeap( i );  // Fix down
    }

	
	
   /**
     * Construct the binary heap given an array of items.
     */
    public ArrayBinaryHeap( T [ ] items )
    {
            size = items.length;
            H = new Object[ size + 1 ];
            int i = 1;
            for( T item : items ) H[i++] = item;
            heapify( );
    }


    
    /**
     * Find the greatest item in the heap.
     * @return the greatest item, or throw an exception if empty.
     */
    public T findMax( )
    {
        if( isEmpty( ) )
		throw new NoSuchElementException("The binary heap is empty");
        return (T)H[1];
    }

	
    /**
     * Remove the smallest item from the priority queue.
     * @return the smallest item, or throw an exception if empty.
     */
    public T deleteMax( )
    {
        if( isEmpty( ) )
		throw new NoSuchElementException("The binary heap is empty");
        T maxItem = (T)H[1];  //findMax( );
        H[1] = H[size--];
        fixHeap( 1 );  // Fix down
        if (size +1 <= H.length/4)
        	H = Arrays.copyOf(H, H.length/2);
        return maxItem;
    }


    /**
     * Test if the heap is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return size == 0;
    }

    /**
     * Make the heap logically empty.
     */
    public void clear( )
    {
        size = 0;
        H = new Object[ DEFAULT_CAPACITY + 1 ];
    }
    
    public int size() {return size;}
    
    /* È possibile fornire un criterio aggiuntivo di confronto tra elementi
     * basato sull’uso di un comparatore ? HOMEWORK
     */



}

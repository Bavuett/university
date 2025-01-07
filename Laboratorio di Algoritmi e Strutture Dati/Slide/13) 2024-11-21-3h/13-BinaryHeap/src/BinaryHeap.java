
/**
 * BinaryHeap.java defines the interface to a binary heap data structure (Max-Heap)
 */
public interface BinaryHeap<T> {


   /**
     * Should be implemented to return true if the binary heap is
     *  empty and false otherwise.
     */
   public boolean isEmpty();

   /**  
     * Should be implemented to return the number of elements in the
     *  binary heap.
     */
   public int size();
   
   
	/**
    * Insert into the array, maintaining heap order.
    * Duplicates are allowed.
    * @param x the item to insert.
    */
   public void insert( T x );
   
   /**
    * Find the greatest item in the heap.
    * @return the greatest item, or throw an exception if empty.
    */
   public T findMax( );
   
   /**
    * Remove the greatest item from the heap.
    * @return the greatest item, or throw an exception if empty.
    */
   public T deleteMax( );
   
   /**
    * Establish heap order property from an arbitrary
    * arrangement of items. Runs in linear time.
    */
   public void heapify( );
   
   /**
    * Make the heap logically empty.
    */
   public void clear( );
   

}  // interface BinaryHeapADT



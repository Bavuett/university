import java.util.*;  

public class HeapsortClass<T extends Comparable<? super T>> {
	
   /**
    *  Sorts a specified array of objects into ascending order, according to
    *  the element class's implementation of the Comparable interface.
    *  The worstTime(n) is O(n * log n).
    *
    *  @param x – the array to be sorted.  
    *
    */ 
  
  public static <T extends Comparable<? super T>> void heapSortA (T[] x) {
	
   int dim = x.length;
   
   BinaryHeap<T> heap = new ArrayBinaryHeap<T> (x); //costruzione Max-Heap
   for (int c = dim-1; c >= 0 ; c--)
	   x[c]= heap.deleteMax(); 
   } // method heapSort
  
   //Homework: estendere la classe ArrayBinaryHeap per la gestione del comparatore
  
  
  public static <T extends Comparable<? super T>> void heapSortAL (T[] x) {
	  // uso implementazione mediante ArrayList (*)
	   int dim = x.length;
	   
	   BinaryHeap<T> heap = new ArrayListBinaryHeap<T>( x ); // (*) //costruzione Max-Heap
	   for (int c = dim-1; c >=0 ; c--)
		   x[c]= heap.deleteMax(); 
	   } // method heapSort
  
  
  public static <T extends Comparable<? super T>> void heapSortAL (T [] x, Comparator<T> comparator) {
	   int dim = x.length;
	   //costruzione Max-Heap
	   BinaryHeap<T> heap = new ArrayListBinaryHeap<T> ( x, comparator );
	   for (int c = dim -1; c >= 0 ; c--)
		   x[c]= heap.deleteMax(); 
	   
	   } // method heapSort
  
  
  
  public static <T extends Comparable<? super T>> void heapSort (T[] x) {
	//in place	
	  int end = x.length - 1; //Notice that x[0 ... end]
	  /*** heapify ***/
	  for( int hole = (end - 1) / 2; hole >= 0; hole-- ) 
		   fixHeap(x, hole, end); 
	  /****************/
	  T maxItem; 
	  for (int c = end; c > 0 ; c--) {
		  maxItem = x[0];  //findMax( );
		  x[0] = x[c];
		  x[c] = maxItem;
		  fixHeap(x, 0, c-1 );  
	  }
  } // method heapSort
  

  /**
    * Internal method to percolate down in the heap.
	* @param hole the index at which the percolate begins.
	* @param end the index at which the percolate ends.
	*/
	    private static <T extends Comparable<? super T>> void fixHeap(T[] x, int hole, int end)  // Fix down
	{
	    int child;
	    T item = x[hole];
	    while (hole*2 + 1 <= end) {  //there exists the left child
	    	child = hole * 2 + 1;  //left child
	    	// if there exists the right child
	    	if( child != end && (x[child + 1]).compareTo(x[child] ) > 0 ) child++;
	    	if( (x[child]).compareTo(item) > 0 ) {
	    		x[hole] = x[child];
	    		hole = child; 
	    	} else break; 
	    }
	    x[hole] = item;
	}

  
    public static void main(String[] args)  {
	   
	  int L = 10000, MAXINT = 15000, NUMSIM = 3000;  //TEST
	  Integer[] numbers, numbersCopy;

      double startTime, endTime;
      // tempi di esecuzione totale in ms
      double time_s=0, time_Ah=0, time_ALh=0, time_h=0;
      	
      Random r = new Random ();

      for (int count=0; count < NUMSIM; count++) {

    	  // GENERAZIONE ARRAY RANDOM
    	  numbers = new Integer[L]; 
       		for (int i = 0; i < L; i++) numbers[i]=r.nextInt(MAXINT);
    
  	//ARRAY-HEAPSORT
  	//System.arraycopy(numbers, 0, numbersCopy, 0, L);
    numbersCopy=numbers.clone();
  	startTime = System.currentTimeMillis(); //The currentTimeMillis() method returns the current time in milliseconds.
  		heapSortA(numbersCopy);
  	endTime = System.currentTimeMillis();
  	time_Ah += endTime - startTime;  //per avere in sec /1000
  	//test correttezza
  	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
  		System.out.println("heapSortA errato!");
  		return; }
  	
  	//ARRAYLIST-HEAPSORT
    numbersCopy=numbers.clone();
  	startTime = System.currentTimeMillis(); //The currentTimeMillis() method returns the current time in milliseconds.
  		heapSortAL(numbersCopy);
  	endTime = System.currentTimeMillis();
  	time_ALh += endTime - startTime;  //per avere in sec /1000
  	//test correttezza
  	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
  		System.out.println("heapSortAL errato!");
  		return; }
  	
  	//HEAPSORT in-place
    numbersCopy=numbers.clone();
  	startTime = System.currentTimeMillis(); //The currentTimeMillis() method returns the current time in milliseconds.
  		heapSort(numbersCopy);
  	endTime = System.currentTimeMillis();
  	time_h += endTime - startTime;  //per avere in sec /1000
  	//test correttezza
  	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
  		System.out.println("heapSort errato!");
  		return; }
  	
  	
	//SORT
	System.arraycopy(numbers, 0, numbersCopy, 0, L);
	startTime = System.currentTimeMillis();
        Arrays.sort(numbersCopy);
	endTime = System.currentTimeMillis();
	time_s += endTime - startTime;
	
}
	
	System.out.println("\n\nTemp medio di esecuzione su " + NUMSIM + " array di " + L +  "interi minori di " + MAXINT);
	System.out.println("Arrays.sort:\t\t" + time_s/NUMSIM + " msec");
	System.out.println("\nheapSortA:\t\t" + time_Ah/NUMSIM + " msec");
	System.out.println("\nheapSortAL:\t\t" + time_ALh/NUMSIM + " msec");
	System.out.println("\nheapSort:\t\t" + time_h/NUMSIM + " msec");

   } // method main

}





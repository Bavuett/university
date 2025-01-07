import java.util.*;  

public class QuicksortClass {

	  /**
	   * Sorts x into ascending order.  Iterative approach.
	   * The worstTime(n) is O(n * n), and averageTime(n) is O(n log n).
	   * It is NOT stable.
	   * 
	   * @param x - the array to be sorted. 
	   */ 
	   public static <T extends Comparable<? super T>> void IterativeQuicksort_0 (T[ ] x){
	        MyStack<Integer> stack = new ArrayStack<Integer>();
	        stack.push(0);
	        stack.push(x.length-1);
	        while (!stack.isEmpty()) {
	          int right = stack.pop();
	          int left = stack.pop();
	          if (right > left) {
	            int i = partition(x, left, right);
	            stack.push(left);
	            stack.push(i-1);
	            stack.push(i+1);
	            stack.push(right);
	          }
	        }
	   }


	  /**
	   * Sorts a into ascending order.  Iterative approach.
	   * The worstTime(n) is O(n * n), and averageTime(n) is O(n log n).
	   * It is NOT stable.
	   * 
	   * @param x - the array to be sorted. 
	   */ 
	   public static <T extends Comparable<? super T>> void IterativeQuicksort_1 (T[ ] a){
	        int[] stack = new int[2*a.length];
	        int stackTop = 0;
	        stack[stackTop++] = 0;
	        stack[stackTop++] = a.length-1;
	        while (stackTop > 0) {
	          int right = stack[--stackTop];
	          int left = stack[--stackTop];
	          while (right > left) {
	            int i = partition(a, left, right);
	            if (i-1 > left) {
	              stack[stackTop++] = left;
	              stack[stackTop++] = i-1;
	            }
	            left = i+1;
	          }
	        }
	   }


  /**
   * Sorts a into ascending order.  Iterative approach.
   * The worstTime(n) is O(n * n), and averageTime(n) is O(n log n).
   * It is NOT stable.
   * 
   * @param x - the array to be sorted. 
   */
   public static <T extends Comparable<? super T>> void IterativeQuicksort (T[ ] a){
        /* si inserisce nello stack prima il piu' grande dei sottoarray,
        ossia si elabora prima l'array piu' piccolo
        => massima dim dello stack: O lg(#el.da ordinare)*/

        int[] stack = new int[2*a.length];
        int stackTop = 0;
        stack[stackTop++] = 0;
        stack[stackTop++] = a.length-1;
        while (stackTop > 0) {
          int right = stack[--stackTop];
          int left = stack[--stackTop];
          while (right > left) {
            int i = partition(a, left, right);
            if (right-i-1 < i-1-left)  {  
            	if(i-1 > left){
                  stack[stackTop++] = left;
                  stack[stackTop++] = i-1;
               }
            left = i+1;
	    } else {
	       if(right > i+1){
                  stack[stackTop++] = i+1;
                  stack[stackTop++] = right;
               }
            right = i-1;
	    }
          }
        }
   }


	    /* partition a[left] to a[right], assumes left <= right  */
	   private static <T extends Comparable<? super T>> int partition (T[ ] a, int left, int right){
	        if (left == right) return left;
	        int i = left - 1;
	        int j = right;
	        while (true) {
	            while ((a[++i]).compareTo(a[right])<0) ;     // find item on left to swap; a[right] acts as sentinel     
	            while ((a[right]).compareTo(a[--j])<0)       // find item on right to swap
	                if (j == left) break;       // don't go out-of-bounds
	            if (i >= j) break;              // check if pointers cross
	            swap(a, i, j);                  // swap two elements into place
	        }
	        swap(a, i, right);                  // swap with partition element
	        return i;
	    }
	   
		/**  Swaps two specified elements in a specified array.
	    *
	    *  @param x – the array in which the two elements are to be swapped.
	    *  @param a – the index of one of the elements to be swapped.
	    *  @param b – the index of the other element to be swapped.
	    *
	    */
	   private static void swap (Object [] x, int a, int b) 
	   {
	      Object t = x[a];
	      x[a] = x[b];
	      x[b] = t;
	   } // method swap
	  

	   public static void main(String[] args)
	    {
			int L = 4000, MAXINT = 10000, NUMSIM = 5000;  //TEST
			Integer[] numbers = new Integer[L], numbersCopy = new Integer[L];

	      	double startTime, endTime;
	      	// tempi di esecuzione totale in ms
	      	double time_s=0; 
	      	double time_q=0;
	      	
	        Random r = new Random ();

	        for (int count=0; count < NUMSIM; count++) {

	  	// GENERAZIONE ARRAY RANDOM 
	       	for (int i = 0; i < L; i++) numbers[i]=r.nextInt(MAXINT);
	  	
	  	// stampa dell'istanza
	      //System.out.print("\n\nIstanza generata:\n");
	  	//for (int i = 0; i < L; i++) System.out.print(numbers[i] + " ");

	    
	  	//ITERATIVE QUICK-SORT
	  	System.arraycopy(numbers, 0, numbersCopy, 0, L);
	  	startTime = System.currentTimeMillis(); //The currentTimeMillis() method returns the current time in milliseconds.
	  		IterativeQuicksort(numbersCopy);
	  	endTime = System.currentTimeMillis();
	  	time_q += endTime - startTime;  //per avere in sec /1000
	  	//test correttezza
	  	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
	  		System.out.println("quicksort errato!");
	  		return; }
	  	
		//SORT
		System.arraycopy(numbers, 0, numbersCopy, 0, L);
		startTime = System.currentTimeMillis();
	        Arrays.sort(numbersCopy);
		endTime = System.currentTimeMillis();
		time_s += endTime - startTime;
		
	}
		
		System.out.println("\n\nTemp medio di esecuzione su " + NUMSIM + " array di " + L + " interi minori di " + MAXINT);
		System.out.println("Arrays.sort:\t\t" + time_s/NUMSIM + " msec");
		System.out.println("\nIterative-QuickSort:\t\t" + time_q/NUMSIM + " msec");


    } // method main
	    
	  
}
import java.util.*;

/** 
 * A small class of Comparable/Comparator based ordering Java methods. 
 * The methods sort the specified array of objects into ascending order,
 * according to the element class's implementation of the Comparable and
 * Comparator interfaces.
 * 
 * Recall:
 * The java.util.Arrays.sort(T[] a, Comparator<? super T> c) method sorts
 * the specified array of objects according to the order induced by the
 * specified comparator.
 * All elements in the array must be mutually comparable by the specified
 * comparator (that is, c.compare(e1, e2) must not throw a ClassCastException
 * for any elements e1 and e2 in the array).
 * This sort is guaranteed to be stable: equal elements will not be reordered
 * as a result of the sort.
 * 
 * Arrays.sort() uses Quicksort for Primitive Arrays and MergeSort for sorting array of Objects.
 * The sorting algorithm is a modified Mergesort (in which the merge is omitted if the highest element
 * in the low sublist is less than the lowest element in the high sublist).
 * This algorithm offers guaranteed n*log(n) performance.
 *  
 * Following is the declaration for java.util.Arrays.sort() method:
 *
 * public static <T> void sort(T[] a, Comparator<? super T> c)
 *
 * The type T has to implement Comparator of itself or its superclass.
 */



public class GenericSort {
	
	/*********** FIRST PART ************/

	
	
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
   
 
   /**
    *  Sorts a specified array into ascending order.
    *  BUBBLE-SORT:
    *  The worstTime(n) is O(n * n).
    *
    *  @param x – the array to be sorted. 
    * 
    *  @throws NullPointerException - if x is null.
    *
    */
   public static <T extends Comparable<? super T>> void bubbleSort (T[ ] x)
 
   {
          int finalSwapPos = x.length - 1,
              swapPos;              

          while (finalSwapPos > 0)
          {
               swapPos = 0;
               for (int i = 0; i < finalSwapPos; i++)
                    if ((x[i]).compareTo(x[i+1]) > 0) 
                    {
                         swap (x, i, i + 1);
                         swapPos = i;
                    } // if
               finalSwapPos = swapPos;             
          } // while      
   } // method bubbleSort


   /**
    *  Sorts a specified array into ascending order, according to
    *  the element class's implementation of the Comparable interface.
    *  The worstTime(n) is O(n * n).
    *
    *  @param x – the array of objects to be sorted.  
    *
    */ 
   public static <T extends Comparable<? super T>> void insertionSort (T [] x) 
   {	
      int k;
      T item;
      // Make x[0] ... x[i-1] sorted
      for (int i = 1; i < x.length; i++){
	    item = x[i];
            for (k = i; k > 0 && (x[k-1]).compareTo (item) > 0; k--) x[k] = x[k-1];
	    x[k] = item;
      }
   } // method insertionSort
   
   
   /**
    *  Sorts a specified array into the order specified by a specified Comparator
    *  object.
    *  The worstTime(n) is O(n * n).
    *
    *  @param x – the array to be sorted.
    *  @param comp – the Comparator object used for ordering.
    *
    *  @throws NullPointerException - if x and/or comp is null.
    * 
    */
   public static <T> void insertionSort (T [ ] x, Comparator<? super T>  comp) 
   {
	   int i, k;
	   T item;
	   for (i = 1; i < x.length; i++) {
		   item = x[i];
		   for (k = i; k > 0 && (comp.compare (x[k-1], item) > 0); k--) x[k] = x[k-1];
		   x[k] = item; 
	   }
   } // method insertionSort


   /**
    *  Sorts a specified array into ascending order, according to
    *  the element class's implementation of the Comparable interface.
    *  The worstTime(n) is O(n * n).
    *
    *  @param x – the array of objects to be sorted.  
    *
    */ 
   public static <T extends Comparable<? super T>>  void selectionSort (T [ ] x) 
   {
      // Make x[0] ... x[i-1] sorted and <= x[i] ... x[x.length - 1]:
      for (int i = 0; i < (x.length - 1); i++) 
      {
         int iMin = i;
         for (int k = i + 1; k < x.length; k++)
            if (x[k].compareTo(x [iMin]) < 0)  iMin = k;
         if (i != iMin) swap (x, i, iMin);
      } // for i
   } // method selectionSort

 
   /**
    *  Sorts a specified array into the order specified by a specified Comparator
    *  object.
    *  The worstTime(n) is O(n * n).
    *
    *  @param x – the array to be sorted.
    *  @param comp – the Comparator object used for ordering.
    *
    *  @throws NullPointerException - if x and/or comp is null.
    * 
    */
   public static <T> void selectionSort (T [ ] x, Comparator<? super T> comp) 
   {
      // Make x [0] ... x[i-1] sorted and <= x [i] ... x [x.length - 1]:
      for (int i = 0; i < (x.length - 1); i++) 
      {
         int iMin = i;
         for (int k = i + 1; k < x.length; k++)
            if (comp.compare (x[k], x[iMin]) < 0)  iMin = k;
        swap (x, i, iMin);
      } // for i
   } // method selectionSort


  /**
   *  Sorts a specified array of objects into ascending order, according to
   *  the element class's implementation of the Comparable interface.
   *  The worstTime(n) is O(n * log n).
   *
   *  @param x – the array to be sorted.  
   *
   */ 
   public static <T extends Comparable<? super T>> void mergeSort (T [] x){
	T[] aux = x.clone();
	//Remark: clone() creates a shallow copy. Which means the elements will not be cloned.
	
	mergeSort(aux, x, 0, x.length);  //sort aux[0, x.lenght-1] into x
   } // method mergeSort 	

  /**
   *  Sorts, by the Comparable interface, a specified range of a 
   *  specified array into the same range of another specified array.
   *  The worstTime(k) is O(k log k), where k is the    
   *  size of the subarray.
   *
   *  @param src – the specified array whose elements are to be 
   *                 sorted into another specified array.
   *  @param dest – the specified array whose subarray is to be sorted.
   *  @param low: the smallest index in the range to be sorted.
   *  @param high: 1 + the largest index in the range to be sorted.        
   */	 
   private static <T extends Comparable<? super T>> void mergeSort (T src[ ], T dest[ ], int low, int high){
	//Given an array x of objects, keep splitting into subarrays until the size of a subarray 
	//is less than 7. Apply Insertion Sort to that subarray and then merge the subarrays back together.

    int length = high-low;
    
     // Use Insertion Sort for small subarrays. 
    if (length < 7) {  // sorts dest[low..high-1]
    	T item;
    	int k;
        for (int i = low+1; i < high; i++) {
            item = dest[i]; 
            for (k = i; k>low && (dest[k-1]).compareTo(item) > 0;  k--) dest[k] = dest[k-1];
            dest[k] = item;
        }
        return;
     } // if length < 7
       
    // Sort left and right halves of src into dest.
    int mid = (low + high)/2 ;
    mergeSort (dest, src, low, mid);
    mergeSort (dest, src, mid, high);

   // If left subarray less than right subarray, copy src to dest.
   if ((src [mid-1]).compareTo (src [mid]) <= 0) {
       System.arraycopy (src, low, dest, low, length);
       return;
   }

   /* Merge sorted subarrays in src into dest.
    * indices p (low..mid-1) and q (mid..high-1) denote the current positions in src
    * index i (low..high-1) denotes the current position in dest
    */
   for (int i = low, p = low, q = mid; i < high; i++) 
      if (q>=high || (p<mid && (src[p]).compareTo (src[q])<= 0))
         dest [i] = src [p++];
      else
          dest[i] = src[q++];
} // method recursive mergeSort



  /**
   * Sorts a specified array of objects into ascending order, according to
   * the element class's implementation of the Comparable interface.
   * The worstTime(n) is O(n * n), and averageTime(n) is O(n log n).
   * It is NOT stable.
   * 
   * @param x - the array of objects to be sorted. 
   */ 
   public static <T extends Comparable<? super T>> void quickSort (T[ ] x) {
	quickSort(x, 0, x.length);
   } // method quickSort


 /**
   * Sorts the array x of "length" objects, from index left (inclusive) 
   * into ascending order.
   */
   private static <T extends Comparable<? super T>> void quickSort(T x[ ], int low, int length){
	int high = low+length-1; // sorts x[low..high] 
	if (low >= high) return;

       // Use Insertion Sort for small subarrays.
        if (length < 7) {
        	T item;
        	int i, k;
        	for (i = low + 1; i <= high; i++){
        		item = x[i];
        		for (k = i; k > low && (x[k-1]).compareTo (item) > 0; k--) x[k] = x[k-1];
        		x[k] = item;	
        	}
        	return;
        }  // if length < 7

	//pivot
	int i = low,
		j = high,
	    mid = (low + high)/2;
		mid = med3 (x,low,mid,high);
		T item = x[mid];  // item is the pivot

	while (true) {
		while ((x[i]).compareTo (item) < 0) i++;
		while ((x[j]).compareTo (item) > 0) j--;
		if (i < j) swap(x, i++, j--);  
		else { 
		    if (i == j) {i++; j--;}
		    break;
		}
	} // while true

	quickSort(x,low,j-low+1);
	quickSort(x,i,low+length-i);
   } // method quickSort_aux



   private static <T extends Comparable<? super T>> int med3(T x[], int a, int b, int c) {
     if ((x[a]).compareTo(x[b]) < 0) {
     	     if ((x[b]).compareTo(x[c]) < 0) return b;
     	     else if ((x[a]).compareTo(x[c]) < 0) return c; else return a; 
     }  else if ((x[b]).compareTo(x[c]) > 0) return b;
	     else if  ((x[a]).compareTo(x[c]) > 0) return c; else return a;
   } //end-med3

  
 /* ESTENDERE ANCHE MERGESORT E QUICKSORT  a
   public static <T> void mergeSort (T [ ] x, Comparator<? super T>  comp)
   public static <T> void quicksortSort (T [ ] x, Comparator<? super T>  comp)
*/

     
   /**
    * Sorts a specified array of int values into ascending order (bottom-up iterative approach).
    * The worstTime(n) is O(n * log n).
    * It is stable. Iterative approach.
    *
    * @param x  - the array to be sorted. 
    */ 
   public static <T extends Comparable<? super T>> void iterativeMergeSort (T[ ] x){
	int n = x.length;
    T[] aux = x.clone();
  	int i, dim;
  	  
    // Use Insertion Sort for small subarrays. 
   if (n < 7) {  // sorts dest[low..high-1]
   	T val;
   	int k;
       for (i = 1; i < n; i++) {
           val = x[i]; 
           for (k = i; k>0 && (x[k-1]).compareTo(val) > 0;  k--) x[k] = x[k-1];
           x[k] = val;
       }
       return;
    } // if n < 7
   
    // splits the array into contiguous subarrays of size dim
	for (dim = 1; dim < n; dim = dim+dim) 
			// i is positioned at the beginning of a contiguous pair of subarrays
           for (i = 0; i < n-dim; i = i+dim+dim)
        	   /* Merges two sorted contiguous subarrays
        	      x[i to i+dim-1] and x[i+dim to Math.min(i+dim+dim-1, n-1)]. */
        	  merge(x, aux, i, i+dim-1, Math.min(i+dim+dim-1, n-1));
   } // method-iterativeMergeSort


   /**
    * Merges two sorted contiguous subarrays x[low to mid] and x[mid+1 to high].
    * The worstTime(n) is O(n).
    *
    * @param x  - the array containing the elements to be merged. 
    * @param aux – the auxiliary array to be used to temporarily copy x[low..mid] and x[mid+1..high],
    *              the latter in reverse order
    * @param low: the smallest index in the range.
    * @param mid: the middle index in the range 
    * @param high: the largest index in the range.
    *
    */ 
   private static <T extends Comparable<? super T>> void merge(T[] x, T[] aux, int low, int mid, int high){
    int i,j,k;
    for (i = mid+1; i>low; i--) aux[i-1]=x[i-1]; 
    for (j = mid; j < high; j++) aux[high+mid-j] = x[j+1];  // copy in inverse order
    for (k=low; k <= high; k++)                  // l'indice k scorre l'array x[]
       if ((aux[j]).compareTo(aux[i])<0) x[k]=aux[j--]; else x[k]=aux[i++];
   }


   /*********** SECOND PART We will study it later  (Prerequisite: stack of items) ********/
   
  /**
   * Sorts a into ascending order.  Iterative approach.
   * The worstTime(n) is O(n * n), and averageTime(n) is O(n log n).
   * It is NOT stable.
   * 
   * @param x - the array to be sorted. 
   */ 
   public static <T extends Comparable<? super T>> void IterativeQuicksort_0 (T[ ] x){
        Stack<Integer> stack = new Stack<Integer>();
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


    /* partitions a[left to right], assumes left < right, a[right] as partition element  */
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
   
  
}//class GenericSort


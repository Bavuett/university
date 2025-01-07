/** 
 * TEST: confronto sui tempi di esecuzione
 * 
 * Recall: 
 * The java.lang.System.currentTimeMillis() method returns the current
 * time in milliseconds.
 */


import java.util.*;  


public class GenericSortTimes_0
{
    public static void main(String[] args)
    {
        new GenericSortTimes_0().run();
    } // method main


    public void run()
    {
	//int L = 2000, MAXINT = 20000, NUMSIM = 1000; // improbabili duplicati  
	int L = 10000, MAXINT = 1000, NUMSIM = 1000; // pochi duplicati  
	//int L = 2000, MAXINT = 100, NUMSIM = 1000; // molti duplicati   


	Integer[] numbers = new Integer[L], numbersCopy = new Integer[L];

      	double startTime, endTime;
	// tempi di esecuzione totale in ms
	double time_s=0; 
	double time_i=0;
	double time_b=0; 
	double time_m=0;
	double time_mbu=0;
	double time_q=0;
	double time_qIt0=0;
	double time_qIt1=0;
	double time_qIt=0;
	double time_sort=0;

    Random r = new Random ();

      for (int count=0; count < NUMSIM; count++) {

	// GENERAZIONE ARRAY RANDOM 
     	for (int i = 0; i < L; i++) numbers[i]=r.nextInt(MAXINT);
	
	// stampa dell'istanza
    //System.out.print("\n\nIstanza generata:\n");
	//for (int i = 0; i < L; i++) System.out.print(numbers[i] + " ");

  
	//SELECTION-SORT
	//System.arraycopy(numbers, 0, numbersCopy, 0, L);  // deep copy
    numbersCopy = numbers.clone(); // shallow copy	
	startTime = System.currentTimeMillis(); //The currentTimeMillis() method returns the current time in milliseconds.
    GenericSort.selectionSort (numbersCopy);
	endTime = System.currentTimeMillis();
	time_s += endTime - startTime;  //per avere in sec /1000
	//test correttezza
	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
		System.out.println("selectionSort errato!");
		return; }


	//INSERTION-SORT
	//System.arraycopy(numbers, 0, numbersCopy, 0, L);
    numbersCopy = numbers.clone();
	startTime = System.currentTimeMillis();
    GenericSort.insertionSort(numbersCopy);
	endTime = System.currentTimeMillis();
	time_i += endTime - startTime;
	//test correttezza
	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
		System.out.println("insertionSort errato!");
		return; }

	
	//BUBBLE-SORT
	//System.arraycopy(numbers, 0, numbersCopy, 0, L);
    numbersCopy = numbers.clone();
	startTime = System.currentTimeMillis();
        GenericSort.bubbleSort(numbersCopy);
	endTime = System.currentTimeMillis();
	time_b += endTime - startTime;
	//test correttezza
	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
		System.out.println("bubbleSort errato!");
		return; }

	//MERGE-SORT
	//System.arraycopy(numbers, 0, numbersCopy, 0, L);
    numbersCopy = numbers.clone();
	startTime = System.currentTimeMillis();
        GenericSort.mergeSort(numbersCopy);
	endTime = System.currentTimeMillis();
	time_m += endTime - startTime;
	//test correttezza
	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
		System.out.println("mergesort errato!");
		return; }


	//ITERATIVE MERGE-SORT
	//System.arraycopy(numbers, 0, numbersCopy, 0, L);
    numbersCopy = numbers.clone();
	startTime = System.currentTimeMillis();
        GenericSort.iterativeMergeSort(numbersCopy);
	endTime = System.currentTimeMillis();
	time_mbu += endTime - startTime;
	//test correttezza
	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
		System.out.println("mergesort bottom up errato!");
		return; }



	//ITERATIVE QUICK-SORT
	//System.arraycopy(numbers, 0, numbersCopy, 0, L);
    numbersCopy = numbers.clone();
	startTime = System.currentTimeMillis();
	GenericSort.IterativeQuicksort_1(numbersCopy);
	endTime = System.currentTimeMillis();
	time_qIt1 += endTime - startTime;
	//test correttezza
	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
		System.out.println("quickSortIt1 errato!");
		return; }

	//System.arraycopy(numbers, 0, numbersCopy, 0, L);
    numbersCopy = numbers.clone();
	startTime = System.currentTimeMillis();
	GenericSort.IterativeQuicksort_0(numbersCopy);
	endTime = System.currentTimeMillis();
	time_qIt0 += endTime - startTime;
	//test correttezza
	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
		System.out.println("quickSortIt1 errato!");
		return; }

	//System.arraycopy(numbers, 0, numbersCopy, 0, L);
    numbersCopy = numbers.clone();
	startTime = System.currentTimeMillis();
	GenericSort.IterativeQuicksort(numbersCopy);
	endTime = System.currentTimeMillis();
	time_qIt += endTime - startTime;
	//test correttezza
	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
		System.out.println("quickSortIt1 errato!");
		return; }


	//QUICK-SORT
	//System.arraycopy(numbers, 0, numbersCopy, 0, L);
    numbersCopy = numbers.clone();
	startTime = System.currentTimeMillis();
        GenericSort.quickSort(numbersCopy);
	endTime = System.currentTimeMillis();
	time_q += endTime - startTime;
	//test correttezza
	for(int i=0; i<L-1; i++) if (numbersCopy[i]>numbersCopy[i+1]) {
		System.out.println("quickSort errato!");
		return; }
	

	//SORT
	//System.arraycopy(numbers, 0, numbersCopy, 0, L);
    numbersCopy = numbers.clone();
	startTime = System.currentTimeMillis();
        Arrays.sort(numbersCopy);
	endTime = System.currentTimeMillis();
	time_sort += endTime - startTime;


      }  // end-for

       	
   System.out.println("\n\nTemp medio di esecuzione su " + NUMSIM + " array di " + L + " interi minori di " + MAXINT);
   System.out.println("Arrays.sort:\t\t" + time_sort/NUMSIM + " msec");

   System.out.println("MergeSort:\t\t" + time_m/NUMSIM + " msec");
   System.out.println("Iterative MergeSort:\t" + time_mbu/NUMSIM + " msec");

   System.out.println("\nQuickSort:\t\t" + time_q/NUMSIM + " msec");
   System.out.println("QuickSort_It:\t\t" + time_qIt/NUMSIM + " msec");
   System.out.println("QuickSort_It0:\t\t" + time_qIt0/NUMSIM + " msec");
   System.out.println("QuickSort_It1:\t\t" + time_qIt1/NUMSIM + " msec");

   System.out.println("\nInsertionSort:\t\t" + time_i/NUMSIM + " msec");
   System.out.println("SelectionSort:\t\t" + time_s/NUMSIM + " msec");
   System.out.println("BubbleSort:\t\t" + time_b/NUMSIM + " msec");


   } // method run

} // end-class 






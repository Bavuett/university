/** 
 * TEST: confronto sui tempi di esecuzione
 * 
 * Recall: 
 * The java.lang.System.currentTimeMillis() method returns the current
 * time in milliseconds.
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.*;  


public class GenericSortTimes
{
    
public static void main(String[] args)  {
	new GenericSortTimes().run();
} // method main


public void run()
{
	
try {

  int l = 1000, MAXINT = 10000, NUMSIM = 10;
  Random r = new Random ();
  
	FileWriter writer = new FileWriter("myfile.txt");
	   
 writer.write("Tempi medi di esecuzione in msec su " + NUMSIM + " array di interi minori di " + MAXINT);
 writer.write("\n1) Arrays.sort");
 writer.write("\n2) MergeSort");
 writer.write("\n3) Mergesort_It");
 writer.write("\n4) QuickSort");
 writer.write("\n5) QuickSort_It");
 writer.write("\n6) QuickSort_It0");
 writer.write("\n7) QuickSort_It1");
 writer.write("\n8) InsertionSort");
 writer.write("\n9) SelectionSort");
 writer.write("\n10) BubbleSort");
 
 
 writer.write("\n\nSize\t1)\t2)\t3)\t4)\t5)\t6)\t7)\t8)\t9)\t10)");     

  
  for (int n=1; n<21; n++) {
	int L = l*n;
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

   writer.write("\n"+L+"\t"+time_sort/NUMSIM+"\t"+time_m/NUMSIM+"\t"+time_mbu/NUMSIM+"\t"+time_q/NUMSIM+"\t"+time_qIt/NUMSIM+"\t"+time_qIt0/NUMSIM+"\t"+time_qIt1/NUMSIM+"\t"+time_i/NUMSIM+"\t"+time_s/NUMSIM+"\t"+time_b/NUMSIM); 
   
   
  }
   
   writer.close();

	System.out.println("\nScrittura sul file riuscita con successo.");
	
}
catch (IOException e) {
System.out.println("Si è verificato un errore.");
e.printStackTrace();
}
} // method run

} // end-class 






/** Esercitazione: test di uso degli iteratori su oggetti List (ArrayList, LinkedList) 
 *  Il programma calcola la somma di interi generati random in [o..MAXVALUE]
 *  sia mediante iteratori che mediante accesso diretto ai singoli elementi
 *  mediante il metodo get()
 *
 *  1) generazione random di liste di dimensione crescente (L massima dimensione)
 *  2) calcolo del tempo di esecuzione sulle liste generate
 *  3) confronto dei tempi di esecuzione
 *  Remark:
 *  The currentTimeMillis() method returns the current time in milliseconds
	"This method returns the difference, measured in milliseconds, between
	the current time and midnight, January 1, 1970 UTC(coordinated universal time)"
 */

import java.util.*;

public class SumList {

	public static void main(String[] args) {		
			     new SumList().run();
	} // method main


	public void run(){
		
	List<Integer> randList = new LinkedList<Integer>();
	List<Integer> randArray = new ArrayList<Integer>();
		
	final int L = 550000;   // lunghezza massima della lista
	final int MAXVALUE = Integer.MAX_VALUE/L;  // MAX_VALUE = 2^31-1 = 2147483647
		
	int somma = 0;  			      
	Random r = new Random();
		
    double startTime, endTime; // tempi di esecuzione totale in ms
    double time_getL; 
    double time_itrL;
    double time_getA; 
    double time_itrA;

	System.out.println("L\t itrL\t itrA\t getL\t getA\t somma");
		
    for (int len = 1000; len< L; len = len*2) {
      	randList.clear();
      	randArray.clear();    	
		      
      	// Insert len random integers, in the range 0...MAXVALUE, into randList:
      	for (int i = 0; i <= len; i++) {
      		int randInt = r.nextInt(MAXVALUE+1);  // intero in [0,MAXVALUE+1)
      		randList.add (randInt); 
      		randArray.add(randInt); 
      	}
		
		somma = 0;
      	//calcola la somma mediante iterazione standard
		startTime = System.currentTimeMillis(); 
		for (Integer x: randList) somma += x;
		endTime = System.currentTimeMillis();
		time_itrL = endTime - startTime;  //per avere in sec /1000
		
		somma = 0;
		startTime = System.currentTimeMillis(); //The currentTimeMillis() method returns the current time in milliseconds.
		for (Integer x: randArray) somma += x;
		endTime = System.currentTimeMillis();
		time_itrA = endTime - startTime; 
		
		//calcola la somma mediante accesso diretto alle singole componenti
		somma = 0;		
		//The currentTimeMillis() method returns the current time in milliseconds.
		startTime = System.currentTimeMillis(); 
		for (int i = 0; i < len; i++) somma += randList.get(i);
		endTime = System.currentTimeMillis();
		time_getL = endTime - startTime; 
		
		somma = 0;		
		startTime = System.currentTimeMillis(); //The currentTimeMillis() method returns the current time in milliseconds.
		for (int i = 0; i < len; i++) somma += randArray.get(i);
		endTime = System.currentTimeMillis();
		time_getA = endTime - startTime; 

		//System.out.println("Somma = " + somma);
		System.out.println(len + "\t" + time_itrL + "\t" + time_itrA  + "\t" + time_getL  + "\t" + time_getA + " ms\t" + somma);

      	}//end-for;
      	
      	System.out.println("end");

	} // method run

} // class SumList




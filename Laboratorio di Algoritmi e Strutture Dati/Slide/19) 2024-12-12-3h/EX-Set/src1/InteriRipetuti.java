/**
 * Programma che genera random N interi, e stampa un
 * messaggio ogni volta che si genera un intero già 
 * inserito in precedenza.
 * Focus su:
 * HashSet rappresenta un insieme non odinato, 
 * TreeSet rappresenta un insieme ordinato
 **/

import  java.util.*;

public class InteriRipetuti { 
	
	public static void main (String[ ] args)
	{
		new InteriRipetuti().run();
	 } // method main
	

	public void run()
	{
	int N = 20, MAXINT = 50;
	
	/******** HASHSET  ********/
	
	Set <Integer> set = new  HashSet <Integer>(); 
	Random  generator = new  Random ();
	for (int i=0; i < N; i++) {
		Integer x = generator.nextInt(MAXINT + 1);
		//  cerca  di  inserire x in set, se già presente stampa  un msg.
		if (!set.add(x))
			System.out.println("Intero ripetuto: " + x);
		else System.out.println(x);
	}
	
	//stampa (non ordinata) del set
	System.out.println("\nHashSet:");
	for (Integer x: set)  System.out.print(x + " ");
	System.out.println(); System.out.println(set);
	
	
	/******** TREESET  ********/
	Set <Integer> set2 = new  TreeSet <Integer>(set); 
	//stampa ordinata del set
	System.out.println("\nTreeSet:");
	for (Integer x: set2)  System.out.print(x + " ");
	System.out.println(); System.out.println(set2);
		
	}//end-main
	
}



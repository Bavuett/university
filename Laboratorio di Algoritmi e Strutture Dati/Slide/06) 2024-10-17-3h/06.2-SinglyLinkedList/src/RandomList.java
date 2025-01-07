/* ESERCITAZIONE: 
 * 
 *  * La classe RandomList crea e manipola un "oggetto List"
 * contenente L numeri interi casuali nell'intervallo [0,max]:
 * PARTE 1: -----------------
 * 1) creazione lista - inserimento di interi generati random
 * 2) stampa dei valori contenuti nella lista
 * 3) ricerca di un elemento nella lista
 * PARTE 2: -----------------
 * 4) cancellazione di elementi dalla lista (uso degli iteratori)
 * 5) ordinamento naturale
  */


import java.util.*;


public class RandomList {

  public static void main (String[ ] args) {
     new RandomList().run();
  } // method main


  public void run(){
     List<Integer> randList = new SinglyLinkedList<Integer>(); // uso la classe giocattolo! 
     final int L = 15;  //size of the list
     final int max = 1000; //maximum integer value
      
        Random r = new Random();
      
        // 1) Insert L random integers, in the range 0...max, into randList:
        for (int i = 0; i < L; i++)
             randList.add (r.nextInt(max+1)); // insertion
      
        // 2) Print out randList:
        System.out.println ("\nRandom List:\n" + randList);  
        
        randList.add (2,r.nextInt(max+1)); // insertion
    	System.out.print ("\nIn position 2 there is a new random integer:\n");
        // 2) Print out randList:
        System.out.println (randList);
      
	// 3) Verify if this list contains the specified element.
    int x = r.nextInt(max+1);
	System.out.print ("\nSee if " + x + " is in randList:\n");
        if (randList.contains (x))
             System.out.println ("Yes, it is in randList.");
        else System.out.println ("No, it is not in randList.");
      

        System.out.println (randList.get (3) + " is at index 3");
      
        System.out.println ("\nRemove the integer " + randList.get (6) + " at index 6.");
	randList.remove (6);

        System.out.println ("Insert a new random integer at index 5.");
        randList.add (5, r.nextInt (max+1));

        // Print out randList.
        Collections.sort(randList);  // Ordino la lista!
        System.out.println (randList);
        
        
        

	/* 4) Remove all even integers      */
        System.out.println ("\nRemove all even integers and sort.");
              
        Iterator<Integer> itr = randList.iterator();
        while (itr.hasNext())        
             if (itr.next() % 2 == 0)
                 itr.remove(); 
           
         // Print out randList;
        Collections.sort(randList);
         System.out.println (randList); 


	/* 4) REMARK: Remove all odd integers */
	    //fails: ConcurrentModificationException 
         /* for (Integer i: randList)
         if (i % 2 == 1) randList.remove(i); */
     
                  
 } // method run

} // class RandomList2

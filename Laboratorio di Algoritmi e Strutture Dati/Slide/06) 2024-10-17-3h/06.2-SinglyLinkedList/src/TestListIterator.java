/* ESERCITAZIONE: 
 * Test sull'uso degli iteratori
 * 
 */

import java.util.*;


public class TestListIterator {

  public static void main (String[ ] args) {
     new TestListIterator().run();
  } // method main


  public void run(){
	  //LinkedList<Integer> randList = new LinkedList<Integer>();
	  //ArrayList<Integer> randList = new ArrayList<Integer>();
	  SinglyLinkedList<Integer> randList = new SinglyLinkedList<Integer>();

     
     final int L = 15;  //size of the list
     final int max = 1000; //maximum integer value
      
        Random r = new Random();
      
        // Insert L random integers, in the range 0...max, into randList:
        for (int i = 0; i < L; i++)
             randList.add (r.nextInt(max+1)); // insertion
      
        //  Print out randList:
        System.out.println ("\nRandom List:\n" + randList);  

         
        /* uso intefaccia ListIterator */
        ListIterator<Integer> itr = randList.listIterator();  
       
         System.out.println ("\nRimpiazza con " + max/2 + " tutti gli interi minori di "  + max/2);
         while (itr.hasNext()) {
   	 	  Integer x = itr.next();
   	 	  if (x<max/2) itr.set(max/2);       	 
         }     
         System.out.println (randList);
         
         System.out.println ("\nInserisce un nuovo intero dopo ogni occorrenza di " + max/2);
         itr = randList.listIterator();
         while (itr.hasNext()) {
   	 	  Integer x = itr.next();
   	 	  if (x == max/2) 
          itr.add(r.nextInt(max+1));         	 
         }
         System.out.println (randList);
         
         // Print out randList;
        System.out.println ("\nSort");
        Collections.sort(randList);
         System.out.println (randList); 
         
     	/* Remove all even integers      */
         System.out.println ("\nCancella le occorrenze di " + max/2);
          
         itr = randList.listIterator();  
         while (itr.hasNext())        
              if (itr.next()  == max/2)
                  itr.remove(); 
         System.out.println (randList); 
         
                 
 } // method run

} // class TestListIterator

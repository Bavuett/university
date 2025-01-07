/* ESERCITAZIONE: 
 * Test sull'uso di SortedLinkedList
 * 
 */

import java.util.*;


public class Test1 {

	  public static void main (String[ ] args) {
		     new Test1().run();
		  } // method main


		  public void run(){
			 SortedLinkedList<Integer> randList = new SortedLinkedList<Integer>();
		     final int L = 15;  //size of the list
		     final int max = 1000; //maximum integer value
		      
		        Random r = new Random();
		      
		        // 1) Insert L random integers, in the range 0...max, into randList:
		        for (int i = 0; i < L; i++)
		             randList.add (r.nextInt(max+1)); // insertion
		      
		        // 2) Print out randList:
		        System.out.println ("\nRandom List:\n" + randList);  
		        
		        randList.add (r.nextInt(max+1)); // insertion
		    	System.out.print ("\nThere is a new random integer:\n");
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
	        System.out.println (randList);

			/* 4) Remove all even integers      */
		        System.out.println ("\nRemove all even integers.");
		              
		        Iterator<Integer> itr = randList.iterator();
		        while (itr.hasNext())        
		             if (itr.next() % 2 == 0)
		                 itr.remove(); 
		        System.out.println (randList);
		           
	     
		                  
		 } // method run

} // class TestListIterator

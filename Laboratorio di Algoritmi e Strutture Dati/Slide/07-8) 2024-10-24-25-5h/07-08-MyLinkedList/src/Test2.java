/* ESERCITAZIONE: 
 * Test sull'uso degli iteratori
 * 
 */

import java.util.*;


public class Test2 {

  public static void main (String[ ] args) {
     new Test2().run();
  } // method main


  public void run(){
     List<Integer> randList = new MyLinkedList<Integer>();

     
     final int L = 15;  //size of the list
     final int max = 1000; //maximum integer value
      
        Random r = new Random();
      
        // Insert L random integers, in the range 0...max, into randList:
        for (int i = 0; i < L; i++)
             randList.add (r.nextInt(max+1)); // insertion
      
        //  Print out randList:
        System.out.println ("Random List:\n" + randList);  

         
        // itr from left to right
        ListIterator<Integer> itr = randList.listIterator();  
         System.out.print ("Conta tutti gli interi minori di "  + max/2 + ": ");
         int count = 0;
         while (itr.hasNext()) {
   	 	  Integer x = itr.next();
   	 	  if (x<max/2) count ++;       	 
         }
         System.out.println(count);
         
         // itr from right to left  
         itr = randList.listIterator(randList.size());
         System.out.print ("Conta tutti gli interi maggiori di "  + max/2 + ": ");
         count = 0;
         while (itr.hasPrevious()) {
   	 	  Integer x = itr.previous();
   	 	  if (x>max/2) count ++;       	 
         }
         System.out.println(count);
         
         
         System.out.println("Add 500:");
         randList.add(500);
         System.out.println(randList);
         
         
         System.out.println("Remove 500:");    
         itr = randList.listIterator();
         while (itr.hasNext()) {
   	 	  Integer x = itr.next();
   	 	  if (x == 500) itr.remove();     	 
         }
         System.out.println (randList);
         

         
 } // method run

} // class TestListIterator

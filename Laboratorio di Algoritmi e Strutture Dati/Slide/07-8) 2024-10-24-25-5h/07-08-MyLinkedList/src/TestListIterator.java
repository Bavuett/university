/* ESERCITAZIONE: 
 * Test sull'uso degli iteratori
 * 
 */

//Nota l'implementazione non consente l'esecuzione dell'iterazione in ordine inverso (ver 2)



import java.util.*;


public class TestListIterator {

  public static void main (String[ ] args) {
     new TestListIterator().run();
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
         
     	/* Remove test      */
         System.out.println ("\nCancella le occorrenze di " + max/2);
          
         itr = randList.listIterator();  
         while (itr.hasNext())        
              if (itr.next()  == max/2)
                  itr.remove(); 
         System.out.println (randList); 
         
        
         //definito solo per tipo LinkedList
         /* System.out.println ("\nStampa in ordine inverso (ver1):"); 
         Iterator<Integer> ditr = randList.descendingIterator(); 
         while (ditr.hasNext()) System.out.print(ditr.next() + " ");  
         } */
              
         //non definito solo per tipo SinglyLinkedList
         /* System.out.println ("\n\nStampa in ordine inverso (ver2):"); 
         itr = randList.listIterator(randList.size());
         while (itr.hasPrevious()) System.out.print(itr.previous() + " ");
         System.out.println ("\n"); 
         */
         
 } // method run

} // class TestListIterator

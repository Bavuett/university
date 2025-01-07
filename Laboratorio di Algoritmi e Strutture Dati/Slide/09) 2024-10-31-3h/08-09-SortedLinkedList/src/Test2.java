import java.util.Comparator;

/* ESERCITAZIONE: 
 * Test sull'uso di SortedLinkedList
 * 
 */

public class Test2 {
	
	
	

	  public static void main (String[ ] args) {
		     new Test2().run();
		  } // method main


		  public void run(){
			 SortedLinkedList<String> listOfString = new SortedLinkedList<String>();
			 listOfString.add ("Patrick"); // insertion
			 listOfString.add ("Ann");
			 listOfString.add ("Alex");
			 listOfString.add ("Alexander");
			 listOfString.add ("Bob");
		      
		     // Print out listOfString
		     System.out.println ("\nlistOfString:\n" + listOfString); 
		     
		     
		     /** EXERCISE **/
		     
		     // Print out twinList   
		     SortedLinkedList<String> twinList = listOfString.copy2();
		     System.out.println ("\ntwinList:\n" + twinList);
		     
		     if (listOfString.equals(twinList)) System.out.println("\nLe liste sono uguali");
		     else System.out.println("\nLe liste sono diverse");
		     
		     //listOfString.setComparator(new String_bylength());

		     // blocco alternativo all'istruzione precedente
		     listOfString.setComparator(
		    		 new Comparator<String>() {
		    	 			public int compare (String s1, String s2) {  
		    	 				return s1.length()-s2.length();	
		    	 			} // method compare}
		    		 });

		     listOfString.add("Giovanna");
		     System.out.println ("\nlistOfString sorted by length:\n" + listOfString);
		     if (listOfString.equals(twinList)) System.out.println("\nLe liste sono uguali");
		     else System.out.println("\nLe liste sono diverse");
		     
		     listOfString.sort();
		     listOfString.add("Alice");
		     System.out.println ("\nlistOfString sorted in natural ordering:\n" + listOfString);

		     
		     
		        
		        
		        
		        
		 } // method run
		  
		  
		class String_bylength implements Comparator<String> {

			   public int compare (String s1, String s2) {  
			     return s1.length()-s2.length();	
			   } // method compare
		}


} // end-class 

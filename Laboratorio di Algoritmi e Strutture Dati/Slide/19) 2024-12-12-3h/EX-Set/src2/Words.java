/* EX1 del 27/01/2016 (I appello)
 * Si scriva un metodo public List<String> DifferentWordsList(List<String>) che, 
 * data in input una lista di stringhe list, restituisce una nuova lista priva di
 * elementi duplicati, contenente tutte le stringhe distinte di list e ordinata 
 * per lunghezze decrescenti (a parità di lunghezza ordinamento lessicografico crescente) .
 * 
 * 
 * Write a method    public List<String> DifferentWordsList(List<String>)
 * that returns a new list containing all the strings in the given list, without
 * duplicates. The method sorts the list by string length in decreasing order. 
 * 
 * 
 * */


import java.util.*;


public class Words {
	
	/*** versione 1 ***/
	public static List<String> DifferentWordsList(List<String> list) {
		HashSet<String> ts = new HashSet<String>(list);  // elimina duplicazioni
		List<String> listOut = new ArrayList<String>(ts);   
	    Collections.sort(listOut, new DecreasingLength());
	    return listOut;
	}
	
	/*** versione 2  ***/
	public static List<String> DifferentWordsList2(List<String> list) {
		TreeSet<String> ts = new TreeSet<String>(new DecreasingLength());
		ts.addAll(list);  // elimina duplicazioni e ordina
		List<String> listOut = new ArrayList<String>(ts);
	    return listOut;
	}


	public static void main(String[] args)  //test
	{
	    List<String> lista = new LinkedList<String>();
	    lista.add("tree");
	    lista.add("flower");
	    lista.add("tree");
	    lista.add("flower");
	    lista.add("animal");
	    lista.add("flower");
	    lista.add("fruit");
	    lista.add("food");
	    
	    System.out.println ("Stringhe:\n" + lista);
	    
	    System.out.println ("\nStringhe distinte ordinate per lunghezze decrescenti:\n" + DifferentWordsList(lista));
	    System.out.println ("\nStringhe distinte ordinate per lunghezze decrescenti (2):\n" + DifferentWordsList2(lista));

	    
	} // method main

}//end-class-Words

class DecreasingLength implements Comparator<String> {
	  public int compare(String a, String b) {
		int diff = b.length() - a.length();
		if (diff == 0) return a.compareTo(b);
		else return diff;

	  }
	  // No need to override equals.
	}





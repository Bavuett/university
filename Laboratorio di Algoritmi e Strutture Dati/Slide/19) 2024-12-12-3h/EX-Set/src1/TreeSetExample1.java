import java.util.*;


class Decreasing implements Comparator<String> {
  public int compare(String a, String b) {
    return b.compareTo(a);
  }
  // No need to override equals.
}


public class TreeSetExample1 {
	
  public static void main(String args[]) {
    TreeSet<String> ts = new TreeSet<String>(new Decreasing());

    ts.add("C");
    ts.add("A");
    ts.add("B");
    ts.add("E");
    ts.add("F");
    ts.add("D");

	System.out.println("Treeset (stringhe in ordine lessicografico decrescente): ");
	System.out.println(ts); //stampa nel formato standard delle liste
	for (String element : ts) //stampa da personalizzare
		System.out.print(element + " ");
  	System.out.println("\n");
  	
  	
   // Check empty or not
	if (ts.isEmpty()) {
		System.out.print("TreeSet is empty.");
	} else {
		System.out.println("TreeSet size: " + ts.size());
	}
 
	// Retrieve first data from tree set
	System.out.println("First data: " + ts.first());
 
	// Retrieve last data from tree set
	System.out.println("Last data: " + ts.last());
 
	if (ts.remove("B")) { // remove element by value
		System.out.println("\nData \"B\" is removed from tree set");
	} else {
		System.out.println("Data doesn't exist!");
	}
	System.out.print("Now Treeset contains: ");
	Iterator<String> iterator = ts.iterator();
	// Displaying the Tree set data
	while (iterator.hasNext()) {
		System.out.print(iterator.next() + " ");
	}
	System.out.println();
	System.out.println("Now the size of Treeset is: " + ts.size());
 
	// Remove all
	ts.clear();
	if (ts.isEmpty()) {
		System.out.print("Now the Treeset is empty.");
	} else {
		System.out.println("Treeset size: " + ts.size());
	}
  }
}
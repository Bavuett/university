import java.util.*;

public class Dispari2<E extends Comparable<? super E>> {
	
	private LinkedList<E> myList = null; 
	
	public boolean OrdinaDispari(){
		
	// we use a HashMap to count the occurrences for all objects
	HashMap<E,Integer> map = new HashMap<E,Integer>();	
	for (E item: myList) map.put(item, 0);
	for (E item: myList) map.put(item, map.get(item)+1);
	
    for (Map.Entry<E, Integer> entry : map.entrySet())
    	if (entry.getValue() % 2 == 0) return false;
    
    Collections.sort(myList);
    return true;
        	
	} //end-OrdinaDispari
	

public static void main(String[] args)  //test
{
	Dispari2<Integer> d = new Dispari2<Integer>();
	d.myList =  new LinkedList<Integer>();
	d.myList.add(20); d.myList.add(20); d.myList.add(20);
	d.myList.add(5); d.myList.add(5);
	
	System.out.println(d.myList);
	if (! d.OrdinaDispari()) System.out.println("Lista pari, ordinamento fallito\n");
	
	d.myList.add(5); d.myList.add(5); d.myList.add(5);
	System.out.println(d.myList);
	if (d.OrdinaDispari()) System.out.println("Lista ordinata: ");
	System.out.println(d.myList);
	
}

} //end-class

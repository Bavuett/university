import java.util.*;

public class NoDupIterator {
	
	public static void main(String[] args)
	{
		new NoDupIterator().run();
	}
	
	
	/****************************************************************************
	ESERCIZIO 1: Usare la classe TreeSet per eliminare i duplicati da un iteratore
	su una struttura di elementi che implementano Comparable<E>,
	restituendo in output un iteratore che scorre i dati secondo
	l'ordine indotto dal metodo compareTo().
	
	Use the TreeSet class to remove all the duplicates from an iterator
	on a structure of elements that implement Comparable <E>, 
	returning an iterator over the elements in this set in ascending order.
	****************************************************************************/
	
	
	public <E extends Comparable<? super E>> Iterator<E> iteratorNoDupOrd(Iterator<E> it){
	// Remark: the type parameter of the Comparable interface should be any supertype of the element type		 
		TreeSet<E> set = new TreeSet<E>();
		while (it.hasNext()) set.add(it.next());
	    return set.iterator();     
	}
	

	/******************************************************************************
	ESERCIZIO 2: Usare la classe HashSet per eliminare i duplicati da un iteratore
	su una struttura, restituendo in output un iteratore che scorre i dati distinti.
	******************************************************************************/
	
	public <E> Iterator<E> iteratorNoDup(Iterator<E> it){
		HashSet<E> set = new HashSet<E>();
		while (it.hasNext()) set.add(it.next());
	    return set.iterator();     
	}

	
	public void run()  //test
	{
		ArrayList<String> lista = new ArrayList<String>();
	    lista.add("tree");
	    lista.add("flower");
	    lista.add("tree");
	    lista.add("flower");
	    lista.add("animal");
	    lista.add("flower");
	    lista.add("fruit");

	    System.out.println ("ArrayList:");
	    Iterator<String> itr = lista.iterator();
	    while (itr.hasNext()) System.out.println (itr.next());
	    
	    System.out.println ("\nWithout duplicates:");
	    itr = lista.iterator();
	    Iterator<String> itrNoDup = this.<String>iteratorNoDup( itr );
	    while (itrNoDup.hasNext()) System.out.println (itrNoDup.next());

	    System.out.println ("\nWithout duplicates, in ascending order:");
	    itr = lista.iterator();
	    itrNoDup = this.<String>iteratorNoDupOrd( itr );
	    while (itrNoDup.hasNext()) System.out.println (itrNoDup.next());	    		
	    
	}

	

}

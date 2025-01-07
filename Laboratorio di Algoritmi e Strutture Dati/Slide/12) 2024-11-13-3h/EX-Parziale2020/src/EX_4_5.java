import java.util.*;

public class EX_4_5 {
	
	/* EX4 a) Scrivere un metodo minoriDi che riceve in ingresso un array di elementi di tipo
	 * String e un elemento di tipo String, e restituisce un oggetto di tipo ArrayList con
	 * elementi di tipo String contenente tutti gli elementi dell'array che sono minori
	 * dell’elemento dato. 
	 */
	
	public static ArrayList<String> minoriDi(String[] array, String item){
		ArrayList<String> minori = new ArrayList<String>();
		for (String x: array)
			if (x.compareTo(item)<0)  minori.add(x);
		return minori;
	} 
	

	/* EX4 b) Scrivere un metodo generico minoriDi che riceve in ingresso un
	 * array di un tipo E e un valore di tipo E e restituisce una
	 * lista di elementi di tipo E contenente tutti gli elementi dell'array che
	 * sono minori dell'elemento dato.
	 */
	
	public static <E extends Comparable<? super E>> LinkedList<E> minoriDi(E[] array, E item){
		LinkedList<E> lista = new LinkedList<E>();
		for (E x: array)
			if (x.compareTo(item)<0)  lista.add(x);
		return lista;
	}
	

	
	/* EX5 a) Scrivere un metodo
	 * LinkedList<Integer> union(LinkedList<Integer> L1, LinkedList<Integer> L2)
	 * che riceve come argomenti due liste di oggetti di tipo Integer prive di elementi
	 * duplicati e restituisce la lista unione, priva di elementi duplicati, contenente gli
	 * elementi di entrambe le liste.
	 * Qual è la complessità di tempo del metodo proposto? Giustificare la risposta
	 */
	

	public static LinkedList<Integer> union (LinkedList<Integer> L1, LinkedList<Integer> L2){
		LinkedList<Integer> Lout = new LinkedList<Integer>();
		Collections.sort(L1);
		Collections.sort(L2);
		ListIterator<Integer> itr1 = L1.listIterator();  
		ListIterator<Integer> itr2 = L2.listIterator();  
		while (itr1.hasNext() && itr2.hasNext()) {
			Integer x1 = itr1.next();
			Integer x2 = itr2.next();
			int flag = x1.compareTo(x2); 
			// x1 > x2
			if (flag > 0)  { itr1.previous(); Lout.add(x2); } 
			// x1 < x2
			if (flag < 0) {itr2.previous(); Lout.add(x1); }
			if (flag == 0) Lout.add(x1);
		}
		while (itr1.hasNext()) Lout.add(itr1.next());
		while (itr2.hasNext()) Lout.add(itr2.next());
		return Lout;
	}
	
	
	
	

	/* EX5 b) Scrivere un metodo generico 
	 * <void> union (List<E> L1, List<E> L2, Comparator<E> c) che riceve come argomenti
	 * due liste L1 e L2 di oggetti di un tipo E prive di elementi duplicati e restituisce in
	 * L1 la lista priva di elementi duplicati, contenente gli elementi di entrambe le liste.
	 * I confronti tra gli elementi devono essere effettuati utilizzando il comparatore
	 * passato come terzo argomento.
	 */
	
	/******************** HOMEWORK ************************/
	public static <E> void union (List<E> L1, List<E> L2, Comparator<E> c){
		if (L2.isEmpty()) return; // L1 resta invariata
		if (L1.isEmpty()) L1 = L2;
		Collections.sort(L1, c);
		Collections.sort(L2, c);
		ListIterator<E> itr1 = L1.listIterator();
		ListIterator<E> itr2 = L2.listIterator();
		while (itr1.hasNext() && itr2.hasNext()) {
			E x1 = itr1.next();
			E x2 = itr2.next();
			int flag = c.compare(x1, x2); 
			// x1 > x2
			if (flag >0) {itr1.previous(); itr1.add(x2); }
			// x1 < x2
			if (flag < 0) itr2.previous();
			//if (flag == 0) continue;
		}
		while (itr2.hasNext()) L1.add(itr2.next());
	}
}	
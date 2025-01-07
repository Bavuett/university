import java.util.*; 

public class Ex2 {
	
	static <T extends Comparable<? super T>> boolean isSorted (LinkedList<T> list) {
	    Iterator<T> it = list.iterator(); 
	    if(!it.hasNext()) return true; 
	    T previous = it.next(); 
	    while(it.hasNext()) {
	    	T current = it.next();
	        if(current.compareTo(previous) < 0) return false;
	        else previous = current;
	    }
	    return true; 
	}
	
	
	// soluzione inefficiente
	public static <T extends Comparable<? super T>> boolean isSorted_0(LinkedList<T> L) {
		LinkedList<T> listaDiControllo = new LinkedList<T>(L);	
		// eseguo ordinamento naturale su listaDiControllo
		Collections.sort(listaDiControllo);
		Iterator<T> i1 = L.iterator();
		Iterator<T> i2 = listaDiControllo.iterator();
		while (i1.hasNext()) {
			T x1 = i1.next();
			T x2 = i2.next();
			if (!x1.equals(x2)) return false;
		}
		return true;
	}
	

	// soluzione molto inefficiente
	public static <T extends Comparable <? super T>> boolean isSorted_1(LinkedList<T> l) {
		for(int i = 0 ; i < l.size()-1 ; i++)
			if(l.get(i).compareTo(l.get(i+1)) > 0) return false;
		return true;
	}	
	

}

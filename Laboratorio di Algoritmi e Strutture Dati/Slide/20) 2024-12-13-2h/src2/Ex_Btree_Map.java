import java.util.*;

public class Ex_Btree_Map {
	
/**
 * EX1 - II parziale 8/1/2019
 * Scrivere un metodo generico statico ContaDuplicati che conta il
 * numero di oggetti duplicati (non univoci) contenuti in un albero binario.
 * Porre particolare attenzione alla scelta della firma.
 * 
 */

public static <E> int ContaDuplicati(BinaryTree<E> t) {
	HashMap<E, Integer> occmap = new HashMap<E, Integer>();
	Iterator<E> itr = t.iteratorInOrder();
	int value, count = 0;
	E key;
	while (itr.hasNext()) {
		key = itr.next();
		if (occmap.containsKey(key))
			value = occmap.get(key) + 1;
		else value = 1;
		occmap.put(key, value);
	}
	for (Map.Entry<E, Integer> entry: occmap.entrySet()) {
		if (entry.getValue() > 1) count++;
	}
	/*
	 	for (Integer occ: occmap.values()) {
		if (occ > 1) count++;
	}
	 */
	return count;
}
	
	
// variante che inizializza la HashMap	
public static <E> int ContaDuplicati2(BinaryTree<E> t) {
	HashMap<E, Integer> occmap = new HashMap<E, Integer>();
	Iterator<E> itr = t.iteratorInOrder();
	int count = 0;
	// inizializza la mappa
	while (itr.hasNext()) occmap.put(itr.next(), 0);
	itr = t.iteratorInOrder();
	// aggiorna le occorrenze
	while (itr.hasNext()) {
		E key = itr.next();
		occmap.put(key, occmap.get(key) + 1);
	}
	for (Map.Entry<E, Integer> entry: occmap.entrySet()) {
		if (entry.getValue() > 1) count++;
	}
	return count;
}
	 
}


/* I parziale 10/11/2023 a.a. 2023/2024 - Esercizio 1.b)
 * Scrivere una classe “Libreria” che rappresenta una libreria come una lista di libri
 * (oggetti di tipo Libro) senza elementi duplicati e supporta le seguenti operazioni:
1.	inserire nella libreria un nuovo libro, se non è già presente, dati in input l’ISBN e l’anno di pubblicazione;
2.	verificare se la libreria contiene un libro, dato in input il suo ISBN;
3.	cancellare dalla libreria un libro, se presente, dato in input il suo ISBN;
4.	ordinare la lista dei libri in ordine crescente rispetto al codice ISBN;
5.	ordinare la lista dei libri in ordine decrescente rispetto all’anno di prima pubblicazione;
6.	calcolare restituire in output, per ogni anno di pubblicazione compreso tra il 2000 e il 2023, 
    il relativo numero di libri contenuti nella libreria.
 */

import java.util.*; 

public class Libreria implements Iterable<Libro> {  
	//NOTA: implements Iterable non richiesta in sede d'esame
	
	private ArrayList<Libro> libreria = new ArrayList<Libro>();
	
	// 1)
	public boolean insert(String isbn, int anno) {
		Libro nuovoL = new Libro(isbn, anno);
		if (! libreria.contains(nuovoL)) {
			libreria.add(nuovoL);
			return true;
		} else return false;
	}
	
	public boolean insert2(String isbn, int anno) {
		Libro nuovoL = new Libro(isbn, anno);
		for(Libro libro: libreria) if (libro.equals(nuovoL)) return false;
		libreria.add(nuovoL);
		return true;
	}
	
	public boolean insert3(String isbn, int anno) {
		for(Libro libro: libreria) if (libro.getIsbn().equals(isbn)) return false;
		libreria.add(new Libro(isbn, anno));
		return true;
	}
	
	// 2)
	
	public boolean contains(String isbn) {
		for(Libro libro: libreria) if (libro.getIsbn().equals(isbn)) return true;
		return false;
	}
	
	public boolean contains2(String isbn) {
		return libreria.contains(new Libro(isbn));	
	}
	
	// 3)
	
	public boolean remove(String isbn) {
		Iterator<Libro> itr = libreria.iterator();
		while (itr.hasNext()) 
			if (itr.next().getIsbn().equals(isbn)) {
				itr.remove();
				return true;
			}
		return false;
	}
		

	public boolean remove2(String isbn) {
		return libreria.remove(new Libro(isbn));
	}
	
	// 4)
	
	public void sort() {
		Collections.sort(libreria);
	}
	
	// 5)
	
	public void sortByYear() {
		Collections.sort(libreria, new Comparator<Libro>() {
			public int compare(Libro l1, Libro l2) {
				return l2.getAnno()-l1.getAnno();
			}
		} );
	}
	
	// 6)
	
	public int[] occurrencesPerYears(int inizio, int fine) {
		if (fine < inizio) return null;
		int[] result = new int[fine-inizio+1];
		for(Libro libro: libreria) {
			int anno = libro.getAnno(); 
			if (anno >= inizio && anno <= fine) result[anno-inizio]++;
		}
		return result;
	}
	
	@Override
	public String toString() {
		//return libreria.toString();
		String str = new String();
		for (Libro libro: libreria) {str  += libro.toString() + "\n";}
		return str;
	}
	
	
	@Override
	public Iterator<Libro> iterator(){
		return libreria.iterator();
	}
	
	
	
	
	

}

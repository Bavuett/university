/*
Esercizio 1 - ESAME del 5 settembre 2017  (VI APPELLO)

Un lista si dice "dispari" se ciascuno dei suoi oggetti appare un numero dispari di volte.
Ad esempio, la lista di interi [20, 5, 5, 20, 20]  non è dispari,
mentre lo è [5, 20, 5, 5].
Si assuma una classe Dispari<E> con una sola variabile d’istanza
private LinkedList<E> myList (non sviluppare il codice).
Si implementi un metodo public boolean OrdinaDispari(){...} interno alla classe,
che restituisce false se myList non è dispari, mentre ordina in modo crescente la lista
e restituisce true se myList è dispari.
Si assuma che gli elementi presenti nella lista implementino l’interfaccia Comparable<E>.
 
*** 

A list is called "odd" if each of its objects appears an odd number of times.
For example, the list of integers [20, 5, 5, 20, 20] is not odd, whereas
the list [5, 20, 5, 5] is odd.
Assume a Dispari<E> class with only one private instance variable
LinkedList <E> myList (do not write the code).
Implement a public boolean method OrdinaDispari() {...} inside the class,
which returns false if myList is not odd, whereas it sorts the list in ascending order
and returns true if myList is odd.
Assume that the objects in the list implement the Comparable <E> interface.
 * 
 */

import java.util.*;

public class Dispari<E extends Comparable<? super E>> {
	
	private LinkedList<E> myList = null;
	
	
	public boolean OrdinaDispari(){
		
	// we use a TreeMap to count the occurrences for all objects
	TreeMap<E,Integer> map = new TreeMap<E,Integer>();	
	for (E item: myList) map.put(item, 0);
	for (E item: myList) map.replace(item, map.get(item)+1);
		
	LinkedList<E> tempList = new LinkedList<E>();
    for (Map.Entry<E, Integer> entry : map.entrySet())
    // Notice that entry.getValue() returns the number of occurrences of entry.getKey() in mylist 
    	if (entry.getValue() % 2 == 0) return false;
    	else for (int i = 1; i <= entry.getValue(); i++)
    			tempList.add(entry.getKey());
    
    myList= tempList;
    return true;
        	
	} //end-OrdinaDispari
	

public static void main(String[] args)  //test
{
	Dispari<Integer> d = new Dispari<Integer>();
	d.myList =  new LinkedList<Integer>();
	d.myList.add(20); d.myList.add(20); d.myList.add(20);
	d.myList.add(5); d.myList.add(5);
	
	System.out.println(d.myList);
	if (! d.OrdinaDispari()) System.out.println("La lista non e' dispari. Ordinamento fallito\n");
	
	d.myList.add(5); d.myList.add(5); d.myList.add(5);
	System.out.println(d.myList);
	if (d.OrdinaDispari()) System.out.println("Lista ordinata: ");
	System.out.println(d.myList);
	
}

} //end-class

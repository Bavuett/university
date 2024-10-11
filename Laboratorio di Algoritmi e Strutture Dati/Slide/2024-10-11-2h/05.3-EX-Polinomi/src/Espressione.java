/*
 * Ordinamento e riduzione dei termini di una
 * ESPRESSIONE ALGEBRICA AD UNA VARIABILE RAPPRESENTATA COME LISTA DI TERMINI 
 * Esempio:  5x^6 + 12.5 x^3 -2 x^7 + 3 
 * puo' essere rappresentata come lista di termini (coefficiente, esponente)
 * (5,6); (12.5,3); (-2,7); (3,0);
 * 
 * Sorting and reducing the terms of one
  * ALGEBRAIC EXPRESSION TO A VARIABLE REPRESENTED AS A LIST OF TERMS
  * Example: 5x^6 + 12.5 x^3 -2 x^7 + 3
  * can be represented as a list of terms (coefficient, exponent)
  * (5.6); (12.5,3); (-2.7); (3.0);
 */


import java.util.*;

public class Espressione {
  List<Termine> list = new LinkedList<Termine>( );

  public void insert(Termine x){
	list.add(x);
  }

  public void print(){ 
	if (list.isEmpty()) return;
	Iterator<Termine> iterator = list.iterator(); 
	System.out.print(iterator.next());
	while (iterator.hasNext()) { 
		System.out.print(" + " + iterator.next()); 
	}
  }
  
  @Override
  public String toString( ){
	String s = new String();
	if (list.isEmpty()) return s;
	Iterator<Termine> iterator = list.iterator(); 
	s += iterator.next().toString();
	while (iterator.hasNext()) { 
		s += " + " + iterator.next(); 
	}
	return s;
  }
  
  /*
  public String toString( ){
   //per ottenere una stringa "formattata" come una generica lista
		return list.toString(); 
	  }
   */



  public void sort(){
  /* e.g., 4x^2 + 2x^9 + 3x^2 + x^3 + 6x^9
   * --> 3x^2 + 4x^2 + x^3 + 2x^9 + 6x^9 */
	Collections.sort(list);
  }
  
  
  public void sort_decr(){
	//Collections.sort(list, new Ord_decr());
	
	Collections.sort(list, new Comparator<Termine>() {

		  public int compare (Termine s1, Termine s2) {
			  //return -s1.compareTo(s2); 
			  //per ordinamento decrescente solo se si ha la certezza che la 
			  //classe T implementa Comparable<T>
			  
				if (s1.getExp() < s2.getExp()) return 1;   
				else if (s1.getExp() > s2.getExp()) return -1;
				// esponenti uguali
				if (s1.getCoeff() < s2.getCoeff()) return 1;
				else if (s1.getCoeff() > s2.getCoeff()) return -1;
				return 0;
		  }} );	
	
  }// end-method

  
  // riduzione dei termini (modifica la lista corrente)
  public void reduce(){  //version 1
  // e.g., 4x^2 + 2x^9 + 3x^2 + x^3 + 6x^9 --> 7x^2 + x^3 + 8x^9 
	if (list.isEmpty()) return;
	Collections.sort(list);
	List<Termine> redList = new LinkedList<Termine>();
	Termine t1, t2;
	Iterator<Termine> itr = list.iterator(); 
	t1=itr.next();
	redList.add(t1);
	while (itr.hasNext()) {
		t2=itr.next();
		if (t1.getExp()==t2.getExp()) {
		    t1.setCoeff(t1.getCoeff() + t2.getCoeff());
		} else {
		    redList.add(t2);
		    t1 = t2;
		}
	}
	list=redList;
  }
  

  // riduzione dei termini (modifica la lista corrente)
  public void reduceInPlace(){ //version 2
  // e.g., 4x^2 + 2x^9 + 3x^2 + x^3 + 6x^9 --> 7x^2 + x^3 + 8x^9 
	if (list.isEmpty()) return;
	Collections.sort(list);
	Termine t1, t2;
	Iterator<Termine> itr = list.iterator(); 
	t1=itr.next();
	while (itr.hasNext()) {
		t2=itr.next();
		if (t1.getExp()==t2.getExp()) {
		    t1.setCoeff(t1.getCoeff() + t2.getCoeff());
		    itr.remove();
		} else {
		    t1 = t2;
		}
	}
  }

  
  // genera una nuova espressione ordinata e ridotta)
  public Espressione getReduced(){
  // e.g., 4x^2 + 2x^9 + 3x^2 + x^3 + 6x^9 --> 7x^2 + x^3 + 8x^9
	Espressione redExpr = new Espressione();  // espressione output
	if (list.isEmpty()) return redExpr;
	
	//copia dell'espressione corrente \Theta(n)
	List<Termine> list2 = new LinkedList<Termine>(); 
	for (Termine t: list) list2.add(new Termine(t.getCoeff(), t.getExp()));
	redExpr.list = list2;
	
	redExpr.reduceInPlace();
	return redExpr;
  }
  

} // end-class 
/*
 * Ordinamento e riduzione dei termini di una
 * ESPRESSIONE ALGEBRICA AD UNA VARIABILE RAPPRESENTATA COME LISTA DI TERMINI 
 * Esempio:  5x^6 + 12.5 x^3 -2 x^7 + 3 
 * puo' essere rappresentata come lista di termini (coefficiente, esponente)
 * (5,6); (12.5,3); (-2,7); (3,0);
 */


import java.util.*;

public class Espressione implements Comparable<Espressione> {
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
  // e.g., 4x^2 + 2x^9 + 3x^2 + x^3 + 6x^9 --> 3x^2 + 4x^2 + x^3 + 2x^9 + 6x^9 
	Collections.sort(list);
  }
  
  
  public void sort_decr(){
	Collections.sort(list, new Ord_decr());
  }

  // riduzione dei termini (modifica la lista corrente)
  public void reduce(){
  // e.g., 4x^2 + 2x^9 + 3x^2 + x^3 + 6x^9 --> 7x^2 + x^3 + 8x^9 
	if (list.isEmpty()) return;
	Collections.sort(list);
	List<Termine> redList = new LinkedList<Termine>();  //lista output
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
  
  // riduzione dei termini (genera una nuova lista)
  public Espressione reduce2new(){
  // e.g., 4x^2 + 2x^9 + 3x^2 + x^3 + 6x^9 --> 7x^2 + x^3 + 8x^9
	Espressione redExpr = new Espressione();  // espressione output
	if (list.isEmpty()) return redExpr;
	
	List<Termine> list2 = new LinkedList<Termine>();; 
	for (Termine t: list) list2.add(new Termine(t.getCoeff(), t.getExp()));  //copia della lista iniziale O(n)
	Collections.sort(list2);
	
	List<Termine> redList = new LinkedList<Termine>();  //lista output
	Termine t1, t2;
	Iterator<Termine> itr = list2.iterator(); 
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
	redExpr.list=redList;
	return redExpr;
  }
  
  /*  EX 1 */
  
  public double calcola(double valx) {
	  double somma = 0;
	  for (Termine t: list) somma += t.getCoeff()*(Math.pow(valx,t.getExp()));
	  return somma;
  }
  
  /* EX 2 */
  
  public int gradoE() {
		 int grado = 0;
		 for (Termine t: list)
			 if (t.getExp() > grado) grado = t.getExp(); 
		 return grado;
	 }
  
  @Override
  public int compareTo( Espressione e2 ) { 
	  
		if (this.gradoE() < e2.gradoE()) return -1;
		if (this.gradoE() > e2.gradoE()) return 1;
		return 0;
		// return this.gradoE() -e2.gradoE();
		
  }
  
	 public static void ordinaE(ArrayList<Espressione> listOfExpr) {
		   Collections.sort(listOfExpr);
	   }
  

} // end-class 
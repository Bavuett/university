import java.util.*;

public class EX1 implements Comparable<Espressione> {   
//in alternativa definire il comparatore

List<Termine> list = new LinkedList<Termine>( );
  
  
  /** EX1 PARZIALE
   * Implementare il metodo public double calcola(double valx), interno alla classe Espressione,
   * che calcola il valore dell'espressione algebrica ad una variabile (this) per il dato valore
   * di valx.
   * 
   * */
   public double calcola(double valx) {
	  double somma = 0;
	  for (Termine t: list) somma += t.getCoeff()*(Math.pow(valx,t.getExp()));
	  return somma;
   }
  
  /** EX2 Parziale 
   * Implementare un metodo statico che, data una lista di espressioni algebriche ad
   * una variabile (oggetto di tipo ArrayList<Espressione>), ordina la lista rispetto
   * al grado dell'espressione (il grado dell'espressione rispetto alla variabile x
   * è l'esponente più alto con cui x compare in essa).
   * Definire tutte le classi e/o metodi aggiuntivi ritenuti utili o necessari.	
   * 
   **/

   // EX 2 richiede implementazione di Comparable<Espressione> o Comparator<Espressione>

  
   
   public int gradoE() {
		 int grado = 0;
		 for (Termine t: list)
			 if (t.getExp() > grado) grado = t.getExp(); 
		 return grado;
	 }
   
   @Override
   public int compareTo( Espressione e2 ) { 
 	  return this.gradoE() - e2.gradoE();
   }
   
//....

}// end-Espressione


  
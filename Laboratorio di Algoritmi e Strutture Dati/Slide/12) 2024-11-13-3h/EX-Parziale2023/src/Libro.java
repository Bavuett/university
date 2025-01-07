/* I parziale 10/11/2023 a.a. 2023/2024 - Esercizio 1.a)
 * L’ISBN (International Standard Book Number) è un codice univoco che identifica
 * un libro a livello internazionale.  Scrivere una classe “Libro” con due variabili d’istanza: 
 * il codice ISBN (di tipo String) e l’anno di prima pubblicazione.
 */

public class Libro implements Comparable<Libro> {
	
  private String isbn;
  private int annoPub = 0;

  public Libro(String nuovoIsbn, int nuovoAnno)
  {  
	isbn = nuovoIsbn;
	annoPub = nuovoAnno;
  }

  public Libro(String nuovoIsbn)
  {
	isbn = nuovoIsbn;
  }	
	
  public String getIsbn(){ return isbn; }
  public int getAnno(){ return annoPub; }
  public void setIsbn(String isbn){ throw new UnsupportedOperationException(); }
  public void setAnno(int nuovoAnno) { annoPub = nuovoAnno; }
  
  @Override
  public boolean equals (Object obj)
  {
	  if (obj == null || ! (obj instanceof Libro)) return false;
	  	return isbn.equals(((Libro)obj).isbn);
  } // method equals
  
  @Override
  public int compareTo (Libro altroL)
  {
	  return isbn.compareTo(altroL.isbn);
  } // method compareTo

  @Override
  public String toString()
  { 
	 return "ISBN libro: " + isbn + ", anno di pubblicazione: " + annoPub;
  } // method toString
}

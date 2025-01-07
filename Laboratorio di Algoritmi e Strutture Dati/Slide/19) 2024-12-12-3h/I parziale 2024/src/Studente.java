/* I parziale a.a. 2024/2025  */

public class Studente implements Comparable<Studente> {
	
  private String matr;
  private int anno_imm = 0;
  private int cfu = 0;

  public Studente(String nMatr, int nAnno, int nCfu)
  {  
	  matr = nMatr;
	  anno_imm = nAnno;
	  cfu = nCfu;
  }

  // aggiunto
  public Studente(String nMatr)
  {
	  matr = nMatr;
  }	
	
  public String getMatr(){ return matr; }
  public int getAnno(){ return anno_imm; }
  public int getCfu(){ return cfu; }
  
  
  @Override
  public boolean equals (Object obj)
  {
	  if (obj == null || ! (obj instanceof Studente)) return false;
	  	return matr.equals(((Studente)obj).matr);
  } // method equals
  
  @Override
  public int compareTo (Studente altroS)
  {
	  return matr.compareTo(altroS.matr);
  } // method compareTo

  @Override
  public String toString()
  { 
	 return "matr: " + matr + ", anno immatricolazione: " + anno_imm + ", cfu maturati" + cfu;
  } // method toString
}

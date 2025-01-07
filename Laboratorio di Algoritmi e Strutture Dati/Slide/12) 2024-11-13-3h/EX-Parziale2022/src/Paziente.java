/**
 * Si consideri un Ospedale costituito da 10 reparti univocamente
 * identificati da un intero tra 1 e 10. L’Ospedale gestisce un archivio
 * elettronico per raccogliere informazioni  sui pazienti ricoverati. 
 * Implementare una classe Paziente che rappresenta un paziente ricoverato.
 * Di ogni paziente vengono archiviate le seguenti informazioni:
 * codice fiscale, età, reparto. 
 **/
class Paziente implements Comparable<Paziente>
{
  String cf; //valore univoco
  int eta, reparto;

  public Paziente (String cf, int eta, int reparto) {
    this.cf = cf.toUpperCase();
    this.eta = eta;
    this.reparto = reparto;
  } // constructor
  
  public Paziente (String cf) {
	    this(cf, 0, 0); 
  } // constructor
  
  public String getCF(){ return cf; }
  public int getEta(){ return eta; }
  public int getReparto(){ return reparto; }
  
  public void setCF(String cf){ throw new UnsupportedOperationException(); }
  public void setEta(int eta) { this.eta = eta; }
  public void setReparto(int reparto) { this.reparto = reparto; }
    
  /**
   * confronta questo oggetto Paziente con l'oggetto Paziente specificato in base al CF
   **/
  public int compareTo (Paziente altroP) {
	  return this.cf.compareTo(altroP.cf);
  } // method compareTo
 
  /**
   * determina se il cf di questo oggetto Paziente è uguale al cf
   * dell'oggetto Paziente specificato
   */
  public boolean equals (Object obj)
  {
	  if (obj == null || ! (obj instanceof Paziente)) return false;
	  	return this.cf.equals(((Paziente)obj).cf);
  } // method equals

  
  /**
   * Restituisce una rappresentazione String di questo oggetto Paziente
   */
  public String toString()
  { 
	 return "CF paziente: " + cf + ", età: " + eta + ", reparto: " + reparto;
  } // method toString
  
} // end-class 

class Automobile implements Comparable<Automobile>
{
  String targa; //valore univoco
  Cliente cliente;

  public Automobile (String targa, Cliente cliente) {
    this.targa = targa.toUpperCase();
    this.cliente = cliente;
  } // constructor
  
  public Automobile (String targa) {
	    this(targa, null);
	  } // constructor
  
  
  public String getTarga(){ return targa; }
  public Cliente getCliente(){ return cliente; }
  
  //public void setTarga(String targa){ throw new UnsupportedOperationException(); }  
  public void setCliente(Cliente cliente){ this.cliente = cliente; }
    
  /**
   * confronta questo oggetto Automobile con l'oggetto Automobile specificato in base alla targa
   */
  public int compareTo (Automobile altraAuto) {
	  return this.targa.compareTo(altraAuto.targa);
  } // method compareTo
 

  /**
   * determina se la targa di questo oggetto Automobile è uguale alla
   * targa dell'oggetto Automobile specificato
   */
  public boolean equals (Object obj)
  {
	  if (obj == null || ! (obj instanceof Automobile)) return false;
	  	return this.targa.equals(((Automobile)obj).targa);
  } // method equals

  
  /**
   * Restituisce una rappresentazione String di questo oggetto Automobile
   */
  public String toString()
  { 
	  if (cliente != null) return "Targa: " + targa + ", Proprietario: " + cliente.toString();
	  else return "Targa: " + targa + ", Proprietario unknown"; 
  } // method toString
  
} // end-class 
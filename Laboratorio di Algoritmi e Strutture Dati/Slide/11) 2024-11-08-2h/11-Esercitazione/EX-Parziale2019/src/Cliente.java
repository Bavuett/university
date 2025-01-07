
class Cliente implements Comparable<Cliente>
{
  String nome;
  String CF; //valore univoco
  String citta; 
  

  public Cliente (String nome, String CF, String citta) {
    this.nome = nome.toUpperCase();
    this.CF = CF.toUpperCase();
    this.citta = citta.toUpperCase();
  } // constructor
  
  public Cliente (String CF) {
	    this("unknown", CF, "unknown");
	  } // constructor
  
  
  public String getNome(){ return nome; }
  public String getCF(){ return CF; }
  public String getCitta(){ return citta; }
  
  public void setNome(String nome){ this.nome = nome.toUpperCase(); }
  //public void setCF(String CF){ throw new UnsupportedOperationException(); }  
  public void setCitta(String citta){ this.citta = citta.toUpperCase(); }
  
  
  /**
   * confronta questo oggetto Cliente con l'oggetto Cliente specificato in base al CF
   */
  public int compareTo (Cliente altroCliente) {
	  return this.CF.compareTo(altroCliente.CF);
	  //alternativa, se non si converte il CF in maiuscolo in fase di assegnamento
	  //return this.CF.compareToIgnoreCase(altroCliente.CF);
  } // method compareTo
 

  /**
   * determina se il CF di questo oggetto Cliente è uguale al
   * CF dell'oggetto Cliente specificato
   */
  public boolean equals (Object obj)
  {
	  if (obj == null || ! (obj instanceof Cliente)) return false;
	  	return this.CF.equals(((Cliente)obj).CF);
	  	//return this.CF.equalsIgnoreCase(((Cliente)obj).CF);
  } // method equals

  
  /**
   * Restituisce una rappresentazione String di questo oggetto Cliente
   */
  public String toString()
  {
    return nome + ", CF: " + CF + ", residente a " + citta;
  } // method toString
  
} // end-class
/* Sviluppare una classe Paziente, avente le variabili d'istanza codice (stringa univoca) e 
 * priorit� (intero).
 * Priorit� pu� assumere uno dei seguenti tre valori che rappresentano i codici di emergenza:
 * 2 (priorit� maggiore), 1, 0 (priorit� minore).
 * NB: Oltre alla priorit�, tenere possibilmente conto dell'ordine di arrivo.
 */


public class Paziente implements Comparable<Paziente>{

   private String codice;
   private int priorita;
   static private int c = 0;  	// it counts the number of instances created for this class
   private int id = 0; 			// a unique integer ID number assigned to each instance

    public Paziente(String codice){
	this.priorita = 0;
	this.codice = codice;
	id = ++c;
    }

    public Paziente(String codice, int priorita){
	this.priorita = priorita;
	this.codice = codice;
	id = ++c;
    }

   public String getCodice(){ return codice; }
   public void setCodice(String codice){this.codice = codice;}

   public int getPriorita(){ return priorita; }
   public void setPriorita(int priorita){this.priorita = priorita;}

   // utili per preservare l'ordine di arrivo in caso di cambio priorita	
   public int getId(){ return id; }
   public void setId(int id){this.id = id;}


   @Override    
   public int compareTo(Paziente altro){
   	if (altro.codice == this.codice) return 0;
        else if (altro.priorita != this.priorita) return  altro.priorita - this.priorita;
             else return  this.id - altro.id;
   }

   @Override 
   public String toString(){
 	return ("Code: " + codice + " - priority: " + priorita + " - id: " + id);
   }

   @Override 
   public boolean equals(Object obj){
	if (obj == null) return false;
        if (!(obj instanceof Paziente)) return false;
        Paziente p = (Paziente) obj; 
        return p.codice == this.codice;
   }



}
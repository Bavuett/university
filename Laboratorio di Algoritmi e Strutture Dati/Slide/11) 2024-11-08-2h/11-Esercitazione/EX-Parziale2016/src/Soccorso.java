import java.util.*;

public class Soccorso {  
    private ArrayList<Paziente> attesa;  

    public Soccorso(){
	attesa = new ArrayList<Paziente>();
    }  

    public void ingresso(String codice, int priorita){
	this.ingresso(new Paziente(codice, priorita));
    }

    public void ingresso(Paziente altro){
	int pos = 0;
	for (Paziente cur: attesa) {
	   if (cur.compareTo(altro) < 0) pos++;
	   else break;
	} 
	attesa.add(pos, altro);
    }

    public Paziente dimissione(){
	return attesa.remove(0);
    }

  
    public void cambio(String codice, int nuovaPriorita){
	/* questo codice commentato   corretto ma non preserva l'ordine di arrivo originario,
	 * ovvero assegna un nuovo id
 	Paziente p = new Paziente(codice, nuovaPriorita);
	attesa.remove(p);  //non consente di recuperare l'oggetto cancellato
	this.ingresso(p);
	*/

	Paziente p = new Paziente(codice, nuovaPriorita);
	Paziente cur = null;
	boolean found = false;
	// cancella il paziente dalla lista, salvando in cur l'oggetto
	Iterator<Paziente> iter = attesa.iterator();
	while(iter.hasNext() && !found) {
    		cur = iter.next();
    		if(cur.equals(p)) {
			iter.remove();
			found = true;
		}
    	}
	if (!found) this.ingresso(p);
	else  {cur.setPriorita(nuovaPriorita); this.ingresso(cur);}

    }


   @Override 
   public String toString(){
 	return attesa.toString();
   }


} 

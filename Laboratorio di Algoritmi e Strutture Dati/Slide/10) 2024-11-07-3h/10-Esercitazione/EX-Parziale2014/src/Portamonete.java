import java.util.*;
 

/*
 Fare riferimento all’interfaccia List del JCF e scegliere un’opportuna implementazione (motivando la scelta), 
per realizzare una classe Portamonete come collezione di monete ordinata in modo non decrescente rispetto al valore 
delle monete. 
Fornire uno o più costruttori ed i seguenti metodi: 
        • addMoneta(Moneta moneta): inserisce in modo ordinato la moneta nel portamonete; 
        • conteggio(Moneta moneta): conta il numero di esemplari della moneta; 
        • getTotale(): restituisce il valore totale delle monete presenti nel portamonete; 
        • remove(Moneta moneta): rimuove la prima occorrenza della moneta specificata, se presente nel portamonete; 
        • print(): stampa il contenuto del portamonete in un formato leggibile. 
Lo studente estenda la classe Portamonete (ed eventualmente, alla luce di questa specifica, la classe Moneta) 
con altri metodi, se lo ritiene opportuno, motivando la scelta. 
 */

//--------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------


public class Portamonete implements Iterable <Moneta>{ 
    
    List<Moneta> listaMonete; 
    int size;
    double valore;
    
    public Portamonete(){
        listaMonete  = new LinkedList<Moneta>();
        size=0;
        valore = 0;
    }


    public void addMoneta(Moneta moneta){
	int pos = 0;
	for (Moneta current: listaMonete){
	    	if (moneta.compareTo(current) > 0 ) pos++;
  		else break;
    	}
	listaMonete.add(pos, moneta);
	size++;
	valore += moneta.getValore();	
    }


    public int conteggio(Moneta moneta) {
	int count=0;
	for (Moneta current: listaMonete){
	    	if (moneta.compareTo(current) < 0) break;
  		if (moneta.equals(current)) count++;
    	}
	return count;
    }


    public double getTotale(){
	return valore;

    }


    public boolean remove(Moneta moneta){
	boolean isRemoved = listaMonete.remove(moneta);
	if (isRemoved) { 
		size--;
		valore -= moneta.getValore();
	}
	return isRemoved;
    }


   public String toString(){
 	return listaMonete.toString();
   }

   public void print(){
	System.out.println(listaMonete);

   }

   public Iterator<Moneta> iterator(){
	return listaMonete.iterator();
   }



   
}
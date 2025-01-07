/**
 * EX1 - PARTE 2 - Lista di Auto
 * Realizzare una classe che gestisca una lista di autoveicoli registrati presso un ufficio di
 * motorizzazione Civile (oggetti Auto). 
 * La classe deve fornire (oltre agli usuali metodi pubblici per gestire i dati di un oggetto)
 * almeno le seguenti funzionalità:
 * - inserimento di un nuovo autoveicolo nella lista;
 * - cancellazione di un autoveicolo dalla lista, data la targa;
 * - stampa a video della lista;
 * - ordinamento della lista in ordine crescente rispetto alla targa dell’autoveicolo;
 * - ordinamento della lista in ordine non decrescente rispetto all’anno di immatricolazione.
 **/


import java.util.*;


class AutoByDate implements Comparator<Auto>  {
	// ordine non decrescente rispetto all’anno di immatricolazione
     public int compare (Auto a, Auto b)  {
    	 int res = a.getAnno()-b.getAnno();
    	 if (res==0) return a.getTarga().compareTo(b.getTarga());
    	 else return res;
     } // method compare

} // class AutoByDate



public class ListaDiAuto {

  List<Auto> list = new LinkedList<Auto>( );

  public void insert(Auto x){
	if (! list.contains(x)) list.add(x);
  }


  public boolean remove(Auto a){
	return list.remove(a);
  }
  
  public boolean remove(String targa){
	return list.remove(new Auto(targa, 2000)); // anno fittizio
  }
  

  public String toString(){
	return list.toString();
  }


  public void PrintLista(){
	System.out.println(list);
  }


  public void sort(){ Collections.sort(list); }

  public void sortByDate(){ Collections.sort(list, new AutoByDate()); }



/**
 * EX2.a
 * Immatricolazioni nell'intervallo di anni [annoIn, annoFin]
 **/

  public  int[] numByYears(int annoIn, int annoFin){
	int size = annoFin - annoIn + 1; // numero di anni da monitorare
	int output[] = new int[size];
	for(Auto x: list) {
	  int diff = x.anno - annoIn;
	  if (diff >= 0 && diff < size) output[diff]++;
	}
  	return output;
  }



  public static void main( String[] args ){
	// TEST OPERAZIONI
	ListaDiAuto lista = new ListaDiAuto();
	lista.insert( new Auto("Fiat Punto", "DJ555BC", "SDFCGD68H23C345T", 2009) );
	lista.insert( new Auto("Fiat Tipo", "DD444BC", "SDFCGD68H23C345T", 2008) );
	lista.insert( new Auto("Opel Astra", "CC456AA", "SSSCGD68t23C345T", 2009) );
	lista.insert( new Auto("Fiat Punto", "AA888BC", "BBbCGD68H23C678f", 2008) );
	lista.insert( new Auto("Opel Corsa", "BB923ZS", "SSSCGD68t23C345T", 2009) );
	lista.PrintLista();   // equivalentemente: System.out.println(lista);

	Auto c = new Auto("DJ555BC", 2009);
	if (lista.remove(c))  
		System.out.println("\nCancellata auto DJ555BC.");
	

	System.out.println("\nOrdinamento per targa crescente:");
	lista.sort();
	System.out.println(lista); 
	
	System.out.println("\nOrdinamento per anno di immatricolazione non decrescente:");
	lista.sortByDate();
	System.out.println(lista); 

	System.out.println("\nCalcolo numero di immatricolazioni per anno:");
	int numbers[] = lista.numByYears(2000, 2015);
	for (int i = 0; i < numbers.length; i++)
		System.out.println("Anno " + (2000+i) + ": " + numbers[i]); 
	  

  }



}  //end-class


public class Test {

	public static void main (String[ ] args) {
		     new Test().run();
	  }
	  
	public void run() {

		/**** GENERAZIONE ESPRESSIONE ALGEBRICA ****/	

		Espressione espressione = new Espressione( );
		espressione.insert(new Termine(2.0, 2));
		espressione.insert(new Termine(3.0, 2));
		espressione.insert(new Termine(5.0, 1));
		espressione.insert(new Termine(1.0, 0));
		espressione.insert(new Termine(-1, 2));
		espressione.insert(new Termine(2, 4));
		espressione.insert(new Termine(6, 1));

		System.out.println("Espressione input:");  
		espressione.print();  // stampa espressione
		
		// stampa nuova espressione ridotta ordinata
		Espressione espressione_ridotta = espressione.getReduced();
		System.out.println("\n\nNuova espressione ridotta:\n" + espressione_ridotta);  
					
		espressione.sort();
		System.out.println("\nEspressione ordinata in modo non decrescente:\n" + espressione); 

		espressione.sort_decr();
		System.out.println("\nEspressione ordinata in modo non crescente:\n" + espressione);  

		// riduci e stampa espressione 
		espressione.reduceInPlace();
		System.out.println("\nEspressione ridotta:\n" + espressione);  

	}

}
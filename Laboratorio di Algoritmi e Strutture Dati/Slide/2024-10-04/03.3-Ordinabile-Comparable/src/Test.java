
public class Test {

	public static void main(String[] args) {

		  VettoreOrdinabile<Punto> vo = new VettoreOrdinabile<Punto>(10);
	      vo.aggiungi (new Punto(30,40));
	      vo.aggiungi (new Punto(300,400));
	      vo.aggiungi (new Punto(3,4));
	      
		  //stampa array ordinato
		  System.out.println("VettorePunto:");
		  vo.visualizza();
		  
		  
		  VettoreOrdinabile<Integer> vo2 = new VettoreOrdinabile<Integer>(10);
	      vo2.aggiungi (Integer.valueOf(34));
	      vo2.aggiungi (Integer.valueOf(10));
	      vo2.aggiungi (Integer.valueOf(45));
	      vo2.aggiungi (Integer.valueOf(7));
	      
		  //stampa array ordinato
	      vo2.ordina();
		  System.out.println("\nVettoreIntero:");
		  vo2.visualizza();
		   
	}

}


public class Test {

	public static void main(String[] args) {

		  VettoreOrdinabile vo = new VettoreOrdinabile(10);
	      vo.aggiungi (new Punto(30,40));
	      vo.aggiungi (new Punto(300,400));
	      vo.aggiungi (new Punto(3,4));
	      
		  //stampa array ordinato
		  System.out.println("VettorePunto:");
		  vo.visualizza();
		  
		  
		  VettoreOrdinabile vo2 = new VettoreOrdinabile(10);
	      vo2.aggiungi (new Intero(34));
	      vo2.aggiungi (new Intero(10));
	      vo2.aggiungi (new Intero(45));
	      vo2.aggiungi (new Intero(7));
	      
		  //stampa array ordinato
		  System.out.println("\nVettoreIntero:");
		  vo2.visualizza();
		  
		  
		  
		  
		  
	}

}

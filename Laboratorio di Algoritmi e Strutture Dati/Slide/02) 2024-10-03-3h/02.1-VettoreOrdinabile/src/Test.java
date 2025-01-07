
public class Test {

	public static void main(String[] args) {
		
		// Test VettorePunto
		System.out.println("Test VettorePunto");
		Punto p1 =new Punto (3,4);
		Punto p2 =new Punto (2,2);
		Punto p3 =new Punto (2,4);
	
		VettorePunto VP = new VettorePunto();
		VP.aggiungi(p1);
		VP.aggiungi(p2);
		VP.aggiungi(p3);		
		VP.visualizza();
		
		// Test VettoreIntero
		System.out.println("\nTest VettoreIntero");
		Integer i1 = Integer.valueOf(3);
		Integer i2 = Integer.valueOf(389);
		Integer i3 = Integer.valueOf(15);
		Integer i4 = Integer.valueOf(10);
		
		VettoreIntero VI = new VettoreIntero();
		VI.aggiungi(i1);
		VI.aggiungi(i2);
		VI.aggiungi(i3);
		VI.aggiungi(i4);
		VI.visualizza();
		
		
		
		
		


	}

}


public class Test {

	public static void main(String[] args) {
		
		// Test VettorePerson
		System.out.println("Test VettorePerson");
		Person p1 =new Person ("Luca","Rossi", 23);
		Person p2 =new Person ("Maria","Bianchi", 18);
		Person p3 =new Person ("Agata","Neri", 20);
	
		VettorePerson VP = new VettorePerson();
		VP.aggiungi(p1);
		VP.aggiungi(p2);
		VP.aggiungi(p3);
		VP.visualizza();

		
		
		
		


	}

}

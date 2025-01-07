
public class Test {

	public static void main(String[] args) {
		
		// Test VettorePerson
		System.out.println("Test VettorePerson");
		Person p1 =new Person ("Luca","Rossi", 23);
		Person p2 =new Person ("Maria","Bianchi", 18);
		Person p3 =new Person ("Agata","Neri", 20);
	
		VettoreOrdinabile vo = new VettoreOrdinabile(5);
		vo.aggiungi(p1);
		vo.aggiungi(p2);
		vo.aggiungi(p3);
		vo.visualizza();
	}

}

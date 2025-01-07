public class VettorePerson extends VettoreOrdinabile {
	
	public VettorePerson () {
		super (10); 
	}
	
	public VettorePerson (int maxDim) {
		super (maxDim);
	}

	
	// this method prevents the insertion of objects of a type other than Point
	@Override  
	public boolean aggiungi (Object elemento) {
		return false; 
	}
 
	public boolean aggiungi (Person elemento) {
		return super.aggiungi(elemento);
	}

	//definition of the abstract method
	@Override
	protected int confronta (Object elemento1, Object elemento2) {
		Person p1, p2;
 		p1 = (Person) elemento1;
 		p2 = (Person) elemento2;
 		if (p1.equals(p2)) return 0; 
 		else {
 			if (p1.getAge() > p2.getAge())
 				return 1;
 			else return -1;
 		}
	}


}

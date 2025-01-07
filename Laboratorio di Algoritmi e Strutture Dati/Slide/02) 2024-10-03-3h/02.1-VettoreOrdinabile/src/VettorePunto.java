public class VettorePunto extends VettoreOrdinabile {
	
	public VettorePunto () {
		super (10); 
	}
	
	public VettorePunto (int maxDim) {
		super (maxDim);
	}

	
	// this method prevents the insertion of objects of a type other than Point
	@Override  
	public boolean aggiungi (Object elemento) {
		return false; 
	}
 
	public boolean aggiungi (Punto elemento) {
		return super.aggiungi(elemento);
	}

	//definition of the abstract method
	@Override
	protected int confronta (Object elemento1, Object elemento2) {
 		Punto p1, p2;
 		p1 = (Punto) elemento1;
 		p2 = (Punto) elemento2;
 		if (p1.equals(p2)) return 0; 
 		else {
 			if (p1.distanza() > p2.distanza())
 				return 1;
 			else return -1;
 		}
	}


}

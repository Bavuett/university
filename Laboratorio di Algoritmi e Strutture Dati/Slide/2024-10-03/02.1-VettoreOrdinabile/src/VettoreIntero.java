public class VettoreIntero extends VettoreOrdinabile {
	
	public VettoreIntero () {
		super (10); 
	}
	
	public VettoreIntero (int maxDim) {
		super (maxDim);
	}

	// this method prevents the insertion of objects of a type other than Integer
	@Override  
	public boolean aggiungi (Object elemento) {
		return false; 
	}
 
	public boolean aggiungi (Integer elemento) {
		return super.aggiungi(elemento);
	}

	//definition of the abstract method
	@Override
	protected int confronta (Object elemento1, Object elemento2) {
 		Integer i1,i2;
 		i1 = (Integer)elemento1;
 		i2 = (Integer)elemento2;
		return (i1 - i2);
	}


}
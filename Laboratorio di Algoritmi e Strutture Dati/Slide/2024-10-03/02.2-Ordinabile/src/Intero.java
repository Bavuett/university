class Intero implements Ordinabile{

   private int intValue;

   public Intero(int x){ intValue=x; }	

   public int getValue(){ return intValue; }
   
  	@Override
  	public String toString() {
  		return String.valueOf(intValue);
  	}
  	
   	@Override
   	public boolean equals(Object obj) {
   		if (obj == null || !(obj instanceof Intero)) return false;
   		return intValue == ((Intero)obj).getValue();
   	}
  	
  	public int confronta (Ordinabile obj) {
  		Intero x;
 		if (obj == null) throw new NullPointerException("L'oggetto specificato e' null");
 		if (obj instanceof Intero) x = (Intero) obj;
 		else throw new ClassCastException("L'oggetto specificato non e' confrontabile con questo oggetto");
 		return intValue - x.getValue();
  	}
  	
  //completare
  	
}

public class Punto implements Ordinabile{

	int x; int y;
   	
   	public Punto (int x, int y) {
   		this.x = x;
   		this.y = y;
   	}
   	
   	int leggiX() { return x; }
   	int leggiY() { return y; }
   	
   	// distance from the origin
   	int distanza() {
      	return (int) Math.sqrt(x * x + y * y);
    }
   	
   	@Override
   	public String toString() {
   		return "("+ x + "," + y + ")";
   	}

   	@Override
   	public boolean equals(Object obj) {
   		if (obj == null) return false;
   		if (!(obj instanceof Punto)) return false;
   		Punto p = (Punto) obj;
   		return ((x == p.x) && (y == p.y));
   	}
   	   	  
   
	//definition of the interface method
	@Override
	public int confronta (Ordinabile obj) {
		Punto p;
		if (obj == null) throw new NullPointerException("L'oggetto specificato e' null");
		if (obj instanceof Punto) p = (Punto) obj;
		else throw new ClassCastException("L'oggetto specificato non e' confrontabile con questo oggetto");
		return distanza() - p.distanza();
	}

}

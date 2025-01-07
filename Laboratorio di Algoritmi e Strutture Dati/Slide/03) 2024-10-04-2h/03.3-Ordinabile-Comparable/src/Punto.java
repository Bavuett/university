class Punto implements Comparable<Punto> {

	int x; int y;
   	
   	public Punto (int x, int y) {
   		this.x = x;
   		this.y = y;
   	}
   	
   	int leggiX() { return x; }
   	int leggiY() { return y; }
   	
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
   	   	
   	   
	//definizione del metodo astratto
	@Override
	public int compareTo (Punto p) {
 		if (p == null) throw new NullPointerException("L'oggetto specificato è null");
 		return distanza() - p.distanza();
	}
}

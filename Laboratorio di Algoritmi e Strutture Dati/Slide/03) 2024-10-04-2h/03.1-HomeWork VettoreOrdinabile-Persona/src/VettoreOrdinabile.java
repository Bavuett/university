public abstract class VettoreOrdinabile {
	
	   private Object vettore[];
	   private int maxDim;  //maximum size
	   private int curDim;  //actual size

	public VettoreOrdinabile (int maxDim) {
	    this.maxDim = maxDim;
		vettore = new Object[maxDim];
		curDim = 0;
	   }

	public boolean aggiungi (Object elemento) {
	    if (elemento != null && curDim < maxDim) {
		   vettore[curDim++] = elemento;
	       return true;
	    } else return false;
	 }

	 public Object leggi (int indice) {
	    if (indice >= 0 && indice < curDim)
		   return (vettore[indice]);
		else return null;
	 }
	 
	 public int dim () { return curDim; }

	 public void ordina () {   //shell-sort
	     int   s, i, j, num;
	     Object temp;
	     num = curDim;
	     for (s = num / 2; s > 0; s /= 2)
	        for (i = s; i < num; i++)
	           for (j = i - s; j >= 0; j -= s)
	             if (confronta (vettore[j], vettore[j + s]) > 0) {
	                 temp = vettore[j];
	                 vettore[j] = vettore[j + s];
	                 vettore[j + s] = temp;
	              }
	  }
	 
 	
	 /**
	  * Compares its two arguments for order. Returns a negative integer, zero, or a positive integer
	  * as the first argument is less than, equal to, or greater than the second.
	  */
	 protected abstract int confronta (Object elemento1, Object elemento2);
	 /* protected modifier: protected members can be accessed from the class itself, 
	  * subclasses of the class and also all classes in the same package of the class
	  */
	 
	 
		// this method sorts and displays the array of Point objects 
		public void visualizza(){
			this.ordina();
			for (int i=0; i<this.dim(); i++) System.out.println(leggi(i));
		}

	}



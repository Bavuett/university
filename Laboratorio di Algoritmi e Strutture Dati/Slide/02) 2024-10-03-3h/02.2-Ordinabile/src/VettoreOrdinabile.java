class VettoreOrdinabile {
	
   private Ordinabile vettore[];
   private int maxDim;  //maximum size
   private int curDim;  //actual size

public VettoreOrdinabile (int maxDim) {
    this.maxDim = maxDim;
	vettore = new Ordinabile[maxDim];
	curDim = 0;
   }

public boolean aggiungi (Ordinabile elemento) {
	if (elemento == null) return false;
	// only elements of the same type are inserted
	if (curDim > 0 && !(elemento.getClass()).equals((vettore[this.curDim-1]).getClass()))
		return false;
	// check the capacity of the array
    if (curDim < maxDim) {
    		vettore[curDim++] = elemento;
    		return true;
    } else return false;
 }

 public Ordinabile leggi (int indice) {
    if (indice >= 0 && indice < curDim)
	   return (vettore[indice]);
	else return null;
 }
 
 public int dim () { return curDim; }

 public void ordina () {   //shell-sort
     int   s, i, j, num;
     Ordinabile temp;
     num = curDim;
     for (s = num / 2; s > 0; s /= 2)
        for (i = s; i < num; i++)
           for (j = i - s; j >= 0; j -= s)
              if (vettore[j].confronta(vettore[j + s]) > 0) {  //NOTICE!
                 temp = vettore[j];
                 vettore[j] = vettore[j + s];
                 vettore[j + s] = temp;
              }
  }
 
 
	// this method sorts and displays the array of Point objects 
	public void visualizza(){
		this.ordina();
		for (int i=0; i<this.dim(); i++) System.out.println(leggi(i));
	}


 
}


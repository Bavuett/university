import java.util.Arrays;

class VettoreOrdinabile<T extends Comparable<? super T>> {
	
   private Comparable<?> vettore[];
   // Notice that we cannot create a generic array of Comparable<T> (row 11)
   
   private int maxDim;  //dimensione massima
   private int curDim;  //dimensione effettiva

public VettoreOrdinabile (int maxDim) {
    this.maxDim = maxDim;
	vettore = new Comparable<?>[maxDim];
	curDim = 0;
   }

public boolean aggiungi (T elemento) {
    if (elemento != null && curDim < maxDim) {
    		vettore[curDim++] = elemento;
    		return true;
    } else return false;
 }

 public T leggi (int indice) {
    if (indice >= 0 && indice < curDim)
	   return ((T)vettore[indice]);
	else return null;
 }
 
 public int dim () { return curDim; }

 public void ordina () {   //shell-sort
     int   s, i, j, num;
     T temp;
     num = curDim;
     for (s = num / 2; s > 0; s /= 2)
        for (i = s; i < num; i++)
           for (j = i - s; j >= 0; j -= s)
              if (((T)vettore[j]).compareTo((T)vettore[j + s]) > 0) {  
                 temp = (T)vettore[j];
                 vettore[j] = vettore[j + s];
                 vettore[j + s] = temp;
              }
  }
 
 
	/** il metodo ordina e visualizza l'array di oggetti Ordinabile */
	public void visualizza(){
		this.ordina();
		for (int i=0; i<this.dim(); i++) System.out.println(leggi(i));
	}


 
}


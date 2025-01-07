/**
 * EX1 - PARTE 1
 * Realizzare una classe Auto, i cui esemplari sono caratterizzati da: 
 * modello, targa, anno di immatricolazione e codice fiscale del proprietario.
 * 
 **/

public class Auto implements Comparable<Auto> {
	String 	modello,
			targa,
			cf;
	int	anno;


	public Auto (String t, int a) { //targa e anno di immatricolazione
		modello = "";
		targa = t.toUpperCase();
		cf = "";
		anno = a;
	}

	public Auto (String m, String t, String c, int a) { 
		modello = m;
		targa = t.toUpperCase();
		cf = c.toUpperCase();
		anno = a;
	}

	public String getModello(){ return modello; }
	public String getTarga()  { return targa; }
	public String getCF()	  { return cf; }
	public int    getAnno()   { return anno; }

	public void setModello(String m){ modello = m; }
	public void setTarga(String t)  { targa = t.toUpperCase(); }
	public void setCF(String c)	{ cf = c; }
	public void setAnno(int a)   	{ anno = a; }

	@Override
   	public int compareTo( Auto x ) {
   		//ordine crescente rispetto alla targa dell’autoveicolo
   		return targa.compareTo(x.targa);  
   	}

	@Override
   	public String toString( ) {
        return 	"\nModello: " + modello +
		"\tTarga: " + targa +
		"\tCF: " + cf + 
		"\tAnno: " + anno;
	}

	@Override
	public boolean equals( Object obj ) {
	    if (obj == null || ! (obj instanceof Auto)) return false;
	    Auto x = (Auto) obj;
            return this.targa.equals(x.targa);
   	}

} // end-class

	
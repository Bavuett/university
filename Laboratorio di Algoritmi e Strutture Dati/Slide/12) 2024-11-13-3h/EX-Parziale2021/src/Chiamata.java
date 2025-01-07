import java.util.*;

public class Chiamata implements Comparable <Chiamata>{
	private double minutiDurata; // durata della telefonata in minuti
	private String numTel; // numero di telefono chiamato
	private Date InizioDataOra; // timestamp di inizio chiamata

	public Chiamata (String numTel, Date InizioDataOra, double minutiDurata) {
		this.minutiDurata = minutiDurata;
		this.numTel = numTel;
		this.InizioDataOra = InizioDataOra;
	}
	
	public double getDurata() { return minutiDurata; }
	public String getNumTel() { return numTel; }
	public Date getDataOra() { return InizioDataOra; }

	@Override
	public boolean equals(Object obj) {
		if ((obj==null) || !(obj instanceof Chiamata)) return false;
		Chiamata c2 = (Chiamata)obj;
		return (minutiDurata == c2.minutiDurata && 
				numTel.equals(c2.numTel) &&
				InizioDataOra.equals(c2.InizioDataOra));
	}

	public String toString() {
		return numTel + ", " + InizioDataOra + ", " + minutiDurata;
	}

	public int compareTo(Chiamata c) {
		return InizioDataOra.compareTo(c.InizioDataOra);
	}

} //fine-classe
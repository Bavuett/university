import java.util.*;

public class Archivio 
{
 
List<Automobile> archivio = new ArrayList<Automobile>(); 

public void insert(String nuovaTarga, Cliente nuovoCliente) {
	for (Automobile auto: archivio) {
		if (auto.getTarga().equals(nuovaTarga)) {
			auto.setCliente(nuovoCliente);
			return;
		}
	}
	archivio.add(new Automobile (nuovaTarga, nuovoCliente));
}


public void insert2(String nuovaTarga, Cliente nuovoCliente) {
	Automobile altra_auto =  new Automobile (nuovaTarga, nuovoCliente); 
	int pos = archivio.indexOf(altra_auto);
	if (pos == -1) 	archivio.add(altra_auto);
	else archivio.get(pos).setCliente(nuovoCliente);
}


public boolean delete (String targa) {
	return archivio.remove(new Automobile(targa));
}


public Archivio archivio_byCitta(String citta) {
	Archivio nuovo  = new Archivio();
	for (Automobile a: archivio)
		if (a.getCliente()!=null && (a.getCliente().getCitta()).equals(citta.toUpperCase()) )
			nuovo.insert(a.getTarga(), a.getCliente());
	return nuovo;
}  


public String toString()
{   String s = "";
	  for (Automobile a: archivio) {
		  s += a.toString() + ";\n";
	  }
	  return s;
} // method toString

 
public void sort_byTarga() {
	Collections.sort(archivio);
}

public void sort_byCF() {
	Collections.sort(archivio, new Cmp_byCF());
}


  
} // end-class 


class Cmp_byCF implements Comparator<Automobile>{
  public int compare(Automobile a1, Automobile a2) {
	  if (a1.getCliente() == null) return +1; // priorità minore ad automobili prive di proprietario
	  if (a2.getCliente() == null) return -1;
	  return (a1.getCliente()).compareTo((a2.getCliente()));
  }

}


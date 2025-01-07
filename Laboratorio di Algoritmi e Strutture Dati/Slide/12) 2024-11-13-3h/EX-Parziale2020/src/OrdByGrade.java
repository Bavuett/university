
/** classe alternativa all'implementazione del metodo compareTo interno
  * alla classe Espressione
  *
  */


import java.util.Comparator;
public class  OrdByGrade implements Comparator<Espressione> {

	  public int compare (Espressione e1, Espressione e2) { 
	  
			if (e1.gradoE() < e2.gradoE()) return -1;
			if (e1.gradoE() > e2.gradoE()) return 1;
			return 0;
	  }
		  
}

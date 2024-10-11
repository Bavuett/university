import java.util.Comparator;

// 

public class Ord_decr implements Comparator<Termine> {

	  public int compare (Termine s1, Termine s2) { 
		  //return -s1.compareTo(s2); 
		  //per ordinamento decrescente solo se si ha la certezza che la 
		  //classe T implementa Comparable<T>
		  
			if (s1.getExp() < s2.getExp()) return 1;   
			else if (s1.getExp() > s2.getExp()) return -1;
			// esponenti uguali
			if (s1.getCoeff() < s2.getCoeff()) return 1;
			else if (s1.getCoeff() > s2.getCoeff()) return -1;
			return 0;

	  }
		  
}

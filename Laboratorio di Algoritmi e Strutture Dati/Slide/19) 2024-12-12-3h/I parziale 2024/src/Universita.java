/* I parziale a.a. 2024/2025) */

import java.util.*;
import java.time.LocalDate;

public class Universita {  
	
	private ArrayList<Studente> uni = new ArrayList<Studente>();
	
	// 1)
	
	public boolean insert(String matr, int anno, int cfu) {
		Studente nuovoS = new Studente(matr, anno, cfu);
		if (! uni.contains(nuovoS)) {
			uni.add(nuovoS);
			return true;
		} else return false;
	}
	
	// 2)
	
	public boolean remove(String matr) {
		Iterator<Studente> itr = uni.iterator();
		while (itr.hasNext()) 
			if (itr.next().getMatr().equals(matr)) {
				itr.remove();
				return true;
			}
		return false;
	}
		

	public boolean remove2(String matr) {
		return uni.remove(new Studente(matr));
	}
	
	// 3)
	
	public boolean contains(String matr) {
		for(Studente stud: uni) if (stud.getMatr().equals(matr)) return true;
		return false;
	}
	
	public boolean contains2(String matr) {
		return uni.contains(new Studente(matr));	
	}
	

	/* 4 A) calcolare il numero medio di cfu conseguiti dagli studenti che si
	 * sono immatricolati in un dato anno;
	 */
	
	public double media_cfu(int anno) {
		int tot_cfu=0, n=0;
		for(Studente stud: uni)
			if (stud.getAnno()==anno) {
				tot_cfu+=stud.getCfu();
				n++;
			}
		return tot_cfu/n;
	}
	
	/* 4 B) calcolare il numero massimo di cfu conseguiti tra tutti gli studenti
	 * che si sono immatricolati in un dato anno;
	 */
	
	public int max_cfu(int anno) {
		int max_cfu=0;
		for(Studente stud: uni)
			if (stud.getAnno()==anno)
				if (stud.getCfu() > max_cfu) max_cfu= stud.getCfu(); 
		return max_cfu;
	}
	
	/* 5 A) ordinare la lista corrente in ordine crescente di anno d’immatricolazione, 
	 * e in subordine di matricola;
	 */
	
	public void sortByYear() {
		Collections.sort(uni, new Comparator<Studente>() {
			public int compare(Studente s1, Studente s2) {
				int diff = s1.getAnno() - s2.getAnno();
				if (diff == 0) return s1.compareTo(s2);
				else return diff;
			}// end-compare
		});
	}//end-method
	
	/* 5 B) ordinare la lista corrente in ordine decrescente di anno d’immatricolazione, 
	 * e in subordine in ordine crescente di matricola;
	 */
	
	public void sortByYearDecr() {
		Collections.sort(uni, new Comparator<Studente>() {
			public int compare(Studente s1, Studente s2) {
				int diff = s2.getAnno() - s1.getAnno();
				if (diff == 0) return s1.compareTo(s2);
				else return diff;
			}// end-compare
		});
	}//end-method


	/* 6 A) restituire una nuova lista contenente gli studenti immatricolati
	 * nell’anno corrente, in ordine crescente di matricola;
	 */
	
	public ArrayList<Studente> selectAndSort() {
		ArrayList<Studente> list = new ArrayList<Studente>(); 
		int anno = LocalDate.now().getYear(); //anno=2024;
		for (Studente s: uni)
			if (s.getAnno()==anno) list.add(s);  
		Collections.sort(list);
		return list;
	}
	
	
	/* 6 B) restituire una nuova lista contenente gli studenti che hanno conseguito
	 * un numero di cfu maggiore o uguale ad una certa soglia di cfu data in input,
	 * in ordine crescente di matricola; 
	 */
	
	public ArrayList<Studente> selectAndsort(int minCfu) {
		ArrayList<Studente> list = new ArrayList<Studente>(); 
		for (Studente s: uni)
			if (s.getCfu()>=minCfu) list.add(s);  
		Collections.sort(list);
		return list;
	}
	

	//7) 
	
	public int[] MatrByYears(int inizio, int fine) {
		if (fine < inizio) return null;
		int[] result = new int[fine-inizio+1];
		for(Studente s: uni) {
			int anno = s.getAnno(); 
			if (anno >= inizio && anno <= fine) result[anno-inizio]++;
		}
		return result;
	}
	
	@Override
	public String toString() {
		//return uni.toString();
		String str = new String();
		for (Studente s: uni) {str  += s.toString() + "\n";}
		return str;
	}
	
	/* Esercizio 2.A  Realizzare un metodo statico che prende in input una lista di
	 * stringhe lunghe al più 20 caratteri e calcola la lunghezza che occorre
	 * più frequentemente.
	 */
	
	public static int ex2A(List<String> list) {
		int[] count = new int[21];
		int max_occ=0, len = 0;
		for (String s: list) if (s!=null && s.length()<=20) count[s.length()]++;
		for (int l=0; l<=20; l++)
			if (count[l]>max_occ) {max_occ=count[l]; len=l;}
		return len;
	}
	
	/* Esercizio 2.B Realizzare un metodo statico che prende in input una lista di
	 * stringhe lunghe al più 25 caratteri e calcola la lunghezza che occorre
	 * meno frequentemente.  
	 */
	
	public static int ex2B(List<String> list) {
		int[] count = new int[26];
		int min_occ=list.size(); //Integer.MAX_VALUE;
		int len = 0;
		for (String s: list) if (s!=null && s.length()<=20) count[s.length()]++;
		for (int l=0; l<=20; l++)
			if (count[l]<min_occ) {min_occ=count[l]; len=l;}
		return len;
	}
	
}

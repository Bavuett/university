import java.util.*;

public class ex2 {
	
	public static ArrayList <String> diffSimmetrica (ArrayList<String> lista1, ArrayList<String> lista2) {
		ArrayList <String> diffSimm = new ArrayList <String>();
		if (lista1.isEmpty()) {diffSimm.addAll(lista2); return diffSimm;}
		if (lista2.isEmpty()) {diffSimm.addAll(lista1); return diffSimm;}
		diffSimm.addAll(lista1);
		diffSimm.addAll(lista2);
		Collections.sort(diffSimm);
		for (int i=0; i<diffSimm.size()-1; i++) {
			if (diffSimm.get(i).equals(diffSimm.get(i+1))) {
				diffSimm.remove(i+1);
				diffSimm.remove(i);
				i--;
			}
		}
		return diffSimm;	
	}
	
	public static <T extends Comparable<? super T>> ArrayList <T> diffSimmetricaGen (ArrayList<T> lista1, ArrayList<T> lista2) {
		ArrayList <T> diffSimm = new ArrayList <T>();
		if (lista1.isEmpty()) {diffSimm.addAll(lista2); return diffSimm;}
		if (lista2.isEmpty()) {diffSimm.addAll(lista1); return diffSimm;}
		diffSimm.addAll(lista1);
		diffSimm.addAll(lista2);
		Collections.sort(diffSimm);
		for (int i=0; i<diffSimm.size()-1; i++) {
			if (diffSimm.get(i).equals(diffSimm.get(i+1))) {
				diffSimm.remove(i+1);
				diffSimm.remove(i);
				i--;
			}
		}
		return diffSimm;	
	}
	
	public static <T> ArrayList<T> diffSimmetricaGen2 (ArrayList<T> lista1, ArrayList<T> lista2, Comparator<T> c) {
		ArrayList <T> diffSimm = new ArrayList <T>();
		if (lista1.isEmpty()) {diffSimm.addAll(lista2); return diffSimm;}
		if (lista2.isEmpty()) {diffSimm.addAll(lista1); return diffSimm;}
		diffSimm.addAll(lista1);
		diffSimm.addAll(lista2);
		Collections.sort(diffSimm, c);
		for (int i=0; i<diffSimm.size()-1; i++) {
			if (diffSimm.get(i).equals(diffSimm.get(i+1))) {
				diffSimm.remove(i+1);
				diffSimm.remove(i);
				i--;
			}
		}
		return diffSimm;	
	}
	

	
	public static void main(String[] args) {
		// ver 1
		ArrayList<String> L1 = new ArrayList<String>(); 
		L1.add("Asia"); L1.add("Luca"); L1.add("Maria"); L1.add("Giacomo");

		ArrayList<String> L2 = new ArrayList<String>(); 
		L2.add("Piero"); L2.add("Luca"); L2.add("Asia"); L2.add("Giacomo");
	
		ArrayList<String> DS = diffSimmetrica(L1,L2);

		System.out.println(L1);
		System.out.println(L2);
		System.out.println(DS);
	
	}//end.main

}

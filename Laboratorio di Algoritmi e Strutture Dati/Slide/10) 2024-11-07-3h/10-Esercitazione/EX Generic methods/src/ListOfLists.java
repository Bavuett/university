/* Esercitazione sulle liste
 * - creazione di oggetti di tipo Arraylist<String>
 * - creazione di oggetti di tipo ArrayList<Arraylist<String>> 
 * - ordinamento */ 

import java.util.*;

public class ListOfLists {

public static void main(String[] args) {
	/* Usare tre volte la classe Arraylist:
	 * 1) creare un oggetto team1 di tipo ArrayList con elementi di tipo String 
	 * 	 e aggiungere tre elementi */

	ArrayList <String> team1 = new ArrayList<String>();	
	team1.add("player2");
	team1.add("player1");
	team1.add("player3");
	System.out.println("Team 1:" + team1);
		
	/* 2) creare un oggetto team2 di tipo ArrayList con elementi di tipo String 
	 * 	 e aggiungere quattro elementi */

	ArrayList <String> team2 = new ArrayList<String>();	
	team2.add("player6");
	team2.add("player5");
	team2.add("player4");
	team2.add("player7");
	System.out.println("Team 2:" + team2);
	
	
	/* 3) creare un oggetto league di tipo ArrayList, i cui elementi siano 
	 * oggetti di tipo Arraylist a loro volta con elementi di tipo String.
	 * Aggiungere team1, team2, ...,  a league */
	
	ArrayList<ArrayList<String>> league = new ArrayList<ArrayList<String>>();
	league.add(team1);
	league.add(team2);
	System.out.println("League:" + league);
	
	/* 4) ordina le liste team1 e team2 in ordine lessicografico crescente e decrescente, rispettivamente */
	
	Collections.sort(team1);
	Collections.sort(team2, Collections.reverseOrder());  //Focus on this!!!
	System.out.println("Team 1 ordinato:" + team1);
	System.out.println("Team 2 ordinato (reverse order):" + team2);
	
	/* 5) creare un oggetto team3 di tipo ArrayList con elementi di tipo String 
	 * 	 e aggiungere due elementi. Aggiungere team3 a league */  
	
	ArrayList <String> team3 = new ArrayList<String>();	
	team3.add("player2");
	team3.add("player8");
	league.add(team3);
	
	/* 6) ordina la lista league in ordine crescente rispetto alle lunghezze dei
	 * suoi elementi (liste con elementi di tipo String ) */  


	//Collections.sort(league, new ListComparator_bySize());
	Collections.sort(league, new Comparator<ArrayList<String>>() {
		public int compare(ArrayList<String> firstList, ArrayList<String> secondList) {
		return firstList.size()-secondList.size();
		}});

	System.out.println("League ordinata:" + league);
	
	} //end-main

} //end-class testItr


class ListComparator_bySize implements Comparator<ArrayList<String>> {
	@Override
	public int compare(ArrayList<String> firstList, ArrayList<String> secondList) {
	return firstList.size()-secondList.size();
	}
	} //end class ListComparator_bySize




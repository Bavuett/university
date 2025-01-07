
public class test {

	public static void main(String[] args) {
		Libreria l = new Libreria();
	
		l.insert("1111111", 2022);
		l.insert("3333333", 1987);
		l.insert("0000111", 2022);
		l.insert("2222222", 2001);
		
		System.out.println(l);
		
		l.sort();
		System.out.println("\nOrdinamento naturale:\n" + l);
		
		l.sortByYear();
		System.out.println("\nOrdinamento decrescente per anno:\n" + l);
		
		System.out.println("\nNumero di libri per anno:\n");
		int[] occorrenze = l.occurrencesPerYears(2000, 2023);
		for (int i=0; i<occorrenze.length; i++) {
			System.out.println("anno " + (2000+i) + ": " + occorrenze[i]);
		}
		
		/***********************************/
		
		//Integer[] array = {5,6,6,6,7,8,8,10,10,12};
		Integer[] array = {5,5};

		int n = Esercizio2.<Integer>NumUnivoci2(array);
		System.out.println("\nNumeri univoci: " + n);
		
		
	} //end-main

}

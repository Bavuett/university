import java.util.Arrays;

public class Esercizio2 {
	
	public static <T extends Comparable<? super T>> int NumUnivoci1(T[] array){
		Arrays.sort(array);
		int cont = 0;
		if (array.length == 1) return 1;
		if (! array[0].equals(array[1])) cont++;
		for (int i=1; i<array.length-1; i++) 
			//se un elemento è diverso dal precedente e dal successivo...
			if (! array[i].equals(array[i-1]))
				if (!array[i].equals(array[i+1])) cont++;
		if (! array[array.length-1].equals(array[array.length-2])) cont++;
		return cont;
	}
	
	
	public static <T extends Comparable<? super T>> int NumUnivoci2(T[] array){
		Arrays.sort(array);
		int cont = 0, i=0, j;
		while ( i < array.length) {
			// j scorre l'array a partire dalla posizione i fintanto che trova duplicati 
			j=i+1;
			while (j < array.length && array[i].equals(array[j])) j++;
			if (j == i+1) cont++;
			i = j;
		}
		return cont;
	}

} //end-class
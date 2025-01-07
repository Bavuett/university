import java.util.Arrays;
import java.util.LinkedList;

public class GenericMethods {

/**
 * Write a generic static method to find largest element in an array.
 * Then use the method on the Integer type.
 **/

public static <T extends Comparable<? super T>> T findMax( T [ ] a ) {
	int maxIndex = 0;

	for( int i = 1; i < a.length; i++ )
		if( a[i].compareTo( a[maxIndex] ) > 0 ) maxIndex = i;

	return a[ maxIndex ];
}

/**
  * Write a generic static method which accepts an array and returns the
  * smallest item. Then use the method on the String type.
 **/

public static <T extends Comparable<? super T>> T findMin( T [ ] a ) {
	T min = a[0];

	for( int i = 1; i < a.length; i++ )
		if( a[i].compareTo( min ) < 0 ) min = a[i];

	return min;
}


/**
  * Write a generic static method which accepts two arrays and returns a linked list
  * of all elements that are common to both arrays. Then use the method on the Integer type. 
  * The output should be sorted into decreasing order. 
 **/

public static <E extends Comparable<? super E>> LinkedList<E> createIntersectionList( E[ ] a,  E[ ] b) {	
	LinkedList<E> list = new LinkedList<E>();
	int i=0, j=0;
	Arrays.sort(a);
	Arrays.sort(b);
	while (i < a.length && j < b.length) {
		if (a[i].compareTo(b[j]) < 0) i++;
		else if (a[i].compareTo(b[j]) > 0) j++;
			else { // a[i] is equal to b[j]
				if (list.isEmpty() || ! a[i].equals(list.getFirst())) list.addFirst(a[i]); 
				i++; j++; 
			}
	}
	return list;
}

public static void main(String[] args) {

	Integer[] arrayOfInt = {13, 15, 2, 100, 45, 245, 24, 2};
	Integer x = GenericMethods.<Integer>findMax(arrayOfInt);
	System.out.println("Max: " + x + "\n");
	
	String[] arrayOfString = {"Exam", "Algorithm", "Laboratory", "Class"};
	String s = GenericMethods.<String>findMin(arrayOfString);
	System.out.println("Min: " + s + "\n");
	
	Integer[] a= {4, 15, 1, 10, 15, 12, 3};
	Integer[] b= {2, 25, 1, 12, 11, 15, 3};
	LinkedList<Integer> list = GenericMethods.<Integer>createIntersectionList(a, b);
	for (int i=0; i < a.length; i++) System.out.print(a[i] + " ");
	System.out.println();
	for (int i=0; i < b.length; i++) System.out.print(b[i] + " ");
	System.out.println();
	System.out.println(list);
	
}
	

} //end-class

import java.util.*;

public class Test {
// Definito a scopo dimostrativo, non richiesto ai fini del parziale
	

public static void main (String[]args){

	
// EX 1 metodo interno a Espressione	
Espressione espr1 = new	Espressione();
espr1.insert(new Termine(3,2));
espr1.insert(new Termine(1,4));
espr1.insert(new Termine(2,3));
espr1.print();
System.out.println("\nespr1(2)="+espr1.calcola(2));

//EX 2
//Costruzioni di altre due espressioni
Espressione espr2 = new	Espressione();
espr2.insert(new Termine(3,1));
espr2.insert(new Termine(1,3));
espr2.insert(new Termine(2,5));
Espressione espr3 = new	Espressione();
espr3.insert(new Termine(7,2));
// Inserimento delle 3 espressioni in lista
ArrayList<Espressione> arrayE = new ArrayList<Espressione>();
arrayE.add(espr1); 
arrayE.add(espr2);
arrayE.add(espr3);
//Ordinamento della lista e stampa
Espressione.ordinaE(arrayE);
System.out.print("\nStampa espressioni in ArrayList (ordinate per grado):");
for (Espressione e: arrayE) {
	System.out.println();
	e.print();
}
System.out.println();
System.out.println();	

// EX 4 a)  MinoriDi
Integer[] array = {1,2,6,5,4,7,0,9,4};
for (Integer x: array) 
 System.out.print(x + " ");

int x=5;
System.out.println("Lista di oggetti interi minori di " + x);
System.out.println(EX_4_5.<Integer>minoriDi(array, x));
System.out.println();


//EX 5 a)  Union
LinkedList<Integer> L1 = new LinkedList<Integer>();
LinkedList<Integer> L2 = new LinkedList<Integer>();
L1.add(10);
L1.add(88);
L1.add(21);
L1.add(8);
System.out.println("L1: " + L1);
L2.add(1);
L2.add(8);
L2.add(20);
L2.add(21);
System.out.println("L2: " + L2);

//EX1.union(L1, L2, new Comp());
System.out.println("Unione di L1 e L2:");
LinkedList<Integer> Lunion; 
Lunion = EX_4_5.union(L1, L2);
System.out.println(Lunion);

EX_4_5.<Integer>union(L1, L2, new IntComp());
System.out.println(L1);

}

}

class IntComp implements Comparator<Integer> 
{
 /**
  *  Compares two specified Integer objects. 
  *
  *  @param i1 � one of the Integer objects to be compared.
  *  @param i2 � the other Integer object.
  *
  *  @return the value of i1�s int � the value of i2�s int.
  *
  */
     public int compare (Integer i1, Integer i2) {
          return i1-i2;
     } // method compare

} 


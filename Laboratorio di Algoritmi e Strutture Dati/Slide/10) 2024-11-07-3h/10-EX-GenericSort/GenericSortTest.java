import java.util.*;  // for the Comparator interface


public class GenericSortTest
{
    public static void main(String[] args)
    {
        new GenericSortTest().run();
    } // method main

    public void run()
    {
        String[ ] words = {"Jayden", "Jack", "Jack", "Rowan", "Brooke"};
        String[ ] copywords = words.clone();
	
        for (String s : words)
            System.out.print (s + "  ");
  
	System.out.print("\n\nOrdinamento naturale con insertionSort:\n");
        GenericSort.insertionSort (words);
        for (String s : words)
            System.out.print (s + "  ");

	System.out.print("\n\nOrdinamento per lunghezza con selectionSort:\n");
        GenericSort.selectionSort (words, new ByLength());
        for (String s : words)
            System.out.print (s + "  ");

	System.out.print("\n\nOrdinamento naturale con quickSort:\n");
        GenericSort.quickSort (copywords);
        for (String s : copywords)
            System.out.print (s + "  ");

	System.out.print("\n\n");

	/********* TEST SU ARRAY DI INTERI ************/

      final int L = 20, MAXINT = 100;
      Integer[ ] numbers = new Integer[L]; 

      Random r = new Random ();
      for (int i = 0; i < L; i++) numbers[i]=r.nextInt(MAXINT);

      Integer[ ] copy1 = numbers.clone();
      Integer[ ] copy2 = numbers.clone();

      // print array to be sorted
      System.out.println("Array to be sorted:");
      for (Integer s : numbers)
            System.out.print (s + " ");
  
	System.out.print("\n\nOrdinamento crescente con insertionSort:\n");
        GenericSort.insertionSort (numbers);
        for (Integer s : numbers)
            System.out.print (s + " ");

	System.out.print("\n\nOrdinamento decrescente con selectionSort:\n");
        GenericSort.selectionSort (numbers, new Decreasing());
        for (Integer s : numbers)
            System.out.print (s + " ");

	System.out.print("\n\nOrdinamento crescente con mergeSort:\n");
        GenericSort.mergeSort (copy1);
        for (Integer s : copy1)
            System.out.print (s + " ");

	System.out.print("\n\nOrdinamento crescente con quickSort:\n");
        GenericSort.quickSort (copy2);
        for (Integer s : copy2)
            System.out.print (s + " ");
 

   } // method run

} // class GenericSortExample



class ByLength implements Comparator<String> 
{

  /** 
   *  Compares two specified String objects lexicographically if they have the 
   *  same length, and otherwise returns the difference in their lengths.
   *
   *  @param s1 – one of the specified String objects.
   *  @param s2 – the other specified String object.
   *
   *  @return s1.compareTo (s2) if s1 and s2 have the same length; 
   *                otherwise, return s1.length() – s2.length(). 
   *
   *  @throws NullPointerException - if s1 and/or s2 is null.
   * 
   */ 

  public int compare (String s1, String s2) 
  {
      int len1 = s1.length(),
          len2 = s2.length();
      if (len1 == len2)
          return s1.compareTo (s2);
          
      return len1 - len2;
  } // method compare

} // class ByLength



class Decreasing implements Comparator<Integer> 
 {
  /**
   *  Compares two specified Integer objects. 
   *
   *  @param i1 – one of the Integer objects to be compared.
   *  @param i2 – the other Integer object.
   *
   *  @return the value of i2’s int – the value of i1’s int.
   *
   */
      public int compare (Integer i1, Integer i2) 
  {
           return i2.compareTo (i1);
      } // method compare

 } // class Decreasing
/* EX:
Declare an array whose elements come from the same Student class.
Each student has a name and grade point average. 
Sort the students in alphabetical order.
Next, sort the students in decreasing order of GPAs.
*/

import java.util.*;  


public class ArraySortExample
{
    public static void main(String[] args)
    {
        new ArraySortExample().run();
    } // method main

    public void run() {
    	Student s1 = new Student ("Jones", "Black", 3.17),
	    s2 = new Student ("Smith", "Red", 3.82), 
	    s3 = new Student ("Jones", "Black", 3.4),
	    s4 =  new Student ("Emily", "Black", 3.4),
	    s5 = new Student ("Anne", "Orange", 3.17);
        Student[ ] array = {s1,s2,s3,s4,s5};

        for (Student s : array)
            System.out.print (s + "; ");
  
	System.out.print("\n\nOrdinamento naturale:\n");
        Arrays.sort (array);
        for (Student s : array)
            System.out.print (s + "; ");

	System.out.print("\n\nOrdinamento per voto medio non crescente:\n");
        Arrays.sort (array, new Student_byGrade());
        for (Student s : array)
            System.out.print (s + "; ");
	System.out.print("\n\n"); 


   } // method run

} // class ArraySortExample
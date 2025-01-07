/* EX:
Declare a LinkedList (ArrayList) object, list, whose elements come
from the same Student class.
Each student has a name and grade point average. 
Sort the students in alphabetical order.
Next, sort the students in decreasing order of GPAs.
*/

import java.util.*;  


public class ListSortExample
{
    public static void main(String[] args)
    {
        new ListSortExample().run();
    } // method main

    public void run() {  	
    	Student s1 = new Student ("Jones", "Black", 3.17),
	    s2 = new Student ("Smith", "Red", 3.82), 
	    s3 = new Student ("Jones", "Black", 3.4),
	    s4 =  new Student ("Emily", "Black", 3.4),
	    s5 = new Student ("Anne", "Orange", 3.17);
    	
    	
    List<Student> list = new LinkedList<Student>();
	list.add(s1);
	list.add(s2);
	list.add(s3);	
	list.add(s4);
	list.add(s5);

	//System.out.println(list);
        for (Student s : list)
            System.out.print (s + "; ");
  
	System.out.print("\n\nOrdinamento naturale:\n");
        Collections.sort (list);
        for (Student s : list)
            System.out.print (s + "; ");

	System.out.print("\n\nOrdinamento per voto medio non crescente:\n");
    Collections.sort (list, new Student_byGrade());
	//list.sort(new Student_byGrade());
        
        /*list.forEach(s -> System.out.print(s + "; "));
		System.out.print("\n\n"); */
        System.out.println(list);


   } // method run

} // class ListSortExample

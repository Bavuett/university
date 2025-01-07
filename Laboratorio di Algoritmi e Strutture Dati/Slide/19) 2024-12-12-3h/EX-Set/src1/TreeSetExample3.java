import java.util.*;

public class TreeSetExample3
{
  public static void main (String[ ] args)
  {
    new TreeSetExample3().run();
  } // method main
 
  public void run()
  {

    // Red-black Tree of Student    
    TreeSet<Student> tree1 = new TreeSet<Student>();
    TreeSet<Student> tree2 = new TreeSet<Student>(new Student_byGrade());
    
    Student s1 = new Student ("Jones", 3.17),
    		s2 = new Student ("Smith", 3.82), 
    		s3 = new Student ("Jones", 3.4);	
    
    tree1.add (s1);  
    tree1.add (s2);
    tree1.add (s3); 
    
    tree2.addAll(tree1);
    tree2.add (new Student ("Anne", 3.4)); 
    
    System.out.println ("\ntree1: " + tree1); 
    System.out.println ("The number of elements in tree1 is " + tree1.size());
    System.out.println ("\ntree2: " + tree2);                
    System.out.println ("The number of elements in tree2 is " + tree2.size());
  } // method run
  
} // class TreeSetExample


class Student_byGrade implements Comparator<Student> {

	 /**
	   * Compares the Student object s1 with the Student object s2.
	   * The comparison is by grade point averages; for two objects with the same gpa,
	   * the comparison is alphabetical.
	   */
	  public int compare (Student s1, Student s2) {  
	    final double DELTA = 0.0000001;
	    if (s1.gpa - s2.gpa > DELTA) return -1;
	    if (s2.gpa - s1.gpa > DELTA) return 1;
	    if ((s1.name).compareTo (s2.name) < 0) return -1;
	    if ((s1.name).compareTo (s2.name) > 0) return 1;
	    return 0;	
	  } // method compare

	// No need to override equals.

	}  //class Student_byGrade
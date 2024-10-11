import java.util.Comparator;

class Student_byGrade implements Comparator<Student> {

 /**
   * Compares the Student object s1 with the Student object s2.
   * The comparison is by grade point averages;
   * for two objects with the same gpa,
   * the comparison is alphabetical.
   */
  public int compare (Student s1, Student s2) {  
    final double DELTA = 0.0000001;
    if (s1.gpa - s2.gpa > DELTA) return -1;
    if (s2.gpa - s1.gpa > DELTA) return 1;
    if ((s1.surname).compareTo (s2.surname) < 0) return -1;
    if ((s1.surname).compareTo (s2.surname) > 0) return 1;
    if ((s1.name).compareTo (s2.name) < 0) return -1;
    if ((s1.name).compareTo (s2.name) > 0) return 1;
    return 0;	
  } // method compare

// No need to override equals.

}  //class Student_byGrade

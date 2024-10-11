class Student implements Comparable<Student>
{
  String name;
  String surname;
  double gpa; //grade point average
  
  public Student() { }
  
  /**
   * Initializes this Student object from a specified name and gpa.
   *
   * @param name – the specified name.
   * @param surname – the specified surname.
   * @param gpa – the specified gpa.
   *
   */
  public Student (String name, String surname, double gpa) {
    this.name = name;
    this.surname = surname;
    this.gpa = gpa;
  } // constructor
  
  /**
   * @return this Student object’s name
   * 
   */
  public String getName() {
	    return name;
	  }
  
  /**
   * @return this Student object’s surname
   * 
   */
  public String getSurname() {
	    return surname;
	  }
  
  /**
   * @return this Student object’s gpa
   * 
   */
  public double getGpa() {
	    return gpa;
	  }
  
  
  
  /**
   * Compares this Student object with a specified Student object.
   * The comparison is alphabetical; for two objects with the same name,
   * the comparison is by grade point averages.
   *
   * @param otherStudent – the specified Student object that this Student
   * object is being compared to.
   *
   * @return -1, if this Student object’s name is alphabetically less than
   *             otherStudent’s name, or if the names are equal and this
   *             Student object’s grade point average is 
   *             greater than otherStudent's grade point average;
   *          0, if this Student object’s name is the same as
   *             otherStudent’s name and the grade point
   *             averages are the same;
   *          1, if this Student object’s name is alphabetically greater
   *             than otherStudent’s name, or if the names are equal and
   *             otherStudent's grade point average is at least DELTA
   *             greater than this Student object’s grade point average.
   *
   */
  public int compareTo (Student otherStudent) {
    final double DELTA = 0.0000001;
    if (surname.compareTo (otherStudent.surname) < 0) return -1;
    if (surname.compareTo (otherStudent.surname) > 0) return 1;
    if (name.compareTo (otherStudent.name) < 0) return -1;
    if (name.compareTo (otherStudent.name) > 0) return 1;  
    if (gpa - otherStudent.gpa > DELTA) return -1;
    if (otherStudent.gpa - gpa > DELTA) return 1;
    return 0;
  } // method compareTo
 

  /**
   * Determines if this Student object’s name and grade point average are
   * the same as some specified object's.
   *
   * @param obj – the specified object that this Student object is being
   * compared to.
   *
   * @return true – if obj is a Student object and this Student object has the
   * same name and almost (that is, within DELTA) the same grade point average as obj.
   *
   */
  public boolean equals (Object obj)
  {
    if (obj == null || ! (obj instanceof Student))
      return false;   
    return this.compareTo ((Student)obj) == 0;    
  } // method equals

  
  /**
   * Returns a String representation of this Student object.
   *
   * @return a String representation of this Student object: name, blank,
   *         grade point average.
   *
   */
  public String toString()
  {
    return surname + " " + name + " " + gpa;
  } // method toString
  
  
} // class Student
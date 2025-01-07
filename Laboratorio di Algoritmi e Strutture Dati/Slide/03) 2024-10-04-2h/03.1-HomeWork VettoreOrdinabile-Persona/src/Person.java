class Person {
	
  String name;
  String surname;
  int age; 
  
  //public Person() { }
  
   public Person (String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
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
  public int getAge() {
	    return age;
	  }
  
  public boolean equals (Object obj)
  {
    if (obj == null || ! (obj instanceof Person))
      return false;
    Person p = (Person)obj;
    return name.equals(p.name) && surname.equals(p.surname) && age==p.age;
  } // method equals


  public String toString()
  {
    return surname + " " + name + ", " + age;
  } // method toString
    
} // class Person
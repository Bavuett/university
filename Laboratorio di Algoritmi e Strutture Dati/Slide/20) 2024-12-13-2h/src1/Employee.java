/* EX2
Suppose we are given the name and division number for each employee in a company.
There are no duplicate names. We would like to store this information 
by increasing division numbers, and within each division number, by alphabetical order of names. 
How should this be done? 
TreeMap? TreeSet? Comparable? Comparator? 
*/

import java.util.*;

public class Employee implements Comparable<Employee>  {
	
  protected String name;  //key
  protected int division;

  public Employee() { }

  public Employee (String name, Integer division)  {
    	this.name = name;
    	this.division = division;
  } // 2-parameter constructor

  public int compareTo (Employee otherEmployee)  {
    if (division != otherEmployee.division)  return division - otherEmployee.division;  
    else return name.compareTo (otherEmployee.name);   
  } // method compareTo

  public String toString()  {
    	return name + " " + division;
  } // method toString
  
  //Homework: completare la classe Employee
  
  
  public static void main(String[ ] args) {
	  
	  TreeSet<Employee> company = new TreeSet<Employee>();
	  company.add (new Employee("Misino John", 8));
	  company.add (new Employee("Nguyen Viet", 14));
	  company.add (new Employee("Panchenko Eric", 6));
	  company.add (new Employee("Dunn Michael", 6));
	  company.add (new Employee("Deusenbery Amanda", 14));
	  company.add (new Employee("Taoubina Xenia", 6));
	  
	  System.out.println ("\nCompany:\n" + company);
  
  }
  
} // class Employee

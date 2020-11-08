/** import LinkedList Collection data structure */
import java.util.LinkedList;
/** import to use sort method */
import java.util.Collections;

/**
  * Faculty is an abstract class that can be extended to various types of faculty
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public abstract class Faculty extends Affiliates {

  // Fields
  /** represents a faculty's id */
  protected int m_facultyId;
  /** represents an faculty member's department */
  protected String m_department;
  /** represents an faculty member's yearly salary */
  protected double m_yearlySalary;
  /** represents the number of papers a faculty member has */
  protected int m_numberOfPapers;

  /**
    * Default Constructor - it assigns some default values to the faculty's fields
  */
  public Faculty(){
    super();
    m_facultyId = -1;
    m_department = "Mathematics";
    m_yearlySalary = -100.00;
    m_numberOfPapers = -1;
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the faculty's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
    * @param facultyId assigned to the m_facultyId field of the faculty member
    * @param department assigned to the m_deparment field of the faculty member
    * @param yearlySalary assigned to the m_yearlySalary field of the faculty member
    * @param numberOfPapers assigned to the m_numberOfPapers field of the faculty member
  */
  public Faculty(String name, int age, String address, String phoneNumber, int yearBegan, int facultyId, String department, double yearlySalary, int numberOfPapers){
    super(name, age, address, phoneNumber, yearBegan);
    m_facultyId = facultyId;
    m_department = department;
    m_yearlySalary = yearlySalary;
    m_numberOfPapers = numberOfPapers;
  }

  /**
    * Copy Constructor - it creates a copy of Faculty instance
    * @param c - the Faculty instance that is being copied
  */
  public Faculty(Faculty c){
    super(c);
    m_facultyId = c.m_facultyId;
    m_department = c.m_department;
    m_yearlySalary = c.m_yearlySalary;
    m_numberOfPapers = c.m_numberOfPapers;
  }

  // Accessors
  /**
    * This is an accessor method that is abstract.
    * @return returns the type of Faculty
  */
  public abstract String getClassType();
  /**
    * This is an accessor method
    * @return returns the Faculty's id field
  */
  public int getId(){
    return m_facultyId;
  }
  /**
    * This is an accessor method
    * @return returns the Faculty's age field
  */
  public String getDepartment(){
    return m_department;
  }
  /**
    * This is an accessor method
    * @return returns the Faculty's address field
  */
  public double getSalary(){
    return m_yearlySalary;
  }
  /**
    * This is an accessor method
    * @return returns the Faculty's number of papers
  */
  public int getNumberOfPapers(){
    return m_numberOfPapers;
  }

  // Mutators
  /**
    * This is a mutator method
    * @param facultyId is set equal to m_facultyId
  */
  public void setFacultyId(int facultyId){
    m_facultyId = facultyId;
  }
  /**
    * This is a mutator method
    * @param department is set equal to m_department
  */
  public void setDepartment(String department){
    m_department = department;
  }
  /**
    * This is a mutator method
    * @param yearlySalary is set equal to m_yearlySalary
  */
  public void setYearlySalary(double yearlySalary){
    m_yearlySalary = yearlySalary;
  }
  /**
    * This is a mutator method
    * @param numberOfPapers is set equal to m_numberOfPapers
  */
  public void setNumberOfPapers(int numberOfPapers){
    m_numberOfPapers = numberOfPapers;
  }

  /**
    * toString - override the default toString Object method
    * @return returns the contents of a Faculty member in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nFaculty ID: " + m_facultyId;
    ret += "\nDepartment: " + m_department;
    ret += "\nYearly Salary: " + m_yearlySalary;
    ret += "\nNumber of Papers: " + m_numberOfPapers;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return returns true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object f){
    if(!(f instanceof Faculty)){
      return false;
    }
    Faculty c = (Faculty)f;
    if(m_facultyId != c.m_facultyId || !(m_department.equals(c.m_department)) || m_yearlySalary != c.m_yearlySalary || m_numberOfPapers != c.m_numberOfPapers){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of a faculty
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nFaculty ID: " + m_facultyId;
    ret += "\nDepartment: " + m_department;
    ret += "\nYearly Salary: " + m_yearlySalary;
    ret += "\nNumber of Papers: " + m_numberOfPapers;
    return ret;
  }

  /**
    * orderAlphabetically() is a method that adds the fields with their respected labels into a LinkedList and then alphabetically sorts the LinkedList
    * @return the alphabetically sorted LinkedList of fields with labels that is returned
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Faculty ID: " + m_facultyId);
    stringLL.add("Department: " + m_department);
    stringLL.add("Yearly Salary: " + m_yearlySalary);
    stringLL.add("Number of Papers: " + m_numberOfPapers);
    Collections.sort(stringLL);
    return stringLL;
  }
}

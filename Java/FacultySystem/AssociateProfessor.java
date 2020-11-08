/** import to use sort method */
import java.util.Collections;
/** import LinkedList Collection data structure */
import java.util.LinkedList;
/**
  * AssociateProfessor is a class that represents associate professors
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public class AssociateProfessor extends Faculty {

  // Fields
  /** an int that represents an associate professor's number of tenure years */
  private int m_yearsSinceTenure;

  /**
    * Default Constructor - it assigns some default values to the AssociateProfessor fields
  */
  public AssociateProfessor(){
    super();
    m_yearsSinceTenure= -1;
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the associate professor's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
    * @param facultyId assigned to the m_facultyId field of the faculty member
    * @param department assigned to the m_department field of the faculty member
    * @param yearlySalary assigned to the m_yearlySalary field of the faculty member
    * @param numberOfPapers assigned to the m_numberOfPapers field of the faculty member
    * @param yearsSinceTenure assigned to the m_yearsSinceTenure field of the associate professor member
  */
  public AssociateProfessor(String name, int age, String address, String phoneNumber, int yearBegan, int facultyId, String department, double yearlySalary, int numberOfPapers, int yearsSinceTenure){
    super(name, age, address, phoneNumber, yearBegan, facultyId, department, yearlySalary, numberOfPapers);
    m_yearsSinceTenure = yearsSinceTenure;
  }

  /**
    * Copy Constructor - it creates a copy of AssociateProfessor instance
    * @param c - the AssociateProfessor instance that is being copied
  */
  public AssociateProfessor(AssociateProfessor c){
    super(c);
    m_yearsSinceTenure = c.m_yearsSinceTenure;
  }

  // Accessors
  /**
    * This is an accessor method that overrides the abstract method from Faculty.
    * @return the type of Faculty
  */
  @Override
  public String getClassType(){
    return "Associate Professor";
  };
  /**
    * This is an accessor method
    * @return the Associate Professor's yearsSinceTenure field
  */
  public int getYearsSinceTenure(){
    return m_yearsSinceTenure;
  }
  // Mutators
  /**
    * This is a mutator method
    * @param yearsSinceTenure is set equal to m_yearsSinceTenure
  */
  public void setYearsSinceTenure(int yearsSinceTenure){
    m_yearsSinceTenure = yearsSinceTenure;
  }

  /**
    * toString - override the default toString Object method
    * @return the contents of an Associate Professor in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nYears Since Tenure: " + m_yearsSinceTenure;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object ap){
    if(!(ap instanceof AssociateProfessor)){
      return false;
    }
    AssociateProfessor c = (AssociateProfessor)ap;
    if(m_yearsSinceTenure != c.m_yearsSinceTenure){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of an associate professor
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nYears Since Tenure: " + m_yearsSinceTenure;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Years Since Tenure: " + m_yearsSinceTenure);
    Collections.sort(stringLL);
    return stringLL;
  }
}

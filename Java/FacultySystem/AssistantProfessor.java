/** import to use sort method */
import java.util.Collections;
/** import LinkedList Collection data structure */
import java.util.LinkedList;

/**
  * AssistantProfessor is a class that represents assistant professors
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public class AssistantProfessor extends Faculty {

  // Fields
  /** an int that represents an assistant professor's number of years until tenure */
  private int m_yearsUntilTenure;

  /**
    * Default Constructor - it assigns some default values to the AssistantProfessor fields
  */
  public AssistantProfessor(){
    super();
    m_yearsUntilTenure = -1;
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the assistant professor's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
    * @param facultyId assigned to the m_facultyId field of the faculty member
    * @param department assigned to the m_department field of the faculty member
    * @param yearlySalary assigned to the m_yearlySalary field of the faculty member
    * @param numberOfPapers assigned to the m_numberOfPapers field of the faculty member
    * @param yearsUntilTenure assigned to the m_yearsUntilTenure field of the assistant professor member
  */
  public AssistantProfessor(String name, int age, String address, String phoneNumber, int yearBegan, int facultyId, String department, double yearlySalary, int numberOfPapers, int yearsUntilTenure){
    super(name, age, address, phoneNumber, yearBegan, facultyId, department, yearlySalary, numberOfPapers);
    m_yearsUntilTenure = yearsUntilTenure;
  }

  /**
    * Copy Constructor - it creates a copy of AssistantProfessor instance
    * @param c - the AssistantProfessor instance that is being copied
  */
  public AssistantProfessor(AssistantProfessor c){
    super(c);
    m_yearsUntilTenure = c.m_yearsUntilTenure;
  }

  // Accessors
  /**
    * This is an accessor method that overrides the abstract method from Faculty.
    * @return returns the type of Faculty
  */
  @Override
  public String getClassType(){
    return "Assistant Professor";
  };
  /**
    * This is an accessor method
    * @return returns the AssistantProfessor's yearsUntilTenure field
  */
  public int getYearsUntilTenure(){
    return m_yearsUntilTenure;
  }
  // Mutators
  /**
    * This is a mutator method
    * @param yearsUntilTenure is set equal to m_yearsUntilTenure
  */
  public void setYearsUntilTenure(int yearsUntilTenure){
    m_yearsUntilTenure = yearsUntilTenure;
  }

  /**
    * toString - override the default toString Object method
    * @return returns the contents of an Assistant Professor in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nYears Until Tenure: " + m_yearsUntilTenure;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return returns true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object ap){
    if(!(ap instanceof AssistantProfessor)){
      return false;
    }
    AssistantProfessor c = (AssistantProfessor)ap;
    if(m_yearsUntilTenure != c.m_yearsUntilTenure){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of an assistant professor
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nYears Until Tenure: " + m_yearsUntilTenure;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Years Until Tenure: " + m_yearsUntilTenure);
    Collections.sort(stringLL);
    return stringLL;
  }
}

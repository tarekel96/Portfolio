/** import to use sort method */
import java.util.Collections;
/** import LinkedList Collection data structure */
import java.util.LinkedList;

/**
  * FullProfessor is a class that represents full professors
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public class FullProfessor extends Faculty {

  // Fields
  /** an int that represents a full professor's number of years until retirement */
  private int m_yearsUntilRetirement;

  /**
    * Default Constructor - it assigns some default values to the FullProfessor fields
  */
  public FullProfessor(){
    super();
    m_yearsUntilRetirement= -1;
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the full professor's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
    * @param facultyId assigned to the m_facultyId field of the faculty member
    * @param department assigned to the m_department field of the faculty member
    * @param yearlySalary assigned to the m_yearlySalary field of the faculty member
    * @param numberOfPapers assigned to the m_numberOfPapers field of the faculty member
    * @param yearsUntilRetirement assigned to the m_yearsUntilRetirement field of the full professor member
  */
  public FullProfessor(String name, int age, String address, String phoneNumber, int yearBegan, int facultyId, String department, double yearlySalary, int numberOfPapers, int yearsUntilRetirement){
    super(name, age, address, phoneNumber, yearBegan, facultyId, department, yearlySalary, numberOfPapers);
    m_yearsUntilRetirement = yearsUntilRetirement;
  }

  /**
    * Copy Constructor - it creates a copy of FullProfessor instance
    * @param c - the FullProfessor instance that is being copied
  */
  public FullProfessor(FullProfessor c){
    super(c);
    m_yearsUntilRetirement = c.m_yearsUntilRetirement;
  }

  // Accessors
  /**
    * This is an accessor method that overrides the abstract method from Faculty.
    * @return returns the type of Faculty
  */
  @Override
  public String getClassType(){
    return "Full Professor";
  };
  /**
    * This is an accessor method
    * @return the Full Professor's yearsUntilRetirement field
  */
  public int getYearsUntilRetirement(){
    return m_yearsUntilRetirement;
  }
  // Mutators
  /**
    * This is a mutator method
    * @param yearsUntilRetirement is set equal to m_yearsUntilRetirement
  */
  public void setYearsUntilRetirement(int yearsUntilRetirement){
    m_yearsUntilRetirement = yearsUntilRetirement;
  }

  /**
    * toString - override the default toString Object method
    * @return the contents of a Full Professor in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nYears Until Retirement: " + m_yearsUntilRetirement;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object fp){
    if(!(fp instanceof FullProfessor)){
      return false;
    }
    FullProfessor c = (FullProfessor)fp;
    if(m_yearsUntilRetirement != c.m_yearsUntilRetirement){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of a full professor
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nYears Until Retirement: " + m_yearsUntilRetirement;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return returns the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Years Until Retirement: " + m_yearsUntilRetirement);
    Collections.sort(stringLL);
    return stringLL;
  }
}

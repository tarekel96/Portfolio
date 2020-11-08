/** import to use sort method */
import java.util.Collections;
/** import LinkedList Collection data structure */
import java.util.LinkedList;

/**
  * FullTimeStaff is a class that represents full time staff members
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public class FullTimeStaff extends Staff  {

  // Fields
  /** a double that represents the full time staff member's yearly salary */
  private double m_yearlySalary;

  /**
    * Default Constructor - it assigns some default values to the staff's fields
  */
  public FullTimeStaff(){
    super();
    m_yearlySalary = -100;
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the staff's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
    * @param staffId assigned to the m_staffId field of the staff member
    * @param title assigned to the m_title field of the staff member's title
    * @param building assigned to the m_building field of the staff member
    * @param yearlySalary assigned to the m_yearlySalary field of the full time staff member
  */
  public FullTimeStaff(String name, int age, String address, String phoneNumber, int yearBegan, int staffId, String title, String building, double yearlySalary){
    super(name, age, address, phoneNumber, yearBegan, staffId, title, building);
    m_yearlySalary = yearlySalary;
  }

  /**
    * Copy Constructor - it creates a copy of FullTimeStaff instance
    * @param c - the FullTimeStaff instance that is being copied
  */
  public FullTimeStaff(FullTimeStaff c){
    super(c);
    m_yearlySalary = c.m_yearlySalary;
  }

  // Accessors
  /**
    * This is an accessor method that overrides the abstract method from Staff.
    * @return the type of Staff member
  */
  @Override
  public String getClassType(){
    return "Full Time Staff";
  };
  /**
    * This is an accessor method
    * @return the FullTimeStaff member's yearlySalary field
  */
  public double getYearlySalary(){
    return m_yearlySalary;
  }

  // Mutators
  /**
    * This is a mutator method
    * @param yearlySalary is set equal to m_yearlySalary
  */
  public void setYearlySalary(double yearlySalary){
    m_yearlySalary = yearlySalary;
  }

  /**
    * toString - override the default toString Object method
    * @return the contents of a FullTimeStaff member in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nFull Time Staff Member Yearly Salary: " + m_yearlySalary;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object fts){
    if(!(fts instanceof FullTimeStaff)){
      return false;
    }
    FullTimeStaff c = (FullTimeStaff)fts;
    if(m_yearlySalary != c.m_yearlySalary){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of a full time staff member
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nFull Time Staff Member Yearly Salary: " + m_yearlySalary;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Full Time Staff Member Yearly Salary: " + m_yearlySalary);
    Collections.sort(stringLL);
    return stringLL;
  }
}

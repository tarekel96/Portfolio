/** import to use sort method */
import java.util.Collections;
/** import LinkedList Collection data structure */
import java.util.LinkedList;

/**
  * PartTimeStaff is a class that represents part time staff members
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public class PartTimeStaff extends Staff  {

  // Fields
  /** is a double that represents the part time staff member's yearly salary */
  private double m_hourlySalary;

  /**
    * Default Constructor - it assigns some default values to the part staff's fields
  */
  public PartTimeStaff(){
    super();
    m_hourlySalary = -10;
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
    * @param hourlySalary assigned to the m_hourlySalary field of the part time staff member
  */
  public PartTimeStaff(String name, int age, String address, String phoneNumber, int yearBegan, int staffId, String title, String building, double hourlySalary){
    super(name, age, address, phoneNumber, yearBegan, staffId, title, building);
    m_hourlySalary = hourlySalary;
  }

  /**
    * Copy Constructor - it creates a copy of PartTimeStaff instance
    * @param c - the PartTimeStaff instance that is being copied
  */
  public PartTimeStaff(PartTimeStaff c){
    super(c);
    m_hourlySalary = c.m_hourlySalary;
  }

  // Accessors
  /**
    * This is an accessor method that overrides the abstract method from Staff.
    * @return the type of Staff member
  */
  @Override
  public String getClassType(){
    return "Part Time Staff";
  };
  /**
    * This is an accessor method
    * @return the PartTimeStaff member's hourlySalary field
  */
  public double getHourlySalary(){
    return m_hourlySalary;
  }

  // Mutators
  /**
    * This is a mutator method
    * @param hourlySalary is set equal to m_hourlySalary
  */
  public void setHourlySalary(double hourlySalary){
    m_hourlySalary = hourlySalary;
  }

  /**
    * toString - override the default toString Object method
    * @return the contents of a PartTimeStaff member in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nPart Time Staff Member Hourly Salary: " + m_hourlySalary;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object fts){
    if(!(fts instanceof PartTimeStaff)){
      return false;
    }
    PartTimeStaff c = (PartTimeStaff)fts;
    if(m_hourlySalary != c.m_hourlySalary){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of a part time staff member
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nPart Time Staff Member Hourly Salary: " + m_hourlySalary;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Part Time Staff Member Hourly Salary: " + m_hourlySalary);
    Collections.sort(stringLL);
    return stringLL;
  }
}

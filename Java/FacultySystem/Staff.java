/** import to use sort method */
import java.util.Collections;
/** import LinkedList Collection data structure */
import java.util.LinkedList;

/**
  * Staff is an abstract class that can be extended to various types of staff members
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public abstract class Staff extends Affiliates  {

  // Fields
  /** an int that represents a staff member's id */
  protected int m_staffId;
  /** a String that represents a staff member's title */
  protected String m_title;
  /** a String that represents a staff member's building */
  protected String m_building;

  /**
    * Default Constructor - it assigns some default values to the staff's fields
  */
  public Staff(){
    super();
    m_staffId = -1;
    m_title = "Program Coordinator";
    m_building = "Keck Building of Science and Engineering";
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
  */
  public Staff(String name, int age, String address, String phoneNumber, int yearBegan, int staffId, String title, String building){
    super(name, age, address, phoneNumber, yearBegan);
    m_staffId = staffId;
    m_title = title;
    m_building = building;
  }

  /**
    * Copy Constructor - it creates a copy of Staff instance
    * @param c - the Staff instance that is being copied
  */
  public Staff(Staff c){
    super(c);
    m_staffId = c.m_staffId;
    m_title = c.m_title;
    m_building = c.m_building;
  }

  // Accessors
  /**
    * This is an accessor method that is abstract.
    * @return the type of Staff
  */
  public abstract String getClassType();
  /**
    * This is an accessor method
    * @return the Staff member's id field
  */
  public int getId(){
    return m_staffId;
  }
  /**
    * This is an accessor method
    * @return the Staff member's title
  */
  public String getTitle(){
    return m_title;
  }
  /**
    * This is an accessor method
    * @return the Staff member's building
  */
  public String getBuilding(){
    return m_building;
  }

  // Mutators
  /**
    * This is a mutator method
    * @param staffId is set equal to m_staffId
  */
  public void setStaffId(int staffId){
    m_staffId = staffId;
  }
  /**
    * This is a mutator method
    * @param title is set equal to m_title
  */
  public void setMajor(String title){
    m_title = title;
  }
  /**
    * This is a mutator method
    * @param building is set equal to m_building
  */
  public void setMinor(String building){
    m_building = building;
  }

  /**
    * toString - override the default toString Object method
    * @return returns the contents of a Staff member in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nStaff ID: " + m_staffId;
    ret += "\nTitle: " + m_title;
    ret += "\nBuilding: " + m_building;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return returns true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object s){
    if(!(s instanceof Staff)){
      return false;
    }
    Staff c = (Staff)s;
    if(m_staffId != c.m_staffId || !(m_title.equals(c.m_title)) || !(m_building.equals(c.m_building))){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of a staff member
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nStaff ID: " + m_staffId;
    ret += "\nTitle: " + m_title;
    ret += "\nBuilding: " + m_building;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return returns the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Staff ID: " + m_staffId);
    stringLL.add("Title: " + m_title);
    stringLL.add("Building: " + m_building);
    Collections.sort(stringLL);
    return stringLL;
  }
}

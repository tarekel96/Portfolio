/** import LinkedList Collection data structure */
import java.util.LinkedList;
/** import to use sort method */
import java.util.Collections;

/**
  * Students is an abstract class that can be extended to various types of students
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public abstract class Students extends Affiliates  {

  // Fields
  /** an int that represents a student's id */
  protected int m_studentId;
  /** a String that represents a student's major */
  protected String m_major;
  /** a String that represents a student's minor */
  protected String m_minor;
  /** a String that represents a student's class standing */
  protected String m_classStanding;

  /**
    * Default Constructor - it assigns some default values to the student's fields
  */
  public Students(){
    super();
    m_studentId = -1;
    m_major = "Communication";
    m_minor = "Business Administration";
    m_classStanding = "Freshman";
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the student's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
    * @param studentId assigned to the m_studentId field of the student member
    * @param major assigned to the m_major field of the student member
    * @param minor assigned to the m_minor field of the student member
    * @param classStanding assigned to the m_classStanding field of the student member
  */
  public Students(String name, int age, String address, String phoneNumber, int yearBegan, int studentId, String major, String minor, String classStanding){
    super(name, age, address, phoneNumber, yearBegan);
    m_studentId = studentId;
    m_major = major;
    m_minor = minor;
    m_classStanding = classStanding;
  }

  /**
    * Copy Constructor - it creates a copy of Student instance
    * @param c - the Student instance that is being copied
  */
  public Students(Students c){
    super(c);
    m_studentId = c.m_studentId;
    m_major = c.m_major;
    m_minor = c.m_minor;
    m_classStanding = c.m_classStanding;
  }

  // Accessors
  /**
    * This is an accessor method that is abstract.
    * @return the type of Affiliate
  */
  public abstract String getClassType();
  /**
    * This is an accessor method
    * @return the Student's id field
  */
  public int getId(){
    return m_studentId;
  }
  /**
    * This is an accessor method
    * @return the Student's age field
  */
  public String getMajor(){
    return m_major;
  }
  /**
    * This is an accessor method
    * @return the Student's minor field
  */
  public String getMinor(){
    return m_minor;
  }
  /**
    * This is an accessor method
    * @return the Student's class standing field
  */
  public String getClassStanding(){
    return m_classStanding;
  }

  // Mutators
  /**
    * This is a mutator method
    * @param studentId is set equal to m_studentId
  */
  public void setStudentId(int studentId){
    m_studentId = studentId;
  }
  /**
    * This is a mutator method
    * @param major is set equal to m_major
  */
  public void setMajor(String major){
    m_major = major;
  }
  /**
    * This is a mutator method
    * @param minor is set equal to m_minor
  */
  public void setMinor(String minor){
    m_minor = minor;
  }
  /**
    * This is a mutator method
    * @param classStanding is set equal to m_classStanding
  */
  public void setClassStanding(String classStanding){
    m_classStanding = classStanding;
  }

  /**
    * toString - override the default toString Object method
    * @return returns the contents of a Students member in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nStudent ID: " + m_studentId;
    ret += "\nMajor: " + m_major;
    ret += "\nMinor: " + m_minor;
    ret += "\nClass Standing: " + m_classStanding;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return returns true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object f){
    if(!(f instanceof Students)){
      return false;
    }
    Students c = (Students)f;
    if(m_studentId != c.m_studentId || !(m_major.equals(c.m_major)) || !(m_minor.equals(c.m_minor)) || !(m_classStanding.equals(c.m_classStanding))){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of a student
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nStudent ID: " + m_studentId;
    ret += "\nMajor: " + m_major;
    ret += "\nMinor: " + m_minor;
    ret += "\nClass Standing: " + m_classStanding;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return returns the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Student ID: " + m_studentId);
    stringLL.add("Major: " + m_major);
    stringLL.add("Minor: " + m_minor);
    stringLL.add("Class Standing: " + m_classStanding);
    Collections.sort(stringLL);
    return stringLL;
  }
}

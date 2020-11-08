/** import to use sort method */
import java.util.Collections;
/** import LinkedList Collection data structure */
import java.util.LinkedList;

/**
  * UnderGraduateStudents is a class that represents undergraduate students
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public class UnderGraduateStudents extends Students {

  // Fields
  /** an int that represents an undergraduate student's number of courses */
  private int m_numberOfCourses;
  /** a double that represents an undergraduate student's scholarship amount */
  private double m_scholarshipAmount;

  /**
    * Default Constructor - it assigns some default values to the UnderGraduateStudents fields
  */
  public UnderGraduateStudents(){
    super();
    m_numberOfCourses= -1;
    m_scholarshipAmount = -100.00;
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the undergraduate student's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
    * @param studentId assigned to the m_studentId field of the student member
    * @param major assigned to the m_major field of the student member
    * @param minor assigned to the m_minor field of the student member
    * @param classStanding assigned to the m_classStanding field of the student member
    * @param numberOfCourses assigned to the m_numberOfCourses field of the undergraduate student member
    * @param scholarshipAmount assigned to the m_scholarshipAmount field of the undergraduate student member
  */
  public UnderGraduateStudents(String name, int age, String address, String phoneNumber, int yearBegan, int studentId, String major, String minor, String classStanding, int numberOfCourses, double scholarshipAmount){
    super(name, age, address, phoneNumber, yearBegan, studentId, major, minor, classStanding);
    m_numberOfCourses = numberOfCourses;
    m_scholarshipAmount = scholarshipAmount;
  }

  /**
    * Copy Constructor - it creates a copy of UnderGraduateStudents instance
    * @param c - the UnderGraduateStudents instance that is being copied
  */
  public UnderGraduateStudents(UnderGraduateStudents c){
    super(c);
    m_numberOfCourses = c.m_numberOfCourses;
    m_scholarshipAmount = c.m_scholarshipAmount;
  }

  // Accessors
  /**
    * This is an accessor method that overrides the abstract method from Students.
    * @return the type of Student
  */
  @Override
  public String getClassType(){
    return "Undergraduate Student";
  };
  /**
    * This is an accessor method
    * @return the Undergraduate Student's number of courses
  */
  public int getNumberOfCourses(){
    return m_numberOfCourses;
  }
  /**
    * This is an accessor method
    * @return the Undergraduate Student's scholarship amount
  */
  public double getScholarshipAmount(){
    return m_scholarshipAmount;
  }

  // Mutators
  /**
    * This is a mutator method
    * @param numberOfCourses is set equal to m_numberOfCourses
  */
  public void setNumberOfCourses(int numberOfCourses){
    m_numberOfCourses = numberOfCourses;
  }
  /**
    * This is a mutator method
    * @param scholarshipAmount is set equal to m_scholarshipAmount
  */
  public void setScholarshipAmount(double scholarshipAmount){
    m_scholarshipAmount = scholarshipAmount;
  }

  /**
    * toString - override the default toString Object method
    * @return the contents of an Undergraduate Student in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nNumber of Courses: " + m_numberOfCourses;
    ret += "\nScholarship Amount: " + m_scholarshipAmount;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object ugs){
    if(!(ugs instanceof UnderGraduateStudents)){
      return false;
    }
    UnderGraduateStudents c = (UnderGraduateStudents)ugs;
    if((m_numberOfCourses != c.m_numberOfCourses) || (m_scholarshipAmount != c.m_scholarshipAmount)){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of an undergraduate student
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nNumber of Courses: " + m_numberOfCourses;
    ret += "\nScholarship Amount: " + m_scholarshipAmount;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Number of Courses: " + m_numberOfCourses);
    stringLL.add("Scholarship Amount: " + m_scholarshipAmount);
    Collections.sort(stringLL);
    return stringLL;
  }
}

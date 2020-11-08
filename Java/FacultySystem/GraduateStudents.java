/** import to use sort method */
import java.util.Collections;
/** import LinkedList Collection data structure */
import java.util.LinkedList;

/**
  * GraduateStudents is a class that represents graduate students
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public class GraduateStudents extends Students {

  // Fields
  /** an int that represents a graduate student's number of published papers */
  private int m_numberOfPapersPublished;
  /** a String that represents a graduate student's thesis advisor */
  private String m_thesisAdvisor;

  /**
    * Default Constructor - it assigns some default values to the GraduateStudents fields
  */
  public GraduateStudents(){
    super();
    m_numberOfPapersPublished= -1;
    m_thesisAdvisor= "Steve Jobs";
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the graduate student's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
    * @param studentId assigned to the m_studentId field of the student member
    * @param major assigned to the m_major field of the student member
    * @param minor assigned to the m_minor field of the student member
    * @param classStanding assigned to the m_classStanding field of the student member
    * @param numberOfPapersPublished assigned to the m_numberOfPapersPublished field of the graduate student member
    * @param thesisAdvisor assigned to the m_thesisAdvisor field of the graduate student member
  */
  public GraduateStudents(String name, int age, String address, String phoneNumber, int yearBegan, int studentId, String major, String minor, String classStanding, int numberOfPapersPublished, String thesisAdvisor){
    super(name, age, address, phoneNumber, yearBegan, studentId, major, minor, classStanding);
    m_numberOfPapersPublished = numberOfPapersPublished;
    m_thesisAdvisor = thesisAdvisor;
  }

  /**
    * Copy Constructor - it creates a copy of GraduateStudents instance
    * @param c - the GraduateStudents instance that is being copied
  */
  public GraduateStudents(GraduateStudents c){
    super(c);
    m_numberOfPapersPublished = c.m_numberOfPapersPublished;
    m_thesisAdvisor = c.m_thesisAdvisor;
  }

  // Accessors
  /**
    * This is an accessor method that overrides the abstract method from Students.
    * @return the type of Students
  */
  @Override
  public String getClassType(){
    return "Graduate Student";
  };
  /**
    * This is an accessor method
    * @return the Graduate Student's number of papers published
  */
  public int getNumberOfPapersPublished(){
    return m_numberOfPapersPublished;
  }
  /**
    * This is an accessor method
    * @return the Graduate Student's thesis advisor
  */
  public String getThesisAdvisor(){
    return m_thesisAdvisor;
  }

  // Mutators
  /**
    * This is a mutator method
    * @param numberOfPapersPublished is set equal to m_numberOfPapersPublished
  */
  public void setYearsSinceTenure(int numberOfPapersPublished){
    m_numberOfPapersPublished = numberOfPapersPublished;
  }
  /**
    * This is a mutator method
    * @param thesisAdvisor is set equal to m_thesisAdvisor
  */
  public void setThesisAdvisor(String thesisAdvisor){
    m_thesisAdvisor = thesisAdvisor;
  }

  /**
    * toString - override the default toString Object method
    * @return the contents of a Graduate Student in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = super.toString();
    ret += "\nNumber of Papers Published: " + m_numberOfPapersPublished;
    ret += "\nThesis Advisor: " + m_thesisAdvisor;
    return ret;
  }

  /**
    * equals - override the default equals Object method
    * @return true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object gs){
    if(!(gs instanceof GraduateStudents)){
      return false;
    }
    GraduateStudents c = (GraduateStudents)gs;
    if(m_numberOfPapersPublished != c.m_numberOfPapersPublished || !(m_thesisAdvisor.equals(c.m_thesisAdvisor))){
      return false;
    }
    return true;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of a graduate student
  */
  @Override
  public String print(){
    String ret = super.print();
    ret += "\nNumber of Papers Published: " + m_numberOfPapersPublished;
    ret += "\nThesis Advisor: " + m_thesisAdvisor;
    return ret;
  }

  /**
    * orderAlphabetically() orders a LinkedList and sorts it alphabetically via the Collections.sort()
    * @return the alphabetically sorted LinkedList
  */
  @Override
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = super.orderAlphabetically();
    stringLL.add("Number of Papers Published: " + m_numberOfPapersPublished);
    stringLL.add("Thesis Advisor: " + m_thesisAdvisor);
    Collections.sort(stringLL);
    return stringLL;
  }
}

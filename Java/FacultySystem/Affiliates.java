/** import in order to implement compareTo method */
import java.lang.Comparable;
/** import to use sort method */
import java.util.Collections;
/** import HashMap and LinkedList Collection data structures */
import java.util.HashMap;
import java.util.LinkedList;

/**
  * an abstract class that can be extended to various types of affiliates
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public abstract class Affiliates implements Printable, Comparable<Affiliates>{

  // Fields
  /** a String that represents an Affiliate's name */
  protected String m_name;
  /** an int that represents an Affiliate's age */
  protected int m_age;
  /** a String that represents an Affiliate's address */
  protected String m_address;
  /** a String that represents an Affiliate's age */
  protected String m_phoneNumber;
  /** an int that represents the year when an Affiliate became an affiliate */
  protected int m_yearBegan;

  /**
    * Default Constructor - it assigns some default values to the affiliate's fields
  */
  public Affiliates(){
    m_name = "John Doe";
    m_age = 40;
    m_address = "2655 El Camino Real, Tustin, CA 92782";
    m_phoneNumber = "7148387895";
    m_yearBegan = 2000;
  }

  /**
    * Overloaded Constructor - it assigns the parameter values to the affiliate's fields
    * @param name assigned to the m_name field of the affiliate
    * @param age assigned to the m_age field of the affiliate
    * @param address assigned to the m_address field of the affiliate
    * @param phoneNumber assigned to the m_phoneNumber field of the affiliate
    * @param yearBegan assigned to the m_yearBegan field of the affiliate
  */
  public Affiliates(String name, int age, String address, String phoneNumber, int yearBegan){
    m_name = name;
    m_age = age;
    m_address = address;
    m_phoneNumber = phoneNumber;
    m_yearBegan = yearBegan;
  }

  /**
    * Copy Constructor - it creates a copy of Affiliate instance
    * @param c - the Affiliate instance that is being copied
  */
  public Affiliates(Affiliates c){
    m_name = c.m_name;
    m_age = c.m_age;
    m_address = c.m_address;
    m_phoneNumber = c.m_phoneNumber;
    m_yearBegan = c.m_yearBegan;
  }

  // Accessors
  /**
    * This is an accessor method that is abstract.
    * @return the type of Affiliate
  */
  public abstract String getClassType();
  /**
    * This is an accessor method
    * @return the Affiliates's name field
  */
  public String getName(){
    return m_name;
  }
  /**
    * This is an accessor method
    * @return the Affiliates's age field
  */
  public int getAge(){
    return m_age;
  }
  /**
    * This is an accessor method
    * @return the Affiliates's address field
  */
  public String getAddress(){
    return m_address;
  }
  /**
    * This is an accessor method
    * @return the Affiliates's phone number field
  */
  public String getPhoneNumber(){
    return m_phoneNumber;
  }
  /**
    * This is an accessor method
    * @return the Affiliates's year began field
  */
  public int getYearBegan(){
    return m_yearBegan;
  }

  /**
    * This is a mutator method
    * @param name is set equal to m_name
  */
  public void setName(String name){
    m_name = name;
  }
  /**
    * This is a mutator method
    * @param age is set equal to m_age
  */
  public void setAge(int age){
    m_age = age;
  }
  /**
    * This is a mutator method
    * @param address is set equal to m_address
  */
  public void setAddress(String address){
    m_address = address;
  }
  /**
    * This is a mutator method
    * @param phoneNumber is set equal to m_phoneNumber
  */
  public void setPhoneNumber(String phoneNumber){
    m_phoneNumber = phoneNumber;
  }
  /**
    * This is a mutator method
    * @param yearBegan is set equal to m_yearBegan
  */
  public void setYearBegan(int yearBegan){
    m_yearBegan = yearBegan;
  }

  /**
    * overrides the default toString Object method
    * @return the contents of an Affiliate in a nicely printed format
  */
  @Override
  public String toString(){
    String ret = "";
    ret += "Name: " + m_name;
    ret += "\nAge: " + m_age;
    ret += "\nAddress: " + m_address;
    ret += "\nPhone Number: " + m_phoneNumber;
    ret += "\nYear Began: " + m_yearBegan;
    return ret;
  }

  /**
    * overrides the default equals Object method
    * @param a the Affiliate that is being compared with the Affiliate invoking equals()
    * @return returns true if the fields are equal and false otherwise
  */
  @Override
  public boolean equals(Object a){
    if(!(a instanceof Affiliates)){
      return false;
    }
    Affiliates c = (Affiliates)a;
    if(!(m_name.equals(c.m_name)) || m_age != c.m_age || !(m_address.equals(c.m_address)) || !(m_phoneNumber.equals(c.m_phoneNumber)) || m_yearBegan != c.m_yearBegan){
      return false;
    }
    return true;
  }

  /**
    * a method from the Comparable interface that is overridden to compare one Affiliate's year came in with another Affiliate's year came in
    * @param a represents the Affiliate that being compared to the Affiliate invoking the compareTo() method
    * @return an int: 0 if the affiliates have equal years came in, 1 if the affiliate invoking compareTo() has a lower year came in (been an affiliate for more years), -1 if the affiliate invoking compareTo() has a higher year came in (been an affiliate for less years)
  */
  @Override
  public int compareTo(Affiliates a){
    if(m_yearBegan == a.m_yearBegan){
      return 0;
    }
    else if(m_yearBegan < a.m_yearBegan){
      return -1;
    }
    return 1;
  }

  /**
    * print() is a method from the user defined Printable Interface that is overridden to print out all of the contents of an affiliate
  */
  @Override
  public String print(){
    String ret = "";
    ret += "\nName: " + m_name;
    ret += "\nAge: " + m_age;
    ret += "\nAddress: " + m_address;
    ret += "\nPhone Number: " + m_phoneNumber;
    ret += "\nYear Began: " + m_yearBegan;
    return ret;
  }

  /**
    * orderAlphabetically() is a method that adds the fields with their respected labels into a LinkedList and then alphabetically sorts the LinkedList
    * @return the alphabetically sorted LinkedList of fields with labels that is returned
  */
  public LinkedList<String> orderAlphabetically(){
    LinkedList<String> stringLL = new LinkedList<String>();
    stringLL.add("Name: " + m_name);
    stringLL.add("Age: " + m_age);
    stringLL.add("Address: " + m_address);
    stringLL.add("Phone Number: " + m_phoneNumber);
    stringLL.add("Year Began: " + m_yearBegan);
    Collections.sort(stringLL);
    return stringLL;
  }

  /**
    * printAlphabetically() is a method that prints out the LinkedList that was alphabetically sorted prior to being passed a parameter
    * @param stringLL is the alphabetically sorted LinkedList of Affiliate fields with labels
    * @return the elements of the alphabetically sorted LinkedList each separated by a coma
  */
  public String printAlphabetically(LinkedList<String> stringLL){
    String ret = "";
    for(int i = 0; i < stringLL.size(); ++i){
      if(i == (stringLL.size() - 1)){
        ret += stringLL.get(i) + " ";
      } else {
        ret += stringLL.get(i) + ", ";
      }
    }
    return ret;
  }
}

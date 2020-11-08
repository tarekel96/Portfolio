import java.util.Scanner;

public class Pizza {

  // declare private fields
  private String m_size;
  private int m_cheeseToppings;
  private int m_pepperoniToppings;
  private int m_veggieToppings;

  // default constructor
  public Pizza(){
    m_size = "small";
    m_cheeseToppings = 1;
    m_pepperoniToppings = 0;
    m_veggieToppings = 0;
  }

  // accessor methods - getter functions
  public String getSize(){
    return m_size;
  }

  public int getCheeseToppings(){
    return m_cheeseToppings;
  }

  public int getPepperoniToppings(){
    return m_pepperoniToppings;
  }

  public int getVeggieToppings(){
    return m_veggieToppings;
  }

  // mutator methods - setter functions
  public void setSize(String size){
    m_size = size;
  }

  public void setCheeseToppings(int cheeseToppings){
    m_cheeseToppings = cheeseToppings;
  }

  public void setPepperoniToppings(int pepperoniToppings){
    m_pepperoniToppings = pepperoniToppings;
  }

  public void setVeggieToppings(int veggieToppings){
    m_veggieToppings = veggieToppings;
  }

  // overloaded constructor with parameters/arguments that are set to the private fields for a Pizza instance
  public Pizza(String size, int cheeseToppings, int pepperoniToppings, int veggieToppings){
    m_size = size;
    m_cheeseToppings = cheeseToppings;
    m_pepperoniToppings = pepperoniToppings;
    m_veggieToppings = veggieToppings;
  }

  // Copy constructor
  public Pizza(Pizza c){
    this.m_size = c.m_size;
    this.m_cheeseToppings = c.m_cheeseToppings;
    this.m_pepperoniToppings = c.m_pepperoniToppings;
    this.m_veggieToppings = c.m_veggieToppings;
  }

  public double calcCost(){
    // totalCost returned at the end
    double totalCost = 0.0;
    int numberOfToppings = 0;

    // adds cost of size based on size field
    switch(this.m_size){
      case "small":
      case "Small":
        totalCost += 10;
        break;
      case "medium":
      case "Medium":
        totalCost += 12;
        break;
      case "large":
      case "Large":
        totalCost += 14;
        break;
    }

  // use accessor methods to get the number of toppings for a Pizza instance
  numberOfToppings = this.getCheeseToppings() + this.getPepperoniToppings() + this.getVeggieToppings();
  totalCost += (2 * numberOfToppings); // each topping costs $2
  return totalCost;
  }

  public String toString(){
    String ret = "";
    ret += "Size: " + this.getSize();
    ret += "\nNumber of Cheese Toppings: " + this.getCheeseToppings();
    ret += "\nNumber of Pepperoni Toppings: " + this.getPepperoniToppings();
    ret += "\nNumber of Veggie Toppings: " + this.getVeggieToppings();
    ret += "\nPizza Cost: $" + this.calcCost();
    ret += "\n";
    return ret;
  }
}

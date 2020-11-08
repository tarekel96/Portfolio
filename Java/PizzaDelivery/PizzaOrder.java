import java.util.Scanner;

public class PizzaOrder {
  // declare private fields
  private int m_numPizzas; // how many pizzas are in the order
  private Pizza[] m_order; // array of base type Pizza
  private int indexCounter = 0; // used in the add() method to keep track of which index to add to

  // Default constructor
  public PizzaOrder(){
    m_numPizzas = 1;
    m_order = new Pizza[m_numPizzas];
    m_order[0] = new Pizza("small", 1, 0, 0);
  }

  // Overloaded constructor that inits the m_numPizzas for an instance of PizzaOrders to the parameter/argument
  public PizzaOrder(int numPizzas){
    m_numPizzas = numPizzas;
    // inits the m_order array to an array of Pizza instances with a size of the numPizzes (the argument passed)
    m_order = new Pizza[m_numPizzas];
  }

  // accessors - getter functions
  public int getNumPizzas(){
    return m_numPizzas;
  }

  public Pizza[] getPizzaOrder(){
    return m_order;
  }

  // mutators - setter functions
  // adds a new pizza to the existing order without violating the set size of the pizza order
  public int addPizza(Pizza pizza){
    // if statement ensures that no more pizzas are added to the order than is allowed to by the size of the array
    if(indexCounter > (m_numPizzas - 1)){
      System.out.println("Cannot add another pizza to the current order.");
      return -1;
    }
    // line of code that adds the pizza object argument to the pizza order array
    m_order[indexCounter] = pizza;
    // must increment the counter to ensure the next pizza is added to the correct index of the pizza order array
    indexCounter += 1;
    return 1;
  }

  // calculates the total cost of the pizza order
  public double calcTotal(){
    // declare/init the totalCost variable
    double totalCost = 0;
    // loop is needed to iteriate through the PizzaOrder array
    for(int i = 0; i < m_numPizzas; ++i){
      // adds each pizza total to the totalCost variable
      totalCost += m_order[i].calcCost();
    }
    return totalCost;
  }

  // prints out the pizza orders in an organized format
  public String toString(){
    String ret = "You ordered " + m_numPizzas + " pizzas.";
    ret += "The final cost of your order comes out to: $" + this.calcTotal();
    ret += "\nThe pizzas are the following: \n";
    for(int i = 0; i < m_numPizzas; ++i){
      ret += m_order[i].toString();
    }
    ret += "Once again, the total cost of your order comes out to: $" + this.calcTotal();
    return ret;
  }
}

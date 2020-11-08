public class PizzaDriver {

  public static void main(String[] args){
    Pizza pizza1 = new Pizza("small", 1, 0, 1); // Code to create a small pizza, 1 cheese, 1 veggie
    Pizza pizza2 = new Pizza("medium", 2, 2, 0); // Code to create a medium pizza, 2 cheese, 2 pepperoni
    Pizza pizza3 = new Pizza("large", 2, 0, 0); // Code to create a large pizza, 2 cheese
    PizzaOrder order = new PizzaOrder(2); // Code to create an order of TWO pizzas
    System.out.println(order.addPizza(pizza1)); // add pizza1 to the order
    System.out.println(order.addPizza(pizza2)); // add pizza2 to the order
    System.out.println(order.addPizza(pizza3)); // add pizza3 to the order
    System.out.println(order.toString()); // Should call order’s toString method
  }

}

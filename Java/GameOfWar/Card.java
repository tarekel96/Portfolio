/** This class represents a card that can be used in a deck or by a War player
  * @author Tarek El-Hajjaoui
  * @version 1.0
*/
public class Card {
  /** A String representing the value of a card: 2-10, J, Q, K, or A */
  private String m_value;
  /** A String representing the suit of a card: hearts, spades, clubs, or diamonds */
  private String m_suit;

  /** This is the default constructor */
  public Card(){
    m_value = "A";
    m_suit = "hearts";
  }

  /** This is an overloaded constructor
    * @param value String representing the value for the card
    * @param suit String representing the suit for the card
  */
  public Card(String value, String suit){
    m_value = value;
    m_suit = suit;
  }

  /** This is a copy constructor */
  public Card(Card c){
    m_value = c.m_value;
    m_suit = c.m_suit;
  }

  // Accessors
  /** This is an accessor method
    * @return returns the value of the card
  */
  public String getValue(){
    return m_value;
  }

  /** This is an accessor method
    * @return returns the suit of the card
  */
  public String getSuit(){
    return m_suit;
  }

  // Mutators
  /** This is a mutator method
    * @param value sets the value for the card
  */
  public void setValue(String value){
    m_value = value;
  }

  /** This is a mutator method
    * @param suit sets the suit for the card
  */
  public void setSuit(String suit){
    m_suit = suit;
  }

  /** This is a helper mutator method
    * converts the String card value of a card to its respected int numerical value
    * @param value is the card value that will be converted
    * @return returns the respected int numerical value based on the provided card value
  */
  public int convertCardToInt(String value){
    int intValue;
    switch(value){
      case "J":
        intValue = 11;
        break;
      case "Q":
        intValue = 12;
        break;
      case "K":
        intValue = 13;
        break;
      case "A":
        intValue = 14;
        break;
      default:
        intValue = Integer.parseInt(value);
        break;
    }
    return intValue;
  }

  /** This is an equals method that overrides the Object default equals method
    * @param o represents the object that is being compared with the card instance calling equals()
    * @return returns true if both of the cards' fields are equal in value
  */
  @Override
  public boolean equals(Object o){
    if (!(o instanceof Card)){
      return false;
    }
    Card c = (Card)o;
    if(m_value != c.m_value || m_suit != c.m_suit){
      return false;
    }
    return true;
  }

  /** This is a toString method that overrides the Object default toString method
    * @return returns a nicely formatted String representation of the card's fields
  */
  @Override
  public String toString(){
    String ret = "";
    ret += "Card Suit: " + m_suit;
    ret += "\nCard Value: " + m_value;
    return ret;
  }
}

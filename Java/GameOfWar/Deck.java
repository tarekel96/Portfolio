import java.util.LinkedList;
/** This is a class that represents a Deck of 52 cards that can be used in card games
  * @author Tarek El-Hajjaoui
  * @version 1.0
*/
public class Deck {
  /** This is a LinkedList composed where the 52 Card Instances are stored */
  private LinkedList<Card> m_cards = new LinkedList<Card>();
  /** This is an array of Strings representing the possible suits for a card in the deck */
  private String[] m_suitArray = {"hearts", "spades", "clubs", "diamonds"};
  /** This is an array of Strings representing the possible suit values for a card in the deck */
  private String[] m_nonNumValues = {"J", "Q", "K", "A"};

  /** This is a default constructor
    * it creates an accurate deck of 52 cards - 13 hearts, 13 spades, 13 clubs, 13 diamonds
  */
  public Deck(){
    // 2 loops below add the 2-10 cards of each suit to the cards LinkedList
    for(int i = 0; i < m_suitArray.length; ++i){
      String cardSuit = m_suitArray[i];
      for(int j = 2; j < 11; ++j){
        String cardValue;
        // conver the integer value to a String
        cardValue = Integer.toString(j);
        // each card is a new intance of an object allocated to the Heap memory
        m_cards.add(new Card(cardValue, cardSuit));
      }
    }
    // 2 loops below add the J, Q, K, and A of each suit to the cards LinkedList
    for(int i = 0; i < m_suitArray.length; ++i){
      String cardSuit = m_suitArray[i];
      for(int j = 0; j < m_nonNumValues.length; ++j){
        String cardValue;
        cardValue = m_nonNumValues[j];
        // each card is a new intance of an object allocated to the Heap memory
        m_cards.add(new Card(cardValue, cardSuit));
      }
    }
  }

  /** This is an overloaded constructor
    * @param cards a LinkedList of cards that represent the deck's cards
  */
  public Deck(LinkedList<Card> cards){
    m_cards = cards;
  }

  // Accessors
  /** This is an accessor method
    * @return returns the LinkedList of cards
  */
  public LinkedList getCards(){
    return m_cards;
  }

  // Mutators
  /** This is a mutator method
    * @param cards is the LinkedList of cards that will be set for the deck instance
  */
  public void setCards(LinkedList<Card> cards){
    m_cards = cards;
  }
  /** This is a mutator method
    * @param index specifies the element index of the Card instance that will be removed from the deck of cards
  */
  public void removeCardFromDeck(int index) {
    m_cards.remove(index);
  }
  /** This is a mutator helper method
    * @return returns a random number - used to pick out a random card from the deck
  */
  public int genRandomIndex(){
    int randomNumber;
    // algorithm is adaptive to the cards LinkedList size
    return randomNumber = (int)(Math.random() * m_cards.size());
  }
  /** This is a mutator method
    * @return returns a random card from the deck
  */
  public Card deal(){
    Card randomCard;
    int randomNumber = genRandomIndex();
    randomCard = m_cards.get(randomNumber);
    // removes the random Card from the Deck
    removeCardFromDeck(randomNumber);
    return randomCard;
  }

  /** This is an equals method that overrides the Object default equals method
    * @param o represents the object that is being compared with the deck instance calling equals()
    * @return returns true if both of the cards have the same LinkedList of cards
  */
  @Override
  public boolean equals(Object o){
    if(!(o instanceof Deck)){
      return false;
    }
    Deck d = (Deck)o;
    if(this.getCards() == d.getCards()){
      return true;
    }
    return false;
  }
  /** This is a toString method that overrides the Object default toString method
    * @return returns a nicely formatted String representation of each of a card's fields from the deck
  */
  @Override
  public String toString(){
    String ret = "";
    for(int i = 0; i < m_cards.size(); ++i){
      ret += "\n" + m_cards.get(i).toString();
    }
    return ret;
  }
}

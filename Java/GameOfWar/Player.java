import java.util.LinkedList;
/** This class represents a player that can be used in a War game
  * @author Tarek El-Hajjaoui
  * @version 1.0
*/
public class Player {
  /** An int representing the player's number (either 1 or 2) */
  private int m_number;
  /** A LinkedList of cards reprenting a player's own list of cards */
  private LinkedList<Card> m_ownedCards;
  // boolean only set true if a player has won - owns all 52 cards
  /** A boolean that is true when a player wins and false otherwise */
  private boolean m_hasWon = false;

  /** This is the default constructor */
  Player(){
    m_ownedCards = new LinkedList<Card>();
  }

  /** This is an overloaded constructor
    * assigns a number to a player and assigns/creates a new LinkedList Instance of Cards
    * @param number int representing the player's number (1 or 2)
  */
  Player(int number){
    m_number = number;
    m_ownedCards = new LinkedList<Card>();
  }

  /** This is an overloaded constructor
    * assigns a number to a player and assigns an existing LinkedList Instance of Cards
    * @param number int representing the player's number (1 or 2)
    * @param ownedCards LinkedList of existing cards
  */
  Player(int number, LinkedList<Card>ownedCards){
    m_number = number;
    m_ownedCards = ownedCards;
  }

  // Accessors
  /** This is an accessor method
    * @return returns the player's number (1 or 2)
  */
  public int getNumber(){
    return m_number;
  }
  /** This is an accessor method
    * @return returns the LinkedList of Card instances that the player has
  */
  public LinkedList getOwnedCards(){
    return m_ownedCards;
  }
  /** This is an accessor method
    * @return returns true if a player has won and false otherwise
  */
  public boolean getWinStatus(){
    return m_hasWon;
  }
  /** This is an accessor method
    * @return returns the size of a player's deck of cards
  */
  public int getNumOfCards(){
    return m_ownedCards.size();
  }

  // Mutators
  /** This is a mutator method
    * @param number sets the number for a player
  */
  public void setNumber(int number){
    m_number = number;
  }
  /** This is a mutator method
    * @param hasWon sets the win status for a player (true or false)
  */
  public void setWinStatus(boolean hasWon){
    m_hasWon = hasWon;
  }
  /** This is a mutator method
    * adds a Card instance to the LinkedList of cards
    * @param c is the card that is to be added
  */
  public void addCard(Card c){
    m_ownedCards.add(c);
  }
  /** This is a mutator method
    * clears all of the cards from the player's deck LinkedList
  */
  public void clearCards(){
    m_ownedCards.clear();
  }
  /** This is a mutator method
    * removes the first Card element of the m_ownedCards LinkedList and returns a new instance copy of that card
    * @return cardRemoved is a copy of the card instance that is removed
  */
  public Card flip(){
    Card cardRemoved = new Card(m_ownedCards.get(0));
    m_ownedCards.remove();
    return cardRemoved;
  }
  /** This is a mutator method
    * it adds a LinkedList of cards to the player's m_ownedCards LinkedList
  */
  public void collect(LinkedList<Card> cardList){
    // addAll() built in Java Collection method
    m_ownedCards.addAll(cardList);
  }
  // war method is invoked whenever there is tie play - one more card is drawn from the player's deck to settle tie
  /** This is a mutator method
    * it is invoked whenever there is tie play
    * one more card is drawn from the player's deck via flip() to settle the tie
    * @return cardRemoved is a copy of the card instance that is removed
  */
  public Card war(){
    Card cardRemoved = flip();
    return cardRemoved;
  }
  /** This is a mutator method
    * updates the player's m_hasWon boolean field based on the amount of cards the player has left
    * @return returns true if a player has 52 cards and won or false otherwise
  */
  public boolean updateWinLoss(){
    if(getNumOfCards() == 52){
      System.out.println("Player " + getNumber() + " has " + getNumOfCards() + " cards and thus has won!" );
      return m_hasWon = true;
    }
    else if(getNumOfCards() > 0){
      //System.out.println("Player " + getNumber() + " has not won and still has " + getNumOfCards() + " cards." );
      return m_hasWon = false;
    }
    else if(getNumOfCards() == 0){
      //System.out.println("Player " + getNumber() + " has " + getNumOfCards() + " cards left and thus has lost." );
      return m_hasWon = false;
    }
    return false;
  }

  /** This is a toString method that overrides the Object default toString method
    * @return returns a nicely formatted String representation of all of the cards of a player's deck
  */
  @Override
  public String toString(){
    String ret = "";
    for(int i = 0; i < m_ownedCards.size(); ++i){
      ret += "\n" + m_ownedCards.get(i).toString();
    }
    return ret;
  }

}

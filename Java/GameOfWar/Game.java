import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections; // used to sort instances of ArrayLists
/** This class represents a War game
  * @author Tarek El-Hajjaoui
  * @version 1.0
*/
public class Game {
  /** A Player instance representing Player One */
  private Player m_playerOne;
  /** A Player instance representing Player Two */
  private Player m_playerTwo;
  /** An int that keeps track of how many battles happpen */
  private int m_numOfBattles = 0;
  /** An int that keeps track of how many wars happpen */
  private int m_numOfWars = 0;
  /** An int that keeps track of how many double wars happpen */
  private int m_numOfDoubleWars = 0;
  /** The deck of cards that is used for the game */
  private Deck m_gameDeck;
  /** A LinkedList of card instances that represent Player One's draw for a battle */
  private LinkedList<Card> m_playerOneDraw;
  /** A LinkedList of card instances that represent Player Two's draw for a battle */
  private LinkedList<Card> m_playerTwoDraw;
  /** A LinkedList of card instances that represent Player One's draw and Player Two's draw combined for a battle */
  private LinkedList<Card> m_combinedDraw;
  /** An int that represents the median numerical score of Player One's current draw for a battle */
  private double m_playerOneHandMedian;
  /** An int that represents the median numerical score of Player Two's current draw for a battle */
  private double m_playerTwoHandMedian;
  /** An ArrayList instance that represents Player One's card values for the current draw of the battle */
  private ArrayList<Integer> m_playerOneHandValues = new ArrayList<Integer>();
  /** An ArrayList instance that represents Player Two's card values for the current draw of the battle */
  private ArrayList<Integer> m_playerTwoHandValues = new ArrayList<Integer>();

  /** This is the default constructor
    * it properly assigns numbers to the two players of the game
  */
  public Game(){
    m_playerOne = new Player(1);
    m_playerTwo = new Player(2);
  }

  // Accessors
  /** This is an accessor method
    * @return returns the instance of Player One
  */
  public Player getPlayerOne(){
    return m_playerOne;
  }
  /** This is an accessor method
    * @return returns the instance of Player Two
  */
  public Player getPlayerTwo(){
    return m_playerOne;
  }
  /** This is an accessor method
    * @return returns number of battles in the game
  */
  public int getNumOfBattles(){
    return m_numOfBattles;
  }
  /** This is an accessor method
    * @return returns number of wars in the game
  */
  public int getNumOfWars(){
    return m_numOfWars;
  }
  /** This is an accessor method
    * @return returns number of double wars in the game
  */
  public int getNumOfDoubleWars(){
    return m_numOfDoubleWars;
  }

  // Mutators
  /** This is a mutator method
    * @param playerOne sets Player One for the game
  */
  public void setPlayerOne(Player playerOne){
    m_playerOne = playerOne;
  }
  /** This is a mutator method
    * @param playerTwo sets Player Two for the game
  */
  public void setPlayerTwo(Player playerTwo){
    m_playerTwo = playerTwo;
  }
  /** This is a helper method
    * @param cardValues is an ArrayList that represents a Player's card values for the current draw of the battle
    * @return median is the median double value of the Integer ArrayList argument
  */
  public static double calculateMedian(ArrayList<Integer>cardValues){
    Collections.sort(cardValues);
    double median;
    if (cardValues.size() % 2 == 0){
      median = ((double)cardValues.get(cardValues.size()/2) + (double)cardValues.get(cardValues.size()/2 - 1))/2;
    }
    else{
      median = (double) cardValues.get(cardValues.size()/2);
    }
  return median;
  }
  /** This is a helper mutator method
    * starts a game
    * creates new Deck instance and randomly distributes the deck evenly to the two Players
  */
  public void initGame(){
    m_gameDeck = new Deck();
    for(int i = 0; i < 26; ++i){
      m_playerOne.addCard(m_gameDeck.deal());
      m_playerTwo.addCard(m_gameDeck.deal());
    }
    m_playerOneDraw = new LinkedList<Card>();
    m_playerTwoDraw = new LinkedList<Card>();
  }
  /** This is a mutator method
    * handles the logic of a battle simulation
  */
  public void battle(){
    // Displays the amount of cards each player has left
    // System.out.println("Start of battle Player 1 has " + m_playerOne.getNumOfCards() + " cards left.");
    // System.out.println("Start of battle Player 2 has " + m_playerTwo.getNumOfCards() + " cards left.");
    Card[] handP1 = new Card[3];
    Card[] handP2 = new Card[3];
    // If Player One has less than 3 cards, the rest of Player One's deck will be used
    if((m_playerOne.getNumOfCards() < 3) && (m_playerTwo.getNumOfCards() > 3)){
      int listSize;
      listSize = m_playerOne.getNumOfCards();
      for(int i = 0; i < listSize; ++i){
        Card currentCardP1 = m_playerOne.flip();
        m_playerOneDraw.add(currentCardP1);
      }
      // 3 iteriations for P2 since has more than 3
      for(int i = 0; i < 3; ++i){
        Card currentCardP2 = m_playerTwo.flip();
        m_playerTwoDraw.add(currentCardP2);
      }
    }
    // If Player Two has less than 3 cards, the rest of Player Two's deck will be used
    else if((m_playerTwo.getNumOfCards() < 3) && (m_playerOne.getNumOfCards() > 3)){
      int listSize;
      listSize = m_playerTwo.getNumOfCards();
      for(int i = 0; i < listSize; ++i){
        Card currentCardP2 = m_playerTwo.flip();
        m_playerTwoDraw.add(currentCardP2);
      }
      // 3 iteriations for P1 since has more than 3
      for(int i = 0; i < 3; ++i){
        Card currentCardP1 = m_playerOne.flip();
        m_playerOneDraw.add(currentCardP1);
      }
    }
    // If both Player One and Player Two have less than 3 cards, the rest of their decks will be used
    else if((m_playerOne.getNumOfCards() < 3) && (m_playerTwo.getNumOfCards() < 3)){
      int listSize1;
      int listSize2;
      listSize1 = m_playerOne.getNumOfCards();
      listSize2 = m_playerOne.getNumOfCards();
      for(int i = 0; i < listSize1; ++i){
        Card currentCardP1 = m_playerOne.flip();
        m_playerOneDraw.add(currentCardP1);
      }
      for(int i = 0; i < listSize2; ++i){
        Card currentCardP2 = m_playerTwo.flip();
        m_playerTwoDraw.add(currentCardP2);
      }
    }
    // if both players have more than 3 cards in their deck, only 3 cards will be drawn
    else {
      for(int i = 0; i < 3; ++i){
        Card currentCardP1 = m_playerOne.flip();
        Card currentCardP2 = m_playerTwo.flip();
        m_playerOneDraw.add(currentCardP1);
        m_playerTwoDraw.add(currentCardP2);
      }
    }
    // the player LinkedList draws are set by now so next will copy the draw elements into the hand arrays, which is used for the logBattle method
    for(int k = 0; k < m_playerOneDraw.size(); ++k){
      handP1[k] = m_playerOneDraw.get(k);
      // System.out.println("handP1: " + handP1[k]);
      // converts the card into its respected value and then adds the result to the ArrayList of values
      m_playerOneHandValues.add(m_playerOneDraw.get(k).convertCardToInt(m_playerOneDraw.get(k).getValue()));
      // helpful to uncomment to make sure the median was calculated correctly
      // System.out.println("handP1 VALUE: " + m_playerOneHandValues.get(k));
    }
    for(int k = 0; k < m_playerTwoDraw.size(); ++k){
      handP2[k] = m_playerTwoDraw.get(k);
      // System.out.println("handP2: " + handP2[k]);
      // converts the card into its respected value and then adds the result to the ArrayList of values
      m_playerTwoHandValues.add(m_playerTwoDraw.get(k).convertCardToInt(m_playerTwoDraw.get(k).getValue()));
      // helpful to uncomment to make sure the median was calculated correctly
      // System.out.println("handP2 VALUE: " + m_playerTwoHandValues.get(k));
    }
    // the hand arrays have the values now can invoke the warlogger battle method
    WarLogger.getInstance().logBattle(m_numOfBattles, WarLogger.P1, handP1);
    WarLogger.getInstance().logBattle(m_numOfBattles, WarLogger.P2, handP2);
    // iterate through the player draw lists to determine each player's score for the battle
    m_playerOneHandMedian = calculateMedian(m_playerOneHandValues);
    m_playerTwoHandMedian = calculateMedian(m_playerTwoHandValues);
    // helpful to uncomment to make sure the median was calculated correctly
    // System.out.println("P1 Median: " + m_playerOneHandMedian);
    // System.out.println("P2 Median: " + m_playerTwoHandMedian);
    // P1 won that battle
    if(m_playerOneHandMedian > m_playerTwoHandMedian){
      // Logs the details of a single battle
      WarLogger.getInstance().logBattleOutcome(m_numOfBattles, WarLogger.P1);
      m_playerOne.collect(m_playerTwoDraw);
      m_playerOne.collect(m_playerOneDraw);
    }
    // P2 won that battle
    else if(m_playerTwoHandMedian > m_playerOneHandMedian){
      // Logs the details of a single battle
      WarLogger.getInstance().logBattleOutcome(m_numOfBattles, WarLogger.P2);
      m_playerTwo.collect(m_playerOneDraw);
      m_playerTwo.collect(m_playerTwoDraw);
    }
    // if the players' decks have equal value, it is war
    else if(m_playerOneHandMedian == m_playerTwoHandMedian){
      WarLogger.getInstance().logBattleOutcome(m_numOfBattles, WarLogger.WAR);
      //System.out.println("WAR!!!");
      // increment the number of wars
      m_numOfWars += 1;
      // if P1 does not have any cards left for the war draw, P2 wins
      if(m_playerOne.getNumOfCards() == 0){
        WarLogger.getInstance().logWarOutcome(m_numOfWars, WarLogger.P2);
        m_playerTwo.collect(m_playerTwoDraw);
        m_playerTwo.collect(m_playerOneDraw);
      }
      // if P2 does not have any cards left for the war draw, P1 wins
      else if(m_playerTwo.getNumOfCards() == 0){
        WarLogger.getInstance().logWarOutcome(m_numOfWars, WarLogger.P1);
        m_playerOne.collect(m_playerTwoDraw);
        m_playerOne.collect(m_playerOneDraw);
      }
      // players go to war
      else {
        // each player draws another card via the war method
        Card warCardP1 = m_playerOne.war();
        Card warCardP2 = m_playerTwo.war();
        // warCards has a war card from each plaer
        LinkedList<Card> warCards = new LinkedList<Card>();
        // warCardsP1 has ONLY 1 war card from Player 1
        LinkedList<Card> warCardsP1 = new LinkedList<Card>();
        // warCardsP2 has ONLY 1 war card from Player 2
        LinkedList<Card> warCardsP2 = new LinkedList<Card>();
        warCards.add(warCardP1);
        warCards.add(warCardP2);
        warCardsP1.add(warCardP1);
        warCardsP2.add(warCardP1);
        int warCardP1Value = warCardP1.convertCardToInt(warCardP1.getValue());
        int warCardP2Value = warCardP2.convertCardToInt(warCardP2.getValue());
        // the player with the higher war card value collects the draw hands and the war cards
        if(warCardP1Value < warCardP2Value){
          WarLogger.getInstance().logWarOutcome(m_numOfWars, WarLogger.P2);
          // P1 collects all of the hand's cards
          m_playerTwo.collect(warCards);
          m_playerTwo.collect(m_playerTwoDraw);
          m_playerTwo.collect(m_playerOneDraw);
        }
        else if(warCardP2Value < warCardP1Value){
          WarLogger.getInstance().logWarOutcome(m_numOfWars, WarLogger.P1);
          m_playerOne.collect(warCards);
          m_playerOne.collect(m_playerTwoDraw);
          m_playerOne.collect(m_playerOneDraw);
        }
        else if(warCardP1Value == warCardP2Value){
          WarLogger.getInstance().logWarOutcome(m_numOfWars, WarLogger.WAR);
          m_numOfDoubleWars += 1;
          m_playerOne.collect(warCardsP1);
          m_playerTwo.collect(warCardsP2);
          m_playerOne.collect(m_playerOneDraw);
          m_playerTwo.collect(m_playerTwoDraw);
        }
      }
    }
    // reset every battle object for the next battle
    m_playerOneDraw.clear();
    m_playerTwoDraw.clear();
    m_playerOneHandMedian = 0;
    m_playerTwoHandMedian = 0;
    m_playerOneHandValues.clear();
    m_playerTwoHandValues.clear();
    // add 1 to number of battles
    m_numOfBattles += 1;

    // helpful to see if each game results in one player with 52 cards and the other 0
    // System.out.println("End of battle P1 has " + m_playerOne.getNumOfCards() + " cards left.");
    // System.out.println("End of battle P2 has " + m_playerTwo.getNumOfCards() + " cards left.");
  }
  /** This is a mutator method
    * carries out the rules of the game until one Player wins
    * @return the String representation which player won the entire game
  */
  public String play(){
    // initGame() - inits the Deck, distributes 26 cards to each player, and inits each player's Draw LinkedLists
    this.initGame();
    // the players will keep battling until a player has 0 cards left
    while(m_playerOne.getNumOfCards() > 0 && m_playerTwo.getNumOfCards() > 0){
      this.battle();
    }
    // update the win loss status for each player and prints out which player wins
    m_playerOne.updateWinLoss();
    m_playerTwo.updateWinLoss();
    if(m_playerOne.getWinStatus() == true){
      return "P1";
    }
    else if(m_playerTwo.getWinStatus() == true){
      return "P2";
    }
    return "";
  }
}

import java.util.ArrayList;
import java.util.Collections;
/** This class represents a simulation in which the user decides how many war games to simulate
  * @author Tarek El-Hajjaoui
  * @version 1.0
*/
public class Simulation {
  /** An int that keeps track of how many games happpen */
  private int m_numOfGames;
  /** An int that represents the average number of battles */
  private double m_avgNumBattles;
  /** An ArrayList of Integers that contains the number of battles for each game simulated */
  private ArrayList<Integer> m_BattlesList = new ArrayList<Integer>();
  /** An int that represents the sum of the all number of battles from the games simulated */
  private int m_GrandTotal_Battles = 0;
  /** An int that represents the average number of wars */
  private double m_avgNumWars;
  /** An int that represents the sum of the all number of wars from the games simulated */
  private int m_GrandTotal_Wars = 0;
  /** An ArrayList of Integers that contains the number of wars for each game simulated */
  private ArrayList<Integer> m_WarsList = new ArrayList<Integer>();
  /** An int that represent the average number of double wars */
  private double m_avgNumDoubleWars;
  /** An int that represents the sum of the all number of wars from the games simulated */
  private int m_GrandTotal_DoubleWars = 0;
  /** An ArrayList of Integers that contains the number of double wars for each game simulated */
  private ArrayList<Integer> m_DoubleWarsList = new ArrayList<Integer>();
  /** An int that represents max number of battles that occurred in a game */
  private int m_maxNumBattles;
  /** An int that represents min number of battles that occurred in a game */
  private int m_minNumBattles;
  /** An int that represents max number of wars that occurred in a game */
  private int m_maxNumWars;
  /** An int that represents min number of wars that occurred in a game */
  private int m_minNumWars;

  /** This is the default constructor
    * defaults to 0 games
  */
  public Simulation(){
    m_numOfGames = 0;
  }

  /** This is an overloaded constructor
    * @param numOfGames int that represents how many games the user wants to simulate to
  */
  public Simulation(int numOfGames){
    m_numOfGames = numOfGames;
  }

  // Accessors
  /** This is an accessor method
    * @return returns the ArrayList of battle numbers
  */
  public ArrayList getBattlesList(){
    return m_BattlesList;
  }
  /** This is an accessor method
    * @return returns the ArrayList of war numbers
  */
  public ArrayList getWarsList(){
    return m_WarsList;
  }
  /** This is an accessor method
    * @return returns the ArrayList of double war numbers
  */
  public ArrayList getDoubleWarsList(){
    return m_DoubleWarsList;
  }
  /** This is an accessor method
    * @return returns grand total number of battles that occurred in the simulation
  */
  public int getGrandTotalBattles(){
    return m_GrandTotal_Battles;
  }
  /** This is an accessor method
    * @return returns the average number of battles that occurred in the simulation
  */
  public double getAvgNumBattles(){
    return m_avgNumBattles;
  }
  /** This is an accessor method
    * @return returns grand total number of wars that occurred in the simulation
  */
  public int getGrandTotalWars(){
    return m_GrandTotal_Wars;
  }
  /** This is an accessor method
    * @return returns the average number of wars that occurred in the simulation
  */
  public double getAvgNumWars(){
    return m_avgNumWars;
  }
  /** This is an accessor method
    * @return returns grand total number of double wars that occurred in the simulation
  */
  public int getGrandTotalDoubleWars(){
    return m_GrandTotal_DoubleWars;
  }
  /** This is an accessor method
    * @return returns the average number of double wars that occurred in the simulation
  */
  public double getAvgNumDoubleWars(){
    return m_avgNumDoubleWars;
  }
  /** This is an accessor method
    * @return returns the max number of battles that occurred in the simulation
  */
  public int getMaxNumBattles(){
    return m_maxNumBattles;
  }
  /** This is an accessor method
    * @return returns the min number of battles that occurred in the simulation
  */
  public int getMinNumBattles(){
    return m_minNumBattles;
  }
  /** This is an accessor method
    * @return returns the max number of wars that occurred in the simulation
  */
  public int getMaxNumWars(){
    return m_maxNumWars;
  }
  /** This is an accessor method
    * @return returns the min number of wars that occurred in the simulation
  */
  public int getMinNumWars(){
    return m_minNumWars;
  }

  // Mutators
  /** This is a mutator method
    * calculates and sets the average number of battles that occurred in the simulation
  */
  public void calculateAvgBattles(){
    for(int i = 0; i < m_numOfGames; ++i){
      m_GrandTotal_Battles += m_BattlesList.get(i);
    }
    m_avgNumBattles = ( (double)m_GrandTotal_Battles / (double)m_numOfGames );
  }
  /** This is a mutator method
    * calculates and sets the average number of wars that occurred in the simulation
  */
  public void calculateAvgWars(){
    for(int i = 0; i < m_numOfGames; ++i){
      m_GrandTotal_Wars += m_WarsList.get(i);
    }
    m_avgNumWars = ( (double)m_GrandTotal_Wars / (double)m_numOfGames );
  }
  /** This is a mutator method
    * calculates and sets the average number of double wars that occurred in the simulation
  */
  public void calculateAvgDoubleWars(){
    for(int i = 0; i < m_numOfGames; ++i){
      m_GrandTotal_DoubleWars += m_DoubleWarsList.get(i);
    }
    m_avgNumDoubleWars = ( (double)m_GrandTotal_DoubleWars / (double)m_numOfGames );
  }
  /** This is a mutator method
    * calculates and sets the max number of battles that occurred in the simulation
  */
  public void calculateMaxNumBattles(){
    m_maxNumBattles = Collections.max(m_BattlesList);
  }
  /** This is a mutator method
    * calculates and sets the min number of battles that occurred in the simulation
  */
  public void calculateMinNumBattles(){
    m_minNumBattles = Collections.min(m_BattlesList);
  }
  /** This is a mutator method
    * calculates and sets the max number of wars that occurred in the simulation
  */
  public void calculateMaxNumWars(){
    m_maxNumWars = Collections.max(m_WarsList);
  }
  /** This is a mutator method
    * calculates and sets the min number of wars that occurred in the simulation
  */
  public void calculateMinNumWars(){
    m_minNumWars = Collections.min(m_WarsList);
  }
  /** This is a mutator method
    * calculates every statistic calculation field
  */
  public void calculate(){
    this.calculateAvgBattles();
    this.calculateAvgWars();
    this.calculateAvgDoubleWars();
    this.calculateMaxNumBattles();
    this.calculateMinNumBattles();
    this.calculateMaxNumWars();
    this.calculateMinNumWars();
  }
  /** This is an accessor method
    * @return returns a nicely formatted String representation of statistics for the simulation
  */
  public String report(){
    String ret = "";
    ret += "Average Number of Battles per game: " + m_avgNumBattles;
    ret += "\nAverage Number of Wars per game: " + m_avgNumWars;
    ret += "\nAverage Number of Double Wars per game: " + m_avgNumDoubleWars;
    ret += "\nMaximum Number of Battles in a game: " + m_maxNumBattles;
    ret += "\nMinimum Number of Battles in a game: " + m_minNumBattles;
    ret += "\nMaximum Number of Wars in a game: " + m_maxNumWars;
    ret += "\nMinimum Number of Wars in a game: " + m_minNumWars;
    return ret;
  }
  /** This is a mutator method
    * this simulates the Simulation instance until all of the games are finished
  */
  public void simulate(){
    for(int i = 0; i < m_numOfGames; ++i){
      String winner;
      Game currentGame = new Game();
      winner = currentGame.play();
      // records the outcome of a game - use i + 1 to indicate which game number it is and winnerNum is the player who won (returned from play())
      if(winner.equals("P1")){
          WarLogger.getInstance().logGameOutcome(i + 1, WarLogger.P1);
      }
      else if(winner.equals("P2")){
        WarLogger.getInstance().logGameOutcome(i + 1, WarLogger.P2);
      }
      else{
        WarLogger.getInstance().logGameOutcome(i + 1, WarLogger.WAR);
      }
      // adds each statistics from each game to the respected ArrayList
      m_BattlesList.add(currentGame.getNumOfBattles());
      m_WarsList.add(currentGame.getNumOfWars());
      m_DoubleWarsList.add(currentGame.getNumOfDoubleWars());
    }
    // calculate average statistics after running all of the games
    this.calculate();
    // report the statistics
    System.out.println(this.report());
  }

  public static void main(String[] args){
    int n;
    String number = "";
    for(int i = 0; i < args.length; ++i){
      number += args[i];
    }
    n = Integer.parseInt(number);
    Simulation testSimulation = new Simulation(n);
    testSimulation.simulate();
    WarLogger.getInstance().release();
  }
}

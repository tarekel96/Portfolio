// Tarek El-Hajjaoui
// Student ID: 1902662
// Chapman Email: elhaj102@mail.chapman.edu
// Course Number & Section: CPSC 231-03
// Mastery Project 3: Javadoc

import java.util.Scanner;
/**
  * A class representing a student's class records.
  * @author Tarek El-Hajjaoui
  * @version 1.0
*/
public class StudentRecord{

  /**
    * The student's quiz one numeric score (out of 10 points).
  */
  private double quizOneScore;
  /**
    * The student's quiz two numeric score (out of 10 points).
  */
  private double quizTwoScore;
  /**
    * The student's quiz three numeric score (out of 10 points).
  */
  private double quizThreeScore;
  /**
    * The student's midterm numeric score (out of 100 points).
  */
  private double midtermScore;
  /**
    * The student's final exam numeric score (out of 100 points).
  */
  private double finalExamScore;
  /**
    * The student's overral numeric score (out of 100 points).
  */
  private double overallNumericScore;
  /**
    * The student's final letter grade (A, B, C, D, or F).
  */
  private String letterGrade;

  /**
    * Default constructor initializing all (private) fields to 0 or "".
  */
  public StudentRecord(){
    quizOneScore = 0.0;
    quizTwoScore = 0.0;
    quizThreeScore = 0.0;
    midtermScore = 0.0;
    finalExamScore = 0.0;
    overallNumericScore = 0.0;
    letterGrade = "";
  }

  /**
   * Overloaded constructor that accepts 5 arguments representing the fields.
   * Constructor assigns the fields for a Student instance to the respeced argument values.
   * @param quizOneScore points field for quiz one numeric score
   * @param quizTwoScore points field for quiz two numeric score
   * @param quizThreeScore points field for quiz three numeric score
   * @param midtermScore points field for midterm numeric score
   * @param finalExamScore points field for final exam numeric score
  */
  public StudentRecord(double quizOneScore, double quizTwoScore, double quizThreeScore, double midtermScore, double finalExamScore){
    this.quizOneScore = quizOneScore;
    this.quizTwoScore = quizTwoScore;
    this.quizThreeScore = quizThreeScore;
    this.midtermScore = midtermScore;
    this.finalExamScore = finalExamScore;
  }

  /**
   * Returns the quiz one numeric score.
   * @return an int value representing the quiz one numeric score in points (out of 10 points).
  */
  public double getQuizOneScore(){
    return this.quizOneScore;
  }

  /**
   * Returns the quiz two numeric score.
   * @return an int value representing the quiz two numeric score in points (out of 10 points).
  */
  public double getQuizTwoScore(){
    return this.quizTwoScore;
  }

  /**
   * Returns the quiz three numeric score.
   * @return an int value representing the quiz three numeric score in points (out of 10 points).
  */
  public double getQuizThreeScore(){
    return this.quizThreeScore;
  }

  /**
   * Returns the midterm numeric score.
   * @return an int value representing the midterm numeric score in points (out of 100 points).
  */
  public double getMidtermScore(){
    return this.midtermScore;
  }

  /**
   * Returns the final exam numeric score.
   * @return an int value representing the final exam numeric score in points (out of 100 points).
  */
  public double getFinalExamScore(){
    return this.finalExamScore;
  }

  /**
   * Returns the student's overall numeric score.
   * @return an int value representing the overall numeric score out of 100.
  */
  public double getOverallNumericScore(){
    return this.overallNumericScore;
  }

  /**
   * Returns the student's final letter grade.
   * @return a String value representing student's final letter grade (A, B, C, D, or F).
  */
  public String getLetterGrade(){
    return this.letterGrade;
  }

  /**
    * Sets the quizOneScore (field) to quizOneScore (parameter).
    * @param quizOneScore points for quizOneScore
 */
  public void setQuizOneScore(double quizOneScore){
    this.quizOneScore = quizOneScore;
  }

  /**
    * Sets the quizTwoScore (field) to quizTwoScore (parameter).
    * @param quizTwoScore points for quizTwoScore
 */
  public void setQuizTwoScore(double quizTwoScore){
    this.quizTwoScore = quizTwoScore;
  }

  /**
    * Sets the quizThreeScore (field) to quizThreeScore (parameter).
    * @param quizThreeScore points for quizThreeScore
 */
  public void setQuizThreeScore(double quizThreeScore){
    this.quizThreeScore = quizThreeScore;
  }

  /**
    * Sets the midtermScore (field) to midtermScore (parameter).
    * @param midtermScore points for midtermScore
 */
  public void setMidtermScore(double midtermScore){
    this.midtermScore = midtermScore;
  }

  /**
    * Sets the finalExamScore (field) to finalExamScore (parameter).
    * @param finalExamScore points for finalExamScore
 */
  public void setFinalExamScore(double finalExamScore){
    this.finalExamScore = finalExamScore;
  }

  /**
    * Sets the overallNumericScore (field) to overallNumericScore (parameter).
    * @param overallNumericScore points for overallNumericScore
 */
  public void setOverallNumericScore(double overallNumericScore){
    this.overallNumericScore = overallNumericScore;
  }

  /**
    * Sets the letterGrade (field) to letterGrade (parameter).
    * @param letterGrade points for letterGrade
 */
  public void setLetterGrade(String letterGrade){
    this.letterGrade = letterGrade;
  }


 /**
  * Computes and sets the overallNumericScore field (out of 100).
  * @return an int value representing the overallNumericScore in (out of 100).
 */
  public double computeNumericScore(){

    /**
     * The respected weight decimals for each academic category.
    */
    final double weightPercentQuizzes = 0.25;
    final double weightPercentMidterm = 0.35;
    final double weightPercentFinal = 0.40;

    /**
     * The raw percentages for each respected category represented in decimals
    */
    double overallQuizPercentage = ((quizOneScore + quizTwoScore + quizThreeScore) / 30);
    double overallMidtermPercentage = (midtermScore / 100);
    double overallFinalPercentage = (finalExamScore / 100);
    /**
     * sum the multiplication of each overall percentage category by its respected weight
    */
    double overallWeightedPercentage =  (overallQuizPercentage * weightPercentQuizzes) +  (overallMidtermPercentage * weightPercentMidterm) + (overallFinalPercentage  * weightPercentFinal);
    /**
     * @see StudentRecord#setOverallNumericScore()
     * invoke setOverallNumericScore to set the overallNumericScore for the student instance
    */
    this.setOverallNumericScore(overallWeightedPercentage * 100);
    return this.getOverallNumericScore();
  }

  /**
    * Computes and sets the letterGrade (either A, B, C, D, or F) for a student instance.
    * @return a String value representing the letterGrade in (A, B, C, D, or E).
  */
  public String computerLetterGrade(){
      if(this.overallNumericScore >= 90.0 && this.overallNumericScore < 100.0){
        letterGrade = "A";
      }
      else if(this.overallNumericScore >= 80.0 && this.overallNumericScore < 90.0){
      letterGrade = "B";
      }
      else if(this.overallNumericScore >= 70.0 && this.overallNumericScore < 80.0){
      letterGrade = "C";
      }
      else if(this.overallNumericScore >= 60.0 && this.overallNumericScore < 70.0){
      letterGrade = "D";
      }
      else if(this.overallNumericScore < 60.0 && this.overallNumericScore >= 0.0){
      letterGrade = "F";
      }
      /**
        * else statement only invokes if the numeric score is not within the range 0-100
      */
      else{
      System.out.println("Error calculating Letter Grade with Numeric Score");
      }
  return letterGrade;
}

/**
 * Prints out the fields for an instance of StudentRecord in a clean manner
*/
public String toString(){
  String ret;
  ret = "Quiz Score 1: " + quizOneScore;
  ret += "\nQuiz Score 2: " + quizTwoScore;
  ret += "\nQuiz Score 3: " + quizThreeScore;
  ret += "\nMidterm Exam Score: " + midtermScore;
  ret += "\nFinal Exam Score: " + finalExamScore;
  ret += "\nOverall Numeric Score: " + this.computeNumericScore();
  ret += "\nLetter Grade: " + this.computerLetterGrade();
  return ret;
}

/**
 * Overrides the default class method equals()
 * Determines whether or not an instance of StudentRecord has the same field values as a different instance of StudentRecord
*/
public boolean equals(Object o){
  StudentRecord s2 = (StudentRecord) o;
  /**
   * init to false because most likely the answer will be false
  */
  boolean isEqual = false;
  /**
   * only if every condition in this if statement is met, will isEqual be set to true
  */
  if(this.getQuizOneScore() == s2.getQuizOneScore() &&
  this.getQuizTwoScore() == s2.getQuizTwoScore() &&
  this.getQuizThreeScore() == s2.getQuizThreeScore() &&
  this.getMidtermScore() == s2.getMidtermScore() &&
  this.getFinalExamScore() == s2.getFinalExamScore())
  {
    isEqual = true;
  }
  return isEqual;
}

  /**
    * This program sets the quizzes, midterm, and final exam scores to hard-coded example values for two different instances of StudentRecord
    * program's main() method and is not meant to be instantiated.
    * @param args enables the use of Strings in main
    * @author Tarek El-Hajjaoui
    * @version 1.0
  */
  public static void main(String[] args){
    Scanner scnr = new Scanner(System.in);
    StudentRecord ExStudent = new StudentRecord(9, 7, 10, 85, 93);
    StudentRecord Tarek = new StudentRecord(8, 7.0, 7.0, 70.00, 70.00);
    System.out.println(ExStudent.toString());
    System.out.println(Tarek.toString());
    System.out.println(Tarek.equals(ExStudent));
    System.out.println(Tarek.equals(Tarek));
  }
}

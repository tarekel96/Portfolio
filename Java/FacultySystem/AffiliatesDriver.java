/** import Scanner for user input */
import java.util.Scanner;
/** import to use InputMismatchException to handle user input */
import java.util.InputMismatchException;
/** import HashMap and LinkedList Collection data structures */
import java.util.LinkedList;
import java.util.HashMap;
/** import to use sort method */
import java.util.Collections;
/** import for file error handling */
import java.io.IOException;
/** import File writing classes */
import java.io.PrintWriter;
import java.io.FileWriter;
/** import File reading classes */
import java.io.FileReader;
import java.io.BufferedReader;

/**
  * AffiliatesDriver class runs a university affiliate database system by utilizing the different Affiliate classes
  * @author Tarek El-Hajjaoui
  * @version 1.0.0
*/
public class AffiliatesDriver {

  /**
    * static method that displays the initial menu options
    * @return the initial menu options
  */
  public static String presentMenuOptions(){
    String ret = "Please enter a number to pick a choice:";
    ret += "\n1) Create an affiliate record";
    ret += "\n2) Print information for an Affiliate given the id";
    ret += "\n3) List all affiliates in order of seniority";
    ret += "\n4) Delete a record given the id";
    ret += "\n5) Save your database to a file";
    ret += "\n6) Restore your database from a file";
    ret += "\n7) Exit";
    return ret;
  }
  /**
    * static method that displays the create an affiliate menu options
    * @return the create an affiliate menu options
  */
  public static String presentCreateOptions(){
    String ret = "Please enter a number to pick a choice:";
    ret += "\n1) Faculty";
    ret += "\n2) Staff";
    ret += "\n3) Student";
    ret += "\n4) Cancel";
    return ret;
  }
  /**
    * static method that displays the create a faculty member menu options
    * @return the create a faculty member menu options
  */
  public static String presentFacultyOptions(){
    String ret = "Please enter a number to pick a choice:";
    ret += "\n1) Full Professor";
    ret += "\n2) Associate Professor";
    ret += "\n3) Assistant Professor";
    ret += "\n4) Cancel";
    return ret;
  }
  /**
    * static method that displays the create a staff member menu options
    * @return the create a staff member menu options
  */
  public static String presentStaffOptions(){
    String ret = "Please enter a number to pick a choice:";
    ret += "\n1) Full Time Staff Member";
    ret += "\n2) Part Time Staff Member";
    ret += "\n3) Cancel";
    return ret;
  }
  /**
    * static method that displays the create a student menu options
    * @return the create a student menu options
  */
  public static String presentStudentsOptions(){
    String ret = "Please enter a number to pick a choice:";
    ret += "\n1) Graduate Student";
    ret += "\n2) Undergraduate Student";
    ret += "\n3) Cancel";
    return ret;
  }
  /**
    * static method that displays general instructions for writing input
    * @return general instructions for writing input
  */
  public static String printWritingInstructions(){
    String ret = "***********Each field should have no spaces and the fields should be separated from each other with a single space***********";
    return ret;
  }
  /**
    * static method that checks if an id key already exists as a key in the HashMap parameter
    * @param hm the HashMap that is being checked
    * @param inputId the id that the method is looking for in the HashMap
    * @return true if the id already exists as a key in the HashMap and false otherwise
  */
  public static boolean checkIfIdExists(HashMap<Integer, Affiliates> hm, int inputId){
    boolean exists = false;
    exists = hm.containsKey(inputId);
    if(exists == true){
      System.out.println("***********The id " + inputId + " already exists.***********");
    }
    return exists;
  }
  /**
    * static method that finds an Affiliate in a HashMap and then prints the Affiliate's info
    * @param hm the HashMap where the Affiliate is stored
    * @param inputId the id of the Affiliate that is to be printed
    * @return the Affiliate's info
  */
  public static String printAffiliateById(HashMap<Integer, Affiliates> hm, int inputId){
    String ret = "";
    Affiliates af = hm.get(inputId);
    ret = af.print();
    return ret;
  }
  /**
    * static method that deletes an Affiliate in a HashMap and then prints a message that the Affiliate has been deleted from the HashMap
    * @param hm the HashMap where the Affiliate is stored
    * @param inputId the id of the Affiliate that is to be deleted
    * @return a message that the Affiliate has been deleted from the HashMap
  */
  public static String deleteAffiliateById(HashMap<Integer, Affiliates> hm, int inputId){
    String ret = "";
    hm.remove(inputId);
    ret += "Removed ID " + inputId + " from the Database.\n";
    return ret;
  }
  /**
    * static method that parses a field with a label of an Affiliate from an existing DB/input text file of Affiliates
    * @param word the field with the label
    * @return the field without the label and the blank spaces are trimed
  */
  public static String parseFieldsFromFile(String word){
    word = word.substring(word.lastIndexOf(":") + 1);
    word = word.trim();
    return word;
  }
  /**
    * static method that parses a line of FullProfessor fields with labels
    * @param currStrArray an array composed of a FullProfessor's fields with labels
    * @param DB the HashMap where the Affiliate instances are stored in
  */
  public static void parseFullProfessor(String[] currStrArray, HashMap<Integer, Affiliates> DB){
    String address = parseFieldsFromFile(currStrArray[1]);
    int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
    String department = parseFieldsFromFile(currStrArray[3]);
    int id = Integer.parseInt(parseFieldsFromFile(currStrArray[4]));
    String name = parseFieldsFromFile(currStrArray[5]);
    int numberOfPapers = Integer.parseInt(parseFieldsFromFile(currStrArray[6]));
    String phoneNumber = parseFieldsFromFile(currStrArray[7]);
    int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[8]));
    double yearlySalary = Double.parseDouble(parseFieldsFromFile(currStrArray[9]));
    int yearsUntilRetirement = Integer.parseInt(parseFieldsFromFile(currStrArray[10]));
    FullProfessor newFullProfessor = new FullProfessor(name, age, address, phoneNumber, yearBegan, id, department, yearlySalary, numberOfPapers, yearsUntilRetirement);
    DB.put(newFullProfessor.getId(), newFullProfessor);
  }
  /**
    * static method that parses a line of FullProfessor fields with labels
    * @param currStrArray an array composed of an AssociateProfessor's fields with labels
    * @param DB the HashMap where the Affiliate instances are stored in
  */
  public static void parseAssociateProfessor(String[] currStrArray, HashMap<Integer, Affiliates> DB){
    String address = parseFieldsFromFile(currStrArray[1]);
    int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
    String department = parseFieldsFromFile(currStrArray[3]);
    int id = Integer.parseInt(parseFieldsFromFile(currStrArray[4]));
    String name = parseFieldsFromFile(currStrArray[5]);
    int numberOfPapers = Integer.parseInt(parseFieldsFromFile(currStrArray[6]));
    String phoneNumber = parseFieldsFromFile(currStrArray[7]);
    int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[8]));
    double yearlySalary = Double.parseDouble(parseFieldsFromFile(currStrArray[9]));
    int yearsSinceTenure = Integer.parseInt(parseFieldsFromFile(currStrArray[10]));
    AssociateProfessor newAssociateProfessor = new AssociateProfessor(name, age, address, phoneNumber, yearBegan, id, department, yearlySalary, numberOfPapers, yearsSinceTenure);
    DB.put(newAssociateProfessor.getId(), newAssociateProfessor);
  }
  /**
    * static method that parses a line of AssistantProfessor fields with labels
    * @param currStrArray an array composed of an AssistantProfessor's fields with labels
    * @param DB the HashMap where the Affiliate instances are stored in
  */
  public static void parseAssistantProfessor(String[] currStrArray, HashMap<Integer, Affiliates> DB){
    String address = parseFieldsFromFile(currStrArray[1]);
    int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
    String department = parseFieldsFromFile(currStrArray[3]);
    int id = Integer.parseInt(parseFieldsFromFile(currStrArray[4]));
    String name = parseFieldsFromFile(currStrArray[5]);
    int numberOfPapers = Integer.parseInt(parseFieldsFromFile(currStrArray[6]));
    String phoneNumber = parseFieldsFromFile(currStrArray[7]);
    int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[8]));
    double yearlySalary = Double.parseDouble(parseFieldsFromFile(currStrArray[9]));
    int yearsUntilTenure = Integer.parseInt(parseFieldsFromFile(currStrArray[10]));
    AssistantProfessor newAssistantProfessor = new AssistantProfessor(name, age, address, phoneNumber, yearBegan, id, department, yearlySalary, numberOfPapers, yearsUntilTenure);
    DB.put(newAssistantProfessor.getId(), newAssistantProfessor);
  }
  /**
    * static method that parses a line of FullTimeStaff fields with labels
    * @param currStrArray an array composed of an FullTimeStaff member's fields with labels
    * @param DB the HashMap where the Affiliate instances are stored in
  */
  public static void parseFullTimeStaff(String[] currStrArray, HashMap<Integer, Affiliates> DB){
    String address = parseFieldsFromFile(currStrArray[1]);
    int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
    String building = parseFieldsFromFile(currStrArray[3]);
    double yearlySalary = Double.parseDouble(parseFieldsFromFile(currStrArray[4]));
    String name = parseFieldsFromFile(currStrArray[5]);
    String phoneNumber = parseFieldsFromFile(currStrArray[6]);
    int id = Integer.parseInt(parseFieldsFromFile(currStrArray[7]));
    String title = parseFieldsFromFile(currStrArray[8]);
    int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[9]));
    FullTimeStaff newFullTimeStaff = new FullTimeStaff(name, age, address, phoneNumber, yearBegan, id, title, building, yearlySalary);
    DB.put(newFullTimeStaff.getId(), newFullTimeStaff);
  }
  /**
    * static method that parses a line of PartTimeStaff fields with labels
    * @param currStrArray an array composed of an PartTimeStaff member's fields with labels
    * @param DB the HashMap where the Affiliate instances are stored in
  */
  public static void parsePartTimeStaff(String[] currStrArray, HashMap<Integer, Affiliates> DB){
    String address = parseFieldsFromFile(currStrArray[1]);
    int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
    String building = parseFieldsFromFile(currStrArray[3]);
    String name = parseFieldsFromFile(currStrArray[4]);
    double hourlySalary = Double.parseDouble(parseFieldsFromFile(currStrArray[5]));
    String phoneNumber = parseFieldsFromFile(currStrArray[6]);
    int id = Integer.parseInt(parseFieldsFromFile(currStrArray[7]));
    String title = parseFieldsFromFile(currStrArray[8]);
    int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[9]));
    PartTimeStaff newPartTimeStaff = new PartTimeStaff(name, age, address, phoneNumber, yearBegan, id, title, building, hourlySalary);
    DB.put(newPartTimeStaff.getId(), newPartTimeStaff);
  }
  /**
    * static method that parses a line of a Graduate Student fields with labels
    * @param currStrArray an array composed of a Graduate Student's fields with labels
    * @param DB the HashMap where the Affiliate instances are stored in
  */
  public static void parseGraduateStudent(String[] currStrArray, HashMap<Integer, Affiliates> DB){
    String address = parseFieldsFromFile(currStrArray[1]);
    int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
    String classStanding = parseFieldsFromFile(currStrArray[3]);
    String major = parseFieldsFromFile(currStrArray[4]);
    String minor = parseFieldsFromFile(currStrArray[5]);
    String name = parseFieldsFromFile(currStrArray[6]);
    int numberOfPapersPublished = Integer.parseInt(parseFieldsFromFile(currStrArray[7]));
    String phoneNumber = parseFieldsFromFile(currStrArray[8]);
    int id = Integer.parseInt(parseFieldsFromFile(currStrArray[9]));
    String thesisAdvisor = parseFieldsFromFile(currStrArray[10]);
    int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[11]));
    GraduateStudents newGraduateStudent = new GraduateStudents(name, age, address, phoneNumber, yearBegan, id, major, minor, classStanding, numberOfPapersPublished, thesisAdvisor);
    DB.put(newGraduateStudent.getId(), newGraduateStudent);
  }
  /**
    * static method that parses a line of an Undergraduate Student fields with labels
    * @param currStrArray an array composed of an Undergraduate Student's fields with labels
    * @param DB the HashMap where the Affiliate instances are stored in
  */
  public static void parseUndergraduateStudent(String[] currStrArray, HashMap<Integer, Affiliates> DB){
    String address = parseFieldsFromFile(currStrArray[1]);
    int age = Integer.parseInt(parseFieldsFromFile(currStrArray[2]));
    String classStanding = parseFieldsFromFile(currStrArray[3]);
    String major = parseFieldsFromFile(currStrArray[4]);
    String minor = parseFieldsFromFile(currStrArray[5]);
    String name = parseFieldsFromFile(currStrArray[6]);
    int numberOfCourses = Integer.parseInt(parseFieldsFromFile(currStrArray[7]));
    String phoneNumber = parseFieldsFromFile(currStrArray[8]);
    Double scholarshipAmount = Double.parseDouble(parseFieldsFromFile(currStrArray[9]));
    int id = Integer.parseInt(parseFieldsFromFile(currStrArray[10]));
    int yearBegan = Integer.parseInt(parseFieldsFromFile(currStrArray[11]));
    UnderGraduateStudents newUndergraduateStudent = new UnderGraduateStudents(name, age, address, phoneNumber, yearBegan, id, major, minor, classStanding, numberOfCourses, scholarshipAmount);
    DB.put(newUndergraduateStudent.getId(), newUndergraduateStudent);
  }
  /**
    * static method that displays an error message that explains why the program crashed when a user provides an invalid input
  */
  public static void inputMismatchMessage(){
    System.out.print("Error: invalid input, please follow input instructions.");
  }
  /**
    * static main method where the Driver is run
    * @param args command line arguments
  */
  public static void main(String[] args){
    // instantiate scnr instance
    Scanner scnr = new Scanner(System.in);
    // instantiate DB HashMap instance
    HashMap<Integer, Affiliates> DB = new HashMap<Integer, Affiliates>();
    // menuOption is the user's response to the main menu choices
    int menuOption = 0;
    // try, catch - looks for an InputMismatchException error
    try{
      // the Driver will keep executing until the user picks menu option 7
      while(menuOption != 7){
        System.out.println(presentMenuOptions());
        menuOption = scnr.nextInt();
        // ****Main Menu Option 1 - this path is taken if the user desires to create a new affiliate in the database****
        if(menuOption == 1){
          // createOption is the user's response to the create menu choices
          int createOption = 0;
          System.out.println(presentCreateOptions());
          createOption = scnr.nextInt();
          // program returns to main menu
          if(createOption == 4){
            continue;
          }
          else {
            // variables are used in all affiliates
            String name;
            int age;
            String address;
            String phoneNumber;
            int yearBegan;
            int id;
            // display input instructions
            System.out.println(printWritingInstructions());
            System.out.println("Enter the following in the precise order: Name, Age, Address, Phone Number, Year Began");
            name = scnr.next();
            age = scnr.nextInt();
            address = scnr.next();
            phoneNumber = scnr.next();
            yearBegan = scnr.nextInt();
            // checks if the id already exists in the Database - loop continues until a valid id is provided
            while(true){
              System.out.println("Enter an id");
              id = scnr.nextInt();
              if(checkIfIdExists(DB, id) == true){
                System.out.println("The id: " + id + " already exists.");
                System.out.println("Please enter a different id");
              }
              else if((checkIfIdExists(DB, id) == false)) {
                System.out.println("The id: " + id + " is valid.");
                break;
              }
            }
            // path a user is taken for creating a faculty member
            if(createOption == 1){
              System.out.println("Creating a new Faculty Member...");
              String department;
              double yearlySalary;
              int numberOfPapers;
              int facultyOption;
              // display input instructions
              System.out.println(printWritingInstructions());
              System.out.println("Enter the following in the precise order: Department, Yearly Salary (decimals are accepted), Number of Papers.");
              department = scnr.next();
              yearlySalary = scnr.nextDouble();
              numberOfPapers = scnr.nextInt();
              // display Faculty input instructions
              System.out.println(presentFacultyOptions());
              facultyOption = scnr.nextInt();
              // path a user is taken to create a full professor
              if(facultyOption == 1){
                System.out.println("Creating a new Full Professor...");
                System.out.println("Enter the amount years until retirement for " + name + ":");
                int yearsUntilRetirement;
                yearsUntilRetirement = scnr.nextInt();
                FullProfessor newFP = new FullProfessor(name, age, address, phoneNumber, yearBegan, id, department, yearlySalary, numberOfPapers, yearsUntilRetirement);
                // adds the new FullProfessor to the DB and displays a success message
                DB.put(newFP.getId(), newFP);
                System.out.println("Success: added an Full Professor to the database.");
                System.out.println("Full Professor info:\n" + newFP.print());
                System.out.println();
              }
              // path a user is taken to create an associate professor
              else if(facultyOption == 2){
                System.out.println("Creating a new Associate Professor...");
                System.out.println("Enter the amount years since tenure for " + name + ":");
                int yearsSinceTenure;
                yearsSinceTenure = scnr.nextInt();
                AssociateProfessor newAP = new AssociateProfessor(name, age, address, phoneNumber, yearBegan, id, department, yearlySalary, numberOfPapers, yearsSinceTenure);
                // adds the new AssociateProfessor to the DB and displays a success message
                DB.put(newAP.getId(), newAP);
                System.out.println("Success: added an Associate Professor to the database.");
                System.out.println("Associate Professor info:\n" + newAP.print());
                System.out.println();
              }
              // path a user is taken to create an assistant professor
              else if(facultyOption == 3){
                System.out.println("Creating a new Assistant Professor...");
                System.out.println("Enter the amount years until tenure for " + name + ":");
                int yearsUntilTenure;
                yearsUntilTenure = scnr.nextInt();
                AssistantProfessor newAP = new AssistantProfessor(name, age, address, phoneNumber, yearBegan, id, department, yearlySalary, numberOfPapers, yearsUntilTenure);
                // adds the new AssociateProfessor to the DB and displays a success message
                DB.put(newAP.getId(), newAP);
                System.out.println("Success: added an Assistant Professor to the database.");
                System.out.println("Assistant Professor info:\n" + newAP.print());
                System.out.println();
              }
              // program returns to main menu
              else if(facultyOption == 4) {
                System.out.println("Returning to main menu...");
                continue;
              }
              // program crashes for any other input and error messages are displayed
              else {
                System.out.println("Error: invalid input, input did not match choices 1 - 4. Please follow input instructions.");
                System.out.println("Returning to main menu...");
                System.out.println();
                continue;
              }
            }
            else if(createOption == 2){
              System.out.println("In process of creating a Staff Member...");
              String title;
              String building;
              int staffOption;
              // display Staff input instructions
              System.out.println(printWritingInstructions());
              System.out.println("Enter the following in the precise order: Title, Building");
              title = scnr.next();
              building = scnr.next();
              System.out.println(presentStaffOptions());
              staffOption = scnr.nextInt();
              // path a user taken if decide to create a full time staff member
              if(staffOption == 1){
                System.out.println("Creating a new Full Time Staff Member...");
                System.out.println("Enter the yearly salary (decimals are accepted) for " + name + ":");
                double yearlySalary;
                yearlySalary = scnr.nextDouble();
                FullTimeStaff newFTS = new FullTimeStaff(name, age, address, phoneNumber, yearBegan, id, title, building, yearlySalary);
                DB.put(newFTS.getId(),newFTS);
                System.out.println("Success: added a Full Time Staff member to the database.");
                System.out.println("Full Time Staff Member info:" + newFTS.print());
                System.out.println();
              }
              // path a user taken if decide to create a part time staff member
              else if(staffOption == 2){
                System.out.println("Creating a new Part Time Staff Member...");
                System.out.println("Enter the hourly salary (decimals are accepted) for " + name + ":");
                double hourlySalary;
                hourlySalary = scnr.nextDouble();
                PartTimeStaff newPTS = new PartTimeStaff(name, age, address, phoneNumber, yearBegan, id, title, building, hourlySalary);
                DB.put(newPTS.getId(),newPTS);
                System.out.println("Success: added a Part Time Staff member to the database.");
                System.out.println("Part Time Staff Member info:\n" + newPTS.print());
                System.out.println();
              }
              // program returns to main menu
              else if(staffOption == 3) {
                System.out.println("Returning to main menu...");
                continue;
              }
              // program terminates if chose wrong input
              else {
                System.out.println("Error: invalid input, input did not match choices 1 - 3. Please follow input instructions.");
                System.out.println("Terminating Program");
                System.out.println();
                break;
              }
            }
            else if(createOption == 3){
              System.out.println("In process of creating a Student...");
              String major;
              String minor;
              String classStanding;
              int studentOption;
              // display Student input instructions
              System.out.println(printWritingInstructions());
              System.out.println("Enter the following in the precise order: Major, Minor, Class Standing");
              major = scnr.next();
              minor = scnr.next();
              classStanding = scnr.next();
              System.out.println(presentStudentsOptions());
              studentOption = scnr.nextInt();
              // path a user is taken to create a graduate student
              if(studentOption == 1){
                System.out.println("Creating a new Graduate Student...");
                System.out.println("Enter the number of papers published followed by (with a space in between) the name of the thesis advisor for: " + name);
                int numberOfPapersPublished;
                String thesisAdvisor;
                numberOfPapersPublished = scnr.nextInt();
                thesisAdvisor = scnr.next();
                GraduateStudents newGS = new GraduateStudents(name, age, address, phoneNumber, yearBegan, id, major, minor, classStanding, numberOfPapersPublished, thesisAdvisor);
                DB.put(newGS.getId(),newGS);
                System.out.println("Success: added a Graduate Student to the database.");
                System.out.println("Graduate Student info:\n" + newGS.print());
                System.out.println();
              }
              // path a user is taken to create an undergraduate student
              else if(studentOption == 2){
                System.out.println("Creating a new Undergraduate Student...");
                System.out.println("Enter the number of courses taken followed by (with a space in between) the scholarship amount (decimals are accepted) for " + name + " :");
                int numberOfCourses;
                double scholarshipAmount;
                numberOfCourses = scnr.nextInt();
                scholarshipAmount = scnr.nextDouble();
                UnderGraduateStudents newUGS = new UnderGraduateStudents(name, age, address, phoneNumber, yearBegan, id, major, minor, classStanding, numberOfCourses, scholarshipAmount);
                DB.put(newUGS.getId(),newUGS);
                System.out.println(DB.get(newUGS.getId()));
                System.out.println("Success: added an Undergraduate Student to the database.");
                System.out.println("Undergraduate Student info:\n" + newUGS.print());
                System.out.println();
              }
              // program returns to main menu
              else if(studentOption == 3) {
                System.out.println("Returning to main menu...");
                continue;
              }
              // program terminates if chose wrong input
              else {
                System.out.println("Error: invalid input, input did not match choices 1 - 3. Please follow input instructions.");
                System.out.println("Terminating Program");
                System.out.println();
                break;
                }
              }
          }
        }
        // ****Main Menu Option 2 - this path is taken if the user desires to search for an affiliate by id****
        else if(menuOption == 2){
          int inputId = 0;
          System.out.println("Enter the id of the Affiliate");
          inputId = scnr.nextInt();
          System.out.println("Searching Database...");
          // checks if the affiliate exists in the database if
          if(checkIfIdExists(DB, inputId) == false){
            System.out.println("*********The id does not exist.*********");
          }
          else {
            System.out.println(printAffiliateById(DB, inputId));
          }
          System.out.println();
        }
        // ****Main Menu Option 3 - this path is taken if user desires to view a list every user from the database****
        else if(menuOption == 3){
          // LinkedList where the Affiliates are stored in and later sorted
          LinkedList<Affiliates> LL = new LinkedList<Affiliates>();
          // maps out the Affiliate instances from the HashMap onto a LinkedList
          DB.forEach((key, value) -> LL.add(value));
          // sorts the Affiliates by the compareTo() method that was overrided to sort Affiliates by yearBegan
          Collections.sort(LL);
          System.out.println("*********Organized in order of seniority (year began at Chapman)*********");
          // prints out each Affiliate from the database in order of seniority
          for(Affiliates a: LL){
            System.out.println("\n" + a.print() + "\n");
          }
          System.out.println("^^^^^^^Organized in order of seniority (year began at Chapman)^^^^^^^");
          System.out.println();
        }
        // ****Main Menu Option 4 - this path is taken if user desires to delete an affiliate from the database****
        else if(menuOption == 4){
          int inputId = 0;
          System.out.println("Enter the id of the Affiliate you wish to delete");
          inputId = scnr.nextInt();
          System.out.println("Searching Database...");
          // first checks if the affiliate exists by looking for the id (key) in the DB HashMap
          if(checkIfIdExists(DB, inputId) == false){
            System.out.println("*********The id does not exist.*********");
          }
          else {
            // deletes affiliate from DB
            System.out.println(deleteAffiliateById(DB, inputId));
          }
          System.out.println();
        }
        // ****Main Menu Option 5 - this path is taken if user desires to save the DB in the text file****
        else if(menuOption == 5){
          // try, catch - looks for an IOException error
          try {
            // prompts user to enter the name of the file where the database will be saved
            System.out.println("Enter the name of the file (no .txt) where you would like to save the Database.");
            String fileName = scnr.next() + ".txt";
            PrintWriter pw = new PrintWriter(new FileWriter(fileName, true));
            // forEach iteriates through the HashMap DB to map out the affiliates into the file
            DB.forEach((key,value) -> {
              pw.println(value.getClassType() + ", " + value.printAlphabetically(value.orderAlphabetically()));
            });
            pw.close();
            System.out.println("SUCCESS: Added database to file: " + fileName + ".txt");
          }
          catch(IOException error){
            System.out.println("ERROR: error in writing to a file.");
            error.printStackTrace();
          }
        }
        // ****Main Menu Option 6 - this path is taken if user desires to take Affiliate input data from a file****
        else if(menuOption == 6){
          // try, catch - looks for an IOException error
          try {
            // prompts user to enter the name of the file where the affiliate data is taken from
            System.out.println("Enter the name of the file (no .txt) that has the Affiliates you would like to add to the Database.");
            String fileName = scnr.next() + ".txt";
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            // LinkedList that holds arrays of Strings
            LinkedList<String[]> fileData = new LinkedList<String[]>();
            // each line is stored in variable named line during the loop
            for(String line = br.readLine(); line != null; line = br.readLine()){
              // count the comas in order to know precisely how big each array should be
              int comaCounter = 0;
              for(int j = 0; j < line.length(); ++j){
                if(line.charAt(j) == ','){
                  comaCounter += 1;
                }
              }
              String[] lineArray = new String[comaCounter + 1]; // add 1 because each line does not end with a coma (do not want to miss the last element)
              lineArray = line.split(","); // turns each line of Strings into an array of Strings - elements are split by a ','
              fileData.add(lineArray);
            }
            for(int i = 0; i < fileData.size(); ++i){
              // currStrArray is the String array that i is currently on of the fileData LinkedList
              String[] currStrArray = fileData.get(i);
              // the first word of each array of strings is always the class type
              String classType = currStrArray[0];
              if(classType.equals("Full Professor")){
                parseFullProfessor(currStrArray, DB);
              }
              else if(classType.equals("Associate Professor")){
                parseAssociateProfessor(currStrArray, DB);
              }
              else if(classType.equals("Assistant Professor")){
                parseAssistantProfessor(currStrArray, DB);
              }
              else if(classType.equals("Full Time Staff")){
                parseFullTimeStaff(currStrArray, DB);
              }
              else if(classType.equals("Part Time Staff")){
                parsePartTimeStaff(currStrArray, DB);
              }
              else if(classType.equals("Graduate Student")){
                parseGraduateStudent(currStrArray, DB);
              }
              else if(classType.equals("Undergraduate Student")){
                parseUndergraduateStudent(currStrArray, DB);
              }
              // error message is thrown if the first element does not match any affiliate class type
              else{
                System.out.println("Error: did not recognize class type for " + classType);
                System.out.println("Data may be incorrectly formatted in " + fileName);
              }
            }
            br.close();
            System.out.println("Success: Added data from file " + fileName + " to database.");
          }
          catch(IOException error){
            System.out.println("Error: an error occurred in reading from the file.");
            error.printStackTrace();
          }
          System.out.println();
        }
        // this error message is displayed if user input an invalid response,
        else {
          System.out.println("Error: invalid input, input did not match choices 1 - 7. Please follow input instructions.");
          System.out.println("Terminating Program");
          System.out.println();
          break;
        }
      }
    }
    catch(InputMismatchException error){
      inputMismatchMessage();
      System.out.println();
      error.printStackTrace();
    }
  }
}

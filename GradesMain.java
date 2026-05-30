// Import Declarations
import java.util.Scanner; // Import the Scanner class
import java.util.ArrayList; // Import the ArrayList class
import java.util.Random; // import random class



/**
 * Title:
 *  MyEd Grade Analyzer
 *
 * Program Summary:
 *  Allows the user to edit, modify, and view a class's grades in a number of ways
 * 
 *
 * Program Element List:
 * - ArrayList.sort (in ClassGrades)
 * - lambda expression (in ClassGrades)
 * - loop label (in ConsoleUserInput)
 * - for loop
 * - enhanced for loop (in ClassGrades)
 * - while/do-while loop
 * - switch case
 * - String.repeat (in MyUtility)
 * - try-catch
 * - Random.nextInt()
 * - helper classes (MyUtility, ConsoleUserInput, ClassGrades)
 *
 * @author Dryden || Solo
 * 
 * @version 1.5
 * 
 * @date 2026-05-29
 * 
 */
public class GradesMain {;
    // Beginning of Program || Primary Class "GradesMain"
    // Global & Instance variables
    
    
    
    
    
    
    /**
     * Constructor for objects of class GradesMain
     * Creates a new GradesMain object
     * 
     * @param     None
     */
    public GradesMain(){ // Beginning of Constructor
        
    } // End of Constructor
    
    
    
    
    
    /**
     * Manages the functionality for adding a new grade to the class
     * 
     * @param ClassGrades classToAddTo
     * @return None
     */
    static void handleAddCommand(ClassGrades classToAddTo) {
        Scanner intInputScanner = new Scanner(System.in);
        String inputLine;
        int newGrade;
        
        
        while (true) { // break when valid number given
            System.out.print("\nEnter 'cancel' to cancel\nEnter new grade value (whole number, 0-100): ");
            
            try {
                inputLine = intInputScanner.nextLine().trim();
                if (inputLine.equalsIgnoreCase("cancel")) {
                    System.out.println("\nAddition cancelled.");
                    return;
                } // End of if
                
                newGrade = Integer.parseInt(inputLine.replace("%", "")); // get int, remove "%" from input
                
                if (newGrade < 0) {
                    System.out.println("Grade must be between 0 and 100, try again.");
                } else if (newGrade > 100) {
                    System.out.println("Grade must be between 0 and 100, try again.");
                } else { // input must be valid
                    break;
                } // End of else-if
                
                
            } catch (NumberFormatException numberE){
                System.out.println("Invalid integer, try again.");
            } // End of try-catch
        } // End of while loop
        
        
        intInputScanner.close();
        
        classToAddTo.addGrade(newGrade);
        System.out.println("\nGrade added: " + newGrade + "%");
    } // End of handleAddCommand
    
    
    
    
    
    /**
     * Manages the functionality for removing a grade from the class
     * 
     * @param ClassGrades classToRandomize
     * @return None
     */
    static void handleRemoveCommand(ClassGrades classToRemoveFrom) {
        Scanner intInputScanner = new Scanner(System.in);
        String inputLine;
        int gradeListSize = classToRemoveFrom.numberOfGrades();
        int indexToRemove; // actually the index + 1
        int previousGrade;
        
        
        classToRemoveFrom.logNumberedGrades();
        
        if (gradeListSize == 0) {
            System.out.println("\nNo grades to remove.");
            return;
        } // End of if
        

        while (true) { // break when valid number given
            System.out.print("\nEnter 'cancel' to cancel\nEnter the ordered number of the grade you want to remove (not the grade itself): ");
            
            try {
                inputLine = intInputScanner.nextLine().trim();
                if (inputLine.equalsIgnoreCase("cancel")) {
                    System.out.println("\nRemoval cancelled.");
                    return;
                } // End of if
                
                indexToRemove = Integer.parseInt(inputLine);
                
                if (indexToRemove < 1) {
                    System.out.println("Selection must be between 1 and " + gradeListSize + ", try again.");
                } else if (indexToRemove > gradeListSize) {
                    System.out.println("Selection must be between 1 and " + gradeListSize + ", try again.");
                } else { // input must be valid
                    break;
                } // End of else-if
                
                
            } catch (NumberFormatException numberE){
                System.out.println("Invalid integer, try again.");
            } // End of try-catch
        } // End of while loop
        
        
        intInputScanner.close();
        
        previousGrade = classToRemoveFrom.getGradeAtIndex(indexToRemove - 1);
        classToRemoveFrom.removeGrade(indexToRemove - 1);
        System.out.println("\nRemoved grade number " + indexToRemove + ": " + previousGrade + "%");
    } // End of handleRemoveCommand
    
    
    
    
    
    /**
     * Manages the functionality for adding random grades to the class
     * 
     * @param ClassGrades classToRandomize
     * @return None
     */
    static void handleRandomCommand(ClassGrades classToRandomize) {
        Scanner intInputScanner = new Scanner(System.in);
        Random currentRandom = new Random();
        String inputLine;
        int numberOfGradesToAdd;
        

        while (true) { // break when valid number given
            System.out.print("\nEnter 'cancel' to cancel\nEnter number of grades to add: ");
            
            try {
                inputLine = intInputScanner.nextLine().trim();
                if (inputLine.equalsIgnoreCase("cancel")) {
                    System.out.println("\nRemoval cancelled.");
                    return;
                } // End of if
                
                numberOfGradesToAdd = Integer.parseInt(inputLine);
                
                if (numberOfGradesToAdd < 0) {
                    System.out.println("Number of new grades must be between 0 and 10, try again.");
                } else if (numberOfGradesToAdd > 10) {
                    System.out.println("Number of new grades must be between 0 and 10, try again.");
                } else { // input must be valid
                    break;
                } // End of else-if
                
                
            } catch (NumberFormatException numberE){
                System.out.println("Invalid integer, try again.");
            } // End of try-catch
        } // End of while loop
        
        intInputScanner.close();
        

        for (int i = 0; i < numberOfGradesToAdd; i++) {
            classToRandomize.addGrade(currentRandom.nextInt(101)); // nextInt is max exclusive, so 100 is the max if 101 is passed
        } // End of for loop
        
        
        System.out.println("\nPopulated class with " + numberOfGradesToAdd + " random grades!");
    } // End of handleRandomCommand
    
    
    
    
    
    /**
     * Manages the functionality for getting the average grade of the class
     * 
     * @param ClassGrades classToAverage
     * @return None
     */
    static void handleAverageCommand(ClassGrades classToAverage) {
        
        if (classToAverage.numberOfGrades() == 0) {
            System.out.println("\nNo grades available to average.");
            return;
        } // End of if
        
        
        System.out.println("\nThe class average is: " + classToAverage.getAverage() + "%");
    } // End of handleAverageCommand
    
    
    
    
    
    /**
     * Prints an ascii art title to the console
     * 
     * @param None
     * @return None
     */
    public static void logTitle() { // Beginning of logTitle
        MyUtility.printInBox("""
  __  __       ______    _    _____      _                 _   __  __            _        
 |  \\/  |     |  ____|  | |  / ____|    | |               | | |  \\/  |          | |       
 | \\  / |_   _| |__   __| | | (___   ___| |__   ___   ___ | | | \\  / | __ _ _ __| | _____ 
 | |\\/| | | | |  __| / _` |  \\___ \\ / __| '_ \\ / _ \\ / _ \\| | | |\\/| |/ _` | '__| |/ / __|
 | |  | | |_| | |___| (_| |  ____) | (__| | | | (_) | (_) | | | |  | | (_| | |  |   <\\__ \\
 |_|  |_|\\__, |______\\__,_| |_____/ \\___|_| |_|\\___/ \\___/|_| |_|  |_|\\__,_|_|  |_|\\_\\___/
          __/ |                                                                           
         |___/                                                                            """, 2, 0, 1);
    } // End of logTitle
    
    
    
    
    
    /**
     * Prints a welcome message to the console
     * 
     * @param None
     * @return None
     */
    public static void logWelcome() { // Beginning of logWelcome
        System.out.println("""
        Welcome to the MyEd Grade Analyzer!
        Educational insights await you!""");
    } // End of logWelcome
    
    
    
    
    
    /**
     * Prints an introductory message to the console
     * 
     * @param None
     * @return None
     */
    public static void logIntro() { // Beginning of logIntro
        System.out.println("""
        It's important to learn about your students and 
        be able to see how they perform.
        With the MyEd Grade Analyzer, get real statistics and insights
        into your students' learning, understanding, and performance.""");
    } // End of logIntro
    
    
    
    
    
    /**
     * Prints an explanatory message to the console
     * 
     * @param None
     * @return None
     */
    public static void logExplanation() { // Beginning of logExplanation
        System.out.println("""
        To use the program, enter the corresponding
        number or word to execute a command.
        
        Use the help command to see more about each option.
        
        Use the refresh command after making changes in the JFrame visual
        
        When removing grades, use the number in brackets
        and not the percent grade value.""");
    } // End of logExplanation
    
    
    
    
    
    /**
     * Prints a thank you message to the console
     * 
     * @param   None
     * @return  None
     */
    public static void logThanks() { // Beginning of logThanks
        System.out.println("""
        Thank you for using the MyEd Grade Analyzer!
        We hope we have helped you greatly in
        your educational endeavours.
        Come again!""");
    } // End of logThanks
    
    
    
    
    
    /**
     * A visual separator for console UI/UX
     * 
     * @param None
     * @return None
     */
    public static void horizontalLine() {
        System.out.println("\n--------------------------------------------------------\n");
    } // End of horizontalLine
    
    
    
    
    
    /**
     * Separates different sections of the UI/UX by clearing the console and printing the title
     * 
     * @param ClassGrades sectionClassGrades
     * @param boolean showSectionGradeList
     * @return None
     */
    public static void newSection(ClassGrades sectionClassGrades, boolean showSectionGradeList) {
        clearConsole();
        logTitle();
        
        if ((sectionClassGrades != null) && showSectionGradeList) {
            sectionClassGrades.logGrades();
        } // End of if
    } // End of newSection
    
    
    
    
    
    /**
     * Waits for the user to press return to continue to next section
     * 
     * @param ClassGrades sectionClassGrades
     * @param boolean showSectionGradeList
     * @return None
     */
    public static void waitNextSection(ClassGrades sectionClassGrades, boolean showSectionGradeList) { // Method for clearing console
        Scanner waitScanner = new Scanner(System.in);
        
        System.out.print("\n\nPress RETURN to continue");
        
        waitScanner.nextLine(); // Wait for user to press RETURN
        waitScanner.close();
        
        newSection(sectionClassGrades, showSectionGradeList);
    } // End of clearConsole
    
    
    
    
    
    /**
     * Clears the text in the console.
     * 
     * @param None
     * @return None
     */
    public static void clearConsole() { // Method for clearing console
        System.out.print("\f"); // Try: "\f" "\u000C" or "\033[H\033[2J"
        System.out.flush();
    } // End of clearConsole
    
    
    
    
    
    /**
     * Main - General Point of Entry for the Program
     * An example of a main method - this is the main part of the program that has the bulk of the code
     * Any comment put here will be added to the user interface when it program is run
     *
     * @param     Generic Statement --> All Values & Strings Allowed
     * @return    None
     */
    public static void main(String[] args) throws InterruptedException { // Beginning of Main
        // main Variable Declarations
        // JFRAME
        
        ClassGrades mainClassGrades = new ClassGrades();
        
        final String[] mainCommands = {
            "add - Add a new grade",
            "remove - Remove a grade",
            "random - Adds a number of random grades",
            "sort - Sorts all grades in descending order",
            "average - Get the average (mean) of all grades",
            "clear - Remove all grades",
            "list - Toggle grade list visibility",
            "refresh - Refresh the console, usually after JFrame changes",
            "help - Toggle command descriptions", 
            "exit - Exit the program"
        };
        int selectionIndex;
        String commandSelection;
        boolean runCommandLoop = true;
        boolean showDescriptions = false;
        boolean showList = true;
        
        
    

        // Beginning of UI/UX
        clearConsole(); // new section without loan UI
        logTitle();
        System.out.println("\n");
        
        logWelcome();
        horizontalLine();
        logIntro();
        horizontalLine();
        logExplanation();
        
        
        
        waitNextSection(mainClassGrades, showList);
        
                
        do { // while (runCommandLoop)
            
            commandSelection = ConsoleUserInput.selectFromOptions("Select an option:", "Commands", mainCommands, false, showDescriptions);
            
            newSection(null, false); // do not show list here, not necessary
            
            System.out.println("Command Entered: " + commandSelection);
            
            
            switch (commandSelection) {
                
                case "add":
                    handleAddCommand(mainClassGrades);
                    break;                    
                
                case "remove":
                    handleRemoveCommand(mainClassGrades);
                    break;
                    
                case "random":
                    handleRandomCommand(mainClassGrades);
                    break;
                    
                case "sort":
                    mainClassGrades.sortGrades();
                    System.out.println("\nGrades successfully sorted!");
                    break;
                    
                case "average":
                    handleAverageCommand(mainClassGrades);
                    break;
                
                case "clear":
                    mainClassGrades.removeAllGrades();
                    System.out.println("\nAll grades removed!");
                    break;
                
                case "list":
                    showList = !showList;
                    break;
                    
                case "refresh":
                    newSection(mainClassGrades, showList); // force new section without waiting
                    continue;
                    
                case "help":
                    showDescriptions = !showDescriptions;
                    newSection(mainClassGrades, showList); // force new section with descriptions toggled
                    continue;
                    
                case "exit":
                    runCommandLoop = false;
                    break;
                    
                default:
                    System.err.println("Invalid command selected: " + commandSelection);
            } // End of switch
            
            waitNextSection(mainClassGrades, showList);
            
        } while (runCommandLoop); // End of do-while
        
        
        
        
        
        // Thank-You UI/UX
        newSection(null, false); // no need to show list
        logThanks();
        
    } // End of Main 
    
    
} // END of class Calculator





// End of Program



/*
 * 
 * NOTES: 
 * 
 * 
 * 
 * 
 * TEST CODE:
 * 
 * 
 * 
*/
// Import Declarations
import java.util.HashMap;  // Import the Scanner class
import java.util.Scanner;
import java.util.ArrayList; // Import the ArrayList class



/**
 * Title:
 *  Blueshore Car Loan Calculator
 *
 * Program Summary:
 *  Allows the user to calculate details of a car loan by inputting values
 * 
 *
 * Program Element List:
 * - HashMap (dictionaries)
 * - method overload (in MyUtility and ConsoleUserInput)
 * - arrays
 * - loop label (in ConsoleUserInput)
 * - for loop (in MyUtility and ConsoleUserInput)
 * - while/do-while loop
 * - switch case
 * - String.repeat (in MyUtility)
 * - double to int converstion like: (int)3.2
 * - helper classes (MyUtility, ConsoleUserInput, LoanObject)
 *
 * @author Dryden || Solo
 * 
 * @version 1.5
 * 
 * @date 2026-05-14
 * 
 */
public class MarksMain {;
    // Beginning of Program || Primary Class "Calculator"
    // Global & Instance variables
    
    
    
    
    
    
    /**
     * Constructor for objects of class MarksMain
     * Creates a new MarksMain object
     * 
     * @param     None
     */
    public MarksMain(){ // Beginning of Constructor
        
    } // End of Constructor
    
    
    
    
    
    /**
     * Prints an ascii art title to the console
     * 
     * @param None
     * @return None
     */
    public static void logTitle() { // Beginning of logTitle
        MyUtility.printInBox("""
   _____             _                       
  / ____|           | |                      
 | |     __ _ _ __  | |     ___   __ _ _ __  
 | |    / _` | '__| | |    / _ \\ / _` | '_ \\ 
 | |___| (_| | |    | |___| (_) | (_| | | | |
  \\_____\\__,_|_|    |______\\___/ \\__,_|_| |_|""", 2, 0, 1);
    } // End of logTitle
    
    
    
    
    
    /**
     * Prints a welcome message to the console
     * 
     * @param None
     * @return None
     */
    public static void logWelcome() { // Beginning of logWelcome
        System.out.println("""
        Welcome to the BlueShore Car Loan Calculator!
        Auto-Financial control awaits you!""");
    } // End of logWelcome
    
    
    
    
    
    /**
     * Prints an introductory message to the console
     * 
     * @param None
     * @return None
     */
    public static void logIntro() { // Beginning of logIntro
        System.out.println("""
        Are you looking to finance a new car?
        Do you want to know what the REAL
        monthly impact will look like?
        Then the BlueShore Car Loan Calculator
        is for you!""");
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
        Select from the calculation inputs to change them,
        or use commands to control the program.""");
    } // End of logExplanation
    
    
    
    
    
    /**
     * Prints a thank you message to the console
     * 
     * @param   None
     * @return  None
     */
    public static void logThanks() { // Beginning of logThanks
        System.out.println("""
        Thank you for using the BlueShore Car
        Loan Calculator! We hope you are on your
        way to achieving your financial and
        automotive goals.""");
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
     * @param currentLoan LoanObject
     * @return None
     */
    public static void newSection() {
        clearConsole();
        logTitle();
    } // End of newSection
    
    
    
    
    
    /**
     * Waits for the user to press return to continue to next section
     * 
     * @param currentLoan LoanObject
     * @return None
     */
    public static void waitNextSection() { // Method for clearing console
        Scanner waitScanner = new Scanner(System.in);
        
        System.out.print("\n\nPress RETURN to continue");
        
        waitScanner.nextLine(); // Wait for user to press RETURN
        waitScanner.close();
        
        newSection();
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
        LoanObject mainLoan = new LoanObject();
        CarLoanVisual visualLoan = new CarLoanVisual();
        
        final HashMap<String, String> commandDescriptions = new HashMap<>();
        final String[] editCommands = {
            "amount - Edit the total amount of money to loan",
            "length - Edit the duration of the loan in months",
            "interest - Edit the interest rate of the loan",
            "down - Edit the down payment of the loan"
        };
        final String[] basicCommands = {
            "phidget - Launch the phidget part of the program", 
            "help - Toggle command descriptions", 
            "exit - Exit the program"
        };
        int selectionIndex;
        String commandSelection;
        boolean runCommandLoop = true;
        boolean activateVisual = false;
        boolean activatePhidget = false;
        boolean showDescriptions = false;
        
        
    

        // Beginning of UI/UX
        clearConsole(); // new section without loan UI
        logTitle();
        System.out.println("\n");
        
        logWelcome();
        horizontalLine();
        logIntro();
        horizontalLine();
        logExplanation();
        
        
        
        waitNextSection();
        logLoanDetails(mainLoan);
                
        do { // while (runCommandLoop)
            
            selectionIndex = ConsoleUserInput.selectFromTwoOptionGroups("Select an option:", "Edit", "Commands", editCommands, basicCommands, false, showDescriptions);
            
            newSection();
            logLoanDetails(mainLoan);
            
            
            
            if (selectionIndex < editCommands.length) { // if selected an edit
                commandSelection = editCommands[selectionIndex].split(" - ")[0];
                System.out.println("Selected to edit: " + commandSelection + "\n");
                
            } else { // if selected a command
                commandSelection = basicCommands[selectionIndex - editCommands.length].split(" - ")[0];
                System.out.println("Command Entered: " + commandSelection + "\n");
            } // End of if else
            
            
            
            switch (commandSelection) {
                case "amount":
                    mainLoan.loanAmount = (int)(ConsoleUserInput.getDoubleInput("Amount of money to loan: ") * 100); // times 100 to convert to cents
                    break;
                
                case "length":
                    mainLoan.loanLength = ConsoleUserInput.getIntInput("Total duration of loan in years: ");
                    break;
                
                case "interest":
                    mainLoan.interestRate = ConsoleUserInput.getDoubleInput("Percent interest rate: ");
                    break;
                
                case "down":
                    mainLoan.downPayment = (int)(ConsoleUserInput.getDoubleInput("Down payment: ") * 100); // times 100 to convert to cents
                    break;
                    
                case "phidget":
                    activatePhidget = true;
                    runCommandLoop = false;
                    System.out.println("Phidget controller will start after you continue.");
                    break;
                    
                case "help":
                    showDescriptions = !showDescriptions;
                    newSection(); // force new section with descriptions toggled
                    logLoanDetails(mainLoan);
                    continue; // skip the waitNextSection, because new section was already forced
                    // no "break;" - throws a dumb 'unreachable statement' error (because continue is there already i guess)
                    
                case "exit":
                    runCommandLoop = false;
                    break;
                    
                default:
                    System.err.println("Invalid command selected: " + commandSelection);
            } // End of switch
            
            
            waitNextSection();
            logLoanDetails(mainLoan);
        } while (runCommandLoop); // End of do-while
        
        
        
        
        
        // Thank-You UI/UX
        newSection();
        logLoanDetails(mainLoan);
        logThanks();
        
    } // End of Main 
    
    
} // END of class Calculator





// End of Program



/*
 * 
 * NOTES: 
 * 
 * on my life there is no AI, i just am a perfectionist about the code sometimes
 * 
 * i tried to add a lot of comments but i guess they might look like ai too now, fuck idk
 * 
 * 
 * TEST CODE:
 * 
 * 
 * 
*/
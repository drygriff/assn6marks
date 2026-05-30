import java.util.Scanner;  // Import the Scanner class

/**
 * A utility class for getting user input from the console
 * 
 * this is for resuing in a lot of projects
 *
 * @author Dryden
 * @version 1.3
 * @date 2026-05-14
 */
public class ConsoleUserInput
{
    
    /**
     * Gets a yes or no answer from a user using the console and Scanner class.
     * 
     * @param promptQuestion String - the yes-or-no question to ask the user
     * @return boolean - true if answer is yes, false if answer is no
     */
    public static boolean yesOrNoQuestion(String promptQuestion) {
        Scanner yesOrNoScanner = new Scanner(System.in);
        String inputYesOrNoAnswer;
        boolean gaveValidAnswer;
        boolean answeredYes = false;
        
        do { // repeats if invalid answer given

            System.out.print(promptQuestion + "\nYes (y) or No (n): ");

            inputYesOrNoAnswer = (yesOrNoScanner.nextLine().trim().toLowerCase());
            
            switch (inputYesOrNoAnswer) {
                case "y": // groups the two cases, like an OR
                case "yes":
                    
                    gaveValidAnswer = true;
                    answeredYes = true;
                    break;
                    
                case "n": // "n" OR "no"
                case "no":
                    gaveValidAnswer = true;
                    answeredYes = false;
                    break;
                    
                default:
                    gaveValidAnswer = false;
                    System.out.println("Invalid response. Try again.");
                    break;
            } // End of switch
            
        } while(!gaveValidAnswer); // End of while loop

        yesOrNoScanner.close();
        return answeredYes;
    } // End of yesOrNoQuestion
    
    
    
    
    
    /**
     * Gets the user's choice from a selection from a list of String options
     * The user can enter their choice either directly or through a number
     * 
     * @param promptQuestion String - the question to ask the user
     * @param boxheader String
     * @param fullOptions String[] - list of options for the user
     * @param requireConfirmation boolean - whether the user should be asked to confirm their selection
     * @param showOptionDescriptions HashMap of String and String - can be null
     * @return String - the selected option
     */
    public static String selectFromOptions(String promptQuestion, String boxHeader, String[] fullOptions, boolean requireConfirmation, boolean showOptionDescriptions) {
        // method variables
        Scanner optionScanner;
        String[] optionKeywords;
        String inputSelection;
        String boxText;
        int finalSelectedIndex;
        int selectionIndex;
        
        
        
        optionKeywords = new String[fullOptions.length];
        for (int i = 0; i < fullOptions.length; i++) {
            optionKeywords[i] = fullOptions[i].split(" - ")[0].trim(); // get first section of each option as keyword
        } // End of for loop

        

        do { // repeats if user wants to retry input
        
            System.out.println(promptQuestion);
            
            boxText = boxHeader + "\n";
            for (int i = 0; i < fullOptions.length; i++) {
                
                if (showOptionDescriptions) { // if using description
                    boxText += (" (" + (i+1) + ")  " + fullOptions[i] + "\n");
                } else { // if no description
                    boxText += (" (" + (i+1) + ")  " + optionKeywords[i] + "\n");
                } // End of if-else
            } // End of for loop
            MyUtility.printInBox(boxText, 2, 1, 1);


            validateLoop: while (true) { // labelled loop as validateLoop, exits with break when valid selection given
                System.out.print("Enter your selection: ");
                
                optionScanner = new Scanner(System.in); // Open and close scanner
                inputSelection = optionScanner.nextLine().trim().toLowerCase();
                optionScanner.close();


                for (int i = 0; i < optionKeywords.length; i++) {
                    if (inputSelection.equals(optionKeywords[i].toLowerCase())) {
                        finalSelectedIndex = i;
                        break validateLoop;
                    } // End of if equal
                } // End of for loop
                
                
                try {
                    selectionIndex = Integer.parseInt(inputSelection) - 1; // Adjust for 0 starting value
                    
                    if ((selectionIndex >= 0) && (selectionIndex < optionKeywords.length)) {
                        finalSelectedIndex = selectionIndex;
                        break;
                    }
                    
                } catch (NumberFormatException numberE) {
                    // do nothing
                } // End of try-catch
                
                System.out.println("Invalid selection. Try again.");
            }// End of validate while loop
            
            // repeat if requires confirmation and user does not confirm 
        } while(requireConfirmation && (!yesOrNoQuestion("Are you sure you want to select \"" + optionKeywords[finalSelectedIndex] + "\"?"))); // End of confirmation while loop

        return optionKeywords[finalSelectedIndex];
    } // End of selectFromOptions
    
    
    
    
    
    
    /**
     * Gets an integer input from the user.
     * 
     * @param userPrompt String - prompt to show user
     * @param minInt int - inclusive minimum
     * @param maxInt int - inclusive maximum
     * @param minMsg String - the message to print when user enters a number below the minimum
     * @param maxMsg String - the message to print when user enters a number above the maximum
     * @return int
     */
    public static int getIntInput(String userPrompt, int minInt, int maxInt, String minMsg, String maxMsg) {
        // method variables
        Scanner intInputScanner = new Scanner(System.in);
        int finalResultNumber;
        
        
        while (true) { // break when valid number given
            System.out.print(userPrompt);
            
            try {
                finalResultNumber = Integer.parseInt(intInputScanner.nextLine());
                
                if (finalResultNumber < minInt) {
                    System.out.println(minMsg + ", try again.");
                } else if (finalResultNumber > maxInt) {
                    System.out.println(maxMsg + ", try again.");
                } else { // input must be valid
                    break;
                } // End of else-if
                
                
            } catch (NumberFormatException numberE){
                System.out.println("Invalid integer, try again.");
            } // End of try-catch
        } // End of while loop
        
        
        intInputScanner.close();
        System.out.println(""); // separation space
        return finalResultNumber;
    } // End of getIntInput
    
    
    
    
    
    /**
     * Gets a double input from the user.
     * 
     * @param userPrompt String - prompt to show user
     * @return double
     */
    public static double getDoubleInput(String userPrompt) {
        // method variables
        Scanner doubleInputScanner = new Scanner(System.in);
        double finalResultNumber;
        
        while (true) { // break when valid number given
            System.out.print(userPrompt);
            
            try {
                finalResultNumber = Double.parseDouble(doubleInputScanner.nextLine());
                break;
            } catch (NumberFormatException numberE){
                System.out.println("Invalid number, try again.");
            } // End of try-catch
        } // End of while loop
        
        doubleInputScanner.close();
        return finalResultNumber;
    } // End of getDoubleInput
    
    
} // End of class ConsoleUserInput





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
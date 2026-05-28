/**
 * A class with utility functions
 * 
 * I was reusing a lot of code over time so I figured it would be easier if it was in it's own class
 *
 *
 * @author Dryden
 * @date 2026-03-09
 */
public class MyUtility
{
    
    /**
     * Merges any number of arrays into a new array.
     * Uses "..." so that any number of arrays can be passed without encompassing them
     * (THIS IS DRYDEN - I DESIGNED THIS, LIKE THE REST OF THE PROJECT)
     * 
     * @param   array1 String[]
     * @param   array2 String[]
     * @param   array3... String[]
     * @return  String[]
     */
    public static String[] mergeStringArrays(String[]... arraysToMerge) { // the "..." is identical to "[]" except the items are passed as different parameters instead of needing to declare a new array - note from dryden not ai
        String[] mergedArray;
        int currentIndex = 0;
        int totalLength = 0;
        
        
        for (String[] genericArray : arraysToMerge) {
            totalLength += genericArray.length;
        } // ENd of for loop
        
        
        mergedArray = new String[totalLength];
        
        for (String[] inputArray : arraysToMerge) {
            for (String stringElement : inputArray) {
                mergedArray[currentIndex] = stringElement;
                currentIndex++;
            } // End of inner for loop
        } // End of outer for loop
        
        return mergedArray;
    } // End of mergeStringArrays
    
    
    
    
    
    
    /**
     * Converts a number to a string with an ordinal suffix (1st, 2nd, 3rd, Nth)
     * 
     * @param numberToBeConverted int
     * @return String - number with added suffix
     */
    public static String toOrdinal(int fullNumber) {
        int lastDigit = (fullNumber % 10);
        
        if ((fullNumber > 10) && (fullNumber < 20)) { // 11th, 12th, 13th are outliers
            return (fullNumber + "th");
        }
        
        switch (lastDigit) { // no "break" necessary because it returns
            case 1: // (1st, 21st, NOT 11st)
                return (fullNumber + "st");
                
            case 2: // 2nd, 22nd, etc
                return (fullNumber + "nd");
                
            case 3: // 3rd, 23rd, etc
                return (fullNumber + "rd");
                
            default: // all other numbers are Nth (5th, 38th, etc)
                return (fullNumber + "th");
                
        } // End of switch-case
        
    } // End of toOrdinal
    
    
    
    
    
    /**
     * Wraps a text when a line exceeds a maximum length
     * 
     * @param maximumLineLength int
     * @param inputText String
     * @return String
     */
    public static String wrapText(int maximumLineLength, String inputText) {
        int charsInARow = 0;
        String outputText = inputText.replace("\r", ""); // remove the stupid extra carriage return character on some strings
        
        for (int i = 0; i < outputText.length(); i++) {
            charsInARow++;
            
            if (outputText.charAt(i) == '\n') {
                charsInARow = 0;
            } // End of if
            
            if (charsInARow > maximumLineLength) {
                outputText = outputText.substring(0, i) + "\n" + outputText.substring(i); // inserts a "\n" before index i
                charsInARow = 0;
            } // End of if
            
        } // End of for loop
        
        return outputText;
    } // End of wrapText
    
    
    
    
    
    /**
     * Prints the given string to the console inside a box
     * REMEMBER: console font is monospace
     * 
     * @param textToPrint String - the text in the box
     * @param sideSpaces int
     * @param topSpaces int
     * @param bottomSpaces int
     * @return None
     */
    public static void printInBox(String textToPrint, int sideSpaces, int topSpaces, int bottomSpaces) {
        // method variables
        String[] linesToPrint = textToPrint.split("\n");
        String outputResult;
        String newTextLine;
        int maxLength = 0;
        int totalLength;
        int currentLength;
        
        
        
        // find the longest line so it can be the width
        for (int i = 0; i < linesToPrint.length; i++) {
            linesToPrint[i] = linesToPrint[i].stripTrailing(); // trim trailing whitespace
            
            currentLength = linesToPrint[i].length();
            if (currentLength > maxLength) {
                maxLength = currentLength;
            } // End of if
        } // End of for loop
        totalLength = (maxLength + (sideSpaces*2));
        
        
        
         // Add top line
        outputResult = (" " + ("_".repeat(totalLength)));
        
        // Add empty vertical spaces
        outputResult += ("\n|" + (" ".repeat(totalLength)) + "|").repeat(topSpaces);
        
        // Add text and side lines
        for (int i = 0; i < linesToPrint.length; i++) {
            newTextLine = ("|  " + linesToPrint[i]);
            
            newTextLine += " ".repeat(totalLength - (newTextLine.length() - 1));
            newTextLine += "|";
            
            outputResult += "\n" + newTextLine;
        } // End of for loop
        
        // Add empty vertical spaces
        outputResult += ("\n|" + (" ".repeat(totalLength)) + "|").repeat(bottomSpaces);
        
        //Add bottom line
        outputResult += ("\n" + (" " + ("‾".repeat(totalLength))));
        
        System.out.println(outputResult);
    } // End of printInBox
    
    
    
    
    
    /**
     * Overload for printInBox with default spacing values
     * 
     * I swear mr vatiougoiss this isn't AI i just really like to have a lazy overload
     * 
     * @param textToPrint the text to print
     * @return None
     */
    public static void printInBox(String textToPrint) {
        printInBox(textToPrint, 2, 1, 1);
    } // End of printInBox overload
    
    
    
    
    
    /**
     * Prints stuff in a box with multiple sections
     * 
     * this is for the group selection options
     * 
     * 
     * @param textToPrint String - the text in the box
     * @param sideSpaces int
     * @param topSpaces int
     * @param bottomSpaces int
     * @return None
     */
    public static void printInSectionedBox(String[] sectionsToPrint, int sideSpaces, int topSpaces, int bottomSpaces, int gapSpaces) {
        // method variables
        String[][] sectionLinesToPrint = new String[sectionsToPrint.length][];
        String outputResult;
        String newTextLine;
        int maxLength = 0;
        int totalLength;
        int currentLength;
        
        for (int i = 0; i < sectionLinesToPrint.length; i++) {
            sectionLinesToPrint[i] = sectionsToPrint[i].split("\n");
        } // End of for loop
        
        
        // Get lines
        for (String[] linesToPrint : sectionLinesToPrint) {
            // Find the longest line
            for (int i = 0; i < linesToPrint.length; i++) {
                linesToPrint[i] = linesToPrint[i].stripTrailing(); // trim trailing whitespace
                
                currentLength = linesToPrint[i].length();
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                } // End of if
            } // End of for loop
        }
        
        totalLength = (maxLength + (sideSpaces*2));
        
         // Add top line
        outputResult = (" " + ("_".repeat(totalLength)));
        
        // Add empty vertical spaces
        outputResult += ("\n|" + (" ".repeat(totalLength)) + "|").repeat(topSpaces);
        
        // Add text and side lines
        for (int i = 0; i < sectionLinesToPrint.length; i++) {
            for (int j = 0; j < sectionLinesToPrint[i].length; j++) {
                newTextLine = ("|  " + sectionLinesToPrint[i][j]);
                
                newTextLine += " ".repeat(totalLength - (newTextLine.length() - 1));
                newTextLine += "|";
                
                outputResult += "\n" + newTextLine;
            } // End of for loop
            
            if (i != (sectionLinesToPrint.length - 1)) {
                if ((gapSpaces % 2) == 0) {
                    outputResult += ("\n|" + (" ".repeat(totalLength)) + "|").repeat(gapSpaces/2);
                    outputResult += ("\n" + ("|" + ("-".repeat(totalLength)) + "|"));
                    outputResult += ("\n|" + (" ".repeat(totalLength)) + "|").repeat(gapSpaces/2);
                } else {
                    outputResult += ("\n|" + (" ".repeat(totalLength)) + "|").repeat(gapSpaces/2);
                    outputResult += ("\n" + ("|" + ("_".repeat(totalLength)) + "|"));
                    outputResult += ("\n|" + (" ".repeat(totalLength)) + "|").repeat((gapSpaces/2) + 1);
                }
            } // End of inner for loop
        } // End of outer for loop
        
        // Add empty vertical spaces
        outputResult += ("\n|" + (" ".repeat(totalLength)) + "|").repeat(bottomSpaces);
        
        //Add bottom line
        outputResult += ("\n" + (" " + ("‾".repeat(totalLength))));
        
        System.out.println(outputResult);
    } // End of printInSectionedBox
    
    
    
    
    
    /**
     * Overload for printInBox with default spacing values
     * 
     * i swear im just weird and like overloads, its not AI
     * 
     * @param textToPrint the text to print
     * @return None
     */
    public static void printInSectionedBox(String[] sectionsToPrint) {
        printInSectionedBox(sectionsToPrint, 2, 1, 1, 1);
    } // End of printInSectionedBox overload
    
    
    
    
    
    /**
     * Sanitizes a string to be a valid number given restrictions
     * 
     * Set numDecimals to -1 for unlimited decimals
     * 
     * @param inputString String
     * @param numDecimals int
     * @return String
     */
    public static String sanitizeNumberString(String inputString, int numDecimals, boolean canBeNegative) {
        int decimalIndex = -1;
        
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            
            if ((currentChar == '-') && (i == 0) && (canBeNegative)) {
                // leave char
                
            } else if ((currentChar == '.') && (decimalIndex == -1) && (numDecimals > 0)) {
                // leave char
                decimalIndex = i;
                
            } else if ((currentChar >= '0') && (currentChar <= '9')   && ((decimalIndex < 0) || (numDecimals < 0) || ((i-decimalIndex) <= numDecimals))){
                // leave char
                
            } else {
                //remove char
                inputString = inputString.substring(0, i) + inputString.substring(i+1);
                i--;
            }// End of if-else chain
        } // End of for loop
        
        return inputString;
    } // End of sanitizeNumberString
    
    
    
    
    
    /**
     * Overload for sanitizeNumberString for default canBeNagative
     * 
     * last overload method i promise
     * 
     * @param inputString String
     * @param numDecimals int
     * @return String
     */
    public static String sanitizeNumberString(String inputString, int numDecimals) {
        return sanitizeNumberString(inputString, numDecimals, true);
    } // End of sanitizeNumberString overload
}
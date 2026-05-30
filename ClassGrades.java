import java.util.ArrayList;

/**
 * Stores a list of grades for a classroom and has methods to
 * view and modify the grades.
 *
 * @author Dryden
 * @version 1.3
 */
public class ClassGrades
{
    ArrayList<Integer> gradeList;
    
    /**
     * Constructor for ClassGrades
     * 
     * @param None
     * @return ClassGrades
     */
    public ClassGrades() {
        gradeList = new ArrayList<Integer>();
    } // End of constructor
    
    
    
    
    
    /**
     * Prints out the list of grades in a box
     * 
     * @param None
     * @return None
     */
    public void logGrades() {
        String gradeBoxText = "Grades:      \n";
        
        if (gradeList.size() == 0) {
            gradeBoxText += "\n None";
            MyUtility.printInBox(gradeBoxText);
            return;
        } // End of if
        
        for (int currentGrade : gradeList) {
            gradeBoxText += "\n " + currentGrade + "%";
        } // End of for loop
        
        MyUtility.printInBox(gradeBoxText);
    } // End of logGrades
    
    
    
    
    
    /**
     * Prints out the list of grades in a box
     * Labeled with numbers starting at 1 (index + 1)
     * 
     * @param None
     * @return None
     */
    public void logNumberedGrades() {
        String gradeBoxText = "Grades:      \n";
        
        if (gradeList.size() == 0) {
            gradeBoxText += "\n None";
            MyUtility.printInBox(gradeBoxText);
            return;
        } // End of if
        
        for (int i = 0; i < gradeList.size(); i++) {
            gradeBoxText += "\n (" + (i+1) + ") "+ + gradeList.get(i) + "%";
        } // End of for loop
        
        MyUtility.printInBox(gradeBoxText);
    } // End of logGrades
    
    
    
    
    
    /**
     * Adds the given int grade to the end of the list
     * 
     * @param int newGrade
     * @return None
     */
    public void addGrade(int newGrade) {
        gradeList.add(newGrade);
    } // End of addGrade
    
    
    
    
    
    /**
     * Removes the element in gradeList iwth the given index
     * 
     * @param int indexToRemove
     * @return None
     */
    public void removeGrade(int indexToRemove) {
        gradeList.remove(indexToRemove);
    } // End of removeGrade
    
    
    
    
    
    /**
     * Removes all grades in the list by creating a new list
     * 
     * @param None
     * @return None
     */
    public void removeAllGrades() {
        gradeList = new ArrayList<Integer>();
    } // End of removeGrade
    
    
    
    
    
    /**
     * Returns the number of elements in the gradeList
     * 
     * @param None
     * @return int
     */
    public int numberOfGrades() {
        return gradeList.size();
    } // End of numberOfGrades
    
    
    
    
    
    /**
     * Returns the element in the gradeList at a specific index
     * 
     * @param int indexToGet
     * @return int
     */
    public int getGradeAtIndex(int indexToGet) {
        return gradeList.get(indexToGet);
    } // End of getGradeAtIndex
    
    
    
    
    
    /**
     * Sorts all grades in descending order
     * 
     * @param None
     * @return None
     */
    public void sortGrades() {
        
        gradeList.sort((firstGrade, secondGrade) -> ((-1) * firstGrade.compareTo(secondGrade))); // lambda function to reverse order, taken from w3schools
    } // End of sortGrades
    
    
} // End of class ClassGrades





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
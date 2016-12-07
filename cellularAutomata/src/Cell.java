/**
 * Cell class represents a single cell in the 2D array grid of healthy, diseased, or dead cells
 * 
 * @author Kayger Duran-Mateo
 */
public class Cell {
    //private instance variables
    private int currValue;
    private int howLongHaveIBeenMe;
     
    /**
     *Full constructor for Cell class 
     * @param currValue keeps track of the current value (state) of each individual cell
     * @param howLongHaveIBeenMe is the counter that keeps track of how long a cell has been sick or dead 
     */
    
    public Cell(int currValue, int howLongHaveIBeenMe)
    {
        this.currValue=currValue;
        this.howLongHaveIBeenMe = howLongHaveIBeenMe;
        
    }
    
    /**
     * Getter for currValue instance variable
     * @return an int value of the cell state
     */
    public int getCurrValue() {
        return currValue;
    }

    /**
     * Setter for currValue instance variable
     * @param currValue the currValue to set
     */
    public void setCurrValue(int currValue) {
        this.currValue = currValue;
    }

    /**
     * Getter for howLongHaveIBeenMe instance variable
     * @return an int count of how long a cell has been in a state
     */
    public int getHowLongHaveIBeenMe() {
        return howLongHaveIBeenMe;
   }

    /**
     *Setter for howLongHaveIBeenMe instance variable
     * @return an incremented int counter 
     */
    public int setHowLongHaveIBeenMe() {
        return howLongHaveIBeenMe++;
    }

    /**
     * resets howLongHaveIBeenMe counter to zero when called
     */
    public void resetCount()
    {
       howLongHaveIBeenMe = 0;
    }
}
    
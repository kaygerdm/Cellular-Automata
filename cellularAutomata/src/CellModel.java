import java.util.*;

/**
 * CellModel class represents the model of 2d array of cell objects
 *
 * @author Kayger Durab-Mateo
 *
 */
public class CellModel {

    //Instance variables all private
    //property of model 2d array
    private Cell[][] cells;
    //values 50X30 read in form controller
    private int row;
    private int col;
    //hard code percents for comparisons 
    private final double healthyPerc = .75;
    private final double notHealthyPerc = .26;
    //neighbor value counts
    int healthyCount = 0;
    int diseasedCount = 0;
    int deadCount = 0;
    int neighborCount = 0;
     //arrays.clone(source,dest.)
    Cell[][] copy;

    /**
     * Empty Constructor for CellModel class
     */
    public CellModel() {

    }

    /**
     * Full constructor for the CellModel class
     *
     * @param row is passed value 50 of type int from controller instance variable
     * @param col is passed value 30 of type int from controller instance variable
     */
    public CellModel(int row, int col) {
        this.row = row;
        this.col = col;

    }

    /**
     * Method that takes empty 2d array of Cell[][] cells and fills it with
     * random values between 0 and 2
     */
    public void gridValues()
    {
        //filling blank cells with values
        cells = new Cell[row][col];

       Random nums = new Random();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {

                Cell cell = new Cell(0,0);
               cell.setCurrValue(nums.nextInt(3));
                cell.getCurrValue();
                cells[i][j] = cell;
            }
        }
    }

    /**
     * void method that updates the health state of a cells[i][j] based upon the
     * health state of identified valid neighbors Note: there are private
     * services methods used and referenced in line 90 and 107
     * 
     */
    public void neighborState() {
         copy = new Cell[row][col];
         for(int i =0; i < row; i++)
        {
           copy [i] = cells[i].clone();
        }
        //method portion i & j reads the grid from left to right 
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                //count the number of neighbors
                //(0,0) = x - 1,y - 1 , (1,0) = x + 1, y - 1
                //x & y reads the neighbors of cell selected
                for (int x = -1; x < 2; x++) {
                    for (int y = -1; y < 2; y++) {
                        if (validCoordinates(i, j, x, y)) {
                            neighborCount++;
                            //assigning health value to neighbors 
                            if (copy[i + x][j + y].getCurrValue() == 0) {
                                healthyCount++;
                            } else if (copy[i + x][j + y].getCurrValue() == 1) {
                                diseasedCount++;
                            } else if (copy[i + x][j + y].getCurrValue() == 2) {
                                deadCount++;
                            }

                        }

                    }
                    
                }
                //update cell value
                updateValue(i,j);
            }

        }
       
    }

    /**
     * Private boolean service method that checks for valid coordinates in
     * bounds of 2d array grid and returns boolean whether coordinate is on grid
     *
     * @param i is the base row coordinate
     * @param j is the base column coordinate
     * @param x is the row offset
     * @param y is the column offset
     * @return returns boolean whether coordinate is on grid
     */
    private boolean validCoordinates(int i, int j, int x, int y) {
        //modeling grid coordinates around selected cell
        boolean valid = true;
        if ((x == 0) && (y == 0)) {
            valid = false;
        } else if (((i + x) < 0) || ((i + x) >= row)) {
            valid = false;
        } else if (((j + y) < 0) || ((j + y) >= col)) {
            valid = false;
        }

        return valid;
    }

    /**
     * Service method update that updates state of cell based upon neighbor health and sick percentage
     * @param i is the base row coordinate
     * @param j is the base column coordinate
     */
    private void updateValue(int i, int j) {
    
        //healthy neighbors calculated
        double hpercent;
        hpercent = (double) healthyCount / (double) neighborCount;
        //sick and dead calculated together
        double unhpercent;
        unhpercent = (double) (diseasedCount + deadCount) / (double) neighborCount;
        //state change conditions
         if (copy[i][j].getCurrValue() == 0) 
         {
             if(unhpercent >= notHealthyPerc)
             {
                 cells[i][j].setCurrValue(1);
                 cells[i][j].resetCount();
             }
             else
             {
                 cells[i][j].setCurrValue(0);
             }

        }    
        
        else if (copy[i][j].getCurrValue() == 1){
            if (hpercent >= healthyPerc) {
                cells[i][j].setCurrValue(0);
                cells[i][j].resetCount();
            }
            //increment counter
            cells[i][j].setHowLongHaveIBeenMe();
            if (cells[i][j].getHowLongHaveIBeenMe() >= 5) {
                cells[i][j].setCurrValue(2);
                //call for reset
                cells[i][j].resetCount();
            }
        }
        else if (copy[i][j].getCurrValue() == 2)
        { 
             if (hpercent >= healthyPerc) {
                cells[i][j].setCurrValue(0);
                //call for reset
                cells[i][j].resetCount();
            }
             
             else
             { 
                 //increment counter
                 cells[i][j].setHowLongHaveIBeenMe();
             }
            if (cells[i][j].getHowLongHaveIBeenMe() >= 5) {
                cells[i][j].setCurrValue(0);
                //call for reset
                cells[i][j].resetCount();
            }
            
        }
   
    }

    /**
     * gridString method that returns a String representation of the 2d array of cells 
     * @return returns a String representation of the 2d array of cells
     */
    public String gridString() {
        //encapsulation of int values in this string
        String stringNums = "";
        int[][] arrayStringVersion = new int[50][30];
        for (int i = 0; i < arrayStringVersion.length; i++) {
            for (int j = 0; j < arrayStringVersion[i].length; j++) {
                //need to transfer current value (int) of array not object coordinate
                arrayStringVersion[i][j] = cells[i][j].getCurrValue();
                stringNums = stringNums + arrayStringVersion[i][j] + " ";
            }
        }

        return stringNums;
    }
        
    } 



/**
 * Project1CellDriver class that is used to start the program and represents the driver for the program
 * @author KDM
 *
 */
public class Project1CellDriver{ 
 
    
    /**
     *Main method that calls instances of CellView view, CellModel grid, and CellController begin to begin program method executions
     * @param args
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException{
	
	CellController run = new CellController();
        run.Start();
        
    }
}
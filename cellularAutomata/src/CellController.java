
/**
 * CellController class manages CellView and CellModel class
 * @author Kayger Duran-Mateo
 */
public class CellController {
    //instance variables
    CellModel grid;
    CellView stage;
    //constant instant variables
    private final int ROW = 50;
    private final int COL = 30;

    /**
     * CellController constructor
     */
    public CellController() {
        //instanciate
        grid = new CellModel(ROW, COL);
        stage = new CellView();

    }

    /**
     * Start method that is called by CellDriver to begin game loop and gather
     * information from CellModel and CellView
     * @throws java.lang.InterruptedException
     */
    public void Start() throws InterruptedException {
         //make it appear 
        stage.View();
        //fill array with first values
        grid.gridValues();
        //get string version of current health state
        String finalString = grid.gridString();
        //get string version
        stage.displayColor(finalString);
        
        for (int i = 0; i < 1000; i++) {
            
            //call model to change healths
            grid.neighborState();
            //get string version of current health state
             finalString = grid.gridString();
            //get string version
            stage.displayColor(finalString);
            Thread.sleep(935);
        }
    }
}

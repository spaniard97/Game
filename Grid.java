import java.util.Random;

/**
 * Grid - holds a two-dimensional array of String objects to use in a game.
 * 
 * @author (your name here)
 * @version (a version number or a date)
 */
public class Grid
{
    // suggested Grid constants
    public static final int ROWS = 5;           // number of rows
    public static final int COLUMNS = 5;        // number of columns
    public static final String HIDDEN = "$ ";   // default string to display
  
    // suggested Grid instance variables
    private String[][] grid;                // the grid itself, a 2-D array of String
    private Random random;                  // random number generator

    /**
     * The Grid constructor creates a new grid using public constants ROWS and COLUMNS. 
     * Constructor also creates a new random number generator. 
     */
    public Grid()
    {
        // initialize instance variables
        grid = new String[ROWS][COLUMNS];
        random = new Random();
    }
    
    /**
     * Displays a grid
     */
    public void showGrid()
    {    
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(grid[i][j]);
                if (j == ROWS - 1) {
                    System.out.println();
                }
            }
        }
        
    }
    
    /** 
     * Generates random coordinates, puts them into a new CoordinatePair,
     * returns CoordinatePair
     * @return a randomly-generated pair of coordinates within the bounds of the
     * grid
     */   
    private CoordinatePair getRandomCoordinates()
    {
        CoordinatePair coords = new CoordinatePair();  // create a new coordinate pair object
        coords.setRow(random.nextInt(ROWS));
        coords.setColumn(random.nextInt(COLUMNS));
        return coords;                                 // return the object
    }
    
    /**
     * Invokes getRandomCoordinates() to put a specific value into a specified
     * number of grid positions.
     * @param the number of randomly-generated coordinates to set
     * @param the target value to set
     */
    public void setRandomCoordinatesInGrid(int coordsToSet, String valueToSet)
    {
        int targetsPlaced = 0;
        CoordinatePair myCoord;
        
        while (targetsPlaced < coordsToSet) {
            myCoord = getRandomCoordinates();
            int row = myCoord.getRow();
            int col = myCoord.getColumn();
            if (!grid[row][col].equals(valueToSet)) {
                grid[row][col] = valueToSet;
                targetsPlaced++;
            }
        }
    }   
    
    public void setGridStartingValues() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                grid[i][j] = HIDDEN;
            }
        }
    }
    
    public boolean isTargetHitWithGuess(CoordinatePair guess) {
        int row = guess.getRow();
        int col = guess.getColumn();
        return !grid[row][col].equals(HIDDEN);
    }
    
    public void setCoordSymbolWithGuess(CoordinatePair guess, String valueToSet) {
        int row = guess.getRow();
        int col = guess.getColumn();
        grid[row][col] = valueToSet;
    }
    
    public boolean isValidGuess(CoordinatePair guess) {
        if (guess == null) {
            return false;
        }
        int row = guess.getRow();
        int col = guess.getColumn();
        
        boolean isValidRow = (row < ROWS && row >= 0);
        boolean isValidCol = (col < COLUMNS && col >=0);
        
        return isValidRow && isValidCol && grid[row][col].equals(HIDDEN);
        
    }
}

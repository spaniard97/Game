
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    // suggested Game constants
    public static final String TARGET = "T ";          
    public static final String HIT = "* ";             
    public static final String MISS = "- ";           
    public static final int NUMBER_OF_TARGETS = 1; // number of targets hidden in the game grid
    public static final int NUMBER_OF_TRIES   = 2;//i think it woorks now // number of tries the user is given
    
    // suggested instance variables
    private Grid targetGrid;                       // the grid that holds the targets
    private Grid displayGrid;                      // the grid that displays hits and misses
    private InputReader reader;                    // input reader to get user coordinate choices
    private int targetsHit;
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        // initialize instance variables
        targetGrid = new Grid();
        displayGrid = new Grid();
        reader = new InputReader();
    }
    
    private boolean isGameWon() {
        return targetsHit >= NUMBER_OF_TARGETS;
    }
    
    private boolean hasTurnsLeft(int tries) {
        return tries <= NUMBER_OF_TRIES;
    }
    /**
     * Play the game - this method contains the game logic
     */
    public void playGame()
    {
        targetGrid.setGridStartingValues();        
        displayGrid.setGridStartingValues();
        targetGrid.setRandomCoordinatesInGrid(NUMBER_OF_TARGETS, TARGET);
        
        targetGrid.showGrid();
        System.out.println();
        displayGrid.showGrid();
        showInstructions();
        
        CoordinatePair myGuess;
        int tryCtr = 1;        
        targetsHit = 0;
        
        while (!isGameWon()) {
            System.out.print(
                "\nTry number " + tryCtr + "\n" +
                "Coordinates start from zero.\n" +
                "Type your choice of coordinates (row column) with a space\n" +
                "between >");
            myGuess = reader.getCoordinates();
            if (displayGrid.isValidGuess(myGuess)) {
                if (targetGrid.isTargetHitWithGuess(myGuess)) {
                    displayGrid.setCoordSymbolWithGuess(myGuess, HIT);
                    targetsHit++;
                } else {
                    displayGrid.setCoordSymbolWithGuess(myGuess, MISS);
                }
                tryCtr++;
            } else {
                System.out.println("Not a valid coordinate, please re-enter");
            }
            displayGrid.showGrid();
            
            if (!hasTurnsLeft(tryCtr)) {
                System.out.println(
                    "\nSorry, you only hit " +
                    targetsHit +
                    " targets out of " +
                    NUMBER_OF_TARGETS
                );
                targetGrid.showGrid();
                return;
            }
        }

        if (isGameWon()) {
            System.out.println(
                "\nCongrats, you hit all " +
                NUMBER_OF_TARGETS +
                " of the targets"
            );
        }        
        targetGrid.showGrid();
        
    }
    
    /**
     * Provides instructions to the user
     */
    private void showInstructions()
    {
        System.out.println(
                "Welcome to the Guessing Game!\n" +
                "You will be shown a grid with 6 hidden targets.\n" +
                "You will be given 10 chances to 'hit' a target.\n" +
                "When prompted, type the coordinates to 'hit'.\n" +
                "The grid will display * for a successful hit and - for a\n" +
                "miss.\n"
        );
    }
}
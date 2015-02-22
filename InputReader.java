import java.util.Scanner;

/**
 * Class InputReader reads numbers typed at the keyboard. Uses
 * the Scanner class from JDK 1.5.
 * 
 * @author     Colleen Penrowley
 * @version    January 2012
 */
public class InputReader
{
    private Scanner scanner;

    /**
     * Create a new InputReader to read a coordinate pair.
     */
    public InputReader()
    {
        scanner = new Scanner(System.in);
    }

    /**
     * @return CoordinatePair with row and column typed by user, or null
     */
    public CoordinatePair getCoordinates()
    {
        CoordinatePair coords = new CoordinatePair();
        try {
            coords.setRow(scanner.nextInt());
            coords.setColumn(scanner.nextInt());    
        }
        catch(java.util.InputMismatchException exc) { // will catch non-numeric input
            scanner.nextLine();             // clear the buffer
            coords = null;                      
        }
        return coords;
    }        
}

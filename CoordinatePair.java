
/**
 * CoordinatePair. This class maintains a row-column pair of numbers
 * to be used as array coordinates. A CoordinatePair object refers to a single
 * location in a two-dimensional array.
 * 
 * @author  
 * @version 
 */
public class CoordinatePair
{
    private int row;
    private int column;

    /**
     * Constructor for objects of class CoordinatePair
     */
    public CoordinatePair()
    {
        setRow(0);
        setColumn(0);
    }
    
    /**
     * @param row to set
     */
    public void setRow(int row)
    {
        this.row = row;
    }
    
    /**
     * @param column to set
     */
    public void setColumn(int column)
    {
        this.column = column;
    }

    /**
     * @return row as int
     */
    public int getRow()
    {
        return row;
    }
    
    /**
     * @return column as int
     */
    public int getColumn()
    {
        return column;
    }
}

/*
    Square.java by Vannel 4/3/2019
    Represents a square on a chessboard
 */

public class Square{
    private int row;
    private int col;
    private String elimNumber;
    
    /**
     * default constructor
     */
    public Square(){
        row = 0;
        col = 0;
        elimNumber = "";
    }
    
    /**
     * overloaded constructor
     *
     * @param the initial row number
     * @param the initial column number
     * @param the initial elimination number
     */
    public Square (int initRow, int initCol, String initElimNumber){
        row = initRow;
        col = initCol;
        elimNumber = initElimNumber;
    }
    
    /**
     * row accessor
     *
     * @return the row number
     */    
    public int getRow(){
        return row;
    }
    
    /**
     * column accessor
     *
     * @return the column number
     */    
    public int getCol(){
        return col;
    }
    
    /**
     * elimNumber accessor
     *
     * @return the square's elimination number
     */    
    public String getElimNumber(){
        return elimNumber;
    }
    
    /**
     * elimNumber mutator
     *
     * @param the new elimation number
     */
    public void setElimNumber (String newElimNumber){
        elimNumber = newElimNumber;
    }
    
    /**
     * prints the square's row, column and current elimination number
     *
     * @return the row, column and elimination number of the square
     */
    public String toString(){
        String square = String.format("[(%d %d)]", row, col, elimNumber);
        return square;
    } 
    
    /*
     * main
     *
    public static void main (String [] args){
        Square s1 = new Square();
        System.out.println(s1);
        Square s2 = new Square(2,3,"x");
        System.out.println(s2);
        System.out.printf("%d %d %s\n", s2.getRow(), s2.getCol(), s2.getElimNumber());
        s2.setElimNumber("10");
        System.out.println(s2);
    }*/
}
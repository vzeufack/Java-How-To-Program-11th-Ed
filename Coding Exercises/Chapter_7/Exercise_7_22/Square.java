/*
    Square.java by Vannel 12/18/2018
    Represents a square on a chessboard
 */

public class Square{
    private int row;
    private int col;
    private int number;
    private int accessibility;
    
    public Square(){
        row = 0;
        col = 0;
        number = 0;
        accessibility = 0;
    }
    
    public Square (int initRow, int initCol){
        setRow (initRow);
        setCol (initCol);
        number = 0;
        accessibility = 0;
    }
    
    public Square (int initRow, int initCol, int initNumber, int initAccessibility){
        setRow (initRow);
        setCol (initCol);
        setNumber (initNumber);
        setAccessibility (initAccessibility);    
    }
    
    public int getRow(){
        return row;
    }
    
    public void setRow(int newRow){
        row = newRow;
    }
    
    public int getCol(){
        return col;
    }
    
    public void setCol(int newCol){
        col = newCol;             
    }
    
    public int getNumber(){
        return number;
    }
    
    public void setNumber (int newNumber){
        number = newNumber;
    }
    
    public int getAccessibility(){
        return accessibility;
    }
    
    public void setAccessibility( int newAccessibility ){
        accessibility = newAccessibility;     
    }
    
    public String toString(){
        String square = String.format("Row: %d | Col: %d | Number: %d | Accessibility: %d", row, col, number, accessibility);
        return square;
    }
    
    public boolean isValid (){
        if (row < 0 || row > 7 || col < 0 || col > 7 || accessibility < 0 || accessibility > 8 || number < 0 || number > 63)
            return false;
        else
            return true;    
    }    
}
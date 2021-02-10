/*
 * KnightTour.java by Vannel 1/21/2019
 * Simulates a Knight tour on a chessboard
 */
 
import java.security.SecureRandom;
import java.util.ArrayList;

public class KnightTour{
    private static SecureRandom random = new SecureRandom();
    
    /*
     * main method
     * @param args
     */
    public static void main (String [] args){
    
        ChessBoard chessboard = new ChessBoard();
        Knight knight = chessboard.getKnight();      
        Square [][] squares = chessboard.getSquares();
        Square currentSquare;
        ArrayList <Square> availableSquares;
        int count = 1;
        int accessibility;
               
        squares[knight.getPosition().getRow()][knight.getPosition().getCol()].setNumber(count++);
        squares[knight.getPosition().getRow()][knight.getPosition().getCol()].setAccessibility(0);
        availableSquares = getAvailableSquares(chessboard, knight.getPosition());
        for (int i = 0; i < availableSquares.size(); i++){
            accessibility = squares[availableSquares.get(i).getRow()][availableSquares.get(i).getCol()].getAccessibility();
            squares[availableSquares.get(i).getRow()][availableSquares.get(i).getCol()].setAccessibility(--accessibility);
        }      
        currentSquare = getLeastAccessibleSquare2(chessboard, knight.getPosition());
        
        while (currentSquare != null){           
           knight.setPosition(currentSquare);
           squares[knight.getPosition().getRow()][knight.getPosition().getCol()].setNumber(count++);
           squares[knight.getPosition().getRow()][knight.getPosition().getCol()].setAccessibility(0);
           availableSquares = getAvailableSquares(chessboard, knight.getPosition());
           if (availableSquares != null)
           {
              for (int i = 0; i < availableSquares.size(); i++){
                  accessibility = squares[availableSquares.get(i).getRow()][availableSquares.get(i).getCol()].getAccessibility();
                  squares[availableSquares.get(i).getRow()][availableSquares.get(i).getCol()].setAccessibility(--accessibility);
              }
           }
           display(chessboard); 
           System.out.println();
           displayAccessibility(chessboard);
           System.out.println();          
           currentSquare = getLeastAccessibleSquare2(chessboard, knight.getPosition());
        }
        System.out.println(--count);
        display(chessboard); 
        System.out.println();
        displayAccessibility(chessboard);       
    }// end main
    
    /*
     * displays the chessboard
     * @param board: the chessboard to display
     */
    private static void display (ChessBoard board){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                System.out.printf("%3d", board.getSquares()[i][j].getNumber());
            }
            System.out.println();
        }
    }//end display
    
    /*
     * display the squares' accessibilities on the chessboard
     * @param board: the chessboard from which to display the accessibilities
     */
    private static void displayAccessibility (ChessBoard board){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                System.out.printf("%3d", board.getSquares()[i][j].getAccessibility());
            }
            System.out.println();
        }
    }//end display accessibility  
    
    /*
     * randomly generates the next square on which to move the Knight
     * @param chessboard
     * @param knightPosition: the Knight's position
     * @return the next square on which to move the knight
     */
    private static Square randomLyGetNextSquare (ChessBoard chessboard, Square knightPosition){
        ArrayList <Square> availableSquares = getAvailableSquares(chessboard, knightPosition);
        
        if (availableSquares != null){
           int randomIndex = random.nextInt(availableSquares.size());
           Square randomSquare = availableSquares.get(randomIndex);
           return randomSquare;
        }
        else
            return null;
    }//end randomLyGetNextSquare
    
    /*
     * Generates the available squares around the current knight's position
     * @param chessboard
     * @param knightPosition: the knight's position
     * @return the list of available squares
     */
    public static ArrayList <Square> getAvailableSquares (ChessBoard chessboard, Square knightPosition){
        ArrayList <Square> availableSquares = new ArrayList <Square> (8);
        Square [][] squares = chessboard.getSquares();
        Square currentSquare;
        
        for (int i = 0; i < 8; i++){
            currentSquare = KnightTour.move(chessboard,knightPosition,i);
            if ( currentSquare != null){
                availableSquares.add(new Square(currentSquare.getRow(), currentSquare.getCol(), 
                                     squares[currentSquare.getRow()][currentSquare.getCol()].getNumber(), 
                                     squares[currentSquare.getRow()][currentSquare.getCol()].getAccessibility()));
            }
        }
                
        if (availableSquares.size() == 0)
            return null;
            
        return availableSquares;
    }//end getAvailableSquares
    
    /**
     * Determines the square with the least accessiblity around the knight's position_level 1
     * @param chessboard
     * @param knightPosition
     * @return the least accessible square
     */
    private static Square getLeastAccessibleSquare1 (ChessBoard chessboard, Square knightPosition){
        ArrayList <Square> availableSquares = getAvailableSquares(chessboard, knightPosition);
        Square leastAccessibleSquare;
        Square currentSquare;
        
        if (availableSquares != null){
           leastAccessibleSquare = availableSquares.get(0);           
           for (int i = 1; i < availableSquares.size(); i++){
               currentSquare = availableSquares.get(i);
               if (leastAccessibleSquare.getAccessibility() > currentSquare.getAccessibility())
                   leastAccessibleSquare = currentSquare;
           }
           return leastAccessibleSquare;
        }
        else{
            return null;
        }
    }
    
    /**
     * Determines the square with the least accessiblity around the knight's position_level_2
     * @param chessboard
     * @param knightPosition
     * @return the least accessible square
     */
    private static Square getLeastAccessibleSquare2 (ChessBoard chessboard, Square knightPosition){
        ArrayList <Square> availableSquares = getAvailableSquares(chessboard, knightPosition);
        Square leastAccessibleSquare1 = getLeastAccessibleSquare1(chessboard, knightPosition);
        ArrayList <Square> leastAccessibleSquaresLevel1 = new ArrayList <Square> (8);
        //Square currentSquare;
        Square leastAccessibleSquareLevel2;
        
        if (availableSquares != null){
           for (int i = 0; i < availableSquares.size(); i++){
               if (availableSquares.get(i).getAccessibility() == leastAccessibleSquare1.getAccessibility())
                   leastAccessibleSquaresLevel1.add(availableSquares.get(i));
           }
           if (leastAccessibleSquaresLevel1.size() == 1)
               return leastAccessibleSquaresLevel1.get(0);
           else { 
              System.out.println("IN....");   
              leastAccessibleSquareLevel2 = leastAccessibleSquaresLevel1.get(0);    
              for (int i = 1; i < leastAccessibleSquaresLevel1.size(); i++){
                  if (getLeastAccessibleSquare1(chessboard, leastAccessibleSquaresLevel1.get(i)).getAccessibility() < getLeastAccessibleSquare1(chessboard, leastAccessibleSquareLevel2).getAccessibility()){
                      leastAccessibleSquareLevel2 = leastAccessibleSquaresLevel1.get(i);
                  }
              }
              return leastAccessibleSquareLevel2;
           }
       }
       return null;
    }
    
    /*
     * determines the knight's next position given a move number
     * @param chessboard
     * @param knightPosition
     * @param moveNumber: varies from 0 to 7 and determines how to move the knight
     * @return the square on which to move the knight
     */
    public static Square move (ChessBoard chessboard, Square knightPosition, int moveNumber){
        int [] horizontal = {2,1,-1,-2,-2,-1,1,2};
        int [] vertical = {-1,-2,-2,-1,1,2,2,1};
        Square position = new Square(knightPosition.getRow(), knightPosition.getCol());
        Square [][] squares = chessboard.getSquares();
        position.setRow(position.getRow() + vertical[moveNumber]);
        position.setCol(position.getCol() + horizontal[moveNumber]);
        
        if (position.isValid() && squares[position.getRow()][position.getCol()].getNumber() == 0 )
            return position;
                    
        return null;
    }//end move
}//end class
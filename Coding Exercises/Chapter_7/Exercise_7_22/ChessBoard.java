/*
 * ChessBoard.java by Vannel 1/21/2019
 * Simulates a chessboard
 */
 
import java.util.ArrayList;

public class ChessBoard{
    
    private static final int NUM_ROWS = 8;
    private static final int  NUM_COLS = 8;
    private Square [][] squares;
    private int [][] accessibility = {{2,3,4,4,4,4,3,2},
                                      {3,4,6,6,6,6,4,3},
                                      {4,6,8,8,8,8,6,4},
                                      {4,6,8,8,8,8,6,4},
                                      {4,6,8,8,8,8,6,4},
                                      {4,6,8,8,8,8,6,4},
                                      {3,4,6,6,6,6,4,3},
                                      {2,3,4,4,4,4,3,2},
                                     };
    private Knight knight;
    
    public ChessBoard(){
        squares = new Square[NUM_ROWS][NUM_COLS];
        for (int i = 0; i < NUM_ROWS; i++){
            for (int j = 0; j < NUM_COLS; j++){
                squares[i][j] = new Square(0,0,0,accessibility[i][j]);
            }
        }
        knight = new Knight();
    }
    
    public Square [][] getSquares(){
        return squares;
    }
    
    public Knight getKnight(){
        return knight;
    }
}
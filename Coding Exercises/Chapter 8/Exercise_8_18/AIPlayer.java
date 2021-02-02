import java.util.Scanner;

/**
 * An AI player in a TicTacToe game
 */
public class AIPlayer extends Player{
    /**
     * constructor
     *
     * @param id       the player ID
     *                 int
     */
    public AIPlayer(int id){
        super(id);
    }
    
    
    /**
      * Allows the AI player to make a move on the board
      *
      * @param board         the TicTacToe board
      *                      CellValue[][]
      *
      * @return the player's move
      */
     @Override
     public int move(CellValue[][] board){
         Scanner read = new Scanner(System.in);
         System.out.printf("Player %d to move > ", getID());
         int move = read.nextInt();
         return move;
     }
}
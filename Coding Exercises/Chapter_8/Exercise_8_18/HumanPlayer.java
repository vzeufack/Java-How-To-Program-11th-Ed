import java.util.Scanner;

/**
 * A human player in a TicTacToe game
 */
public class HumanPlayer extends Player{
    /**
     * constructor
     *
     * @param id       the player ID
     *                 int
     */
    public HumanPlayer(int id){
        super(id);
    }
    
    
    /**
      * Allows a human player to make a move on the board
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
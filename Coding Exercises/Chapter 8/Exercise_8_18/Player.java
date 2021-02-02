import java.util.Scanner;
import java.util.ArrayList;

/**
 * Represents a player in the TicTacToe game
 *
 * The player could be human or computer
 */
public class Player{
    private int id; //the player ID, either 1 or 2
    private String type; //defines if the player is Human or AI
    private Scanner read = new Scanner(System.in);
    
    /**
     * constructor
     *
     * Initializes the player ID
     *
     * @param id,         the player ID
     *                    int
     *
     * @param type        the player type (human or AI)
     *  
     */
     public Player (int id, String type){
         this.id = id;
         this.type = type;
     }
     
     /**
      * ID accessor
      *
      * @return the player's ID
      */
     public int getID(){
         return id;
     }
     
     /**
      * type mutator
      *
      * @param newType   the new player type
      */
      public void setType(String newType){
         this.type = newType;
      }
      
      /**
       * isHuman accessor
       *
       * @return the player's type
       */
       public String getType(){
          return type;
       }
     
     /**
      * Provides the cell value of the player
      *
      * @return the player's cell value
      */
     public CellValue getCellValue(){
         int id = getID();
         
         if (id == 1)
             return CellValue.X;
         else
             return CellValue.O;
     } 
     
     /**
      * Allows a player to make a move on the board
      *
      * @param board         the TicTacToe board
      *                      CellValue[][]
      *
      * @return the player's move
      */
     public int[] move(CellValue[][] board){
        //String type = getType();
        int[] choice;
        
        if (type.equalsIgnoreCase("human")){
           int cellID;
           do{
              System.out.printf("Player %d to move > ", getID());
              cellID = read.nextInt();
              if (cellID < 1 || cellID > 9){
                  System.out.println("** Invalid cell position!!! Please enter a valid position in the range [1-9] **");
              }
           }while(cellID < 1 || cellID > 9);
           choice = getRealPosition(cellID);         
        }
        else{
           choice = computerMove(board);
        }
        return choice;
     }
     
    /**
     * Allows AI player to make a move
     * 
     * @param board         the TicTacToe board
     *                      CellValue[][]
     *
     * @return the AI move
     */
     private int[] computerMove(CellValue[][] board){
        //Get available moves
        ArrayList<int[]> availableMoves = getAvailableMoves(board);
        
        //Determine and return best move
        int[] bestMove = availableMoves.get(0);
        int bestScore = GetScore(board, availableMoves.get(0), true, getID());
        System.out.println(bestScore);
        int currentScore;
        
        for (int i = 1; i < availableMoves.size(); i++){
          currentScore = GetScore(board, availableMoves.get(i), true, getID());
          if (currentScore > bestScore){
            bestMove = availableMoves.get(i);
            bestScore = currentScore;
          }
        }
        return bestMove; 
     }
     
     //determines available moves
     private ArrayList <int[]> getAvailableMoves(CellValue [][] board){
       ArrayList <int[]> result = new ArrayList <int[]>();
       for (int i = 0; i < board.length; i++){
           for (int j = 0; j < board[i].length; j++){
               if (board[i][j] == CellValue.EMPTY){
                   int [] availableMove = {i,j};
                   result.add(availableMove);
               }
           }
       }
       
       if (result.size() == 0)
         return null;
       else
         return result;
     }
     
     /**
      * determines the best score if the given move in done on the board
      */
     private int GetScore(CellValue[][] board, int [] move, boolean isAI, int playerID){
       CellValue[][] boardCopy = new CellValue[3][3];
       for (int i = 0; i < board.length; i++){
         for (int j = 0; j < board[i].length; j++){
           boardCopy[i][j] = board[i][j];
         }
       }
       boardCopy[move[0]][move[1]] = playerID == 1?CellValue.X:CellValue.O;
       
       if(thereIsWin(boardCopy, move))
         if (isAI)
           return 10;
         else
           return -10;
       
       if (thereIsDraw(boardCopy, playerID))
         return 0;
       
       boolean isAINegation = !isAI;
       int pID = playerID == 1? 2: 1;
       
       ArrayList<int[]> availableMoves = getAvailableMoves(boardCopy);
       int bestScore;
       int currentScore;
       bestScore = GetScore(boardCopy, availableMoves.get(0), isAINegation, pID);
       
       if (isAI){        
         for (int i = 1; i < availableMoves.size(); i++){
           currentScore = GetScore(boardCopy, availableMoves.get(i), isAINegation, pID);
           if (currentScore > bestScore){
             //bestMove = availableMoves.get(i);
             bestScore = currentScore;
           }
         }
       }
       else{
         for (int i = 1; i < availableMoves.size(); i++){
           currentScore = GetScore(boardCopy, availableMoves.get(i), isAINegation, pID);
           if (currentScore < bestScore){
             //bestMove = availableMoves.get(i);
             bestScore = currentScore;
           }
         }
       }
       return bestScore;
     }
     
   /**
    * Determines the real position of the move on the board
    *
    * @param move         the relative position
    *
    * @return the real position
    */
   private int[] getRealPosition(int move){
       ArrayList <int []> realPositions = new ArrayList<int []>(9);
       int[] pos1 = {0,0};
       int[] pos2 = {0,1};
       int[] pos3 = {0,2};
       int[] pos4 = {1,0};
       int[] pos5 = {1,1};
       int[] pos6 = {1,2};
       int[] pos7 = {2,0};
       int[] pos8 = {2,1};
       int[] pos9 = {2,2};
       
       realPositions.add(pos1);
       realPositions.add(pos2);
       realPositions.add(pos3);
       realPositions.add(pos4);
       realPositions.add(pos5);
       realPositions.add(pos6);
       realPositions.add(pos7);
       realPositions.add(pos8);
       realPositions.add(pos9);
       
       return realPositions.get(move - 1);
   }
   
   /**
    * Determines whether there is a win in the current position
    *
    * @param lastMove       the last move on the board
    *                       int
    *
    * @param playerID       the id of the player who made the move
    *
    * @return true if there is a win, false othewise
    */
   private boolean thereIsWin(CellValue[][] board, int[] lastMove){
      if (lastMove[0] == 0 && lastMove[1] == 0 &&
          ((board[0][0] == board[0][1] && board[0][0] == board[0][2]) ||
           (board[0][0] == board[1][0] && board[0][0] == board[2][0]) ||
           (board[0][0] == board[1][1] && board[0][0] == board[2][2]))){
         //showWinnerMsg(playerID, opponent);
         return true;
      }
      else if (lastMove[0] == 0 && lastMove[1] == 1 &&
               ((board[0][1] == board[0][0] && board[0][1] == board[0][2]) ||
                (board[0][1] == board[1][1] && board[0][1] == board[1][2]))){
         //showWinnerMsg(playerID, opponent);
         return true;
      }
      else if (lastMove[0] == 0 && lastMove[1] == 2 &&
               ((board[0][2] == board[0][0] && board[0][2] == board[0][1]) || 
                (board[0][2] == board[1][2] && board[0][2] == board[2][2]) ||
                (board[0][2] == board[1][1] && board[0][2] == board[2][0]))){
         //showWinnerMsg(playerID, opponent);
         return true;
      }
      else if (lastMove[0] == 1 && lastMove[1] == 0 &&
               ((board[1][0] == board[1][1] && board[1][0] == board[1][2]) || 
                (board[1][0] == board[0][0] && board[1][0] == board[2][0]))){
         //showWinnerMsg(playerID, opponent);
         return true;
      }
      else if (lastMove[0] == 1 && lastMove[1] == 1 &&
               ((board[1][1] == board[1][0] && board[1][1] == board[1][2]) || 
                (board[1][1] == board[0][1] && board[1][1] == board[2][1]) ||
                (board[1][1] == board[0][0] && board[1][1] == board[2][2]) ||
                (board[1][1] == board[0][2] && board[1][1] == board[2][0]))){
         //showWinnerMsg(playerID, opponent);
         return true;
      }
      else if (lastMove[0] == 1 && lastMove[1] == 2 &&
               ((board[1][2] == board[0][2] && board[1][2] == board[2][2]) || 
                (board[1][2] == board[1][0] && board[1][2] == board[1][1]))){
         //showWinnerMsg(playerID, opponent);
         return true;
      }
      else if (lastMove[0] == 2 && lastMove[1] == 0 &&
               ((board[2][0] == board[0][0] && board[2][0] == board[1][0]) || 
                (board[2][0] == board[2][1] && board[2][0] == board[2][2]) ||
                (board[2][0] == board[1][1] && board[2][0] == board[0][2]))){
         //showWinnerMsg(playerID, opponent);
         return true;
      }
      else if (lastMove[0] == 2 && lastMove[1] == 1 &&
               ((board[2][1] == board[2][0] && board[2][1] == board[2][2]) || 
                (board[2][1] == board[1][1] && board[2][1] == board[0][1]))){
         //showWinnerMsg(playerID, opponent);
         return true;
      }
      else if (lastMove[0] == 2 && lastMove[1] == 2 &&
               ((board[2][2] == board[2][0] && board[2][2] == board[2][1]) || 
                (board[2][2] == board[1][2] && board[2][2] == board[0][2]) ||
                (board[2][2] == board[1][1] && board[2][2] == board[0][0]))){
         //showWinnerMsg(playerID, opponent);
         return true;
      }
      else{
         return false;
      }
   }
   
   /**
    * Determines whether there is a draw in the current position
    *
    * @param lastMove       the last move on the board
    *                       int
    *
    * @return true if there is a draw, false othewise
    */
  public boolean thereIsDraw(CellValue[][] board, int playerID){
     ArrayList<int[]> availableMoves = getAvailableMoves(board);
     
     if (availableMoves == null){
       return true;
     }
     else{
       int player = playerID == 1? 2: 1;
       for (int i = 0; i < availableMoves.size(); i++){
          CellValue[][] currentBoard = new CellValue[3][3];
          for (int j = 0; j < board.length; j++){
            for (int k = 0; k < board.length; k++){
               currentBoard[j][k] = board[j][k];
            }
          }
          updateBoard(currentBoard, availableMoves.get(i), player);
          
          if (thereIsWin(currentBoard, availableMoves.get(i))){
            return false;
          }
          else{
            if (thereIsDraw(currentBoard, player) == false){
              return false;
            }
          }
       }
     }
     return true;  
   }
   
   /**
    * updates the board
    *
    * @param lastMove      the last move
    *
    * @param playerID      the id of the player who made the move
    */
    private void updateBoard (CellValue[][] board, int[] move, int playerID){
       if (playerID == 1){
          board[move[0]][move[1]] = CellValue.X;
       }
       else{
          board[move[0]][move[1]] = CellValue.O;
       }
    }
}
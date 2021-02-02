import java.util.Scanner;
import java.util.ArrayList;

/**
 * TicTacToe Game
 *
 * This class allows to create and play TicTacToe games
 * The board's size is 3x3
 * It allows a human player to play against another human player
 * or against an AI player
 */
public class TicTacToe{
    private CellValue[][] board = new CellValue[3][3]; //the tic-tac-toe board
    Player player1; //player 1
    Player player2; //player 2
    private Scanner read = new Scanner(System.in);
    
    /**
     * Constructor
     *
     * Initializes the board to EMPTY cells
     * Initializes player 1 and player 2 
     */
    public TicTacToe(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = CellValue.EMPTY;
            }
        }
        
        player1 = new Player(1, "human");
        player2 = new Player(2, "human");
    }
    
    /**
     * board accessor
     *
     * @return the board
     */
     public CellValue[][] getBoard(){
        return board;
     }
    
    /**
     * starts the game
     */
    public void start(){        
        //Game header
        System.out.printf("***** Tic Tac Toe Version 1.0 *****\n\n");
        
        //Tutorial
        displayTutorial();
        System.out.println();         
      
        int opponent;      
      
        do{
            displayMenu();           
            //opponent selection
            do{
                opponent = read.nextInt();
                if (opponent != 1 && opponent != 2 && opponent != 3){
                    System.out.print("Please, enter 1, 2 or 3 > ");
                }
            }while (opponent != 1 && opponent != 2 && opponent != 3);
            
            if (opponent == 1 || opponent == 2){
               play(opponent);
               resetBoard();
            }    
                    
        }while(opponent != 3);
      
        //display Good Bye Message
        System.out.println("\n***** Thank you for playing! *****");  
    }
    
    /**
     * resets the board to empty values
     */
    private void resetBoard(){
      for (int i = 0; i < board.length; i++){
         for (int j = 0; j < board[i].length; j++){
             board[i][j] = CellValue.EMPTY;
         }
       }
    }
    
    /**
     * Tells how to play
     */
    private void displayTutorial(){
        System.out.printf("---------- How to play ----------\n");
        System.out.printf("To make a move, enter a value in the range [1;9] as shown below\n");
        System.out.println("-------------------");
        System.out.println("|  1  |  2  |  3  |");
        System.out.println("-------------------");
        System.out.println("|  4  |  5  |  6  |");
        System.out.println("-------------------");
        System.out.println("|  7  |  8  |  9  |");
        System.out.println("-------------------");
        System.out.printf("THe first to align three in a row wins!\n");
    }
    
    /**
     * Displays the game menu
     */
    private void displayMenu(){
        System.out.printf("%s\n%s\n%s\n%s\n%s", "---------- Menu ----------", 
                                                    "1- Play against Human", 
                                                    "2- Play against Computer", 
                                                    "3- Stop", 
                                                    "Enter 1, 2 or 3 > ");
    }
    
    /**
     * starts the game     
     */
    public void play (int opponent){          
       //set player 1 and player 2       
       if (opponent == 1){
           System.out.println("\n---------- Playing Against Human ---------");
           player1.setType("human");
           player2.setType("human");
       }
       else{
           System.out.println("\n---------- Playing Against AI ---------");
           System.out.print("Do you want to start (y/n)>");
           char answer = read.next().charAt(0);
           if (answer == 'y'){
              player1.setType("human");
              player2.setType("ai");
           }
           else{
              player1.setType("ai");
              player2.setType("human");
           }        
       }
       
       int [] lastMove;
       boolean isEnd;
       
       //play 
       do{         
           do{               
               lastMove = player1.move(board);
           }while(!isValid(lastMove));           
                     
           updateBoard(getBoard(), lastMove, 1);
           displayBoard();
           
           isEnd = false;
           if (!isEnd && thereIsWin(getBoard(), lastMove, 1, opponent)){
             isEnd = true;
             showWinnerMsg(1, opponent);
           }
           if(!isEnd && thereIsDraw(getBoard(), lastMove, 1, opponent)){
             isEnd = true;
             System.out.println("\n*** Draw Game ***\n");
           }
           
           if (!isEnd){              
               do{
                   lastMove = player2.move(board);
               }while(!isValid(lastMove));
               
               updateBoard(getBoard(), lastMove, 2);
               displayBoard();
               //isEnd = thereIsWin(getBoard(), lastMove, 2, opponent) || thereIsDraw(getBoard(), lastMove, 2, opponent);
               
               if (!isEnd && thereIsWin(getBoard(), lastMove, 2, opponent)){
                  isEnd = true;
                  showWinnerMsg(2, opponent);
                }
                if(!isEnd && thereIsDraw(getBoard(), lastMove, 2, opponent)){
                  isEnd = true;
                  System.out.println("\nDraw Game\n");
                }
           }
       }while(!isEnd);
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
   
   /**
    * determines whether a move is valid
    *
    * @param move        the player's move
    *                    int
    */
   private boolean isValid(int [] move){
      CellValue[][] board = getBoard();
      
      if (board[move[0]][move[1]] != CellValue.EMPTY){
         System.out.println("** Cell is no more available. Please select another cell **");
         return false;
      }
      else{
         return true;
      }
   }
   
   /**
    * Determines the real position of the move on the board
    *
    * @param move         the relative position
    *
    * @return the real position
    */
   /*private int[] getRealPosition(int move){
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
   }*/
   
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
   private boolean thereIsWin(CellValue[][] board, int[] lastMove, int playerID, int opponent){
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
    * shows the winning message
    *
    * @param the player id
    */
   private void showWinnerMsg(int playerID, int opponent){
       System.out.println();
       
       if (opponent == 1){
         System.out.printf("Player %d Won!\n", playerID);
       }
       else{
         if (playerID == 1){
           if (player1.getType() == "human")
             System.out.printf("You Won!\n");
           else
             System.out.printf("AI Won!\n");
         }
         else{
           if (player2.getType() == "human")
             System.out.printf("You Won!\n");
           else
             System.out.printf("AI Won!\n");
         }
       }
       
       System.out.println();
   }
   
   /**
    * Determines whether there is a draw in the current position
    *
    * @param lastMove       the last move on the board
    *                       int
    *
    * @return true if there is a draw, false othewise
    */
  public boolean thereIsDraw(CellValue[][] board, int [] lastMove, int playerID, int opponent){
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
          
          if (thereIsWin(currentBoard, availableMoves.get(i), player, opponent)){
            return false;
          }
          else{
            if (thereIsDraw(currentBoard, availableMoves.get(i), player, opponent) == false){
              return false;
            }
          }
       }
     }
     return true;  
   }
   
   /**
    * returns the string value of a cell
    *
    * @param row       the row number
    *
    * @param col       the column number
    *
    * @return the string value of the cell
    */
   private String getValue(int row, int col){
      CellValue[][] board = getBoard();
      if (board[row][col] == CellValue.EMPTY){
         return "  ";
      }
      else{
         return board[row][col] + " ";
      }
   }
   
   /**
    * displays the board
    */
   private void displayBoard(){
      System.out.println("-------------------");
      System.out.printf ("|  %s |  %s |  %s |\n", getValue(0,0), getValue(0,1), getValue(0,2));
      System.out.println("-------------------");
      System.out.printf ("|  %s |  %s |  %s |\n", getValue(1,0), getValue(1,1), getValue(1,2));
      System.out.println("-------------------");
      System.out.printf ("|  %s |  %s |  %s |\n", getValue(2,0), getValue(2,1), getValue(2,2));
      System.out.println("-------------------");
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
}
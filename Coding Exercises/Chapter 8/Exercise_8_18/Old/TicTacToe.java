import java.util.Scanner;
import java.util.ArrayList;

//implements a tic tac toe game
public class TicTacToe{
   private enum CellValue{X, O, EMPTY};
   private CellValue[][] board = new CellValue[3][3];
   Scanner read = new Scanner(System.in);
      
   //constructor
   public TicTacToe(){
      for (int i = 0; i < board.length; i++){
         for (int j = 0; j < board[i].length; j++){
             board[i][j] = CellValue.EMPTY;
         }
      }
   }
   
   //returns the board
   private CellValue[][] getBoard(){
      return board;
   }
   
   //sets the value of a board's cell
   private void setBoard(int row, int col, CellValue value){
      this.board[row][col] = value;
   }
   
   //starts the game
   public void start(){
      //Game title
      System.out.printf("***** Tic Tac Toe Version 1.0 *****\n\n");
      System.out.printf("How to play: to mark a cell, enter the cell value. Cell values range from 1 to 9 as shown below\n");
      displayBoardWithNumbers();
      System.out.println();         
      
      int gameMode;      
      
      //play until player wants to stop
      do{
         //choose game mode (vs human or vs computer)         
         System.out.printf("%s\n%s\n%s\n%s\n%s", "Menu:", "1- Play against Human", "2- Play against Computer", "3- Stop", "Enter 1, 2 or 3 > ");
         do{
            gameMode = read.nextInt();
            if (gameMode != 1 && gameMode != 2 && gameMode != 3){
               System.out.print("Please, enter 1, 2 or 3 > ");
            }
         }while (gameMode != 1 && gameMode != 2 && gameMode != 3);
         
         //play
         switch (gameMode){
            case 1:
               playHuman();
               break;
            case 2:
               playComputer();
               break;
         }         
      }while(gameMode != 3);
      
      //display Good Bye Message
      System.out.println("\n***** Thank you for playing! *****");  
   }
   
   //To play against human
   private void playHuman(){
       int p1, p2;
       boolean thereIsWinOrDraw;        
       displayBoard();
       
       do{
          System.out.print("Player 1 to play > ");
          do{
            p1 = read.nextInt();
          }while (!isValidPlay(p1));
          updateBoard(p1, 1);
          displayBoard();
          thereIsWinOrDraw = thereIsWinOrDraw(p1, 1);
          if (!thereIsWinOrDraw){
              System.out.print("Player 2 to play > ");
              do{
                 p2 = read.nextInt();
              }while (!isValidPlay(p2));
              updateBoard(p2, 2);
              displayBoard();
              thereIsWinOrDraw = thereIsWinOrDraw(p2, 2);
          } 
       }while (!thereIsWinOrDraw);
   }
   
   //determines whether a play is valid
   private boolean isValidPlay(int cellID){
      CellValue[][] board = getBoard();
      int [] cellCoordinates;
      
      if (cellID >= 1 && cellID <= 9){
         cellCoordinates = getCellCoordinates(cellID);
         if (board[cellCoordinates[0]][cellCoordinates[1]] != CellValue.EMPTY){
            System.out.print("Cell is no more available. Please select another cell > ");
            return false;
         }
         else{
            return true;
         }
      }
      else{
         System.out.print("Invalid square value!!! Please select a valid square > ");
         return false;
      }
   }
   
   //To play against computer
   private void playComputer(){
      char starter;
      
      //determine starter
      System.out.print("Do you want to start (y/n)>");
      starter = read.next().charAt(0);
      
      if (starter == 'y'){
         playComputerAsFirst();
      }
      else{
         playComputerAsSecond();
      }
   }
   
   //plays against the computer with human starting first
   private void playComputerAsFirst(){
      int p, c;
      boolean thereIsWinOrDraw;
      
      displayBoard();
      do{
          System.out.print("Player to play > ");
          p = read.nextInt();
          updateBoard(p,1);
          displayBoard();
          thereIsWinOrDraw = thereIsWinOrDraw(p, 1);
          if (!thereIsWinOrDraw){
              c = computerPlay(2, 1);
              updateBoard(c,2);
              displayBoard();
              thereIsWinOrDraw = thereIsWinOrDraw(c, 2);
          } 
       }while (!thereIsWinOrDraw);
   }
   
   //plays against the computer with computer starting first
   private void playComputerAsSecond(){
      int p, c;
      boolean thereIsWinOrDraw;
      
      displayBoard();
      do{
          c = computerPlay(2,1);
          updateBoard(c,1);
          displayBoard();
          thereIsWinOrDraw = thereIsWinOrDraw(c, 1);
          if (!thereIsWinOrDraw){
             System.out.print("Player to play > ");
             p = read.nextInt();
             updateBoard(p,2);
             displayBoard(); 
             thereIsWinOrDraw = thereIsWinOrDraw(p, 2);             
          } 
       }while (!thereIsWinOrDraw);
   }
   
   //display the board with numbers from 1 to 9
   private void displayBoardWithNumbers(){
      System.out.println("-------------------");
      System.out.println("|  1  |  2  |  3  |");
      System.out.println("-------------------");
      System.out.println("|  4  |  5  |  6  |");
      System.out.println("-------------------");
      System.out.println("|  7  |  8  |  9  |");
      System.out.println("-------------------");
   }
   
   //displays the board
   private void displayBoard(){
      System.out.println("-------------------");
      System.out.printf ("|  %s |  %s |  %s |\n", getValue(0,0), getValue(0,1), getValue(0,2));
      System.out.println("-------------------");
      System.out.printf ("|  %s |  %s |  %s |\n", getValue(1,0), getValue(1,1), getValue(1,2));
      System.out.println("-------------------");
      System.out.printf ("|  %s |  %s |  %s |\n", getValue(2,0), getValue(2,1), getValue(2,2));
      System.out.println("-------------------");
   }
   
   //determines the string value of a particular cell
   private String getValue(int row, int col){
      CellValue[][] board = getBoard();
      if (board[row][col] == CellValue.EMPTY){
         return "  ";
      }
      else{
         return board[row][col] + " ";
      }
   }
      
   //updates the board
   private void updateBoard(int cellID, int playerID){
      CellValue value = playerID == 1? CellValue.O: CellValue.X;
      int [] cellCoordinates = getCellCoordinates(cellID);
      setBoard(cellCoordinates[0], cellCoordinates[1], value);
   }
   
   //sets a cell in a board and returns the updated board
   private CellValue[][] setCell (CellValue [][] board, Position pos, boolean isMaximizingPlayer){
      CellValue value = isMaximizingPlayer? CellValue.O: CellValue.X;
      //int [] cellCoordinates = getCellCoordinates(cellID);
      
      CellValue [][] updatedBoard = new CellValue[3][3];
      for (int i = 0; i < updatedBoard.length; i++){
         for (int j = 0; j < updatedBoard[i].length; j++){
            updatedBoard[i][j] = board[i][j];
         }
      }
      updatedBoard[pos.getRow()][pos.getCol()] = value;
      return updatedBoard;
   }
   
   //determines whether there is a win or a draw
   private boolean thereIsWinOrDraw(int cellID, int playerID){
      CellValue[][] board = getBoard();
      
      switch (cellID){
         case 1:
            if ((board[0][0] == board[0][1] && board[0][0] == board[0][2]) || 
                (board[0][0] == board[1][0] && board[0][0] == board[2][0]) ||
                (board[0][0] == board[1][1] && board[0][0] == board[2][2])){
                displayWinningMsg(playerID);
                return true;
            }
            break;
         case 2:
            if ((board[0][1] == board[0][0] && board[0][1] == board[0][2]) || 
                (board[0][1] == board[1][1] && board[0][1] == board[1][2])){
                displayWinningMsg(playerID);
                return true;
            }
            break;
         case 3:
            if ((board[0][2] == board[0][0] && board[0][2] == board[0][1]) || 
                (board[0][2] == board[1][2] && board[0][2] == board[2][2]) ||
                (board[0][2] == board[1][1] && board[0][2] == board[2][0])){
                displayWinningMsg(playerID);
                return true;
            }
            break;
         case 4:
            if ((board[1][0] == board[1][1] && board[1][0] == board[1][2]) || 
                (board[1][0] == board[0][0] && board[1][0] == board[2][0])){
                displayWinningMsg(playerID);
                return true;
            }
            break;
         case 5:
            if ((board[1][1] == board[1][0] && board[1][1] == board[1][2]) || 
                (board[1][1] == board[0][1] && board[1][1] == board[2][1]) ||
                (board[1][1] == board[0][0] && board[1][1] == board[2][2]) ||
                (board[1][1] == board[0][2] && board[1][1] == board[2][0])){
                displayWinningMsg(playerID);
                return true;
            }
            break;
         case 6:
            if ((board[1][2] == board[0][2] && board[1][2] == board[2][2]) || 
                (board[1][2] == board[1][0] && board[1][2] == board[1][1])){
                displayWinningMsg(playerID);
                return true;
            }
            break;
         case 7:
            if ((board[2][0] == board[0][0] && board[2][0] == board[1][0]) || 
                (board[2][0] == board[2][1] && board[2][0] == board[2][2]) ||
                (board[2][0] == board[1][1] && board[2][0] == board[0][2])){
                displayWinningMsg(playerID);
                return true;
            }
            break;
         case 8:
            if ((board[2][1] == board[2][0] && board[2][1] == board[2][2]) || 
                (board[2][1] == board[1][1] && board[2][1] == board[0][1])){
                displayWinningMsg(playerID);
                return true;
            }
            break;
         case 9:
            if ((board[2][2] == board[2][0] && board[2][2] == board[2][1]) || 
                (board[2][2] == board[1][2] && board[2][2] == board[0][2]) ||
                (board[2][2] == board[1][1] && board[2][2] == board[0][0])){
                displayWinningMsg(playerID);
                return true;
            }
            break;
      }
      return false;
   }
   
   //displays the winning message according to playerID
   private void displayWinningMsg(int playerID){
       System.out.println();
       if (playerID == 1 || playerID == 2){
          System.out.printf("Congratulations, Player %d Won!!!\n", playerID);
       }
       else if (playerID == 3){
          System.out.printf("Congratulations, You Won!!!\n");
       }
       else{
          System.out.printf("Computer won!\n");
       }
       System.out.println();
   }
   
   //performs the computer plays
   private int computerPlay(int level, int player){      
      return minimax(getBoard(), 2, true);
   }
   
   //implements minimax algorithm
   private int minimax (CellValue[][] board, int level, boolean isMaximizingPlayer){
      if (isGameOver(board) || level == 0){
         return getScore(board, isMaximizingPlayer);
      }
      
      ArrayList <Position> possibleMoves = getAllPossibleMoves(board);     
      int currentScore;
      int bestScore;
      CellValue[][] currentBoard;
      
      if (isMaximizingPlayer){
          bestScore = Integer.MIN_VALUE;
          
          for (int i = 0; i < possibleMoves.size(); i++){
              currentBoard = setCell(board, possibleMoves.get(i), isMaximizingPlayer);
              currentScore = minimax(currentBoard, level-1, false);
              if (currentScore > bestScore){
                 bestScore = currentScore;
              }
          }
          return bestScore;
      }
      else{
          bestScore = Integer.MAX_VALUE;
          for (int i = 0; i < possibleMoves.size(); i++){
              currentBoard = setCell(board, possibleMoves.get(i), isMaximizingPlayer);
              currentScore = minimax(currentBoard, level-1, true);
              if (currentScore < bestScore){
                  bestScore = currentScore;
              }
          }
          return bestScore;
      }
   }
   
   //computes the score
   private int getScore (CellValue[][] board, boolean isMaximizingPlayer){
       CellValue value = isMaximizingPlayer? CellValue.O: CellValue.X;
       int [] pos;
       int score = -1;
       
       for (int i = 0; i < 9; i++){
           pos = getCellCoordinates(i);
           if (board[pos[0]][pos[1]] == value && thereIsWinOrDraw(i, 1))
               score = 1;
       }
       
        
       if (isMaximizingPlayer){
       }
       return 0;
   }
   
   //determines if game is over
   private boolean isGameOver (CellValue[][] board){
       for (CellValue [] row: board){
           for (CellValue cell: row){
               if (cell == CellValue.EMPTY)
                   return false;
           }
       }
       return true;
   }
   
   //determines all possible moves
   private ArrayList <Position> getAllPossibleMoves(CellValue [][] board){
       ArrayList <Position> result = new ArrayList <Position>();
       for (int i = 0; i < board.length; i++){
           for (int j = 0; j < board[i].length; j++){
               if (board[i][j] == CellValue.EMPTY)
                   result.add(new Position(i,j));
           }
       }
       return result;
   }
   
   //determines the cell coordinates
   private int[] getCellCoordinates(int playerInput){
      int [] cell = new int[2];
      
      switch (playerInput){
         case 1:
            cell[0] = 0;
            cell[1] = 0;
            break;
         case 2:
            cell[0] = 0;
            cell[1] = 1;
            break;
         case 3:
            cell[0] = 0;
            cell[1] = 2;
            break;
         case 4:
            cell[0] = 1;
            cell[1] = 0;
            break;
         case 5:
            cell[0] = 1;
            cell[1] = 1;
            break;
         case 6:
            cell[0] = 1;
            cell[1] = 2;
            break;
         case 7:
            cell[0] = 2;
            cell[1] = 0;
            break;
         case 8:
            cell[0] = 2;
            cell[1] = 1;
            break;
         case 9:
            cell[0] = 2;
            cell[1] = 2;
            break;
      }
      return cell;
   }
}